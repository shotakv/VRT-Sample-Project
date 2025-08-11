#Visual Regression Tracker
Visual Regression Tracker(VRT) Prerequisites:
Docker Desktop
WSL(if working on corporate devices and want to do it for your own)
IntelliJ


Step 1: Create any folder on your desktop and paste the provided docker-compose.yml and .env file into this directory

Step 2: Open Windows PowerShell with administrator and change the running directory to your newly created folder with command like:
 “cd C:\Users\{Your User}\Desktop\VRTFolder”

Step 3: Run command “docker compose up -d” and wait for it to finish running.
In Docker wait for migrations container to finish running.
Now VRT should be running on your docker setup! And you can visit it on localhost:8080

Step 4:
Register in VRT User Interface using your own email and make sure you can see the projects dashboard

Step 5: 
Open new powershell window and run these commands:
1)“docker exec -it {containerName} psql -U postgres -d vrt_db”

2)Select id,email,role from “User”;

3)Update “User” SET role = ‘admin’ where email = ‘your@email.com”
Now you are an admin with all permissions!



