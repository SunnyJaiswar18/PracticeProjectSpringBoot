package com.ParacticsProjectSpringBoot.service.repository;

import com.ParacticsProjectSpringBoot.service.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

}
