# Sakila Soap API
**Sakila** [its structure](https://dev.mysql.com/doc/sakila/en/sakila-structure.html)-->
  is a sample database created by MySQL that is used for testing, demonstrating, and experimenting with the features and functionality of MySQL's relational database management system.
The Sakila database is a nicely normalised schema modelling a DVD rental store featuring things like films, actors, film-actor relationships and a central inventory table that connects films, stores and rentals

**REST API (Representational State Transfer Application Programming Interface)** is a type of web API that uses HTTP requests to interact with data resources.REST APIs typically use HTTP methods such as GET, POST, PUT, PATCH, and DELETE to retrieve, create, update, and delete resources, respectively. They also use URIs (Uniform Resource Identifiers) to identify resources and hypermedia links to navigate between resources.

# Technologies used
* Java 17
* JAX-WS (Jersey)
* Maven
* Tomcat 10
* Jakarta persistance (Hibernate)
* MySql
* Intellij IDEA
* Postman


# Endpoints

| Resource         | Endpoint           |
| ---------------- |:------------------:|
| ActorService     | /webapi/actor      |
| AddressService   | /webapi/address    |
| CategoryService  | /webapi/category   |
| CityService      | /webapi/city       |
| CountryService   | /webapi/country    |
| CustomerService  | /webapi/customer   |
| FilmService      | /webapi/film       |
| InventoryService | /webapi/inventory  |
| LanguageService  | /webapi/language   |
| PaymentService   | /webapi/payment    |
| RentalService    | /webapi/rental     |
| StaffService     | /webapi/staff      |
| StoreService     | /webapi/store      |
   
  
  
# Run with Maven
  Clone the project --> git clone https://github.com/SoadEhab/SakilaRestAPI.git
  
  Go to the project directory --> cd SakilaRestAPI
  
* Create db user and set the username and password values in the persistence.xml
* Create db named sakila in your MySql Server and it is available from [here](https://dev.mysql.com/doc/index-other.html)
* Run your tomcat apache server and then change the configuration of tomcat in pom.xml
* Deploy the application using the following maven command -->
    mvn clean install tomcat7:deploy
