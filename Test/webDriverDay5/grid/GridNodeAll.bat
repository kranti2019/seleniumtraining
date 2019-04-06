c:
cd "C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingoct18weekdays\lib"
java ^
-Dwebdriver.gecko.driver="C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingoct18weekdays\test\resources\geckodriver64bit.exe" ^
-Dwebdriver.chrome.driver="C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingoct18weekdays\test\resources\chromedriver.exe" ^
-Dwebdriver.ie.driver="C:\Users\Ketan\SkyDrive\Selenium\workspace\webdrivertrainingoct18weekdays\test\resources\IEDriverServer.exe" ^
-jar selenium-server-standalone-3.141.59.jar -role node ^
-hub http://192.168.0.111:4444/grid/register ^
-browser "browserName=firefox,maxInstances=1,platform=Windows" ^
-browser "browserName=chrome,maxInstances=9" ^
-browser "browserName=opera,maxInstances=4" ^
-browser "browserName=android,maxInstances=2" ^
-browser "browserName=internet explorer,maxInstances=5" ^
-browser "browserName=safari,maxInstances=150" ^
-maxSession 20
pause