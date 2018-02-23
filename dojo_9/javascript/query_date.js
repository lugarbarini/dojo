function QueryDate(daysToTrip) {
	this._daysToTrip = daysToTrip;
}

QueryDate.prototype.daysToTrip = function() {
	return this._daysToTrip;
};

module.exports = QueryDate;

