package com.example.task219.repository;

import com.example.task219.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackSpringDataRepository extends JpaRepository<Feedback,Long> {
}
