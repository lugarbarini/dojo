const Place = require("./place.js");

function Destination(city, distance) {
	Place.call(this, city, distance);
}

module.exports = Destination;