# spring-palindrome

This little Spring Boot app lets you check if a given string is a palindrome.
You can fill the form on the main page or send a GET request like `http://page/get/string`.


## Jenkins Continuous Integration with Docker containers
### Initial setup:
- If you don't have Docker installed already: https://docs.docker.com/engine/install/ubuntu/ (assuming you are running Ubuntu)
- Run `docker run -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):$(which docker) -p 888:8080 -p 50000:50000 -d -v jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:latest`
- You might also want to run `sudo chmod 666 /var/run/docker.sock` to avoid permission problems
- Take Jenkins password from `docker logs jenkins`, go to http://localhost:888 and enter the password
- Create user and log in
- On Dashboard choose **Manage Jenkins** and then **Manage Plugins**, go to **Available** and install following plugins:
    - Maven Integration plugin
    - Maven Invoker plugin
    - Docker
    - docker-build-step
    - CloudBees Docker Build and Publish
- Click **Install without restart** and wait for completion

### Jenkins and Docker integration:
- On Dashboard choose **New Item**, then enter some name, choose Maven project and click OK
- Mark **Github project** and paste URL of this repository
- In **Source Code Management** choose Git and again paste the repository URL
- In **Branches to build** type `*/main`
- In **Build Trigger** mark **Poll SCM** and enter `* * * * *` in the box below.
- In **Goals and options** enter `clean install package`
- Click **Add post-build step** and choose **Docker Build and Publish**
- In **Repository Name** enter your DockerHub ID and app name, like: `yourdockerid/palindrome`
- Now add your credentials to Docker Hub
- Apply and save
- Click **Build now**
- Image should be now pushed to Docker Hub and you can run it
- Project is also going to be built every time a change is pushed to GitHub repository

### Test with my Docker image:
- `docker run -p 8080:8080 icxamclbhnvw/palindrome`
- And go to http://localhost:8080
