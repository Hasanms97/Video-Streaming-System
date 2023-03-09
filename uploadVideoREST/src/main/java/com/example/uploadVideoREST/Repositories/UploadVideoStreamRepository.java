package com.example.uploadVideoREST.Repositories;


import com.example.uploadVideoREST.Models.video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadVideoStreamRepository extends JpaRepository<video, Integer> {

}
