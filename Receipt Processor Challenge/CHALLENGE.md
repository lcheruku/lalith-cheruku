# Introduction

Receipt Processor Challenge is a problem where I need to build a comprehensive web service using a backend technology to solve it. Through out this process, I've put my best foot forward to think broadly, solved most of the edge cases, dry run the test cases and finally achieved the desired outcome. 

In this brief summary, I'll explain everything about my thought process, what steps I took to solve the problem, how I managed and autowired corresponding dependencies, walk through all files and folders etc.

I'll end this conversation by configuring docker images followed by building and running them in a docker container. Without wasting any much time, Let's get going🏃‍♂️‍➡️

## What was the challenge about?

This challenge is about building a web service that fulfills the openAPI documentation provided in a yml file. You'll find the documentation in src/main/resources/api.yml. Before I worked on solving this problem, I gave a quick glance at my tech expertise and went about gathering up the important things I need in my armoury.

## What do I need in the first place🤔?

There are several things I need to figure out from the plenty of options I have to solve this problem. Based on the problem, I realized these choices as optimal.

### 1. What web service do I need?

   The specifications for this challenge are,
   * Payload: JSON payload(view src/main/resources/examples for example cases)
   * Response: JSON object

   Based on these specifications, I thought **REST web service** is the best web service I can use to build the respective API endpoints.

### 2. Which programming language do I need to select?

   I'm proficient in both Java and Node.js. However, my choice of preference is **Java** because of it's immense ability to create necessary REST endpoints making use of a robust and reknowned framework called **SpringBoot**.

### 3. How do I generate the id values from my code?

There are many ways I could've gone. For example, use Spring Data JPA for generating id values with auto-increment through @GeneratedValue annotation. However, we are not working with any database at this point. Therefore, I decided to use UUID(Universally Unique Identifier) and used randonUUID() to randomly generate values. But a small anamoly here is that everytime I call the receipts/process endpoint, new id values get generated for the same request body after commiting a POST method. But I still opted for it because of the example response provided in the summary section of the challenge page.

### 4. Are there any additional headers needed to implement?

Not needed

### 5. Which REST client do I need to use?

There are many REST clients you'll come across in your Software Development journey. For this problem, there is no specific reason choose a particular REST client unless you wanna say you are familiar with it. I choose **POSTMAN** because I'm more familiar with its interface.

## What are the different edge cases I came across?

I've this habit of analyzing different edge cases before even starting to solve the problem. I'm more used solving both the problems and edge cases at the same time. For this challenge, I've come across quite a few edge cases while resolving most of them. I'll put forward these edge cases down below.

1. **Invalid Payloads** - As mentioned, API endpoints accept only JSON payloads. rest all are considered invalid.
2. **Transfer protocol** - Because of using RESTful services, I was only able to use http and https protocols to successfully load API endpoints.
3. **id Value** - As mentioned previously, randomized UUID values were used based on the specification given by this problem. UUID is not tightly-coupled to the receipt once called, which means id's for the same receipt keep chaning.
4. **Input validation** - Input values for Retailer names and description are generally a mix of characters including special characters like @, !, # etc. Inputs accept all characters including alphanumeric and non-alphanumeric.
5. **Date and Time validation** - Errors like 13th month, 31st date, 25th hour of the day, 61st minute of the hour etc., are prone to happen as these entities do not exist.

## 
