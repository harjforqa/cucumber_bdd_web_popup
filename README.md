# Welcome !

Hi! This readme file will act as a guide to get started on the Cucumber/BDD test automation framework for automating web
apps. Below are the tools being in use:

## Tools Used with their versions

| Tool Name    	       | Version                   				  |
|----------------------|---------------------------------|
| `Java` 			           | openjdk 17.0.7 2023-04-18 LTS 	 |
| `IDE`                | IntelliJ IDEA Community Edition |
| `Cucumber`           | 7.6.0                           |
| `Apache Maven`       | 3.8.6                           |
| `TestNG`             | 7.5.1                           |
| `Selenium WebDriver` | 4.11.0                          |        
| `ExtentReports`      | 5.0.9                           |     

## Test Cases Structure

    • Test Cases/Cucumber Feature Files: {ROOT}/src/test/resources/FeatureFiles/Amazon.feature
    • Step Definitions: {ROOT}/src/test/java/stepDefinitions
    • Page Objects: {ROOT}/src/test/java/pageFactory
    • Page wise reusable actions: {ROOT}/src/test/java/actions

## Folder Structure(top to bottom)

> > **Project ROOT >** cucumber_bdd_web
>
> > **Project ROOT** > pom.xml > Maven dependencies
>
> > **Logs** > Contains application logs(both error and info logs)
>
> > **Reports** > Test execution reports(extent report) along with screenshots
>
> > **pageObjects** > Contains page locators and reusable actions
>
> > **Reports** > Test Report in HTML format
>
> > **src > main > resources**
> > **config.properties** > contains application flag settings
>
> > > **extent.properties** > configuration settings for extent reports
>
> > > **log4j2.xml** > settings for application logs
>
> > **src > test > java**
> > > **actions** > low-level reusable methods for every web page
>
> > > **pageFactory** > contains page locations
>
> > > **stepDefinitions** > high-level reusable methods for every web page
>
> > **src > test > utilities**
> > > **ConfigReadUtil.java** > utility to fetch common info stored in config.properties file
>
> > > **DriverUtil.java** > utility to invoke and quit driver
>
> > > **GetArgumentUtil.java** > utility to get command line arguments. Helpfull in passing browser name and environment
> > > name during run time
>
> > > **LogUtil.java** > utility to print application logs
>
> > > **WrapperUtil.java** > contains all the selenium wrapper methods e.g. findElement() etc
>
> > **src > test > resources**
> > > **FeatureFiles** > contains actual test cases in the form for feature files

## Command line options in cucumber maven

| Command      						                           | Purpose                       				                  |
|-----------------------------------------------|:----------------------------------------------------|
| `mvn test` 					                              | run all the test cases        			                   |
| `-Dbrowser=chrome`                            | provide browser name                                |
| `-Denv="saucedemo"`                           | provide testing environment name                    |
| `-Dcucumber.filter.tags="@smoke"`             | provide tag name via command line                   |
| `-Dcucumber.filter.tags="@smoke or @sanity"`  | execute scenarios having either tag @smoke, @sanity |
| `-Dcucumber.filter.tags="@smoke and @sanity"` | execute scenarios having both tags @smoke, @sanity  |

## Useful commands to run test cases

`mvn test`

`mvn test -Dbrowser="chrome"`

`mvn test -Dbrowser="chrome" -Dcucumber.filter.tags="@e2e"`

## Naming conventions to be followed

    • PascalCase - ClassNames, DirectoryNames, 
    • camelCase - packageNames, methodNames, variableNames, locatorNames
    • Generic case - Feature files