const Cost = require("./cost.js");

function Trip(transports) {
    this._transports = transports;
}

Trip.prototype.cost = function() {
	// reemplazar por reduce
	var cost = new Cost(0);
	for (var i=0; i<this._transports.length; i++) {
		cost = cost.add(this._transports[i].cost());
	}

	return cost;
};

module.exports = Trip;