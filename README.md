# BoredBards Capstone Project Repository

This is the repository for our Android app for DMs/GMs of the tabletop roleplaying game _Dungeons and Dragons_. It features a section for the DM's campaign(s) and notes for each. The application also has a database of items, spells, monsters, etc. for the D to use in constructing and running their games.For a more detailed description of the application and it's capabilities, check the repositiry's wiki page [here](https://github.com/SCCapstone/BoredBards/wiki).

## Style Guide
This application follows [Google's Style Guide for Java](https://google.github.io/styleguide/javaguide.html)

## External Requirements
> To build this application, you'll need the following:
### On Ubuntu or Debian Based Linux
### React Native
##### Node.js 
```sh
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash - &&\
sudo apt-get install -y nodejs
```
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

##### Environmental Variables (For React Native)
> Add the following to your **$HOME/.bash_profile** or **$HOME/.bashrc**
```sh
export ANDROID_SDK_ROOT=$HOME/Library/Android/Sdk
export PATH=$PATH:$ANDROID_SDK_ROOT/emulator
export PATH=$PATH:$ANDROID_SDK_ROOT/platform-tools
```
##### React Native CLI
> To use React Native's built-in CLI in a new project, run
```sh
npx react-native init <ProjectName>
```
> This is not necessary if you are integrating React Native into an existing project

##### An Android Device
> THis can be either a physical device or, more commonly, an Android Virtual Device (accessible from Anroid Studio)

## Setup

## Running the Application

## Deploying the Application

## Testing (To Be Added Later)

# Authored by: Jake Powers, Caroline Barrineau, Charles Simons, Andrew MacMurray
