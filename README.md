# RickAndMortyApp

Let's get schwifty with this android application! What better way to source the characters of the hit adult animated TV show Rick and Morty!
“Sometimes science is more art than science.” — Rick

In order for this application to use the Rick and Morty GraphQL API, Apollo Client was injected to access its schema.sdl. Queries were designed to
gather characters from the show to display personal details that may be of useful knowledge for an upcoming trivia night. 

## Main Activity

Here we have the main activity shown as the application successfully starts. 

<img src="https://user-images.githubusercontent.com/32172992/159155530-942c24bb-49d4-4900-9b83-9c72b23fae68.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159155530-942c24bb-49d4-4900-9b83-9c72b23fae68.png" width="200" height="400" />

This main activity shows a top app bar that shows the name of the application. I have also added the iconic Rick and Morty title to add familiarity. 
There are two buttons: View All Characters and Shared Preferences. 

The main purpose of this app is to show details of the characters so it would only make sense to click on that first.

"SHOW ME WHAT YOU GOT!" - Cromulon

## Character List

<img src="https://user-images.githubusercontent.com/32172992/159156047-e01bfab3-0461-4730-99e8-e530aa9f9744.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159156047-e01bfab3-0461-4730-99e8-e530aa9f9744.png" width="200" height="400" />

But wait! A use of the progress indicator is genuinely placed here while we wait for the list of characters to load. Here we see a new activity opens. At 
this time, an ApolloClient instance is used here to make a query to gather the characters from the API. We don't see that actually happening so the
progress indicator represents that. 

After waiting some time, the list finally loads!

<img src="https://user-images.githubusercontent.com/32172992/159156189-5b010b99-c67c-4bf3-901b-54030473ef86.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159156189-5b010b99-c67c-4bf3-901b-54030473ef86.png" width="200" height="400" />

The app bar displays a new title as we navigate to this activity. Each character is represented by a card in a recyclerview. We see the name of a 
character and its species type. As we are scrolling through the list, oh whoops! I accidentally clicked on a card. I wonder what happens?

## Character Details

<img src="https://user-images.githubusercontent.com/32172992/159156524-89dc6d87-4bae-437e-b36d-3fda71be1feb.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159156524-89dc6d87-4bae-437e-b36d-3fda71be1feb.png" width="200" height="400" />

Oh? We have more details that we didn't even know? Awesome! This really confirms Jerry is a human. 

This fragment displays character details. The app bar title changes again and we see an image of a character from the previous activity screen that
displayed the list of characters. I added a little divider that made this screen a bit more appealing. Below the divider are more details of a character. 
This fragment does not really do much like the other activities. Another query is made to dive deeper of character details such as id, name, status, 
species and gender. Pretty cool, huh? 

## Shared Preferences

Let's head back to the main page. Remember that second button that was named Shared Preferences? Let's click on that!

<img src="https://user-images.githubusercontent.com/32172992/159156990-fff9f17e-2dcf-4924-a885-e8a749ca9d6f.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159156990-fff9f17e-2dcf-4924-a885-e8a749ca9d6f.png" width="200" height="400" />

This activity Shared Preferences to cache user local data. We see two EditText boxes that represents a user ID and a password. It is very similar to a
login screen. We have four buttons that saves the new user data, clears the data, shows the default login, and shows. Here is my default login:

<img src="https://user-images.githubusercontent.com/32172992/159157308-6ab3d13a-a586-40a4-9eae-c269d5402056.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159157308-6ab3d13a-a586-40a4-9eae-c269d5402056.png" width="200" height="400" />

And there we have it! I foresee new features of this app coming soon!

## Design Pattern

<img src="https://user-images.githubusercontent.com/32172992/159158529-c46b0c43-d702-45fb-ac80-e7b97858097c.png" data-canonical-src="https://user-images.githubusercontent.com/32172992/159158529-c46b0c43-d702-45fb-ac80-e7b97858097c.png" width="200" height="400" />

I did my best at incorporating the MVP architectural pattern. The model contains classes that created the ApolloClient instance and a repository that runs
the GraphQL queries of the characters. The view folder represents the activity and fragment views. Lastly, we have the presenter that uses the models to
format the activities and fragments.

## Outro

I am happy to present you an android application that uses the Rick and Morty GraphQL API in Kotlin. Building this was so much fun and if you could not 
already tell, I am a big fan of the show! Thank you so much for your time and I am open to sharing ideas of future features to be added! 
