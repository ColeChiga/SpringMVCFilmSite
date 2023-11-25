# SpringMVCFilmSite

## Description
The Spring MVC Film Site project is a project that tasks the programmer with combing multiple programming languages to create a functioning web page that allows a user to access data from a database in the web page in a well displayed and easily readable way.

This project begins with the user being shown a page that allows them to choose to enter either a film's ID or a keyword from the film's title or description. If the user enters a keyword they are brought to a page that displays the title and descriptions of the films that contain that word. If the user enters a keyword that does not appear in any film, they are shown a screen saying so. The user is given an option to return to the home screen or, if a film is found, they can click on the film's title to see all the information about the film. 

If they click on the film's title it will bring them to the same page that they are brought to if they type in a film's ID on the home page. This page displays all of the information about the film as an unordered list, including the film's language, categories, and actors (as a sub list). From here the user is given the option to return to the home page. 

## Technology used
Java, OOP, Eclipse, SQL, MySQL, Terminal, Maven, HTML, CSS, SPRING MVC, JSP. 

## Lessons Learned
This project was not too difficult since it was similar to, and in a lot of ways an extension of the Film Query project. One area I did struggle with was with getting the list of actors to display. First I had some problems getting the jsp file to access the list of actors properly. This turned out to just be a series of syntax errors, but once I figured out where I was going wrong it was an easy fix.

 The next issue I had was with the program throwing a null pointer exception when the user input an ID that didn't have a film associated with it. At first I fixed this by putting a limit on the inputs the user could put, making it so they could not enter a number lower than one or higher than 1000. After considering this solution for a little while, I thought it worked well for a lower limit (since no film will have an ID of 0 or negative), but if more films are added the upper limit would need to be increase. Because of this I changed the way I coded the jsp file. Originally I had passed in two objects, one "film" object and one array list "actors" object that used the list of actors from the "film" object. I had done it this way as part of the fix to the syntax errors I was getting earlier. I changed the file to only take in the film object, and just access the list of actors from a forEach loop in the jsp file. 
 
This solution seemed obvious after I came up with it, and it taught me just how important it is to take breaks from coding so that you can come back with a fresh set of eyes and thought process. At the time that I came up with the "fix" to the syntax errors I was coding for three or four hours with very little time away. The actual fix was implemented the next day after a good nights rest and a lot of time away from my computer. Breaks are important and may help me to find better solutions to problems than I would find after hours of work.

