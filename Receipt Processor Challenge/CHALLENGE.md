# Introduction

Receipt Processor Challenge is a problem where I need to build a comprehensive web service using a backend technology to solve it. Through out this process, I've put my best foot forward to think broadly, solved most of the edge cases, dry run the test cases and finally achieved the desired outcome. 

In this brief summary, I'll explain everything about my thought process, what steps I took to solve the problem, how I managed and autowired corresponding dependencies, walk through all files and folders etc.

I'll end this conversation by configuring docker images followed by building and running them in a docker container. Without wasting any much time, Let's get going🏃‍♂️‍➡️

## What was the challenge about?

This challenge is about building a web service that fulfills the OpenAPI documentation provided in a yml file. You'll find the documentation in src/main/resources/**api.yml**. Before I worked on solving this problem, I gave a quick glance at my tech expertise and went about gathering up the important things I need in my armoury.

## What do I need in the first place🤔?

There are several things I need to figure out from the plenty of options I have to solve this problem. Based on the problem, I realized these choices as optimal.

### 1. What web service do I need?

   The specifications for this challenge are,
   * Payload: JSON payload(view src/main/resources/*examples* for example cases)
   * Response: JSON object

   Based on these specifications, I thought **REST web service** is the best web service I can use to build the respective API endpoints.

### 2. Which programming language do I need to select?

   I'm proficient in both Java and Node.js. However, my choice of preference is **Java** because of it's immense ability to create necessary REST endpoints making use of a robust and reknowned framework called **SpringBoot**.

### 3. How do I generate the id values from my code?

There are many ways I could've gone. For example, use Spring Data JPA for generating id values with auto-increment through @GeneratedValue annotation. However, we are not working with any database at this point. Therefore, I decided to use UUID(Universally Unique Identifier) and used randonUUID() to randomly generate values. But a small anamoly here is that everytime I call the receipts/process endpoint, new id values get generated for the same request body after commiting a POST method. But I still opted for it because of the example response provided in the summary section of the challenge page.

### 4. Are there any additional headers needed to implement?

Not needed

### 5. Which REST client and IDE do I need to use?

There are many REST clients and IDEs you'll come across in your Software Development journey. For this problem, there is no specific reason choose a particular REST client unless you wanna say you are familiar with it. I choose **POSTMAN** and **Eclipse** because I'm more familiar with there interfaces.

## What are the different edge cases I came across?

I've this habit of analyzing different edge cases before even starting to solve the problem. I'm more used solving both the problems and edge cases at the same time. For this challenge, I've come across quite a few edge cases while resolving most of them. I'll put forward these edge cases down below.

1. **Invalid Payloads** - As mentioned, API endpoints accept only JSON payloads. rest all are considered invalid.
2. **Transfer protocol** - Because of using RESTful services, I was only able to use http and https protocols to successfully load API endpoints.
3. **id Value** - As mentioned previously, randomized UUID values were used based on the specification given by this problem. UUID is not tightly-coupled to the receipt once called, which means id's for the same receipt keep chaning.
4. **Input validation** - Input values for Retailer names and description are generally a mix of characters including special characters like @, !, # etc. Inputs accept all characters including alphanumeric and non-alphanumeric.
5. **Date and Time validation** - Errors like 13th month, 31st date, 25th hour of the day, 61st minute of the hour etc., are prone to happen as these entities do not exist.
6. **HTTP methods for endpoints** - Process Receipts endpoint accepts only POST whereas Get Points endpoint accepts only GET. Using methods other than what were assigned like using GET for Process Receipts and PUT for Get Points etc., would result in "Method not allowed" error. 

## What is my thought process? How I approached step-by-step👨?

As I decided to build REST APIs using Spring Boot framework, I created different classes in my Eclipse IDE. I'll explain them one by one down below.

1. SpringBootApplication class - I created **ReceiptProcessorChallengeApplication.java** class using *@SpringBootApplication* to start off my spring boot application. You'll find this class in src/main/java/SpringBootApplication folder.
2. Model classes - I wanted to create two model classes to determine the format and key-value pairs of my JSON payload. One is **Receipt.java** and **Item.java**. View them at src/main/java/Model folder.
3. Service classes - Now it's time for Service class. These are usually annotated with *@Service*. Take a look at them in src/main/java/Service folder.
   1. I created **ServiceReceipt.java** for created two methods namely **processReceipt()** and **getPoints()**. These methods contain application logic with respect to the request and response specification mentioned in OpenAPI documentation. These methods are called by the RestController class as soon as our API endpoints are triggered.
   2. The main purpose of **PointsAwarded.java** class is to calculate the points for receipts based on the set of rules mentioned in the challenge description.
4. Controller class - I've configured all the above classes to this *@RestController* annotated **ReceiptController.java** class. API endpoints, http methods **POST** and **GET**, request body and path variable are clearly mentioned. Service class methods are called as soon as the API endpoint is called in POSTMAN and appropriate response get generated within 100-150ms. See code in src/main/java/Controller folder.

But, this is not how I begun. I started off by building a compatible project using **Spring Initializr**. For that, I
1. Opened a web browser(Chrome).
2. Typed start.spring.io on the address bar and pressed enter.
3. Selected project as **Maven**, language as **Java**.
4. Selected most recent Spring Boot version(did not choose Snapshot versions because they are still under development).
5. Gave project metadata as per my convenience.
6. Chose **Jar** packaging.
7. Added **Spring Boot Starter Web** and **Spring Boot DevTools** dependencies and clicked Generate.

A jar file was downloaded in my local machine in a Zip folder. I extracted it into a folder and then,
1. I opened Eclipse
2. Clicked on File(Top-left corner)
3. Clicked on Import
4. Clicked on Existing Maven Projects, hit next.
5. Selected the root directory where this jar file is residing and hit finish.

I was successfully able to open a Maven project generated by the Spring Initializr and I'm ready to code. I quickly glanced at *pom.xml*(main folder) and *application.properties*(src/main/resources) to see I have all the necessary dependencies and configurations needed for this challenge. 

I used the default *8080* port server. However, I still including the port number as 8080 in my application.properties files to ensure my application is running in that same port.

After finishing my code, I run my project using **Maven Build** command. For that, I right-clicled on my project name in the project explorer, selected *Run As*, hit *Maven Build..*, typed **clean package** in the goals field and clicked **Run**. A jar file has been downloaded to my target directory in my local machine. I would deploy this jar file to a docker container and I'll explain how I did it very soon. For now, after I generated my jar file, I run my code and executed it in POSTMAN Rest Client.

## How did I dry run my test cases?

To do a dry run, I opened my POSTMAN app in my local machine and did the following,
1. I've selected http method as **POST**, typed *http://localhost:8080/receipts/process* in the address field, pasted the content of **morning-receipt.json** from the example folder in the **Body** section and hit Send. This API called the processReceipt() method in the service class. This is the example response I got,

    Response:

       {
       "id": "c3c55e53-259a-4ca6-aacd-68d3f9aa3493"
       }

 2. Now, I selected **GET** http method, typed *http://localhost:8080/receipts/c3c55e53-259a-4ca6-aacd-68d3f9aa3493/points* and hit Send. This API called getPoints() method and generated the response as follows,

    Response:

        {
        "points": 15
        }

3. Likewise, I tried dry-running my other example test case i.e., **simple-receipt.json**. I repeated the above process to get respective responses as below.

   1. POST: *http://localhost:8080/receipts/process*

      Response:

            {
            "id": "2aae0161-b571-40e7-a2cd-e115349c6398"
            }

   2. GET: *http://localhost:8080/receipts/2aae0161-b571-40e7-a2cd-e115349c6398/points*
  
      Response:

            {
            "points": 31
            }

4. I also dry runned the test cases displayed in the summary page and got appropriate results.

This is how I went about solving the problem. I've also calculated the points for the example receipts in a piece of paper & compared them with the response I got. As expected, they are all the same. Then, I played with it for some time and stopped my project from running. I re-checked calling the API endpoint at POSTMAN after stopping my project in Eclipse. I got "Could not send request" error as expected.

## How I setup Docker image and built them with the Docker container?

To setup docker, I followed a simple -step process. Go through the following steps one-by-one.

1. Firstly, I Opened GitBash terminal in my Eclipse IDE by right-clicking on my project name and clicking "Show Local Terminal" button.
2. 
