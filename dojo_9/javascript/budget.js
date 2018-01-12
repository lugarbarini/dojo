
function Budget(salePrice) {
	this._salePrice = salePrice;
}

Budget.prototype.salePrice = function() {
	return this._salePrice;
};

module.exports = Budget;