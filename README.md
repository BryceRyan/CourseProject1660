# CourseProject1660

There are two steps needed before you run this.  First, make sure that you have some sort of X Server up.  I used XLaunch.

Next, you must edit the .env file.

DISPLAY=(IP HERE):0.0
  
Replace the (IP HERE) with the IP of your X Server.
  
After that, just run docker-compose build and docker-compose up.

As a disclaimer it takes a long time (~10 minutes on my machine) to build because it has to download both firefox and openjdk.

Code Walkthrough Link: https://drive.google.com/file/d/1wCXRexGJSLDYi0t7h8FhkOSgfOxkIRZm/view?usp=sharing

Demonstration Link: https://drive.google.com/file/d/1cPVp4g9EuGZeESdYjwN8dWGXJelkzj7a/view?usp=sharing
