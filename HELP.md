# Getting Started
Cash Register System that returns the change value 

This system would support any kind of currency but limited to following contraints
* Customer purchase currency shall get change in the same currency
* Customer shall get back the denomination from highest currency denomination.
    * e.g. If paid in USD currency , the return change will in Hundred dollar followed by penny, nickel, dime, quarter and so on.
    * Sample 1 if purchase price (PP) is $20.02 and cach paid (CH) is $160  then cash returned is highest order of denomination will be
        * ONE HUNDRED,TWENTY,TEN,FIVE,TWO,TWO,HALFDOLLAR,QUARTER,DIME,DIME,PENNY,PENNY
    * Sample 2 if purchase price (PP) is $20.03 and cach paid (CH) is $50  then cash returned is highest order of denomination will be
         * TWENTY,FIVE,TWO,TWO,HALFDOLLAR,QUARTER,DIME,DIME,PENNY


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

