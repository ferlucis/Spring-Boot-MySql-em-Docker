package com.mysqlrest.springbootmysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysqlrest.springbootmysql.models.Cao;

@Repository
public interface CaoRepository extends JpaRepository<Cao, Long> {
    
}
