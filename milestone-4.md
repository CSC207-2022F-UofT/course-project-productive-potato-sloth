# milestone-4.md

## Leon Cai (chazzybearr)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/9) - Implementation <br />
This pull request contained the bulk of the enterprise and application logic, including all my entities and use cases, as well as tests for the entities. It adheres to clean architecture and SOLID design principles, as each class only has one responsibility. In addition, I have added a facade class for to hide the smaller implementation details. Further, all methods (aside from the ones in the facade class) are non-static, which reduces coupling. Finally, all methods are annotated with Javadoc for easy communication and review.

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/10) - Code Review <br />
This review consisted of a variety of comments, including minor changes, like fixing method names to follow camel case, and removing useless methods in test classes. Additionally, I made a design choice to store the user instance, rather than the username, inside of the message class.

## Khai Nguyen (kldtntg)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/27) - Implementation <br />
The controllers, presenters, interactors, and entities, which make up the Enterprise Business Rules, Application Business Rules, Interface Adapters, are included along with some tests. The core logics are mostly complete, and the only task left is to connect the logic with the UI. The pull request demonstrates extensive use of the SOLID principles, notably dependency inversion and interface segregation. 

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/24) - Code Review <br />
I was able to check for correctness as well as offer my opinions on what the next steps could be. 

## Vishnu Nittoor (nitvishn)

[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/19) - Implementation 

This pull request featured the creation of the class UserDatabaseGateway, a class that implements the DataAccessInterface. This is the entirety of the our application's implementation of data storage and access. It included relevant tests for the class. Although this pull request was two files, it is my most significant one -- since I have ensured that I frequently create pull requests, the other pull requests for my branch may individually be less significant.

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/14) - Code Review

My review of this pull request included some comments regarding concrete return types, but found that the majority of the code was good for merging into the main branch. I indicated that although the changes should be ideally incorporated, the pull request was ready for approval and they may be done in the next pull request.

## Dawei He (Dawei-He2022)

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

## Chhavi Shah (ConvserseScholar)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/21) - Implementation <br />
This pull request included an almost-completed User entity, which most of our team depends on for their implementations. The code adheres to the Clean Architecture structure and the SOLID Design Principles as the entity does not depend on anything from the external layers (use cases / controller / UI) of the Clean Architecture model, and is self-sufficient. 
I understand that commenting out the methods of the class for parameters that were not implemented (by my team) is not the most efficient way of writing up my code while waiting for others to implement their parts. This is inefficient as it requires me to keep uncommenting code as updates are made, which is not the best. Derek mentioneed implementing an interface to help with this, but I'm not sure how to write that in code and I'm almost done with uncommenting all the code in User as most of the entities are completed and merged to main. So that is something I could consider when implementing something of this sort next time. 
Methods are relevant docstrings written up to help understand functionality. 

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/24) - Code Review <br />
I believe this to be my most valuable review as it was one I did after I better understood the Clean Architecture structure and what needs to be implemented to ensure the structure is maintained. I raised questions about whether the structure was implemented right (in terms of where the Presenter and RequestModel should be called instead of implementing the functionalities of those classes within the Interactor). I hope this helps build our project unifomrly among us seven.

## Paridhi Goel (Paridhi)

[Pull Request](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/22) 

This pull request includes the creation of Timer Entity, the Input Data Structure/Boundary and the Timer Interactor.
It is significant because this code forms the basis of the functionality of the Timer feature in this project. 
It adheres to Clean Architecture and SOLID design principles because on the outer layer (use cases) depends on the entity Timer and
not the other way round. The code includes appropriate documentation for all classes and methods.

[Code Review](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/21) 

This review addressed a missing instance variable in the entity class which was required for testing by another member and me. 
Otherwise, the code was ready to be merged although some methods
were commented out because the entities they depended on were not merged into main then.


