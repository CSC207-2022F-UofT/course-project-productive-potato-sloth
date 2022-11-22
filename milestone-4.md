# milestone-4.md

## Leon Cai
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/9) - Implementation <br />
This pull request contained the bulk of the enterprise and application logic, including all my entities and use cases, as well as tests for the entities. It adheres to clean architecture and SOLID design principles, as each class only has one responsibility. In addition, I have added a facade class for to hide the smaller implementation details. Further, all methods (aside from the ones in the facade class) are non-static, which reduces coupling. Finally, all methods are annotated with Javadoc for easy communication and review.

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/10) - Code Review <br />
This review consisted of a variety of comments, including minor changes, like fixing method names to follow camel case, and removing useless methods in test classes. Additionally, I made a design choice to store the user instance, rather than the username, inside of the message class.

## Khai Nguyen
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/27) - Implementation <br />
The controllers, presenters, interactors, and entities, which make up the Enterprise Business Rules, Application Business Rules, Interface Adapters, are included along with some tests. The core logics are mostly complete, and the only task left is to connect the logic with the UI. The pull request demonstrates extensive use of the SOLID principles, notably dependency inversion and interface segregation. 

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/24) - Code Review <br />
I was able to check for correctness as well as offer my opinions on what the next steps could be. 

## Vishnu Nittoor

[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/19) - Implementation 

This pull request featured the creation of the class UserDatabaseGateway, a class that implements the DataAccessInterface. This is the entirety of the our application's implementation of data storage and access. It included relevant tests for the class. Although this pull request was two files, it is my most significant one -- since I have ensured that I frequently create pull requests, the other pull requests for my branch may individually be less significant.

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/14) - Code Review

My review of this pull request included some comments regarding concrete return types, but found that the majority of the code was good for merging into the main branch. I indicated that although the changes should be ideally incorporated, the pull request was ready for approval and they may be done in the next pull request.

Milestone 4 report--Dawei He

Pull request 1: Code Contribution (6-feature-6-chatroom, pull request #18) (https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/18)

Although as of now, I have only made one pull request, this pull request has made 
significant headway into the implementation of my feature, and the code written therein
has served to guide further development. 

In this pull request, I implemented the
entities and interactor class for my feature, as well as establishing the package 
organization of the program. Inside the code, I documented when necessary (such as 
explaining what the tests are for) but not excessively, as I intended for the method names
to be self-explanatory.

Furthermore, throughout writing the code up to the pull request (and afterward) I 
strictly followed SOLID principles and clean architecture, evident in the separation of 
code into entity, use case, controller/presenter and UI layers, with classes in each layer
only being able to call methods in adjacent layers. However, I did not see any instances 
where it would be appropriate to adopt a Design Pattern such as a Factory (because there are 
only two entities with no subclasses) or a Facade (the interactor only has two methods, 
one of which was added after Pull Request #18).

Finally, I coded Unit Tests for every entity and the interactor. One would not see such 
ubiquitous proliferation of unit tests in the commit that this file is in, because I am 
ot yet finished in fully implementing the UI and presenters, hence why there may be 
commented-out code and no tests on some files.

Pull Request 2: Code Review (1-feature-1-task-list, pull request #15) (https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/15)

In this code review, I reviewed Leon Cai's pull request and did a comprehensive analysis 
of (1) his testing and documentation, and (2) the correctness of the code. In the first 
review "pass", I exclusively looked at the organization, documentation and readability 
of the code while in the second "pass" I analyzed existing issues in the code based on 
the most recent failed autograde test and suggested solutions whenever possible. I chose
to mention this pull request because while I have reviewed other people's pull requests before, 
those reviews were often simple approvals instead of a comprehensive review or analysis because
the code did not normally raise any errors by the time it was put on a pull request, and is
usually well documented, thus there was simply not much to write about, unlike with this 
particular pull request in which there were a number of errors in coding.
