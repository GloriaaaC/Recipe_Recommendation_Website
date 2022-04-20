# ELEC5619 Project - *Pick&Cook*

## Dependencies
<!-- List all used libraries and their versions -->

Prerequisites:

- [MySQL 8](https://www.mysql.com/downloads/)
- [Java (JDK 11)](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3](https://maven.apache.org/download.cgi)

Java libraries:

| groupId                  | artifactId                     | version |
| :----------------------- | :----------------------------- | :------ |
| com.baomidou             | mybatis-plus-boot-starter      | 3.4.3.4 |
| com.google.code.gson     | gson                           | 2.8.2   |
| javax.servlet            | avax.servlet-api               | 4.0.1   |
| javax.servlet            | jstl                           | 1.2     |
| junit                    | junit                          | 4.13.2  |
| mysql                    | mysql-connector-java           | 8.0.26  |
| org.apache.tomcat.embed  | tomcat-embed-jasper            | 9.0.52  |
| org.jetbrains            | annotations                    | 22.0.0  |
| org.projectlombok        | lombok                         | 1.18.20 |
| org.springframework.boot | spring-boot-starter-parent     | 2.5.4   |
| org.springframework.boot | spring-boot-starter-test       | 2.5.4   |
| org.springframework.boot | spring-boot-starter-tomcat     | 2.5.4   |
| org.springframework.boot | spring-boot-starter-validation | 2.5.4   |
| org.springframework.boot | spring-boot-starter-web        | 2.5.4   |

## Functionalities
<!-- List all working functionalities of the project -->

**Account** - enables users to store user-related data such as favourite recipes.
- Users are able to register an account.
- Users are able to log in.
- Users are able to change their password.
- Users are able to log out.

**Favourite** - help users remember their favorite recipes. They can use this feature to practice over and over again and strengthen their mastery of certain recipes.
- Users are able to follow a certain recipe.
- Users are able to unfollow a certain recipe.
- Users are able to create a favourite folder to store recipes.
- Users are able to remove a favourite folder.
- Users are able to add a certain recipe to a certain folder.
- Users are able to remove a certain recipe to a certain folder.

**Search** - help users to find suitable recipes for learning and skill-improving.
- Users are able to search for a recipe by name.
- Users are able to get recommended recipes by selecting ingredients.
- Users are able to avoid certain ingredients included in the recommended recipe.
- Users are able to search for an ingredient by name.

**History** - help users remember recipes they've learned or browsed.
- Users are able to view their recipe browsing history.
- Users are able to delete certain browsed recipe history.

**Commenting** - allow users to share their experiences and insights.
- Users are able to rate a specific recipe.
- ​​Users are able to comment on a specific recipe.
- Users are able to delete their rate and comments.

### Non-functional Requirements

- The system provides worldwide cuisines. (Cultural)
- The system opens the recipe page within 2s once the users clicked a specific recipe. (Performance)
- The system encrypts users’ accounts and securely stores them in cloud service. (Security)
- The system responds to feedback within 1s once the users clicked a button. (Performance)
- The system is able to run in any browser, such as chrome, firefox, ie, microsoft edge. (Compatibility)
- The system allows users to zoom the recipe picture size, for example the default home page can display 4×4 recipes, users can change it to 3×3 bigger recipe pictures.(Accessibility)
- The website pages are concise and clear, ensuring that users can operate easily. (Usability)
- The system supports simultaneous use by multiple users. (Capacity)

## Usage
<!-- A quick guide on how to run your application -->

Make sure you are in the root directory of the project.

**1 - Setup database**

Connect to MySQL Server, then execute following commands to create tables.

```
CREATE DATABASE recipeweb;
USE recipeweb;
SOURCE tables.sql;
SHOW TABLES;
QUIT;
```

**2 - Run the application**

Check the configuration file located in `src/main/resources/application.yml`.
Make sure the database URL and the user information are correct.
Then, use Maven to run the application.

```
mvn clean install
mvn spring-boot:run
```

Now, you can go to [http://127.0.0.1:8080/login]() to explore our website.

Alternatively, you can use [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) to run the application without hassle.

## Authors

Ziyan Chen, Siyang Hu, Yitian Lin, Yihang Wu, Zhipeng Zhou

