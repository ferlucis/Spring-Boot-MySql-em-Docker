package com.mysqlrest.springbootmysql.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysqlrest.springbootmysql.dtos.CaoDto;
import com.mysqlrest.springbootmysql.models.Cao;
import com.mysqlrest.springbootmysql.services.CaoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cao")
public class CaoController {

    final CaoService caoService;
    
    public CaoController(CaoService caoService) {
        this.caoService = caoService;
    }
    
    @PostMapping("/")
    public ResponseEntity<Object> saveCao(@RequestBody CaoDto caoDto){
        var cao = new Cao();
        BeanUtils.copyProperties(caoDto, cao);
        return ResponseEntity.status(HttpStatus.CREATED).body(caoService.save(cao));
    }

    @GetMapping("/")
    public ResponseEntity<List<Cao>> getAllCaos(){
        return ResponseEntity.status(HttpStatus.OK).body(caoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCao(@PathVariable("id") Long id){
        Optional<Cao> cOptional = caoService.findById(id);
        if(!cOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cão não encontrado");
        }
            return ResponseEntity.status(HttpStatus.OK).body(cOptional.get());

    }

}
