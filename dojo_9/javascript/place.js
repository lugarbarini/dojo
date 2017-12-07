function Place(city, distance) {
	this._city = city;
	this._distance = distance;
}

Place.prototype.distanceInKm = function(otherPlace) {
	return Math.abs(this._distance - otherPlace._distance);
};

module.exports = Place;