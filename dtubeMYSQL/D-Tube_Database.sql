create database dtube;
use dtube;


CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `video` (
  `video_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `path` varchar(1000) DEFAULT NULL,
  `user_user_id` int DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  KEY `fk_user` (`user_id`),
  KEY `FKt8idk9osu0py8efvdrydf4evj` (`user_user_id`),
  CONSTRAINT `fk_userr` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
); 



