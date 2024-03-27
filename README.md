 **EVENT MANAGEMENT SYSTEM**


**1.0	INTRODUCTION:**

•	I have developed a Backend system for an Event Management System using Microservices based architecture, where we can save all events and track all upcoming events.

•	Created Microservices are event management system, weather application, Event service discovery, Event API gateway + Load Balancer.

•	**Tech Stack Used:** Java, Spring Boot, MySQL, SpringDataJPA, Spring cloud (Netflix – Eureka server) for service Discovery, API G/W, LB, Postman as a Rest client.

•	Used MVC pattern for Spring Boot applications as followed like below diagram 

**2.0	BRIEF ABOUT TECH STACK:**

**Java:**

•	It’s a Platform Independent language. Java is known for its "write once, run anywhere" mantra, which means Java code can run on any device that supports. 

•	And Java's scalability and performance capabilities make it suitable for building large-scale and high-performance applications.

**SpringBoot:**

•	Spring boot main features are Rapid development, Dependency management, Auto-configuration, Embedded server, Microservice based and Integration.

•	Spring Boot is well-suited for building microservices architectures. Its lightweight nature and modular design make it easy to create and deploy independent microservices that can communicate with each other via RESTful APIs or messaging protocols.

•	Spring Boot seamlessly integrates with other Spring projects and frameworks such as Spring Data, Spring Security, Spring Cloud, etc. 

•	This allows developers to leverage the full power of the Spring ecosystem to build robust and scalable applications.

**MySQL:**

•	MySQL is an open-source relational database management system (RDBMS)

•	its scalability, allowing projects to start small and grow seamlessly as their data needs increase. It supports features like sharding, replication, clustering, and partitioning, which help distribute and manage data across multiple servers as the application scales.

•	MySQL is optimized for performance, with features like query caching, indexing.

**SpringDataJPA:**

Spring Data JPA simplifies and accelerates the development of data access layer in Spring-based applications, offering features for efficient database interaction, Automatic & Dynamic query generation, transaction management.

****Spring Cloud:**

•	**Service Discovery:** whenever a new server of any service comes up, it will first register itself with the service discovery. 

•	Whenever 1 Microservice needs to call another Microservice, it gets the I/P Addresses of that service from the service discovery.

•	****API G/W :** It takes the request & Routes the request to the correct microservice.

•	**LB**: Balance the load between servers.

**3.0	API ENDPOINTS FOR EVENT MANAGEMENT MICROSERVICE:**

**Data creation API:**

**Create a Single Event:**  POST / localhost:3002/events/create 

**Create a List of Events:**  POST/ localhost:3002/events/createAll

**Event Finder API:**

**Get all events:**  GET / localhost:3002/events/all

**Get list of all events based on the user's Request Params latitude, longitude, and a specified date:**  GET / localhost:3002/events/find?latitude=40.7128&longitude=-74.0060&date=2024-03-15

•	Here, this will return events occurring within the next 14 days from the specified date. 

•	And sorted by the earliest event after the specified date, with a page size of 10.

**4.0  External APIs:**

To get the Weather data, **I have created Weather Application Microservice**.  And the flow chat will be like this as below diagram
 
**End Points to get Weather Data:**      GET/ localhost:9000/api/weather/Hartville     (By using Request parameter as City Name)  

**Spring Eureka:**  http://localhost:8761 (for more instances creation)

 
•	Here, I have written few Unit Test cases in Weather Application to handle errors.

•	Created Service Discovery  for to make parallel calls to the external Weather API to minimize response time.

**5.0	SUGGESTIONS FOR OPTIMIZING API USAGE:**

•	we can use Redis cache to cache the response.

•	Create a Relation Database Service (RDS) in AWS, it will scale the databases in cloud.

•	Deploy our Microservices in Cloud like AWS. For that we can use EC2 instances, Create Jar file from IntelliJ & deploy the jar file. Or can use Elastic Bean Stalk (EBS) to improve the performance.

**6.0	CHALLENGES:**

•	While developing the project, I have faced the various issues like,

•	Initially, I have created Single Event one by one, then I thought to search fast ways to upload the Csv file data. And I found the ways like, can create a list of events at once.so, csv file changed to JSON format, then send in Postman. We have option to send whole file also.

•	Creating the Pagination & Sorting by date for Find API where User has to give Request parameters. I have solved the problem by doing Google search based on errors in IntelliJ & by watching YouTube videos.

•	While creating Weather application microservice, where I have integrated with External API, it will give lot of information. I have taken only weather and details as a Response.

**7.0	SOURCE CODE_ GITHUB REPOSITORIES:**

https://github.com/Nirosha-Rayee/EventManagementSystem.git	

https://github.com/Nirosha-Rayee/WeatherApplication.git

https://github.com/Nirosha-Rayee/EventServiceDiscovery.git

**8.0	INSTRUCTIONS TO RUN CODE:**

•	Install JAVA, Maven, MySQL database in your system.

•	Download complete code from this repository and then import in your desired code editor (Eclipse or IntelliJ IDEA)

•**Clone the Repository:**

https://github.com/Nirosha-Rayee/EventManagementSystem.git

https://github.com/Nirosha-Rayee/WeatherApplication.git

https://github.com/Nirosha-Rayee/EventServiceDiscovery.git

•	After installing database create user and database in MySQL, provide the DB name in Event management service microservice in Application Properties.

•	Run all the Microservices one by one and hit the Endpoints in Postman.

Please refer this video if you want, https://www.youtube.com/watch?v=ZqxVJ9gEKo0

**Thank you for providing this opportunity.**







