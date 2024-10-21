package com.ParacticsProjectSpringBoot.service.repository;
import com.ParacticsProjectSpringBoot.service.entity.StoreLearnJavaTopics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StoreLearnJavaTopicsRepository extends JpaRepository<StoreLearnJavaTopics,Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE learn_java_data", nativeQuery = true)
    void truncateTable();
}
