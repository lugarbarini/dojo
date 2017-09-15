function Installment(installmentCount) {
	this._installmentCount = installmentCount;
}

Installment.prototype.printDetailForAmount = function(amountToPay) {
	return this._installmentCount + "x $" + this._amount(amountToPay);
};

Installment.prototype._amount = function(amountToPay) {
	return amountToPay/this._installmentCount;
};

module.exports = Installment;
