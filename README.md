==================================================================================
BDD Cucumber Selenium Webdriver Appium Rest-Assured Java TestNg Extent Report Automation Framework
==================================================================================
This project is a template test automation framework, which provides structured and standard way of 
creating automated test scripts for GUI, Mobile and API level tests across projects  

This is a reusable automation framework that blends together Selenium WebDriver, Appium, Android Driver, Rest Assured, SauceLabs and Cucumber JVM (incorporating Gherkin and the BDD 'Given, When Then' testing construct)   

This framework supports automation of : - 
* Web Browsers (Chrome, But can be easily scalled to use other commonly used browsers)  
* Web Browser Responsive Design with view ports configuration  --todo
* Mobile Automation on Emulated and Physical Devices, for Native, Hybrid, and Web App  
* Mobile Automation on Cloud using SauceLabs
  

The framework incorporates design principle of BDD (Behaviour driven development) which promotes
 writing acceptance tests by describing behaviour of application under test in simple english language from
 the perspective of its stakeholders. 
 Having test written in Natural language helps the Project Team 
 (Product Owners, Business Analysts, Development and QA team) to understand and track the requirements
 
Supports Custom Page Object model which represents the screens of application under Test as a series of objects and 
encapsulates the fields represented by a page which ultimately avoids duplication and improves code maintainability and readability.  
    

Tools & libraries
=================
The test automation framework is comprised of following tools and libraries  

* Cucumber-JVM:- BDD Framework  
* Custom Page Object Pattern and utility functions  
* Selenium WebDriver: - Browser automation framework
* Rest-Assured: - Restful Api framework   
* Android Driver: - Android Mobile Automation  
* Appium: - Mobile Native app, Hybrid App, Web app  
* Selenium Grid: - Distribute test Execution across several machines 
* SauceLabs: - Cloud Based testing of mobile and Web Apps  
* JAVA: - Programming language  
* TestNg: - TestNg Java testing framework  
* Maven: - Build tool  
* Jenkins: - Continuous Integration  
* PicoContainer: - Standard Dependency Injection     
* Git: - Version Control  
* Github or Local Git Server: - Git repository hosted server  
* Intellij Or Eclipse: - Integrated Development Environment  
* Hamcrest library: - Assertion for tests 
* Extent Reports 4.0: - Logging and Test Reporting  
* DbUtils Mysql (optional): - Java Database utility api (Easily Integrable)     
* PhantomJsDriver, GhostDriver (optional): - Full web stack No browser required supporting headless testing (Easily Integrable)
* AutoIt (optional): - To interact with windows based components (Easily Integrable)  
* Zalenium : Using Docker to build a testing infrastructure for web UI and mobile

Test Automation framework support
------------------------------------------
Ashwin Naik
--------------
Test Automation Architect  
ashwinnaik87@gmail.com  



Machine Configuration
====================
Configure Windows and setup: -   
*Java 8  
*Git
*Maven  


Get the latest Source Code
===========================
Open Terminal or command line
cd to the desired folder where the test automation source code needs to be checkout

Run command
git clone https://github.com/ashwin363636/Cucumber_TestNG_Extent_Project.git

This will download the latest template source code

IDE Configuration
==================
Intellij plugins  
----------------
Configure and Install Following Plugins  
File >> Setting >> Plugins >> Browser Repositories>

*Cucumber for Java
*Gherkin
*Git Integration  
*Maven Integration

Eclipse plugins  
----------------
Configure and Install Following Plugins  
Help>>Install new software
*Cucumber for Java
http://cucumber.github.com/cucumber-eclipse/update-site  

*TestNg  

*Git Integration

Plugin configuration for Cucumber Feature
Open Run Configurations
Select Cucumber Feature and create one new configuration
Project: Cucumber_TestNG_Extent_Project
Feature: /src/test/resources/features
Glue:  com.cucumber.testng.step_definition
Reports:  Extent Reports, monochrome, pretty

File >> Setting >>  
Search for Annotation Processing  
(Java Compiler ... Annotation Processing>> Enable the check box


Import Project into Intellij
----------------------------
File>Import Project>
Browse to Cucumber_TestNG_Extent_Project



Import Project into Eclipse
--------------------------
File>Import>Maven>Existing Maven Projects>Next>
Browse to Cucumber_TestNG_Extent_Project
Ensure pom.xml is found
Finish

open terminal
cd to test root directory
run "mvn clean eclipse:eclipse" 



Framework Setup steps
============================

In pom.xml we use the relative path within <profile.path> as shown below to invoke or make use of these profiles. 
src/main/resources/profiles

Open "pom.xml" 
Scroll to Profile section : - Choose desired profile e.g "dev" for running locally

        <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-surefire-plugin</artifactId>
              <configuration>
                  <suiteXmlFiles>
                      <suiteXmlFile>${Mode}.xml</suiteXmlFile>
                  </suiteXmlFiles>
              </configuration>
         </plugin>


Compile Build or Run Tests
==========================

Command Line

cd to root ot Cucumber_TestNG_Extent_Project project directory

To clean and compile the build
-----------------------------
clean test -Dmaven.surefire.debug -Dtest= -DMode=<Execution Mode>

To run all tests parallel
------------------------
mvn clean install -Dtest= -DMode=Runall

To run a single test with tags
------------------------

mvn clean install -Dcucumber.options="--tags @gui --tags ~@api" -P single

** Note "~" before tag means this specific tag will not run

To Rerun failed test scenarios
---------------------------------------------
After a test suite is run. There is rerun.txt created at the project root level in rerun folder. This rerun file contains the details of all the failed scenarios.
e.g target/cucumber-report/single/rerun.txt

mvn clean install -Dcucumber.options="@rerun/rerun.txt" -P single


Jenkins
======

mvn clean install  -P jenkins

** Create 3 string parameters in jenkins 
with the below conventions which will be passed on as an argument to the above maven command  

Key: cucumber.options Default Value: --tags @gui, @api     
Key: driverhost  Default Value: 0000.000.000.00 (RAS server with selenium server configured for the project)  
Key: driverport  Default Value: 4444  


Report
======

Local reports
-------------

Extent Reports
A report will be generated at /reports

Standard HTML Report  
A report will be generated at /target/cucumber-report/index.html  

Preety Cucumber-Html Report  
A report will be generated at /target/cucumber-report/cucumber-html-reports/feature-overview.html 

Jenkins report
--------------
The report will be available as part of configured Jenkins test build  
**Cucumber plugin for Jenkins needs to be installed



Getting Started
===========================


Feature Files
-------------------------------------------------------------------
These files contains the acceptance criteria which are written in Gherkin Language and contains various scenarios.  
The feature files are tagged with "@tagname" to group common feature files 

File Extension:  *.feature    
Location: "/src/test/resources/features"      
Directory:  Separate directories for GUI, API and Mobile tests. I have grouped common features files in a 
single directory    
File Conventions: Meaning full name "WebRegister.feature"
Example:   
@Sequential
Feature: Testing the login feature so we can verify no unauthorised user can login to the system

  Scenario Outline: Web failure Test
    Given Open Application and Enter url



Page Objects
-------------------------------------------------------------------
PageObjects are used to store the WebElements for a Web Page.
A good practice is to have a separate class for every single WebPage.
To avoid duplication for multiple pages which have common web page elements a Parent class can be created 
and the child class can then inherit.  
Every Page  class extends "BasePage.class" to make use of the Driver Object and utility functions.  
In case of Parent and Child Class, Parent class extends BasePage class and child class extends Parent class      
   
Location: /src/test/java/com/cucumber/testng/page_objects
Directory structure: Group common Page Objects classes in a single directory e.g Login Functionality Classes in Login Directory      
File Conventions:Every Class file ends with Page.class (Loginpage.class)  

Example:   

public class HomeSamplePage extends PageObject {

    public By LOGIN_BTN = By.xpath("//button[@id='loginButton']");
    
        public MenuPage performLogin(LoginCredentials credentials) {
            System.out.println("Clicking login button");
            getDriver().switchTo().defaultContent();
            input(USERNAME_INPUT, credentials.getUsername());
            input(PASSWORD_INPUT, credentials.getPassword());
            click(LOGIN_BTN);
            return new MenuPage();
        }
}


Step Definitions
 --------------------------------------------------------------------
 Every steps defined in Feature file needs to be implemented in Step Definitions Class
 
 Location: /src/test/java/com/cucumber/testng/step_definition 
 Directory structure: Separate directories for GUI, API and Mobile tests. Grouped common step definition files in a 
                      single directory    
 File Conventions:Every Class file ends with StepDef.class (LoginStepDef.class)  
 
 Example:  
 
 public class HomePageSteps {
 
    private HomeSamplePage homePage =  new HomeSamplePage();
 
     @Given("^Open Application and Enter url$")
         public void open_Application_and_Enter_url() {
             System.out.println("Calling Login Action to launch  the application");
             loginActions.launchApplication();
         }
 }
 
 Actions class
 --------------------------------------------------------------------
 Every action defined in Feature file needs to be implemented in Actions Class
 
 Location: /src/test/java/com/cucumber/testng/action 
 Directory structure: Separate class has been created for each major epic in the application
  (group of related features)
  
 File Conventions:Every Class file ends with Actions.class (LoginActions.class) 
 The Class is used to interact with all the Page classes to implement a test and extract
  the required response to be asserted in the step defination class.
 
 Example:  
 
 public class LoginActions {
     private LoginPage loginPage;
     private MenuPage menupage;
  
     public LoginActions(LoginPage loginPage, MenuPage menupage){
         this.loginPage = loginPage;
         this.menupage = menupage;
   
     }
 
     public void launchApplication(){
         System.out.println("launchApplication");
         WebDriverFactory.createDriverInstance(Settings.BrowserType);
         loginPage = launchAUT();
     }

Run Test Suite
--------------------------------------------------------------------
Test Suites are used to run a group of Tests which are tagged and represented in form of Feature files & Scenarios

Location: /src/test/java/com/cucumber/testng/runner
File Conventions:Every Class file ends with Runner.class (ParallelRunner.class)  


    @CucumberOptions(
            features = "src/test/resources/features",
            glue = {"com.cucumber.testng.step_definition"},
            tags = {"not @Sequential"},
            plugin = {"pretty", "html:target/cucumber-report/single",
                    "json:target/cucumber-report/single/cucumber.json",
                    "rerun:target/cucumber-report/single/rerun.txt",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
    )
    public class ParallelRunner extends BaseRunner {
    }

Where: -  
features: represent the location of feature files from the compiled build  
tags:  multiple tags can be specified by comma separated denotation, if a specific tag needs to be excluded then this 
        can be specified by "~" . e.g "~@api" feature files tagged with "~api" will not be run as a part of Test Suite.  
plugin: html, json, Extent report and rerun reports are created. if a TesSuite is renamed then change the reporting directory name for both reports  
   

Other ways to run the tests or Test Suite
---------------------------------------------
*command line using Maven:- mvn clean test -Dmaven.surefire.debug -DMode=debug -Dview=iphone -Dzalenium=false
Mode- Enables the Debug/Normal mode of test execution
View- Enables a certain viewport for the browser to execute test
Zalenium- executes test in Zalenium grid network
 
  

