const Cost = require("./cost.js");

function Trip(transport) {
    this._transport = transport;
}

Trip.prototype.cost = function() {
	return new Cost(865);
};

module.exports = Trip;