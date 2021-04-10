# CourseProject1660

There are two steps needed before you run this.  First, make sure that you have some sort of X Server up.  I used XLaunch.

Next, you must add a .env file.  GitHub wasn't letting me commit it directly (makes some sense), so here it is: 

DISPLAY=<IP HERE>:0.0
  
Replace the <IP HERE> with the IP of your X Server, then paste that into a file named .env in the same directory.
  
After that, just run docker-compose up.
