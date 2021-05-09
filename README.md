# spring-palindrome

### How to:
- If you don't have Docker installed already: https://docs.docker.com/engine/install/ubuntu/
- Run `docker run -p 8080:8080 -p 50000:50000 -d -v jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:latest`
- Take jenkins password from `docker logs jenkins` and go to http://localhost:8080
- Click `Install selected plugins`
- Create user and log in
- Install maven plugin
