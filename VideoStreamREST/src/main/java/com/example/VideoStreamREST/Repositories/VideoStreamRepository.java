package com.example.VideoStreamREST.Repositories;

import com.example.VideoStreamREST.Models.video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoStreamRepository extends JpaRepository<video,Integer> {
    @Query(value = "SELECT * FROM video WHERE user_id = ?1", nativeQuery = true)
    List<video> findVideosByUserID(int id);
}
