# SoleSource

<p align="center">
<img width="500" height="500" src="https://raw.githubusercontent.com/DevPinda/Not-Sketchers/main/Not-Sketchers/src/main/resources/static/img/Logo/5.png">
</p>

## Description

This repository holds the source code for the full-stack e-commerce platform "SoleSource" that is built around the Java Spring Boot Framework and is used to handle an inventory management system and sales for a business.

### **DISCLAIMER: Our brand name was originally "Not-Sketchers". Due to issues with search engine optimisation we have renamed our brand to "SoleSource".**

## Contributors

<b> 1. DevPinda (Parminder Singh)
2. kaziarham (Kazi Arham)
3. rabiafatima1 (Fatima Rabia)
4. AishaArwo (Aisha Arwo)
5. DaanyaalChughtai (Daanyaal Chughtai)
6. FreshPrinceTom (Thomas Merricks)
7. HassanAliCS1 (Hassan Ali)
8. hussainahmed02 (Hussain Ahmed)
9. Shoka-San (Aaron Willis) </b>

## Pre-requisites

### 1. Git Bash
### 2. IntelliJ IDEA Ultimate Edition (Community Edition does not support Spring Boot)
### 3. XAMPP
### 4. Maven
### 5. Java JDK 17

## Installation

### 1. Clone the repository: 
- Run the command below in <b>Git Bash</b> at your desired directory: ```https://github.com/DevPinda/Not-Sketchers.git```

### 2. Open the project in IntelliJ IDEA Ultimate Edition:
- Navigate to the directory where you cloned the repository and open the project in <b>IntelliJ IDEA Ultimate Edition</b>.

### 3. Install the required dependencies:
- Run the command below in <b>Git Bash</b> at the <b>root directory</b> of the project: ```mvn clean install```

### 4. Start the MySQL and Apache server:
- Open XAMPP and start the <b>MySQL</b> server alongside the <b>Apache</b> service.

### 5. Access the MySQL server:
- Open PHPMyAdmin and create a new database called ```sole_source_db``` and import the SQL file located at ```src/main/resources/sole_source_db.sql```.

## Configuration

### 1. Change the database credentials inside the application.properties file:
- Navigate to ```src/main/resources/application.properties``` and change the ```spring.datasource.username``` and ```spring.datasource.password``` to your MySQL username and password respectively.

### 2. Change the database credentials inside the DatabaseConnectionTest.java file:
- Navigate to ```src/test/java/com/sole_source/sole_source/DatabaseConnectionTest.java``` and change the ```spring.datasource.username``` and ```spring.datasource.password``` to your MySQL username and password respectively.

### 3. Verify the URL inside both the application.properties and DatabaseConnectionTest.java files:
- Verify that the ```spring.datasource.url``` is set to ```jdbc:mysql://localhost:3306/sole_source_db```, make sure the port number and the database name are set correctly.

### 4. Create a new Data Source inside IntelliJ IDEA Ultimate Edition:
- Open IntelliJ IDEA Ultimate Edition, at the top of the screen click on ```View``` and select ```Tool Windows``` and then select ```Database```
- Then click on the ```+``` button and select ```Data Source``` and ```MySQL```, then click ```OK```.
- In the ```Data Source Name``` field enter ```sole_source_db```, in the ```Host``` field enter ```localhost```, in the ```Port``` field enter ```3306```, in the ```Database``` field enter ```sole_source_db```, in the ```User``` field enter your MySQL username and in the ```Password``` field enter your MySQL password.

### 5. Verify the Data Source inside IntelliJ IDEA Ultimate Edition:
- Open and check every Entity File inside the entity package at path ```Not-Sketchers/src/main/java/com/cs2tp/notsketchers/entities``` and verify that the ```@Table``` annotation is set to the correct table name and the datasource is assigned to the Bean of each ```@Table``` annotation.

### 6. Run the application:
- In IntelliJ IDEA Ultimate Edition, run the application by clicking the green play button at the top right of the screen, otherwise locate the main class ```NotSketchersApplication.java``` and run it.