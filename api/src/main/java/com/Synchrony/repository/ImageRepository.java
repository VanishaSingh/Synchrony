package com.Synchrony.repository;

import com.Synchrony.entity.Image;
import com.Synchrony.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByUser(User user);
}
