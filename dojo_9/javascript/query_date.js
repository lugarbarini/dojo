function QueryDate(daysToTrip) {
	this._daysToTrip = daysToTrip;
}

QueryDate.prototype.daysToTrip = function() {
	return this._daysToTrip;
};

QueryDate.prototype.returnIfDaysToTrip = function(daysToTrip, greaterThanEquals, lessThan) {
	return this._daysToTrip >= daysToTrip ? greaterThanEquals : lessThan; 
};

module.exports = QueryDate;

