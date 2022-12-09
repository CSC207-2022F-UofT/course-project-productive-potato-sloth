# milestone-5.md

## Leon Cai (chazzybearr)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/15) - Implementation <br />

This pull request contains the code for my use cases, controllers, presenters, and screens. This pull request changed all my use cases to take a request mode and return a response model, rather than raw paramaters.

Addressing Feedback:
> Tests have been significantly improved. 
> Paramaterized tasks which use various strings rather than hardcoding strings are implemented throughout the tests of use cases and controllers.

> This pull request is still quite large, but I have managed to keep it updated with master and kept everything documented where it is clear to any reader what any class or method does.

> I've tried to add comments throughout my pull request to add additional information unable to fit in the commit message. 
> I've also included justifications for the code patterns and the choices I made throughout the code.

> Design patterns are used to a much more significant extend. 
> Dependency injection is evident through my screens, where my screens references all other screens it needs to show, rather than creating using the "new" keyword, creating a hard dependency. 
> Screens also implement the observer pattern, where the cause and the effect of a change in view model are separated. This makes creating and updating future screens extremely simple (I even felt the benefits of the observer pattern while I was coding my screens!)


[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/40) - Code Review <br />

My code review consisted of general comments, like documentation, and uses of aspects of clean architecture, like abstract classes and custom exceptions. Additionally, I noticed minor errors like empty classes, strange class names, and formatting consistency etc. I also pointed out areas of improvement like consolidating a couple lines of code into one code, and clean architectures violations, including a magic number.


## Khai Nguyen (kldtntg)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/46) - Implementation <br />

This pull request contains my code for the building blocks of my feature: entities, interactors, controllers, presenters and screens. The code are implemented with clean architecture and the SOLID principles in mind. The initializations of necessary componenents of the feature are also refractored to make combining my feature with the rest of the application easier.

[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/50) - Code Review <br />
My code review carefully checks for consistency between this pull request and what we agreed upon before hand. I also checked for clean architecture and SOLID principles being applied, making sure the commit is ready for merging.

## Vishnu Nittoor (nitvishn)

[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/31) - Implementation 

This was my most significant pull request. I finished the ScheduleEvent use case to completion in a fashion in which all components are connected to each other functionally and meaningfully. I created and added the UI elements, and created a test for scheduling an event.

Major progress was made in terms of initializing an application with the ScheduleEventScreen, and great care was taken to ensure that this is done in a manner which is easily integrable into the main method that would be implemented in subsequent commits.  


[Pull Request 2]()https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/15 - Code Review

This was my code review of Leon's pull request. I commented in detail on changes made to the User, Tag, and UserDatabaseGateway classes. My comments were varied in nature -- for example, although there was a comment challenging Leon's use of a task factory, I defended it since I thought it was good design. There were a few inconsistencies including the built-in data structures such as ArrayList being made instance variables of classes, which are problems. I made 20 comments in total, being sure to observe very crucial details in the implementation.  

## Dawei He (Dawei-He2022)

[Pull request 1] (https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/43)
This is my pull request. It consists of all my controllers' tests and the UI. Although this may not sound important, in this pull request I fixed all of the errors preventing my UI from rendering and setting the contents as blank, which enabled me to identify problems within my demo class and controllers, and fix them in time.

In this pull request, I was able to completely integrate my code with that of the other group members and get my program to run properly, which is the final step toward completing the program. Writing unit tests for controllers and presenters also enabled me to detect and fix errors much more efficiently, and eliminate potential sources of error when rendering the UI. This greatly helped in meeting the submission deadline (because a lot of time was saved in debugging). 

I also wrote detailed docstrings for every class and method, and adhered to SOLID principles, especially Dependency Inversion, throughout. This will help in improving readability of my code for code reviews.

In a large part, the significance of this pull request can also be attributed to the fact that I spent nearly a week debugging the UI before I solved it in an office hour with Prof.Gries. Without a working UI, any amount of architecture will remain untested and this pull request gave me the ability to test and integrate my program as a whole, instead of as individual parts.


[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/45)
This is my code review. I reviewed Chhavi (ConverseScholar)'s commit and left a detailed review to the best of my ability. Whenever possible, I analyzed what the author of the pull request was trying to do, her intentions as well as her implementation, and tried to raise questions about why a particular design decision was made or why a class was implemented the way it is. I tried to give constructive criticism and raise questions whenever I saw something I could not understand the necessity of. I believe that by combing through the code, giving constructive criticism and questioning design decisions, I can facilitate the upkeep and elevation of the quality of the written code in our project.


## Chhavi Shah (ConvserseScholar)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/50) - Implementation <br />
This pull request consisted of my complete implemention of the User entity, createAccount and Login usecases and relevant screens, and tests, with all required documentation. 

My code runs (as seen in the demo too). The User class implements Serializable. The UI works. 

For screens, I would like to have implemented the code such that the User is able to Create an Account from the Login Screen (there is a button for it), but I was not able to implement that yet so that is there to implement at a later stage. For now, we have a Welcome Screen that allows Users to edit Tasks, schedule Events, etc, and Login and Create an Account. This of course is not ideal as we would like the User to see and interact with the Welcome Screen after logging in (so after they've created an account too). For now, this is the implementation that's been implementated for simplicity. Another thing I would like to implement is a log out function to allow a new User to log into the application.

I admit that this was a rather big PR (almost 50 files), but a lot of it was other people's code that I pulled from the main branch. 

I have tests for the User entity and Login and CreateAccount interactors that work on IntelliJ but for some reason the interactor tests are failing on GitHub. They all work though and my team has also looked at the issue and we couldn't figure it out. The tests and non-test code all have relevant documentation that would help others understand the code I have implemented. 

I understand that in my other commits / pull requests, I had a lot of commenting / uncommenting of code in the User entity as I waited for others to finish their implementations that User depended on. As all other entities were implemented and pulled to main by the time of my pull request, this is resolved and the final implementation of the User entity is there. 

I haven't really used any design patterns as the code I needed to implement was rather straight-forward and I thought that using a design pattern would complicate the simplicity of the implementation. There is of course scope to use a design pattern for what I've implemented (like Factory for User). 

Also, my initial use case plan was to have a settings page too from which Users could change their Calendar view and password, which I was unable to implement right now so it is something to do at a later stage. 


[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/24) - Code Review <br />
Despite this being the same review I talked about in milestone 4, I still think this was my best review contribution. I brought up points that I think helped Paridhi with her implementation and how it would contribute wholly to our project - such as ensuring we were all being uniform in how we set up our implementations so that the code is more clean. 

## Paridhi Goel (Paridhi)

[Pull Request](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/39) - Code Review <br />

This pull request includes a large proportion of the code contribution made by me to get the Timer feature running.
Although, I made more pull requests after this to refactor code, add further enhancements and tests, the code in this pull request forms the major
body of the Timer feature. The title of the pull request is "Timer UI layer and controller" because I initially only intended
to merge the screens and controller layer with this PR. I previously made separate PRs for useCase layer, entity layer, Main and Welcome Screen.
However, someone pushed to the main branch deleting all my work that existed on the main branch. Therefore, I had to recommit my entities, usecases etc.

The code follows clean architecture and SOLID Design principles.

I added the timer factory design pattern because that would allow easy extension of this application because in the future if we decide to add different
types of timers that store different kinds of data. For example, workout timer, study timer, cooking.

The TimerInputBoundary Interface and Presenter Interface exist to invert dependencies between controller and use case layer.

[Code Review](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/31) - Code Review <br />

I think this code review by me helped the team keep our main class clean and small, avoiding the large class code smell.
I thought it was better to have separate classes and methods that setup the screens for particular features, and then
have the welcome screen call these classes and methods. The main method of Main
class then just has to set up the welcome screen. This allowed us all to work on our separate classes and connect them in the end
instead of everyone adding their work to one Main class, which could have been messy.


## Steven Jiang (1StevenJiang1)

[Pull Request](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/40) 


[Code Review](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/47) 