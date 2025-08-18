# ⚙️ Visual Regression Tracker

## Prerequisites

Before starting, ensure you have the following installed:

- Docker Desktop  
- WSL (if working on corporate devices and want to run locally)  
- IntelliJ (or your preferred IDE)

---

## Step 1: Set Up the Project Directory

Create any folder on your desktop and paste the provided `docker-compose.yml` and `.env` file into this directory.

![FolderImage](GitImages/1.PNG)

---

## Step 2: Open PowerShell and Navigate to the Folder

Open **Windows PowerShell as Administrator**, then navigate to your newly created folder using a command like: **cd C:\Users{Your User}\Desktop\VRTFolder**


![PowerShell_1](GitImages/2_.PNG)

---

## Step 3: Start Docker Containers

Run the following command: **docker compose up -d**


Wait for the containers to finish starting. You should see output like this:

![VRT_Install_1](GitImages/3.PNG)

![VRT_Install_2](GitImages/4.PNG)

In Docker Desktop, wait for the **migrations** container to finish running.

![Docker_Photo_1](GitImages/5.PNG)

Once complete, VRT should be up and running. You can now access it at: localhost:8080


![VRT_Running](GitImages/6.PNG)

---

## Step 4: Access the dashboard as default admin user

User: visual-regression-tracker@example.com
Password: 123456

---

Now you are ready to start visual testing! 🎉






