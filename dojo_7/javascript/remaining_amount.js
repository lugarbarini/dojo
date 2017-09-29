function RemainingAmount(initialAmount) {
	this._remainingAmount = initialAmount;
}

RemainingAmount.prototype.addContribution = function(payment) {
	var contribution = payment.contributeWith(this._remainingAmount);
	this._remainingAmount = contribution.substractFrom(this._remainingAmount);
	return contribution;
};

module.exports = RemainingAmount;
