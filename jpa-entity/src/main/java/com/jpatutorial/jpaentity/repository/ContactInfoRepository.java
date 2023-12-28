package com.jpatutorial.jpaentity.repository;

import com.jpatutorial.jpaentity.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
