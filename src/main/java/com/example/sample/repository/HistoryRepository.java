package com.example.sample.repository;

import com.example.sample.model.entity.K8sHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<K8sHistory, Long> {

}
