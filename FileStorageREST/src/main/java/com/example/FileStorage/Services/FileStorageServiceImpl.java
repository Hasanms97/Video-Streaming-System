package com.example.FileStorage.Services;

import com.example.FileStorage.Repositories.FileStorageRepository;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Repository
public class FileStorageServiceImpl implements FileStorageService {
    private final Storage storage;
    @Autowired
    public FileStorageServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Autowired
    FileStorageRepository fileStorageRepository;

    @Override
    public void saveVideo(String id, MultipartFile videoFile) throws IOException {
        BlobId blobId = BlobId.of("dtube-videos", id);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        byte[] content = videoFile.getBytes();
        storage.create(blobInfo, content);
    }

    @Override
    public void deleteVideo(String path) {
        BlobId blobId = BlobId.of("dtube-videos", path+".mp4");
        storage.delete(blobId);
    }
}
