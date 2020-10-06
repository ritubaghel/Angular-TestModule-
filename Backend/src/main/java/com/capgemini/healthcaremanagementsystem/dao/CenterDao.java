package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaremanagementsystem.entity.Center;

@Repository
public interface CenterDao extends JpaRepository<Center, Long> {
}
