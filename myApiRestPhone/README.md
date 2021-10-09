# PHONE APP

#### Necessary requirements:
- Spring Boot
- MongoDB

The project has been implemented in Java using Spring Boot framework.
Whole project has been built on a local host in port 8080.
It has been used a non-relational database (MongoDB) for the two exercises. MongoDB database is allocated to the default local host in port 27017.
The order of the directories follows the next structure:







### Exercise 1
For this exercise it has been needed the creation of the database named myPhone that contains a collection of phones where it's indicated the brand, price, reference, brief description and image of the phones.
This collection needs to be load initially following the steps defined in the loadphones.md file.
To use the "get" service it's needed to include the following http request: 
http://localhost:8080/api/phonesCatalog


### Exercise 2
For the exercise 2 it's been used 2 endpoints in which one of them creates and validates the order and the other one adds the order to the myPhone database in the collection named order.
The order validation is performed using the get service implemented in exercise 1. When the order it's added to the database it's created automatically its identifier.
- Validation order endpoint: This "post" service receives a body request with the information of the order. During the order validation it's calculated the order price. Some examples of the body requests are displayed in bodyrequest.txt file. To use the "post" service it's needed to include the following http request: 
http://localhost:8080/api/validateOrder

- Add order to the myPhone database endpoint: This service receives the same information of the previous endpoint and uses the same body request. This adds the order to the database and shows by console the overview of the order. To use the "post" service it's needed to include the following http request: 
http://localhost:8080/api/addOrder

### Question 1: 
One possible improvement of the system it could be to perform an implementation based on TDD to reach a system more robust against failures.

### Question 2: 
To avoid API overflow, the API would have to take into account all defined and non-defined errors to avoid unexpected failures. Additionally it would be needed to limit the memory since in case of a higher demanding of that the API wouldn't give it.

Note: I've been researching about those issues and have found these possible solutions, but I have never used them and honestly, I would need help implementing them.


