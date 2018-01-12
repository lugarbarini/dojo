const Cost = require("./cost.js");
const Budget = require("./budget.js");

function BudgetCreator(availability) {
	this._availability = availability;
}

BudgetCreator.prototype.createBudget = function(trip, queryDate) {

	// TODO refactor
	var pricingPolicy;
	if (this._availability.availablePlacesPercentForTrip(trip) <= 20) {
		// mas de 80% vendido, se incrementa 20% el precio del viaje
		pricingPolicy = new TripExtraChargePercent(20);
	} else {
		// menos de 80% vendido, se reduce 10% el precio del viaje
		pricingPolicy = new TripDiscountPercent(10);
	}
	
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