function Availability(percentAvailable) {
	this._percentAvailable = percentAvailable;
}

Availability.prototype.availablePlacesPercentForTrip = function(trip) {
	return this._percentAvailable;
};

module.exports = Availability;