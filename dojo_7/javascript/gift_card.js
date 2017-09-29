const Contribution = require('./contribution.js');

function GiftCard(giftCardAmount) {
	this._amount = giftCardAmount;
}

GiftCard.prototype.printPaymentDetail = function(amountToPay) {
	return "Gift Card: $" + amountToPay;
};

GiftCard.prototype.contributeWith = function(amountToPay) {
	return new Contribution(this, Math.min(amountToPay, this._amount));
};

GiftCard.prototype.priority = function() {
	return 0;
};

module.exports = GiftCard;