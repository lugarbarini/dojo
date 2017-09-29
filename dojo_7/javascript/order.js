const NoShipment = require('./no_shipment.js');
const RemainingAmount = require('./remaining_amount.js');

function Order(amount) {
	this._amount = amount;
	this._shipment = new NoShipment();
	this._payments = [];
}

Order.prototype.shipWith = function(shipment) {
	this._shipment = shipment;
};

Order.prototype.payWith = function(payment) {
	this._payments.push(payment);
	this._sortPayments();
};

Order.prototype.payWithPayments = function(paymentList) {
	paymentList.forEach( p => this.payWith(p) );
};

Order.prototype._totalAmount = function() {
	return this._amount + this._shipment.cost();
};

Order.prototype._sortPayments = function() {
	this._payments.sort(function(payment1, payment2){return payment1.priority()-payment2.priority()});
};

Order.prototype.printPaymentDetail = function() {
	var details = [];
	var remainingAmount = new RemainingAmount(this._totalAmount());
	
	for(var i=0; i < this._payments.length; i++) {
		var payment = this._payments[i]; 
		var contribution = remainingAmount.addContribution(payment);
		details.push(payment.printPaymentDetail(contribution));
	}

	return details.join(" - ");
};

module.exports = Order;
