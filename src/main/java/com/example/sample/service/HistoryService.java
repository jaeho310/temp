package com.example.sample.service;

import com.example.sample.model.entity.K8sHistory;
import com.example.sample.repository.HistoryRepository;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public List<K8sHistory> getHistories() {
        return historyRepository.findAll();
    }

    public K8sHistory insertHistory(K8sHistory histories) {
        K8sHistory history = K8sHistory.builder()
                .name(histories.getName())
                .kind(histories.getKind())
                .cmd(histories.getCmd())
                .namespace(histories.getNamespace())
                .id(histories.getId())
                .time(histories.getTime())
                .build();

        return historyRepository.save(history);
    }
}
