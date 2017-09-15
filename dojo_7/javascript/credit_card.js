const Installment = require('./installment.js');

function CreditCard(installment) {
	this._installment = installment || new Installment(1);
}

CreditCard.prototype.contributeWith = function(amountToPay) {
	return amountToPay;
};

CreditCard.prototype.printPaymentDetail = function(amountToPay) {
	return "Tarjeta de Crédito: " + this._installment.printDetailForAmount(amountToPay);
};

CreditCard.prototype.priority = function() {
	return 1;
};

module.exports = CreditCard;
