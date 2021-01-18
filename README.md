To run download the files from git. 

Install the test apk on a single emulator

Then use the command `gradle cucumber` from the project source

Alternative I have written and tested the code using IntelliJ and I can run the feature files by right clicking them and selecting run. 

I have written this framework using 2 physical devices and an emualtor. As The devices are identified by their uuid I have commented out the code that runs the test on them

**If you want to enable testing on physical devices:**

In the `DeviceDriver` class; under the method `getSamsungS105GDriver` update the `udid` cpability to the udid of your device and also update the `platformVersion` to match. This can also be done for the `getPixel4ADriver` to enable a second physical device

Then:

In the `HospitalsPageView` and `ResultPageView` uncomment out the commented out code. If you've just changed the Samsung details, just uncomment out the comments labelled samsung and same for the pixel. 

All the tests runn on the 3 devices sequencially.
