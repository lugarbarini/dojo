function Cost(amount) {
	this._amount = amount;
}

Cost.prototype.equals = function(otherCost) {
	return this._amount == otherCost._amount;
};

Cost.prototype.add = function(otherCost) {
	return new Cost(this._amount + otherCost._amount);
};

Cost.prototype.percent = function(percent) {
	return new Cost(this._amount * percent);
};

module.exports = Cost;