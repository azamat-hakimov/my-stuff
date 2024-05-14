package com.mystuff.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mystuff.app.entity.Stuff;
import com.mystuff.app.repository.StuffRepository;

@Service
public class ServiceImpl implements StuffService {

    private StuffRepository stuffRepository;

    @Autowired
    public ServiceImpl(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    @Override
    public void addStuff(Stuff stuff) {
        stuffRepository.save(stuff);
    }

    @Override
    public List<Stuff> getStuff() {
        return stuffRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteStuffByName(String stuff) {
        stuffRepository.deleteByStuff(stuff);
    }
    
}
