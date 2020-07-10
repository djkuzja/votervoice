#### Enviroment

 - JDK 11
 - Maven
 - Cucumber
 - Selenium WebDriver
 - JUnit
 
 
 ### Cucumber Selenium Test
 Under 'src/test' there is a suite of UI tests. The features file are located in the 'feature' folder in the 'resources/feature'. The step definition files containing a step definition for each step in a feature file. The 'steps' folder also includes a 'Hooks.java' file where all 'setup' and 'teardown' related actions are done. 
 
 #### Configuration
 Configurations for the cucumber tests resides in the project folder in form of '.properties' file.
 
 ### Test Running
 Cucumber is a JInit extension/ It's launched by running JUnit from Maven or IDE.
 To run with IDE uncomment 'tags' parameter in 'runners.cukesRunner'.
 
 
 #### From command line
 
 ##### To run a single scenario
 'mvn test -Dcucumber.options="-- tags@tagName'
 
 ##### To run all tests
 'mvn test'
 
 
