function Availability(percentAvailable) {
	this._percentAvailable = percentAvailable;
}

Availability.prototype.returnIfAvailability = function(targetAvailablity, greaterThan, lessThanEquals) {
	return this._percentAvailable > targetAvailablity ? greaterThan : lessThanEquals;
};

module.exports = Availability;