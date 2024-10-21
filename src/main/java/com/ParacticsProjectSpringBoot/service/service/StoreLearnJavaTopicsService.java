package com.ParacticsProjectSpringBoot.service.service;

import com.ParacticsProjectSpringBoot.service.entity.StoreLearnJavaTopics;
import com.ParacticsProjectSpringBoot.service.repository.StoreLearnJavaTopicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreLearnJavaTopicsService {

    @Autowired
    StoreLearnJavaTopicsRepository storeLearnJavaTopicsRepository;

    public Boolean storeData(List<StoreLearnJavaTopics> storeLearnJavaTopics){
        storeLearnJavaTopicsRepository.saveAll(storeLearnJavaTopics);
        return true;
    }

    public List<StoreLearnJavaTopics> getAllTopics() {
        return storeLearnJavaTopicsRepository.findAll();
    }

    public void truncateTopicsTable() {
        storeLearnJavaTopicsRepository.truncateTable();
    }
}
