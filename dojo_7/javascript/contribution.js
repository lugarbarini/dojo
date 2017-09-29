function Contribution(paymentMethod, amount) {
	this._paymentMethod = paymentMethod;
	this._amount = amount;
}

Contribution.prototype.printPaymentDetail = function() {
	return this._amount == 0 ? '' : this._paymentMethod.printPaymentDetail(this._amount);
};

Contribution.prototype.substractFrom = function(amount) {
	return amount - this._amount;
};

module.exports = Contribution;