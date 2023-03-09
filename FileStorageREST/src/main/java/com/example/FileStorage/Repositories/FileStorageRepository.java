package com.example.FileStorage.Repositories;

import com.example.FileStorage.Entities.video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileStorageRepository extends JpaRepository<video,Integer> {
}
