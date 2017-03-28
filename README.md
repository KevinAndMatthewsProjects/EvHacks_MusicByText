## Music By Text

**Winning** Project for EV Hacks I <br>
:round_pushpin: 
Evergreen Valley High School, San Jose, CA, USA<br>
:date: 10/10/15

### Inspiration
We wanted to create an application that could allow users to play music as a community in public areas. Music is a large part of our team's lives, so we wanted to develop an application to make the experience of listening to music better. This application could also be used at our school to play music during lunch times.

### What it does

The user sends in a song request to the server via text message, and that request is noted, and sorted by popularity. Songs with a higher number of requests are prioritized. This allows multiple people to control what is being played in a place such as a mall or store.

### How it works

A Twillio server is set up with a phone number, which allows people to text it. A java server then repeatedly checks the server to see if there have been any new messeges. If there is a new messege, the Java server runs it through a google search to find a youtube video for the song. The song title is also passed through a rigorous screening process to remove and unwanted songs. The songs are then placed in a que to be played.
<br>
<br>
<img src="https://github.com/KevinAndMatthewsProjects/IoTSmartHouse/blob/master/img/iotsmarthouse.png" width="420" height="235">
<br>
<br>
### Roles
#### Kevin Palani:
* Java Server
* Twilio API

 #### Matthew Pham:
* Google Search API
* Youtube Technology
<br>

 #### Special Thanks To:
 #### Richard Huang (@aeolyus)
 * Idea
 
  #### Draco Li & Larry Qu
  * Moral Support
  * Taking prize distribution



7) Go to http://www.java2s.com/Code/JarDownload/javax.servlet/javax.servlet.jar.zip
should auto download a zip file. If it doesnt, go to http://www.java2s.com/Code/Jar/j/Downloadjavaxservletjar.htm and scroll till you reach a text saying "Related examples in the same category", and select the download link right above it

8) Go to http://search.maven.org/remotecontent?filepath=com/google/code/gson/gson/2.4/gson-2.4.jar it should auto download a .jar file, if not, go to http://search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.4%7Cjar and select gson-2.4.jar

9) Go to http://search.maven.org/remotecontent?filepath=com/twilio/sdk/twilio-java-sdk/5.2.0/twilio-java-sdk-5.2.0-jar-with-dependencies.jar  should auto download a .jar file, if it doesnt go to http://search.maven.org/#browse%7C1317483485 and select twilio-java-sdk-5.2.0-jar-with-dependencies.jar

