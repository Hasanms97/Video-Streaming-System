# Video-Streaming-System
This project implements a containerized Video Streaming System consisting of multiple microservices.

The system microservices are described as follows:

**Upload Video (Web app):** This service is used to upload MP4 files or any other video format. Users are allowed to upload videos after validating their credentials through the Authentication Service. Video names and paths on the filesystem are written to the MySql Service. The file itself is written to a file storage through the File System Service.

**Video Streaming (Web app):** This service is used to view videos. Users are allowed to view videos after validating their credentials through the Authentication Service. The list of videos and their paths are taken from MySql DB service, and the video itself can be read from the file storage through the File System Service.

**Authentication Service:** This is a simple service that validates user credentials.

**File System Service:** This service is used to write and read files from a file storage such as HDD or AWS S3.

**MySql DB Service:** This service maintains a list of videos and their corresponding paths or URLs.
Technologies used


## **Technologies used**

The Video Streaming System is built using the following technologies:

Java Spring Boot for building the web apps
MySQL for the database
Docker for containerization
Docker Compose for orchestration


## **Installation and Setup**

## **Prerequisites**

Docker and Docker Compose should be installed on your system.


## **Steps**

Clone this repository:

git clone 
cd video-streaming-system

Build the Docker images for each service:

docker-compose build

Start the containers:


docker-compose up

This will start all the services and make them available on the following ports:


> > D-TubeMVC (Web app) - http://localhost:10000/

> > uploadVideoREST (Web app) - http://localhost:9091/

> > VideoStreamREST (Web app) - http://localhost:9090/

> > AuthenticationREST (Web app) - http://localhost:8080/

> > FileStorageREST - http://localhost:9999/



## **Conclusion**

The Video Streaming System is a containerized solution for uploading and viewing videos. It is built using Flask, MySQL, Docker, and Docker Compose. With this system, users can upload and view videos after validating their credentials through the Authentication Service. The video names and paths are stored in the MySql DB Service, and the video files are stored in a file storage through the File System Service.


Conclusion

Flask, MySQL, Docker, and Docker Compose. With this system, users can upload and view videos after validating their credentials through the Authentication Service. The video names and paths are stored in the MySql DB Service, and the video files are stored in a file storage through the File System Ser
