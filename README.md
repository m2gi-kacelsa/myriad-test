## API Documentaiton

### Set up project

The project was generated from scratch using Spring Initializr,
https://start.spring.io/
The version of java wich is used is Java 17, the dependencies used are: Spring web,
H2 dependency, Spring Data JPA, lombok

### Run Project

To run the project, you should do the steps bellow:

1. Install Java 17 (configure path variable system)

2. Install an IDE like IntelliJ or Eclipse

3. Build the project to install dependencies

4. Launch project in the IDE

### Test the API with Postman

After installing Postman, we can test the API, once the application in successfully
started, we can test the two exposed services of the API:

1. Register User http://localhost:8080/api/user/sign-in
   Use the POST method, Example of Json format:
    - {
      "username": "test",
      "birthDate": "05-02-2004",
      "countryOfResidence": "France",
      "gender": "FEMME",
      "phoneNumber": "0777 77 77 77"
      }

2. Get User details: http://localhost:8080/api/user/userId
   Use the GET method, Response Example with userId=1:
    - {
      "id": 1,
      "username": "Test ",
      "birthDate": "05-02-1994",
      "countryOfResidence": "France",
      "gender": "FEMME",
      "phoneNumber": "0777 77 77 77"
      }


