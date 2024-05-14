package com.mystuff.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mystuff.app.entity.Stuff;

@Repository
public interface StuffRepository extends JpaRepository<Stuff,Long>{
    @Transactional
    void deleteByStuff(String stuff);
}
