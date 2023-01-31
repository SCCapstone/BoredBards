# BoredBards Capstone Project Repository

This is the repository for our Android app, _The DM's Grimoire_, for DMs/GMs of the tabletop role-playing game _Dungeons and Dragons_. It features a section for the DM's campaign(s) and notes for each. The application also has databases of items, spells, monsters, etc. for the DM to use in constructing and running their games. For a more detailed description of the application and its capabilities, check the repository's wiki page [here](https://github.com/SCCapstone/BoredBards/wiki).

## Style Guide
This application follows [Google's Style Guide for Java](https://google.github.io/styleguide/javaguide.html)

## External Requirements
> To build this application, you'll need the following:
### On Ubuntu or Debian Based Linux
##### OpenJDK
```sh
sudo apt update
sudo apt install -y openjdk-18-jdk
sudo apt install -y openjdk-18-jre
```
##### Android Studio
* Visit [this](https://developer.android.com/studio/index.html#downloads) website
* Then download and unpack the android-studio-<version.number>-linux.tar.gz
* Once unpacked, run the contained studio.sh file and follow all subsequent instructions
* To import the project, choose "From VCS" in the project creation menu and select the SCCapstone/BoredBards repository

##### Environmental Variables (For React Native)
> Add the following to your **$HOME/.bash_profile** or **$HOME/.bashrc**
```sh
export ANDROID_SDK_ROOT=$HOME/Library/Android/Sdk
export PATH=$PATH:$ANDROID_SDK_ROOT/emulator
export PATH=$PATH:$ANDROID_SDK_ROOT/platform-tools
```

### On Windows x64
> Download Android Studios through the [Android Studios website](https://developer.android.com/studio?gclid=Cj0KCQjw48OaBhDWARIsAMd966C3-36dorjYTl49utxjZVQB-1tlXhZzmWTdbtlbZcCPWcbVX_C2B5MaAooNEALw_wcB&gclsrc=aw.ds#downloads)
>
> Install the package and then follow the instructions given

##### An Android Device
> This can be either a physical device or, more commonly, an Android Virtual Device (accessible from Android Studio)
* Visit [this](https://developers.foxit.com/developer-hub/document/create-an-emulator-for-testing-in-android-studio/) website to download an Android Virtual Device (AVD) for when a physical android phone is not available to test

## Setup

## Running the Application
> To run the application, choose an AVD from Android Studio's lists of virtual devices or connect a physical device to your machine and select it. Then, run the application from Android Studio

## Deploying the Application
> To deploy the application, follow the relevant instructions listed at [this](https://developer.android.com/studio/publish) website. In short, you need to remove any calls to **_Log_** and the **_android:debuggable_** attribute from the manifest file. With Gradle, you can use the **_release_** build type to set build settings for the published version of the application

## Testing
### Test Location
* Unit tests are located in the directory labeled: *_app/src/test/java/com/example/bored_bard_*
* Instrumentation tests are located in the directory labeled: *_app/src/androidTest/java/com/example/bored_bard_*

### Running Tests
> These instructions assume that testing is being done within the Android Studio IDE (for other testing instructions, see the official Android Documentation [here](https://developer.android.com/training/testing/fundamentals))
* To run any one of the test methods, right-click the method or class and select the "Run <test name>" option in the menu
* To run all instrumented test methods, right-click the *_app/src/androidTest/java/com/example/bored_bard_* directory and select the "Run tests in <directory name>" option in the menu
* To run all unit test methods, right-click the *_app/src/test/java/com/example/bored_bard_* directory and select the "Run tests in <directory name>" option in the menu
* Alternatively, you can run a test by selecting it from the menu next to the "Build" button and then clicking "Run"

## Repository and Code Authored by: 
Jake Powers, Caroline Barrineau, Charles Simons, Andrew MacMurray
