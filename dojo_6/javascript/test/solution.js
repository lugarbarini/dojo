const chai = require('chai');

function Cost(amount) {
	this.amount = amount;
}

Cost.prototype.divide = function(number) {
	return this.amount / number;
};

function SellingPrice(amount) {
	this.amount = amount;
}

SellingPrice.prototype.difference = function(cost) {
	return this.amount - cost;
};



function Product(cost) {
	this.cost = cost;
}

Product.prototype.method_name = function(first_argument) {
	// body...
};

Product.acumulateCost = function(productList) {
	var totalCost = 0;
	for(var i = 0; i < productList.length; i++) {
		totalCost += productList[i].getCost();
	}
	return totalCost;
};

Product.prototype.profit = function(sellingProfit) {
	return new Profit(sellingProfit.difference(this.getCost()));
};

Product.prototype.getCost = function() {
	return this.cost.amount;
};



function ProductPack(quantity, cost) {
	this.quantity = quantity;
	this.cost = cost;
}

ProductPack.prototype.profit = function(sellingPrice) {
	return this.singleProduct().profit(sellingPrice);
};

ProductPack.prototype.getCost = function() {
	return this.singleProduct().getCost();
};

ProductPack.prototype.singleProduct = function() {
	return new Product(new Cost(this.cost.divide(this.quantity)));
};



function UnitSale(productOrPack, sellingPrice) {
	this.productOrPack = productOrPack;
	this.sellingPrice = sellingPrice;
}

UnitSale.prototype.profit = function() {
	return this.productOrPack.profit(this.sellingPrice);
};




function MultiProductSale(products, sellingPrice) {
	this.products = products;
	this.sellingPrice = sellingPrice;
}

MultiProductSale.prototype.profit = function() {
	return new Profit(this.sellingPrice.difference(
		this.totalCost()
	));
};

MultiProductSale.prototype.totalCost = function() {
	return Product.acumulateCost(this.products);
};



function Profit(value) {
	this._value = value;
}

Profit.prototype.equals = function(otherProfit) {
	return this._value == otherProfit._value;
};


function Cow() {

}

Cow.prototype.equals = function(otherCow) {
	return this === otherCow
};

function Barter(barterPrice) {
	this._barterPrice = barterPrice;
}

Barter.prototype.difference = function(cost) {
	return this._barterPrice;
};



describe("dojo 6", () => {
	describe("all", function() {
        it("When I sell 1 product the profit is the difference between selling price and its cost", () => {
    		var product = new Product(new Cost(100));
			var profit = new UnitSale(product, new SellingPrice(300)).profit();

    		chai.assert.isTrue(profit.equals(new Profit(200)));
        });

        it("When I sell many products the profit is the difference of selling price and all products costs", () => {
    		var product1 = new Product(new Cost(100));
    		var product2 = new Product(new Cost(120));
			var profit = new MultiProductSale([product1, product2], new SellingPrice(300)).profit();

    		chai.assert.isTrue(profit.equals(new Profit(80)));
        });

        it("When I sell 1 product of a product pack, the profit is the difference between selling price and its cost", function() {
			var productPack = new ProductPack(50, new Cost(1000));
			var profit = new UnitSale(productPack, new SellingPrice(300)).profit();

			chai.assert.isTrue(profit.equals(new Profit(280)));
        });

        it("When I sell 5 products of a product pack, the profit is the difference between selling price and all products cost", function() {
        	var productPack = new ProductPack(50, new Cost(1000));
			var profit = new MultiProductSale(
				[productPack, productPack, productPack, productPack, productPack]
				, new SellingPrice(300))
			.profit();

    		chai.assert.isTrue(profit.equals(new Profit(200)));
        });

        it("When I sell a product and they pay me with a cow, the profit is the cow", () => {
			var product = new Product(new Cost(100));
			var cow = new Cow();
			var profit = new UnitSale(product, new Barter(cow)).profit();

    		chai.assert.isTrue(profit.equals(new Profit(cow)));
        });
    });

});

