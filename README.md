# assignment4tdd-sz - 3X3 Magic Box Game
[![Build Status](https://travis-ci.com/cmput402-w19/assignment4tdd-sz.svg?token=FssyMmBPRuAzV51Y1wPf&branch=master)](https://travis-ci.com/cmput402-w19/assignment4tdd-sz)
[![codecov](https://codecov.io/gh/cmput402-w19/assignment4tdd-sz/branch/master/graph/badge.svg)](https://codecov.io/gh/cmput402-w19/assignment4tdd-sz)

# Installation instruction
1. Install JDK 11 on MacBook Pro with Retina Display from [https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
2. Install IntelliJ IDEA 2018.3.4 (Ultimate Edition) on a MacBook Pro with Retina Display
3. Use IntelliJ IDEA open this project
4. Right click App.java(assignment4tdd-sz/src/main/java/assignment4/App.java)
5. Click "Run 'App.main()'"

# Description
This is Assignment 4 for CMPUT 402.
### 3X3 Magic Box Game
You need to enter integer numbers from 1 to 9 to a 3 by 3 grid. 
Each number can be only used once. 
You need to make the sum of each row and column and the two diagonal be 15. 
<br>
![Play Rule](http://www.dr-mikes-math-games-for-kids.com/images/3x3-middle-is-5.png)

# How to play
1. Enter your name.
2. Enter "a" to add a number. Or Enter "d" to delete a number. 
3. Enter the row number of the cell.
4. Enter the column number of the cell. 
5. If you enter "a" to add a number, it will ask you to enter the number that you want to add. 
6. After you fulfill the board, if you win, it will show a message saying that you win, which is followed by a score board. 
7. If your answer is not correct, it will ask you keep playing until you find the correct answer. 
8. The score board list all the players' name and their play time in seconds. They are sorted in ascending order. The player who uses the least time will appear at the top. 

For more details please see [http://www.dr-mikes-math-games-for-kids.com/3x3-magic-square.html](http://www.dr-mikes-math-games-for-kids.com/3x3-magic-square.html)

# Contribute List
* Shuonan Pei
* Zhimao Lin

# Please email us for help
You can contact us through our ualberta email.

# References

* [http://tutorials.jenkov.com/java-date-time/system-currenttimemillis.html](http://tutorials.jenkov.com/java-date-time/system-currenttimemillis.html)
* [https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/](https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/)
* [https://stackoverflow.com/questions/2279030/type-list-vs-type-arraylist-in-java](https://stackoverflow.com/questions/2279030/type-list-vs-type-arraylist-in-java)
* [https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println](https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println)
* [https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-test/2.1.2.RELEASE](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-test/2.1.2.RELEASE)
* [https://stackoverflow.com/questions/13364406/mock-a-constructor-with-parameter](https://stackoverflow.com/questions/13364406/mock-a-constructor-with-parameter)
* [https://stackoverflow.com/questions/36119627/call-constructor-with-and-without-parameter-with-powermockito](https://stackoverflow.com/questions/36119627/call-constructor-with-and-without-parameter-with-powermockito)
* [https://www.baeldung.com/mockito-void-methods](https://www.baeldung.com/mockito-void-methods)
* [https://stackoverflow.com/questions/15904584/mockito-gives-unfinishedverificationexception-when-it-seems-ok](https://stackoverflow.com/questions/15904584/mockito-gives-unfinishedverificationexception-when-it-seems-ok)
* [https://mvnrepository.com/artifact/org.powermock/powermock-api-mockito/1.7.3](https://mvnrepository.com/artifact/org.powermock/powermock-api-mockito/1.7.3)
* [https://mvnrepository.com/artifact/org.powermock/powermock-module-junit4/1.7.4](https://mvnrepository.com/artifact/org.powermock/powermock-module-junit4/1.7.4)
* [https://stefanbirkner.github.io/system-rules/](https://stefanbirkner.github.io/system-rules/)
* [https://github.com/powermock/powermock/issues/901](https://github.com/powermock/powermock/issues/901)