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

SellingPrice.prototype.difference = function(price) {
	return this.amount - price;
};

SellingPrice.prototype.sellingPriceMinusCost = function(cost) {
	return new SellingPrice(this.amount - cost.amount);
};

function Product(cost) {
	this.cost = cost;
}

Product.prototype.method_name = function(first_argument) {
	// body...
};

Product.prototype.accumulatedCost = function(products) {
	return products.reduce(this.cost, function(accum, product) {
		return accum + product.cost;
	});
};

Product.acumulateCost = function(productList) {
	var totalCost = 0;
	for(var i = 0; i < productList.length; i++) {
		totalCost += productList[i].getCost();
	}
	return totalCost;
};

Product.prototype.profit = function(sellingProfit) {
	return sellingProfit.sellingPriceMinusCost(this.cost);
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
	return this.productOrPack.profit(this.sellingPrice).amount;
};




function MultiProductSale(products, sellingPrice) {
	this.products = products;
	this.sellingPrice = sellingPrice;
}

MultiProductSale.prototype.profit = function() {
	return this.sellingPrice.difference(
		this.totalCost()
	);
};

MultiProductSale.prototype.totalCost = function() {
	return Product.acumulateCost(this.products);
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

        it("When I sell 1 product of a product pack, the profit is the difference between selling price and its cost", function() {
			var productPack = new ProductPack(50, new Cost(1000));
			var profit = new UnitSale(productPack, new SellingPrice(300)).profit();

			chai.assert.equal(280, profit);
        });

        it("When I sell 5 products of a product pack, the profit is the difference between selling price and all products cost", function() {
        	var productPack = new ProductPack(50, new Cost(1000));
			var profit = new MultiProductSale(
				[productPack, productPack, productPack, productPack, productPack]
				, new SellingPrice(300))
			.profit();

    		chai.assert.equal(200, profit);
        });
    });

});

