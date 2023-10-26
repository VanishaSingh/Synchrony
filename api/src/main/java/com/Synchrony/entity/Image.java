package com.Synchrony.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgurId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
