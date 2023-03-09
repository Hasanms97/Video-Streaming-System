package com.example.FileStorage.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "video")
public class video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private int id;
    @Column(name = "description")
    @NonNull
    private String description;
    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "path")
    @NonNull
    private String path;
    @Column(name = "user_id")
    @NonNull
    int user_id;

}
