const Cost = require("./cost.js");
const Budget = require("./budget.js");

function BudgetCreator(availability) {
	this._availability = availability;
}

BudgetCreator.prototype.createBudget = function(trip, queryDate) {

	// old code
	// var pricingPolicy;

	// if (queryDate.daysToTrip() >= 180) {
	// 	var pricingPolicy = this._availability.returnIfAvailability(20 /* porcentaje de disponibilidad*/, 
	// 		new TripDiscountPercent(10), 
	// 		new TripExtraChargePercent(20));
	// } else {
	// 	var pricingPolicy = this._availability.returnIfAvailability(10 /* porcentaje de disponibilidad*/, 
	// 		new TripDiscountPercent(20), 
	// 		new TripExtraChargePercent(50));
	// }
	
	// return new Budget(pricingPolicy.applyTo(trip.salePrice()));

	var promotions = [
		new TripDiscountPercent(10, [
			new BeforeDaysCondition(180),
			new HigherAvailabilityCondition(20)
		]), 
		new TripExtraChargePercent(20, [
			new BeforeDaysCondition(180),
			new LessAvailabilityCondition(20)
		]), 
		new TripDiscountPercent(20, [
			new BetweenDaysCondition(90, 179),
			new HigherAvailabilityCondition(10)
		]),
		new TripExtraChargePercent(50, [
			new BetweenDaysCondition(90, 179),
			new LessAvailabilityCondition(10)
		]), /*
		new TripExtraChargePercent(10, [
			new BetweenDaysCondition(8, 15)
		]),
		new TripExtraChargeFixed(100, [
			new BetweenDaysCondition(0, 7)
		])  */
	];

	var promotion = new NoPromotion();

	for (var i = 0; i < promotions.length; i++) {
		promotion = promotions[i].challenge(promotion, trip);
	}

	return new Budget(promotion.applyTo(trip));
};



// Pricing policies

function NoPromotion() {
	
}

NoPromotion.prototype.challenge = function(otherPromotion) {
	return otherPromotion;
};

NoPromotion.prototype.applyTo = function(trip) {
	return trip.salePrice();
};

function TripDiscountPercent(discountPercent, conditions) {
	this._discount = discountPercent;
	this._conditions = conditions;
}

TripDiscountPercent.prototype.challenge = function(otherPromotion, theTrip) {
	return this.applies(theTrip) ? this : otherPromotion;
};

TripDiscountPercent.prototype.applies = function(theTrip) {
	var applies = true;
	for (var i = 0; i < this.conditions.length; i++) {
		applies &= this.conditions[i];
	}
	return applies;
};

TripDiscountPercent.prototype.applyTo = function(amount) {
	return amount.percent(1 - this._discount / 100);
};


function TripExtraChargePercent(chargePercent, conditions) {
	this._charge = chargePercent;
	this._conditions = conditions;
}

TripExtraChargePercent.prototype.applies = function() {
	var applies = true;
	for (var i = 0; i < this.conditions.length; i++) {
		applies &= this.conditions[i];
	}
	return applies;
};

TripExtraChargePercent.prototype.applyTo = function(amount) {
	return amount.percent(1 + this._charge / 100);
};

module.exports = BudgetCreator;