function RemainingAmount(initialAmount) {
	this._remainingAmount = initialAmount;
}

RemainingAmount.prototype.addContribution = function(payment) {
	var contribution = payment.contributeWith(this._remainingAmount);
	this._remainingAmount = this._remainingAmount - contribution;
	return contribution;
};

module.exports = RemainingAmount;
