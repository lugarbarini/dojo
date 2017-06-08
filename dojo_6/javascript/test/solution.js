const chai = require('chai');

function Cost(amount) {
	this.amount = amount;
}

function SellingPrice(amount) {
	this.amount = amount;
}

SellingPrice.prototype.sellingPriceMinusCost = function(cost) {
	return new SellingPrice(this.amount - cost.amount);
};

function Product(cost) {
	this.cost = cost;
}

Product.prototype.profit = function(sellingProfit) {
	return sellingProfit.sellingPriceMinusCost(this.cost);
};

function UnitSale(product, sellingPrice) {
	this.product = product;
	this.sellingPrice = sellingPrice;
}

UnitSale.prototype.profit = function() {
	return this.product.profit(this.sellingPrice).amount;
};

function MultiProductSale(products, sellingPrice) {
	this.products = products;
	this.sellingPrice = sellingPrice;
}

MultiProductSale.prototype.profit = function() {
	var remainingProfit = this.sellingPrice;

	for (var i = 0; i < this.products.length; i++) {
		remainingProfit = this.products[i].profit(remainingProfit);
	}
	
	return remainingProfit.amount;
};





describe("dojo 6", () => {
	describe("all", function() {
        it("When I sell 1 product the profit is the difference between selling price and its cost", () => {
    		var product = new Product(new Cost(100));
			var profit = new UnitSale(product, new SellingPrice(300)).profit();

    		chai.assert.equal(200, profit);
        });

        it("When I sell many products the profit is the difference of selling price and all products costs", () => {
    		var product1 = new Product(new Cost(100));
    		var product2 = new Product(new Cost(120));
			var profit = new MultiProductSale([product1, product2], new SellingPrice(300)).profit();

    		chai.assert.equal(80, profit);
        });
    });

});


/*
function Transaction(unitPrice, quantity) {
	this.unitPrice = unitPrice;
	this.quantity = quantity;
}

function Product(buyTransaction) {
    this.buyTransaction = buyTransaction;
}

Product.prototype.sell = function(sellTransaction) {
	return new Profit(sellTransaction, buyTransaction);
};*/

