# Car Resale Application Server

### This project a server application for Car Resale. It is built in Java Spring Boot framework with Mongo DB database. ###

### Installation

##### set up Mongo DB database #####

Following are the guidelines to run mongoDB as a docker image.
1. Node: refer [link](https://docs.mongodb.com/manual/installation/) for manual MongoDB installation.

2. Link for docker [install the docker](https://docs.docker.com/get-docker/)

install the docker image from docker hub

     `docker pull mongo`
     
Get the image id of the mongo and run the Mongo DB in docker container. 

    Specify the ip and port in the command to expose port externally. 
    
      `docker image ls`
      
     `docker run -p 0.0.0.0:27017:27017 <image_id>`
     
     Mongo Server is up and running.   
 
 3. Confirm the MongoDB connection properties in application.properties file. 
 
`spring.data.mongodb.host=127.0.0.1`
`spring.data.mongodb.port=27017`
`spring.data.mongodb.database=CarWareHouse `


  ##### set up server #####
  
1. Create a new Java Project in Eclipse. Import project using Import --> File system option. Right click on the project. Go to configure & select convert into maven project.

2. download lombark.jar dependency from [here](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.12). Double click on
the jar and add eclipse in the path.

3. The default port to run the server is 8080. It can be modified in application.properties file.

 	`server.port=8081`
 	
4. Create a executable jar file of the application and run the jar. For instance:

  `java -jar ../target/Car-Resale-0.0.1-SNAPSHOT.jar `
  
5. Refer following swagger for Rest API specifications:

` http://localhost:8080/resale-cars/swagger-ui.html `