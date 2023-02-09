package com.example.backend.repository;

import com.example.backend.entity.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplaintRepository extends JpaRepository<ComplaintEntity,Long> {
}
