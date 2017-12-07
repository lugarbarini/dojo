function Section(origin, destination) {
	this._origin = origin;
	this._destination = destination;
}

Section.prototype.distanceInKm = function() {
	return this._origin.distanceInKm(this._destination);
};

module.exports = Section;