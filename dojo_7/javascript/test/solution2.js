const chai = require('chai');

const AccountMoney = require('../account_money.js');
const Installment = require('../installment.js');
const CreditCard = require('../credit_card.js');
const Shipment = require('../shipment.js');
const NoShipment = require('../no_shipment.js');
const RemainingAmount = require('../remaining_amount.js');
const Order = require('../order.js');
const GiftCard = require('../gift_card.js');

// ---

// ---


describe("Dojo 7", () => {
    describe("Dos medios de pago - ", function() {
        it("Tengo una orden por 1000 y 1000 de dinero en cuenta. Al imprimir el detalle de pagos se muestra $1000 por dinero en cuenta", () => {
			var order = new Order(1000);

			order.payWith(new AccountMoney(1000));

			chai.assert.equal("Dinero en Cuenta: $1000", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y 3000 de dinero en cuenta. Al imprimir el detalle de pagos se muestra $1000 por dinero en cuenta", () => {
			var order = new Order(1000);

			order.payWith(new AccountMoney(3000));

			chai.assert.equal("Dinero en Cuenta: $1000", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y pago con Tarjeta de Credito en 1 cuota. Al imprimir el detalle de pagos se muestra $1000 con Tarjeta en 1 cuota", () => {
        	var order = new Order(1000);

			order.payWith(new CreditCard());

			chai.assert.equal("Tarjeta de Crédito: 1x $1000", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y pago con Tarjeta de Credito en 2 cuotas. Al imprimir el detalle de pagos se muestra $500 con Tarjeta en 2 cuotas", () => {
        	var order = new Order(1000);

			order.payWith(new CreditCard(new Installment(2)));

			chai.assert.equal("Tarjeta de Crédito: 2x $500", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 con 50 de envio y pago con Tarjeta de Credito en 2 cuotas. Al imprimir el detalle de pagos se muestra $500 con Tarjeta en 2 cuotas", () => {
        	var order = new Order(1000);

        	order.shipWith(new Shipment(50))
			order.payWith(new CreditCard(new Installment(2)));

			chai.assert.equal("Tarjeta de Crédito: 2x $525", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y pago 100 con dinero en cuenta y el resto con tarjeta. Al imprimir el detalle de pagos se muestra $100 por dinero en cuenta y $900 con Tarjeta en 1 cuota", () => {
			var order = new Order(1000 /* item total */);
			var accountMoneyBalance = 100;
			
			order.payWith(new AccountMoney(accountMoneyBalance));
			order.payWith(new CreditCard());

			chai.assert.equal("Dinero en Cuenta: $100 - Tarjeta de Crédito: 1x $900", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y pago 100 con dinero en cuenta y el resto con tarjeta. Al imprimir el detalle de pagos se muestra $100 por dinero en cuenta y $900 con Tarjeta en 1 cuota", () => {
			var order = new Order(1000 /* item total */);
			var accountMoneyBalance = 100;
			
			order.payWithPayments([new AccountMoney(accountMoneyBalance), new CreditCard()]);

			chai.assert.equal("Dinero en Cuenta: $100 - Tarjeta de Crédito: 1x $900", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y pago 100 con dinero en cuenta y el resto con tarjeta. Luego cambio el envio. Al imprimir el detalle de pagos se muestran los pagos con el monto actualizado", () => {
			var order = new Order(1000 /* item total */);
			var accountMoneyBalance = 100;
			
			order.payWithPayments([new AccountMoney(accountMoneyBalance), new CreditCard()]);

			chai.assert.equal("Dinero en Cuenta: $100 - Tarjeta de Crédito: 1x $900", order.printPaymentDetail());

			order.shipWith(new Shipment(50));

			chai.assert.equal("Dinero en Cuenta: $100 - Tarjeta de Crédito: 1x $950", order.printPaymentDetail());
        });

        it("Tengo una orden por 1000 y pago 100 con dinero en cuenta y el resto con tarjeta. Al imprimir el detalle de pagos se muestra $100 por dinero en cuenta y $900 con Tarjeta en 1 cuota", () => {
			var order = new Order(1000 /* item total */);
			var accountMoneyBalance = 100;
			
			order.payWithPayments([new CreditCard(), new AccountMoney(accountMoneyBalance)]);

			chai.assert.equal("Dinero en Cuenta: $100 - Tarjeta de Crédito: 1x $900", order.printPaymentDetail());
        });


        it("Tengo una orden por 1000 y pago 100 con dinero en cuenta, 50 con Gift Card y el resto con tarjeta. Al imprimir el detalle de pagos se muestra $100 por dinero en cuenta, $50 con la gift card y $850 con Tarjeta en 1 cuota", () => {
			var order = new Order(1000 /* item total */);
			var accountMoneyBalance = 100;
			
			order.payWithPayments([new AccountMoney(accountMoneyBalance), new GiftCard(50), new CreditCard()]);

			chai.assert.equal("Dinero en Cuenta: $100 - Gift Card: $50 - Tarjeta de Crédito: 1x $850", order.printPaymentDetail());
        });
    });
});








