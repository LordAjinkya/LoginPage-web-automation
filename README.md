The project is developed using java, selenium, tesng, chromedriver for automation of Login page scenarios of the website. The project does not completely use the page object model as there is only one page to be automated. I haven't used a test base class to separately declare the locators and other properties. 

I have also used webdrivermanager which is compatible this version of selenium and doesn't require to define the path of chromeDriver

Versions of all the tools: - Apache Maven 3.9.5 || Java version: 1.8.0_391 || webdrivermanager: 5.5.3 || selenium-java: 4.15.0 || testng: 7.8.0 || chrome: 119.0.6045.105 || chromeDriver: 119.0.6045.105 || 

Website: https://www.saucedemo.com/v1/index.html

Challenges: I was getting this error,"org.openqa.selenium.sessionnotcreatedexception: could not start a new session. possible causes are invalid address of the remote server or browser start-up failure." while I tried executing the script. I tried cusing the same versions for both chrome and chromeDriver by reinstalling the chrome browser from the chromeDriver website. The error still persisted. Later I tried using this library "webdrivermanager" which doesnt require us to provide path of the driver using system property. The error was resolved then.

Scenarios: The scenarios covered in the test class are pretty self explanatory as I have used method names likewise and also have mentioned in the comments

Report: It is available in the index.html file. I havent used a extent report due to lack of time, however I have attached the reports screenshots here in the readme file



<img width="722" alt="image" src="https://github.com/LordAjinkya/LoginPage-web-automation/assets/55977408/46f5e21c-04d0-4657-82e3-5c4f559cc162">


<img width="721" alt="image" src="https://github.com/LordAjinkya/LoginPage-web-automation/assets/55977408/a818d31d-5f9b-40e9-bddb-66da339e65e2">


<img width="635" alt="image" src="https://github.com/LordAjinkya/LoginPage-web-automation/assets/55977408/e8a2bc3a-2d8c-4f5c-abf4-b6805046e29d">
# LoginPage-web-automation
