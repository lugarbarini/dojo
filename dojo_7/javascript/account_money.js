function AccountMoney(balance) {
	this._balance = balance;
}

AccountMoney.prototype.printPaymentDetail = function(amountToPay) {
	return "Dinero en Cuenta: $" + amountToPay;
};

AccountMoney.prototype.contributeWith = function(amountToPay) {
	return Math.min(amountToPay, this._balance);
};

AccountMoney.prototype.priority = function() {
	return 0;
};

module.exports = AccountMoney;