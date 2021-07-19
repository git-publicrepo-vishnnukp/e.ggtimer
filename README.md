Project - Automate E.ggtimer.com

Instructions to execute the script:

Clone the git repo (git clone -b master https://github.com/git-publicrepo-vishnnukp/e.ggtimer.git)
Once downloaded, open the project in your favorite IDE.

To run the project:

1. Right click the project and select Run as 'Run Configurations'.

2. On the left hand pane, right click on 'Maven build' and add 'New Configuration'

3. In the new configuration, click on workspace button and select the project which you imported.

4. And, in the goals enter the following command 'clean test allure:report -DtestNGRunnerFile=testng.xml -Dbrowser=chrome -Dheadless=false -Denv=prod' and run
And, these options can be modified as well. (eg: browser = firefox, headless=true)

5. Also, allure report has been integrated with this framework. So once the tests run, refresh the project. Expand the Results -> allure-report folder and open the index.html in a browser.

Operating System used - OS X Catalina,
IDE used - STS 3.9.15(Spring tool suite),
Reports - Allure (Integrated with the framework),
Build tools - Maven,
Unit testing framework - TestNG,
Programming language - Java,
Automation framework - Selenium,

And all the dependencies are included in pom.xml.
