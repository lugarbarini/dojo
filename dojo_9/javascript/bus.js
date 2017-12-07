const Cost = require("./cost.js");

function Bus(section) {
	this._section = section;
	this._costPerKm = 5;
}

Bus.prototype.cost = function() {
	return new Cost(this._costPerKm * this._section.distanceInKm());
};


module.exports = Bus;