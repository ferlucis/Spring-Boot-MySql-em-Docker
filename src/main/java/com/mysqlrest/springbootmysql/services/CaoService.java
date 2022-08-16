package com.mysqlrest.springbootmysql.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mysqlrest.springbootmysql.models.Cao;
import com.mysqlrest.springbootmysql.repositories.CaoRepository;

@Service
public class CaoService {
    
    CaoRepository caoRepository;
    
    public CaoService(CaoRepository caoRepository) {
        this.caoRepository = caoRepository;
    }

    @Transactional
    public Cao save(Cao cao) {
        return caoRepository.save(cao);
    }

    public List<Cao> findAll(){
        return caoRepository.findAll();
    }

    public Optional<Cao> findById(Long id) {
        return caoRepository.findById(id);
    }

    

}
