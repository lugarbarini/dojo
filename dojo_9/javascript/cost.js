function Cost(amount) {
	this._amount = amount;
}

Cost.prototype.equals = function(otherCost) {
	return this._amount == otherCost._amount;
};

module.exports = Cost;