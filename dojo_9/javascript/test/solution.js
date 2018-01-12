const chai = require('chai');

const Trip = require("../trip.js");
const Bus = require("../bus.js");
const Train = require("../train.js");
const Section = require("../section.js");
const Place = require("../place.js");
const Cost = require("../cost.js");
const QueryDate = require("../query_date.js");
const BudgetCreator = require("../budget_creator.js");
const Availability = require("../availability.js");

const BsAsDistance = 0;
const MDQDistance = 450;
const TrelewDistance = 1500;
const BahiaBlancaDistance = 900;

// ------ tests

describe("Sistema de viajes", () => {

    it("Un viaje de Bs As a Mar del Plata en micro sale $865", () => {

    	var bus = new Bus(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
    	var trip = new Trip([bus]);

		chai.assert.equal( new Cost(2250).equals(trip.cost()), true );

    });
    
    it("Un viaje de Bs As a Mar del Plata en tren sale $900", () => {

    	var train = new Train(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
    	var trip = new Trip([train]);

		chai.assert.equal( new Cost(900).equals(trip.cost()), true );

    });

    it("Un viaje de Trelew a Bs As en tren sale $1500", () => {

        var train = new Train(new Section(new Place("Trelew", TrelewDistance), new Place("Bs As", BsAsDistance)));
        var trip = new Trip([train]);

        chai.assert.equal( new Cost(3000).equals(trip.cost()), true );

    });

    it("Un viaje de Trelew a Bs As yendo a Bahia Blanca en tren y luego en micro a BsAs sale $5700", () => {

        var trip = new Trip([
            new Train(new Section(new Place("Trelew", TrelewDistance), new Place("Bahia Blanca", BahiaBlancaDistance))),
            new Bus(new Section(new Place("Bahia Blanca", BahiaBlancaDistance), new Place("Bs As", BsAsDistance)))
        ]);

        chai.assert.equal( new Cost(5700).equals(trip.cost()), true );

    });


    it("En condiciones normales, el precio de venta del viaje es 10% por sobre el costo del mismo", () => {

        var bus = new Bus(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
        var trip = new Trip([bus]);

        chai.assert.equal( new Cost(2475).equals(trip.salePrice()), true );

    });    

    it("Son 180 dias antes de la fecha del viaje en micro de Bs As a MDQ y todavia no se vendio ninguna plaza. El precio de venta del viaje se reduce un 10%", () => {

        var bus = new Bus(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
        var trip = new Trip([bus]);
        var daysBeforeTrip = 180;
        var availability = new Availability(100);    // mockeamos que la disponibilidad es 100%
        var budgetCreator = new BudgetCreator(availability);

        var budget = budgetCreator.createBudget(trip, new QueryDate(daysBeforeTrip));

        chai.assert.equal( new Cost(2227.5).equals(budget.salePrice()), true );

    }); 

    it("Son 180 dias antes de la fecha del viaje en micro de Bs As a MDQ y ya se vendió el 80% de las plazas (queda solo el 20% libre). El precio de venta del viaje incrementa un 20%", () => {

        var bus = new Bus(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
        var trip = new Trip([bus]);
        var daysBeforeTrip = 180;
        var availability = new Availability(20);    // mockeamos que la disponibilidad es 20%
        var budgetCreator = new BudgetCreator(availability);

        var budget = budgetCreator.createBudget(trip, new QueryDate(daysBeforeTrip));

        chai.assert.equal( new Cost(2970).equals(budget.salePrice()), true );

    }); 


    it("Son 90 dias antes de la fecha del viaje en micro de Bs As a MDQ y ya se vendió el 90% de las plazas (queda 10% o menos libre). El precio de venta del viaje se incrementa un 50%", () => {

        var bus = new Bus(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
        var trip = new Trip([bus]);
        var daysBeforeTrip = 90;
        var availability = new Availability(10);    // mockeamos que la disponibilidad es 10%
        var budgetCreator = new BudgetCreator(availability);

        var budget = budgetCreator.createBudget(trip, new QueryDate(daysBeforeTrip));

        chai.assert.equal( new Cost(3712.5).equals(budget.salePrice()), true );

    });

    it("Son 90 dias antes de la fecha del viaje en micro de Bs As a MDQ y se vendió menos del 90% de las plazas (queda mas de 10% libre). El precio de venta del viaje se reduce un 20%", () => {

        var bus = new Bus(new Section(new Place("Bs As", BsAsDistance), new Place("MDQ", MDQDistance)));
        var trip = new Trip([bus]);
        var daysBeforeTrip = 90;
        var availability = new Availability(11);    // mockeamos que la disponibilidad es 11%
        var budgetCreator = new BudgetCreator(availability);

        var budget = budgetCreator.createBudget(trip, new QueryDate(daysBeforeTrip));

        chai.assert.equal( new Cost(1980).equals(budget.salePrice()), true );

    }); 
    
});
