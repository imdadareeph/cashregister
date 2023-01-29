# cashregister

####Cash Register System that returns the change value 

This system would support any kind of currency but limited to following contraints
* Customer purchase currency shall get change in the same currency
* Customer shall get back the denomination from highest currency denomination.
    * e.g. If paid in USD currency , the return change will in Hundred dollar followed by penny, nickel, dime, quarter and so on.
    * Sample 1 if purchase price (PP) is $20.02 and cach paid (CH) is $160  then cash returned is highest order of denomination will be
        * ONE HUNDRED,TWENTY,TEN,FIVE,TWO,TWO,HALFDOLLAR,QUARTER,DIME,DIME,PENNY,PENNY
    * Sample 2 if purchase price (PP) is $20.03 and cach paid (CH) is $50  then cash returned is highest order of denomination will be
         * TWENTY,FIVE,TWO,TWO,HALFDOLLAR,QUARTER,DIME,DIME,PENNY

###Facts:
* This system doesn't take care of denomination where same number exists for a coin and Notes
    * Example : A country may have a coin of 1 value and a paper note for same 1 value.
    * This System will always take paper notes precedence over coins.
    * As future enhencement, the precedence can be taken as prefered value as user input.

### Environment for Development
 Those projects were developed with followings.

 * Java SDK 17 (17.0.2)
 * Spring-Boot (3.0.2)
 * Maven 3 (3.6.2)
 
### Run the demo
The whole application has been packaged to be run as mvn spring-boot:run
```
mvn clean install -Dmaven.test.skip=true
mvn spring-boot:run
mvn clean install -Dtest="CashRegisterConfigsTest"
```