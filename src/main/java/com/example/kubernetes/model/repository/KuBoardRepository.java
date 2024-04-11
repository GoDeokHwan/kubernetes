package com.example.kubernetes.model.repository;

import com.example.kubernetes.model.entity.KuBoard;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KuBoardRepository extends ReactiveCrudRepository<KuBoard, Long> {
}
