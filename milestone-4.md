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
