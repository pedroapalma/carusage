# Movies Api
![Coverage](.github/badges/jacoco.svg)

This project aims to develop a versatile car that can be used for various purposes throughout the week.

- **Monday**: The car will serve as a reliable vehicle for go to work.
- **Tuesday**: It will be utilized for racing on a circuit.
- **Wednesday and Thursday**: The car will be designed for off-road adventures.
- **Friday**: The ultimate feature will allow the car to transform into a secret agent vehicle. This will include activating camouflage and deploying pre-installed firearms.

This project combines functionality and creativity to build a multi-purpose car that adapts to the needs of its user throughout the week.

# Technologies Used

- Java
- Spring Boot

# Getting Started

## Prerequisites

- Java 17
- Maven

## Installing

- Clone the repository.
- Build the project using Maven: `mvn clean package`
- Run the application: `java -jar target/carusage-0.0.1-SNAPSHOT.jar`
- Access the API endpoints using your preferred HTTP client.

# API

## Endpoint

- `GET /car-usage/{dayOfWeek}`: This endpoint retrieves information about the car's usage for a specified day of the week. Replace {dayOfWeek} with the following available days (`monday`, `tuesday`, `wednesday`, `thursday`, `friday`)

## Documentation

http://localhost:8080/swagger-ui/index.html

## Example

### Request

`GET` http://localhost:8080/car-usage/monday

### Response

`OK`


```
Car using to go to work
```