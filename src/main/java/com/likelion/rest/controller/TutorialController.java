package com.likelion.rest.controller;

import com.likelion.rest.entity.Tutorial;
import com.likelion.rest.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorials") // API nhận tất cả Tutorial và tìm các Tutorial với title
    public ResponseEntity<List<Tutorial>> findAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Tutorial> tutorialList;
            if (title == null) {
                tutorialList = tutorialService.findAll();
            } else {
                tutorialList = tutorialService.findByTitle(title);
            }

            if (tutorialList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(tutorialList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( "/tutorials/{id}") // API nhận một tutorial bởi id
    public ResponseEntity<Tutorial> findTutorialById(@PathVariable("id") Long id) {
        Tutorial tutorial = tutorialService.findById(id);
        if (tutorial == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        }
    }

    @PostMapping("/tutorials") // APi tạo mới một tutorial
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial tempTutorial = new Tutorial();
            tempTutorial.setTitle(tutorial.getTitle());
            tempTutorial.setDescription(tutorial.getDescription());
            tempTutorial.setPublished(tutorial.isPublished());
            Tutorial savedTutorial = tutorialService.save(tempTutorial);

            return new ResponseEntity<>(savedTutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}") // Cập nhập một tutorial bởi id
    public ResponseEntity<Tutorial> updateTutorial (@PathVariable("id") Long id, @RequestBody Tutorial tutorial) {
        Tutorial tutorialById = tutorialService.findById(id);

        if (tutorialById == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            tutorialById.setTitle(tutorial.getTitle());
            tutorialById.setDescription(tutorial.getDescription());
            tutorialById.setPublished(tutorial.isPublished());
            Tutorial savedTutorial = tutorialService.save(tutorialById);

            return new ResponseEntity<>(savedTutorial, HttpStatus.OK);
        }
    }

    @DeleteMapping("/tutorials/{id}") // Xóa một tutorial bởi id
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                tutorialService.deleteById(id);

                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials") // Xóa tất cả tutorial
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialService.deleteAll();

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/published") // tìm các tutorial đã công bố
    public ResponseEntity<List<Tutorial>> findAllPublishedTutorials() {
        try {
            List<Tutorial> publishedTutorials = tutorialService.findByPublished(true);

            if (publishedTutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(publishedTutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
