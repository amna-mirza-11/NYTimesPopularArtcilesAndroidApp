# NewYorkTimesPopularArticles
***Run Code on a real device***

Set up your device as follows:
Connect your device to your development machine with a USB cable. If you're developing on Windows, you might need to install the appropriate USB driver for your device.
Enable USB debugging in the Developer options as follows.
First, you must enable the developer options:

Open the Settings app.
(Only on Android 8.0 or higher) Select System.
Scroll to the bottom and select About phone.
Scroll to the bottom and tap Build number 7 times.
Return to the previous screen to find Developer options near the bottom.
Open Developer options, and then scroll down to find and enable USB debugging.

Run the app on your device as follows:
In Android Studio, click the app module in the Project window and then select Run > Run (or click Run  in the toolbar).
In the Select Deployment Target window, select your device, and click OK

Android Studio installs the app on your connected device and starts it. 
You should now see "NYTimesArticles" displayed in the app running on your device

***Run Test***
To Run the test go to app than src than androidTest folder
Inside AndroidTest multiple unit test files are avaiable for all parts of project. Open right file and right click on name of file.
It will show run option with file name, click on run button to run all unit test case inside file. 


***code coverage reports***
All the coverage reports are generated and placed in app folder than build folder and inside build there is reports folder
In reports folder Just open the index.html for overallreport but for individual package and classes you can check adjucent files.

***Generate coverage reports***
To generate coverage reports click on gradle button on right top corner than click on green icon,
after this box appear with project name , in command file write "createDebugAndroidTestCoverageReport" and press ok.
It will create code coverage reports.