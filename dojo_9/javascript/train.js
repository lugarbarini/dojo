const Cost = require("./cost.js");

function Train(section) {
	this._section = section;
	this._costPerKm = 2;
}

Train.prototype.cost = function() {
	return new Cost(this._costPerKm * this._section.distanceInKm());
};

module.exports = Train;