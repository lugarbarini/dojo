function Shipment(cost) {
	this._cost = cost;
}

Shipment.prototype.cost = function() {
	return this._cost;
};

module.exports = Shipment;
