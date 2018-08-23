# Knapsack Rest Service

### Steps taken:
Youtube video to understand the problem and algorithm better.
https://www.youtube.com/watch?v=8LusJS5-AGo

### Heroku deployment:
I have deployed the app to Heroku. This is the URL to visit.
https://nstanogias-knapsack.herokuapp.com/swagger-ui.html

### Backend Implementation:
- Spring Boot for writing Rest Service
- Spring Evens for parallel execution
- H2 in memory database as storing mechanism
- Spring Security with basic http authentication for securing admin endpoints (username: admin, password: admin)
- Maven for dependency management
- Docker for containerizing service
- Swagger for interface
- Unit tests for basic components

### Frontend Implementation:
- React Framework with Bootstrap 4 as a component library
- Redux for global state management
- React Router for route rendering and navigation

Currently, I have implemented only the admin dashboard page, which shows all the tasks that have been submitted.
This work will be extended.
As a temporal frontend solution, swagger interface is used.

### Steps to run the service locally:
It is better to run the application with increased java heap space in order to be able to assign many problems in parallel

1. go to root directory (knapsack folder)
2. maven install
3. java -Xms4096m -Xmx8192m -jar target/knapsack-0.0.1-SNAPSHOT.jar

### Running the service in a container (It is prerequisite docker machine to be up and running):

1. sudo docker build -t knapsack .
2. docker run -p 6543:8080 knapsack
3. go to http://localhost:6543/swagger-ui.html

### Running the service locally along with React client:

1. go to root directory
2. java -Xms4096m -Xmx8192m -jar target/knapsack-0.0.1-SNAPSHOT.jar

3. from another terminal tab go to root directory
4. cd client
5. npm install
6. npm start
7. go to http://localhost:3000


### Follow up tasks:
- Improve error handling
- Improve input validation
- Add code comments
- Improve testing
- Finish frontend implementation and integration with React
