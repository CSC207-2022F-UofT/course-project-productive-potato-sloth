# milestone-4.md

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




[Pull Request 2]() - Code Review <br />


## Khai Nguyen (kldtntg)
[Pull Request 1]() - Implementation <br />

[Pull Request 2]() - Code Review <br />

## Vishnu Nittoor (nitvishn)

[Pull Request 1]() - Implementation 


[Pull Request 2]() - Code Review

## Dawei He (Dawei-He2022)

Pull request 1: Code Contribution () ()


Pull Request 2: Code Review () ()


## Chhavi Shah (ConvserseScholar)
[Pull Request 1](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/42) - Implementation <br />
This pull request consisted of my complete implemention of the User entity, createAccount and Login usecases and relevant screens, and tests, with all required documentation. 

My code runs (as seen in the demo too). The User class implements Serializable. The UI works. 

For screens, I would like to have implemented the code such that the User is able to Create an Account from the Login Screen (there is a button for it), but I was not able to implement that yet so that is there to implement at a later stage. For now, we have a Welcome Screen that allows Users to edit Tasks, schedule Events, etc, and Login and Create an Account. This of course is not ideal as we would like the User to see and interact with the Welcome Screen after logging in (so after they've created an account too). For now, this is the implementation that's been implementated for simplicity. 

I admit that this was a rather big PR (almost 50 files), but a lot of it was other people's code that I pulled from the main branch. 

I have tests for the User entity and Login and CreateAccount interactors that work on IntelliJ but for some reason the interactor tests are failing on GitHub. They all work though and my team has also looked at the issue and we couldn't figure it out. The tests and non-test code all have relevant documentation that would help others understand the code I have implemented. 

I understand that in my other commits / pull requests, I had a lot of commenting / uncommenting of code in the User entity as I waited for others to finish their implementations that User depended on. As all other entities were implemented and pulled to main by the time of my pull request, this is resolved and the final implementation of the User entity is there. 

I haven't really used any design patterns as the code I needed to implement was rather straight-forward and I thought that using a design pattern would complicate the simplicity of the implementation. There is of course scope to use a design pattern for what I've implemented (like Factory for User). 

Also, my initial use case plan was to have a settings page too from which Users could change their Calendar view and password, which I was unable to implement right now so it is something to do at a later stage. 


[Pull Request 2](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/pull/24) - Code Review <br />
Despite this being the same review I talked about in milestone 4, I still think this was my best review contribution. I brought up points that I think helped Paridhi with her implementation and how it would contribute wholly to our project - such as ensuring we were all being uniform in how we set up our implementations so that the code is more clean. 

## Paridhi Goel (Paridhi)

[Pull Request]() 


[Code Review]() 


## Steven Jiang (1StevenJiang1)

[Pull Request]() 


[Code Review]() 
