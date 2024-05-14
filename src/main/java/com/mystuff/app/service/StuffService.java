package com.mystuff.app.service;

import java.util.List;

import com.mystuff.app.entity.Stuff;

public interface StuffService {
    void addStuff(Stuff stuff);
    List<Stuff> getStuff();
    void deleteStuffByName(String stuff);
}
