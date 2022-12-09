# Productive Potato Sloth
By The Productive Potato Sloths

## Description
A Java application created for the CSC207 Final Project

#### Specifications and Features
1. Task List and View (Leon Cai, chazzybearr)
>The user has access to a list of tasks, where they can view details and edit tasks. 
>The user can also create new and delete tasks
>Users can also create Tags on a tag view screen, and add those tags to Tasks

2. Text Chat Room

3. Invitation Mangement System
Users are able to send invitations to different users to collaborate on different tasks. Users can also accept and decline the invitations sent to them.

4. Timer (Paridhi Goel, paridhi26)

>The user can press the start timer button on welcome screen to navigate to the Timer screen.
>The user can then set a countdown timer of a duration of their choice.
>The user can pause the timer in between to take breaks and can resume it by pressing start again.
 
5. Interactive Event Scheduler

6. Task Statistics 

7. Login and Creating an Account (Chhavi Shah, ConverseScholar)
> The user is able to create a new account and log into the application.


## Getting Started
### Prerequisites
You will need an IDE which supports Java

### Installation
1. Clone the Repo
```sh
https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth.git
```

2. Install the lgooddatetime picker library:

   - Open `File -> Project Structure`.
   - Open `Libraries`.
   - Click the `+` button on the top left, and click `From Maven`.
   - In the text box, type the beginning of the phrase`com.github.lgooddatepicke`, click search, and select the latest version.
   - Check the box on the left of `Download to: <dir>`
   - Click OK, and then Apply.

3. Run the Main file located at the program root

## Usage

### The welcome screen
<img src="https://user-images.githubusercontent.com/82430669/206600368-fb7e4f7a-5989-4727-b01e-5cf32079cad2.png" width=50% height=50%>

### The task list screen
<img src="https://user-images.githubusercontent.com/82430669/206600407-65c71fcf-c67b-4e8d-8698-df559dc43104.png" width=25% height=25%>

 
### Editing a task
<img src="https://user-images.githubusercontent.com/82430669/206600620-cb13f051-703d-42cd-8423-f930c04af0ff.png" width=50% height=50%>

### The tag list screen
<img src="https://user-images.githubusercontent.com/82430669/206600686-729ceb59-dc5b-409e-bd9b-72421b5061fa.png" width=25% height=25%>
### the ChatRoom screen
![Screenshot (559)](https://user-images.githubusercontent.com/113304165/206635355-a03068c0-7066-45c9-bbf3-5a4787c3dd32.png)

### Log In Page
![image](https://user-images.githubusercontent.com/97484565/206642536-8d206bb0-35d5-4c55-b7b1-6f3530ce4520.png)

### Create Account Page
![image](https://user-images.githubusercontent.com/97484565/206642786-875e8017-7cc8-4064-a5fc-6f8f195532e9.png)



## Roadmap

## Contributing
Contributions are **greatly appreciated**! 

If you have suggested changes that would make this project better, please fork this repo and make a pull request!

1. Clone the repo
```
git clone https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth.git
```

2. Create a new branch
```
git checkout -b ＜your-amazing-feature＞
```

3. Push your changes
```
git commit -m <your-amazing-commit-message>
```

4. Push to origin
```
git push origin <your-amazing-feature>
```

5. Open a pull request

## Contributer Specific Notes
### Leon Cai (chazzybearr)

For some design choices I made:

> I chose to have only one TaskRequestModel and TaskResponse model class, rather than having request and response model classes for each use case.
> 
> As stated above, with 12 use cases, I would have to have an additional 24 classes (one TaskRequest and one TaskResponse).
> 
> For a program of this size, I concluded it would be unnecessary to have such a titanic quantity of lazy classes.
> 
> Thus, I made the choice to combine all the request and response models into one class each.
> 
> Though this does break clean architecture in the Single Responsibility Principle, I concluded that if this program were to expand, it would be trivial to break the generic TaskRequest and Response models for their separate use cases.
> 
> Same comments and reasoning with the TagResponse and Request Models

Tests: 

> My tests are located in my [branch](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/tree/1-feature-1-task-list/src/test/java)
> 
> I've added many extensive tests to my use cases and controllers. 
> 
> I've made effective use of the @ParamaterizedTest feature, ensuring that I test every edge case of string, including multiple characters, one character, and the empty string
> 
> Additionally, I've used the @BeforeEach and @AfterEach to instantiate a simulated database and saved it in a temporary file. 
> 
> After the tests have finished, the method annotatied with @AfterEach removes all objects in the simulated database, ensuring that the next test that is run starts from a clean state.

Roadmap:
> One of the features I planned to implement was the ability to add colours to tags, and have the corresponding tasks appear with those colours. 
> 
> This feature has not been implemented in the latest commit, so throughout my code, I have used placeholder colours. 
> 
> Implementing the feature will require minimal changes to the code, as I simply have to replace the placeholder values with the values submitted by the user

Design patterns:

1. Simple Factory


    > I've used the Simple Factory to abstract away the process of creating tasks. 
    > 
    > This ensures that any future changes to the constructor(s) of Task will only require changes to the Factory, as the only hard dependency occurs in this class.
    > 
    > This choice has followed the Open/Closed principle, as this factory can easily be extended for additional constructors, but closed for changes, as the constructors which already exist in the factory will never change
    > 
    > In the future, implementing a builder design pattern would make more sense, as a Task can be instantiated in multiple ways (with/without a description, w/wo tags etc)

2. Observer

    
    > The observer pattern is used between my screens, where the observers are the screens which display the list of Tasks and Tags to the user. 
    > 
    > Any potential sources of change to the view model implement subject, which the observers will reflect.
    > 
    > This separates the cause and the effect of the change, and additionally follows clean architecture as creating a new info screen requires simply subscribing it to the subject

### Vishnu Nittoor (nitvishn)

Note about errors:

> There seem to some errors in the autograding procedure. This is due to java Serialization not playing nicely with GitHub. Please ignore these errors <3 

Some design choices:

> I decided to use pure data classes EventDataResponseObject and EventDataRequestObject to use to pass information up and down the clean architecture. I found myself writing the same fields over and over again in the request and response models of my two use cases, which was a code smell. I believe that this fixes the code smell, and allows for greater modularity in the information contained in events.
> 
> I decided also to have classes ViewCalendarMainFrame and ScheduleEventMainFrame that are given gateways and the current user service and know how to create screens and run them. This makes embedding my use case into the Main method much, much easier -- note that this takes two lines of code rather than several. My teammates agree that this is a design decision that might be worth making homogenous across the code for the project.

Tests:

> My tests are located in [here.](https://github.com/CSC207-2022F-UofT/course-project-productive-potato-sloth/tree/2-feature-2-interactive-scheduler/src/test/java).
> I've tested every success and failure case of the ScheduleEventInteractor. I've also tested the 
> creation of EventDataResponseObjects from Events. A critical folder that needs to exist is `data_files` in the same
> folder as `java` in the parent folder `test`. The gateway created in the interactor tests opens this file.

Design Patterns:

1. Observer:
> The observer pattern is used twice across my ViewCalendar and ScheduleEvent use cases, once to allow the ViewCalendarScreen to observe the ViewModel and allow itself to re-render when it changes, and another time to allow the ViewCalendarScreen to observe the ScheduleEvent use case and entirely call its use case method again to fetch all the events again, and then re-render.
> 
> It is seen from this that there are two different update behaviours. I recognize that this could be a code smell and have detailed how to fix this in the future in Roadmap below.

Roadmap:

> I would have loved to have a real calendar interface instead of printing blocks that contain the information for each event. Further, Derek raised the fact that using two Observer interfaces is kind of superfluous, and I'd like to look for ways to have just one interface and get around the problem described in design patterns above. 
> 
> One solution is to change the Observer interface to use the Strategy design pattern to allow for multiple update methods. This seems like a clean way to solve the problem.
> 
> Further features to add are more fields for scheduling events, such as repeating events, optional tasks, and network integration with Google Calendar. 
> 

### Dawei He (Dawei-He2002)
Roadmap:
> Originally, I had wanted to implement an editing message feature that would allow users to edit messages they sent to the view. This turned out to be not implemented because of time constraints. However, given some free time later I can easily add the requirred controllers, presenters, usecases and UI elements since it would require very little modification of existing code.
Tests:
> I have comprehensive tests for all classes except for the View and initialization methods. The View and initialization are not tested because they can be "tested" and debugged by running the local main (ChatRoomDemo) method and using the debugger to fix any errors.
Design choices:
> I have rigorously adhered to the Dependency Inversion Principle throughout the entirety of my project. I did not feel the need to implement any design patterns because of the relative simplicity and lack of complex inheritance hierarchies inside my feature. However, I did adhere to SOLID principles whenever possible.
> In the initization controller class, I created an InputBoundary with the controller. Although this is a potential breach of Clean Architecture practices, there was no other way to initialize the ChatRoom without any initialized classes. Since a CHatRoom cannot be initialized without at least one Task and one User, it cannot be initialized directly on Main like many of the other screens, so I have to rely on Leon's Task view initializing my screen.

### Chhavi Shah (ConverseScholar)
Roadmap:
> From the Login screen, I wanted to allow the User to go to the Create Account page so create an account that then redirects them back to the login page once the account is created. 
> Additionally, we have a Welcome Screen that allows Users to edit Tasks, schedule Events, etc, and Login and Create an Account. This of course is not ideal as we would like the User to see and interact with the Welcome Screen after logging in (so after they've created an account too). So this is something I want to update at a later stage. 
> Another thing I would like to implement is a log out function to allow a new User to log into the application.
> Finally, I wanted to implement a Settings page that, at the basic level, allowed Users to change their Calendar view (to either include / remove weekends from their View) and change their password, which I was unable to within my given timeframe. 


Tests:
> I have ran tests for my two use cases of Login and CreateAccount which ensure that both work as required. 


Design Patterns:
> I haven't really used any design patterns as the code I needed to implement was rather straight-forward and I thought that using a design pattern would complicate the simplicity of the implementation. There is of course scope to use a design pattern for what I've implemented (like Factory for User).

### Khai Nguyen (kldtntg)
1. *Please run the class InvitationMainScreen to see the demonstration of the invitation management system*
Clean architectures are used extensively across the programs, where concrete classes (such as controllers and interactors) depend on abstractions instead of one another. SOLID principles are also utilized to make the code clean and readable.

Dependency injection is used throughout the program to help eliminate hard dependency across layers/ entities. An example would be the gateways being initialize in Main and passed to the screens to avoid hard dependencies. 

2. The entity objects are tested thoroughly.

The use cases are tested by checking whether the interactors result in appropriate changes to the entities. The output data sent to the presenters by the interactors are also tested to see if they are expected.

3.Design patterns are not used in my implementation of the feature, but they will be utilized moving forward to write a cleaner/ more maintaiable code base. An example would be the observer pattern being used to update the accept/declineInvitation screen with tasks corresponding a sender as soon as that sender is chosen. 
## Licence
This project is under the MIT Licence

## Contact

