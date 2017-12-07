const Place = require("./place.js");

function Origin(city, distance) {
	Place.call(this, city, distance);
}

module.exports = Origin;