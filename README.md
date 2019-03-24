# BusyFlights Service

BusyFlights is a rest web service that provides information to user regarding 
flights.


## Version 
**1.0**


The services are available thought the http://<server>:<port>/search relative URL.

	http://<server>:<port>/search

### POST

Send a POST request will result in a response with a new list of BusyFlightsResponse that contains informations about flights.

**Response message Example**
	
	http://<server>:<port>/search
	
	Params
	
	{
  		"origin": "latam",
  		"destination": "TMS",
  		"departureDate": "2017-01-29T08:40:00Z",
  		"returnDate": "2017-02-15T12:40:00Z",
  		"numberOfPassengers": "2"
	}
	
***For a valid board ID (HTTP 200 Status)***

	[
	  {
	    "airline": "latam",
	    "supplier": "CrazyAir",
	    "fare": 34.45,
	    "departureAirportCode": "LHR",
	    "destinationAirportCode": "TMS",
	    "departureDate": "2017-01-29T13:45:00Z",
	    "arrivalDate": "2016-02-15T08:45:00Z"
	  },
	  {
	    "airline": "easyjet",
	    "supplier": "ToughJet",
	    "fare": 244.56,
	    "departureAirportCode": "LHR",
	    "destinationAirportCode": "TMS",
	    "departureDate": null,
	    "arrivalDate": null
	  },
	  {
	    "airline": "ryanair",
	    "supplier": "CrazyAir",
	    "fare": 256.98,
	    "departureAirportCode": "LHR",
	    "destinationAirportCode": "TMS",
	    "departureDate": "2017-01-29T15:14:00Z",
	    "arrivalDate": "2016-02-15T09:35:00Z"
	  }
	]
	

## Tech

It was used the following technologies:

* Java 1.8
* Spring Boot 1.4
* Spring Framework
* Apache Maven 3.3.9
* JUnit
* Mockito


## Bulding and packaging

You will need Maven to build this project. You can build the package using the following command on the project root directory:

    mvn clean package


## Executing

There are two ways of running this application.

The first one is for running it through Maven:

    mvn spring-boot:run

The second one is for running the jar package (located in the target directory after a packaging) directly:

    java -jar busyflights-1.0.jar -Dserver.port=8090 (optional param)

## curl
curl -i --header "Content-Type: application/json" --request POST --data "@apitest.json" http://localhost:8090/search

## Next Steps / TODOs

- Change POST to GET to call services
- Security
- Time-out
- URLs by params
- Change convert methods in functions
- Documentation
- Tests
- Validations and Exceptions
- Failover hystrix

## License
MIT