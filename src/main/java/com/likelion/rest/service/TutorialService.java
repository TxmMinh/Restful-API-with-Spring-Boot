package com.likelion.rest.service;

import com.likelion.rest.entity.Tutorial;

import java.util.List;

public interface TutorialService {
    List<Tutorial> findAll();
    List<Tutorial> findByTitle(String title);
    Tutorial findById(long id);
    void deleteById(long id);
    void deleteAll();
    List<Tutorial> findByPublished(boolean b);
    Tutorial save(Tutorial tutorial);

}
