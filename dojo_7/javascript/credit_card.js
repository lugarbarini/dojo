const Installment = require('./installment.js');
const Contribution = require('./contribution.js');

function CreditCard(installment) {
	this._installment = installment || new Installment(1);
}

CreditCard.prototype.contributeWith = function(amountToPay) {
	return new Contribution(this, amountToPay);
};

CreditCard.prototype.printPaymentDetail = function(amountToPay) {
	return "Tarjeta de Crédito: " + this._installment.printDetailForAmount(amountToPay);
};

CreditCard.prototype.priority = function() {
	return 10;
};

module.exports = CreditCard;
