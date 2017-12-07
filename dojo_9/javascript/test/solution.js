const chai = require('chai');

const Trip = require("./trip.js");
const Bus = require("./bus.js");
const Section = require("./section.js");
const Origin = require("./origin.js");
const Destination = require("./destination.js");
const Cost = require("./cost.js");



// ------ tests

describe("Sistema de viajes", () => {

    it("Un viaje de Bs As a Mar del Plata en micro sale $865", () => {

    	var bus = new Bus(new Section(new Origin("Bs As"), new Destination("MDQ")));
    	var trip = new Trip(bus);

		chai.assert.equal( true, new Cost(865).equals(trip.cost()) );

    });
    
});
