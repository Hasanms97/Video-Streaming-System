# Video-Streaming-System
This project implements a containerized Video Streaming System consisting of multiple microservices.

Video Streaming System Architecture

The system microservices are described as follows:

Upload Video (Web app): This service is used to upload MP4 files or any other video format. Users are allowed to upload videos after validating their credentials through the Authentication Service. Video names and paths on the filesystem are written to the MySql Service. The file itself is written to a file storage through the File System Service.
Video Streaming (Web app): This service is used to view videos. Users are allowed to view videos after validating their credentials through the Authentication Service. The list of videos and their paths are taken from MySql DB service, and the video itself can be read from the file storage through the File System Service.
Authentication Service: This is a simple service that validates user credentials.
File System Service: This service is used to write and read files from a file storage such as HDD or AWS S3.
MySql DB Service: This service maintains a list of videos and their corresponding paths or URLs.
Technologies used

The Video Streaming System is built using the following technologies:

Flask for building the web apps
MySQL for the database
Docker for containerization
Docker Compose for orchestration
Installation and Setup

Prerequisites
Docker and Docker Compose should be installed on your system.
Steps
Clone this repository:
bash
Copy code
git clone https://github.com/<username>/video-streaming-system.git
cd video-streaming-system
Build the Docker images for each service:
bash
Copy code
docker-compose build
Start the containers:
bash
Copy code
docker-compose up
This will start all the services and make them available on the following ports:
Upload Video (Web app) - http://localhost:5000/
Video Streaming (Web app) - http://localhost:5001/
Authentication Service - http://localhost:5002/
MySql DB Service - http://localhost:5003/
File System Service - http://localhost:5004/
Usage

To use the Video Streaming System, follow these steps:

Visit http://localhost:5000/ to upload a video.
Visit http://localhost:5001/ to view the uploaded videos.
Conclusion

The Video Streaming System is a containerized solution for uploading and viewing videos. It is built using Flask, MySQL, Docker, and Docker Compose. With this system, users can upload and view videos after validating their credentials through the Authentication Service. The video names and paths are stored in the MySql DB Service, and the video files are stored in a file storage through the File System Service.
