const Cost = require("./cost.js");

function Budget(trip, queryDate) {
	this._trip = trip;
	this._queryDate = queryDate;
}

Budget.prototype.salePrice = function(disponibility) {
	return this._trip.salePrice().percent(0.9);
};

module.exports = Budget;