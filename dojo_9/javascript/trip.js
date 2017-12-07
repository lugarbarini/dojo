const Cost = require("./cost.js");

function Trip(transport) {
    this._transport = transport;
}

Trip.prototype.cost = function() {
	return this._transport.cost();
};

module.exports = Trip;