const Cost = require("./cost.js");
const Budget = require("./budget.js");

function BudgetCreator(availability) {
	this._availability = availability;
}

BudgetCreator.prototype.createBudget = function(trip, queryDate) {

	var pricingPolicy = this._availability.returnIfAvailability(20 /* porcentaje de disponibilidad*/, 
		new TripDiscountPercent(10), 
		new TripExtraChargePercent(20));

	return new Budget(pricingPolicy.applyTo(trip.salePrice()));
};

// Pricing policies

function TripDiscountPercent(discountPercent) {
	this._discount = discountPercent;
}

TripDiscountPercent.prototype.applyTo = function(amount) {
	return amount.percent(1 - this._discount / 100);
};


function TripExtraChargePercent(chargePercent) {
	this._charge = chargePercent;
}

TripExtraChargePercent.prototype.applyTo = function(amount) {
	return amount.percent(1 + this._charge / 100);
};

module.exports = BudgetCreator;