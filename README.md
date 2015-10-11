# EvHacks MusicByText
Winner at EVHacks 2015 for Most Technical Hack

#How to get working on your computer

1) Download the src file, and save the .java files to your desktop

2) Open Eclipse, and make a new project, with any name

3) Using an explorer, navigate to your new project propably located at C:\Users\InsertYourUserName\workspace\ProjectName

4) In the src file, copy the three .java files you downloaded

5) Go back to eclipse, and in the default package, make three new classes (by putting your mouse over the new project and hitting alt+shitf+n and selecting new class)

5) Name these classes GoogleResults, Server, and YoutubePlay (Spelling and Caps count)

6)If you did it right, the class files will shows the code on eclipse, dont worry about all the errors

7) Go to http://www.java2s.com/Code/JarDownload/javax.servlet/javax.servlet.jar.zip
should auto download a zip file. If it doesnt, go to http://www.java2s.com/Code/Jar/j/Downloadjavaxservletjar.htm and scroll till you reach a text saying "Related examples in the same category", and select the download link right above it

8) Go to http://search.maven.org/remotecontent?filepath=com/google/code/gson/gson/2.4/gson-2.4.jar it should auto download a .jar file, if not, go to http://search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.4%7Cjar and select gson-2.4.jar

9) Go to http://search.maven.org/remotecontent?filepath=com/twilio/sdk/twilio-java-sdk/5.2.0/twilio-java-sdk-5.2.0-jar-with-dependencies.jar  should auto download a .jar file, if it doesnt go to http://search.maven.org/#browse%7C1317483485 and select twilio-java-sdk-5.2.0-jar-with-dependencies.jar

10) For the download from step 7, extract the .jar file from the .zip file

11) Save the three Jars anywhere you want, but make sure you know where

12) Go back the eclipse, and click on your project.

13) Hit alt+enter, and select Libraris

14) Click on Add External Jars, and add the three jars you downloaded

15) At this point, there should be no errors in your class files

16) If you run, everything will work except the auto click. This is because the program moves the mouse the a specific screen cordinents. Howerver, the cordinents of the buttons will change based on your computer and your monitor size

17) To fix this, go to the Server class file in eclipse. Go to line 65. Around there, look for a commented line saying printMouse(); .Uncomment it by removing the "//" before it (Not the one after it)

18) Run the program and ask me to text the song. When i do, you will notice the mouse does not move to the correct spots. After the mouse finishes moving(wait about 10 seconds), move the mouse to the taskbar where a new window with the jar icon should of opened. Put your mouse on it, and alt+tab back to eclipse. In the console, you should see No Songs Playing and java.awt.Point[x=962,y=351] (Not the same numbers) Record these numers (Let it refresh a few times before recording it)

19) After, alt tab back to the newly opened window with the link, and place your mouse on it. Alt tab back to eclipse, and record the corinents shows 

20) Recomment the printMouse(); funtion ~line 65 by placing two / before it

21) Go to ~line 177, and look for a function robot.mouseMove(number,number); replace the numbers with the first cordinents you recorded

22) Go to ~line 182 and replace the cordinents with the second cordidnents you recorded

23) It should properly work. If it doesnt, msg me and ill try to help
