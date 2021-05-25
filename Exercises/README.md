# Exercises

- ___Week of April 30___
    - To run, download package weekofapr30, go to directory parent to weekofapr30 and open a terminal at this location.
    - Enter command ```javac weekofapr30/SolutionsRunner.java```
    - Enter command ```java weeekofapr30.SolutionsRunner```
    - A user interface will appear to guide for the steps, proceed as required.
    - File [weekofapr30/ExercisesDescription.txt](https://github.com/AshGaur/Java-FSD-Assignments/tree/main/Exercises/weekofapr30/ExercisesDescription.txt) has list of all exercises included.
    
- ___May 05___
    - Method to reverse and check if input string is palindrome. `may05/StringReverseAndPalindrome.java`
    - Own implementation of split method from java.util.String. `may05/MyOwnSplitMethod.java`
    - Use methods from java.lang.String and this class to do exercises from [may05/Lab-Strings.png](https://github.com/AshGaur/Java-FSD-Assignments/tree/main/Exercises/may05/Lab-Strings.png). `may05/Assignments2.java`

- ___May 07___
    - Display Timer on console. `may07/TimerThread.java`
     <img src="may07/timer.gif" alt="Timer" width="500"/>
     
    - Display Random number between 1000 and 9999 without using inbuilt random methods. `may07/RandomNumber.java`

- ___May 10___
    - Exercises problem statement are defined in [may10/JavaLabWork1.pdf](https://github.com/AshGaur/Java-FSD-Assignments/tree/main/Exercises/may10/JavaLabWork.pdf).
    - Lab1 Make required classes hierarchy,members and methods as described in problem statement. `may10/library`
    - Exercises 1,2,3 trafficSimulator,nthFibonacci,primesPrinter. `may10/Exercises123.java`
    - Custom Exception on given conditions Exercise 4,5. `may10/ValidateUser.java`
    - Custom Exception in package com.cg.eis.exception exercise 6. `may10/com/Exercise6.java`

- ___May 12___
    - Use a suitable collection and create a continous menu-driven program to serve the problem statement explained in [may12/ProblemStatement.png](may12/ProblemStatement.png) `may12/Runner.java`
    <img src="may12/Run.gif" alt="Execution Output">
    
- ___May 14___
    - Added Project lombok Annotations to write cleaner code. `may12/Partcipant.java`
    - Added option at menu command 6 to get sorted by data by available parameters i.e. ID,Skills,Firstname,Lastname by using Comparator interface and compare method.
    - Added code to avoid duplicates by using HashSet, and overridden methods hashCode and equals methods.
    - Opimized verbose code to make it look a little cleaner.

- ___May 18___
    - Exercies problem statement can be seen in [may18/FileIO.png](may18/FileIO.png)
    - Print data from file with line numbers. `may18/FileDataLineNumber.java`
    - Print number of characters,words and lines from the text in a file. `may18/NumberOfCharsWordsLines.java`
    - Read filename and display File details. `may18/FileDetailsWithName.java`
    - Copy from source to target file using thread by copying 10chars at a time. `may18/FileProgram.java`
    <img src="may18/10CharsCopiedAtATime.gif" alt="File updating realtime every 5 secs with 10 characters at a time" width="500">
    
- ___May 21___
    - Exercise problem statement: Make a menu-driven program to replicate the Layered Architecture which monitors and adds employees and also gives a scheme accordingly as mentioned here [may21/LA-Assignment.pdf](may21/LA-Assignment.pdf)
    - Layer Overview:
        * UI -> Contains Main class which has the logic to show all the ui options and is the runner of the application. `(may21.layeredarchitecture.ui.App.java)`
        * Service -> Contains code from which UI connects to get a particular service as required. Also contains the Custom Exception thrown for invalid inputs. `(may21.layeredarchitecture.service.EmployeeServiceUser.java)`
        * DAO -> Service gets connected to DAO which has code to connect to the database and make changes as required. `(may21.layeredarchitecture.dao.DaoClass.java)`
        * Bean -> The employee details get mapped to the bean object and this object is then used to display,edit,delete,etc. It is the encapsulation of the employee details. `(may21.layeredarchitecture.bean.Employee.java)`
        
- ___May 25___
    - Exercies Problem Statement: Create a bank simulating application using Spring and Layered Architecture modules implemented are mentioned here [may25/ModulesRequired.jpg](may25/ModulesRequired.jpg)
    - Layer Overview:
        * UI -> Main Class (`may25.spring.walletapp.ui/App.java`)
        * Service -> (`may25.spring.walletapp.service/WalletService.java`)
                  -> (`may25.spring.walletapp.service/InvalidInputException.java`)
        * DAO -> JDBC connection and db transactions (`may25.spring.walletapp.dao.DaoClass.java`)
              -> Transaction History are managed in text file (`may25.spring.walletapp.dao/TransactionTracker.java`)
        * Bean -> Customer Bean (`may25.spring.walletapp.bean/Customer.java`)
    - DB credentials are injected via (`may25/resources/dbDetails.properties`)