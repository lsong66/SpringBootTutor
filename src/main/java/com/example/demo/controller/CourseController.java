package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {
    @Autowired // IOC
    CourseService courseService; // Singleton

    @GetMapping(path = "/", produces = "application/json")
    public HttpEntity findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

//    @GetMapping(path = "/api/course/findAllCourses", produces = "application/json")
//    public HttpEntity<List<CourseDto>> findAllCourses(){
//        List<CourseDto> allCourses = courseService.findAllCourses();
//
//        return new ResponseEntity<>(allCourses, HttpStatus.OK);
//    }

    @GetMapping(path = "/look-up/{inputString}", produces = "application/json")
    public HttpEntity<Course> searchCourse(@PathVariable("inputString") String inputString) {

        List<Course> findedCourse = courseService.searchByCourseName(inputString);

        return new ResponseEntity(findedCourse, HttpStatus.OK);
    }

    @PostMapping(path = "/{inputString}", produces = "application/json")
    public HttpEntity<Course> addCourse(@PathVariable("inputString") String inputString) {

        List<Course> addCourse = courseService.addCourseName(inputString);

        return new ResponseEntity(addCourse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{inputString}", produces = "application/json")
    public HttpEntity<Course> deleteCourse(@PathVariable("inputString") String inputString) {

        List<Course> deleteCourse = courseService.deleteCourseName(inputString);

        return new ResponseEntity(deleteCourse, HttpStatus.OK);
    }

    @PutMapping(path = "/{Target}/{newName}", produces = "application/json")
    public HttpEntity<Course> updateCourse(@PathVariable("Target") String target, @PathVariable("newName") String name) {

        List<Course> updateCourse = courseService.updateCourseName(target, name);

        return new ResponseEntity(updateCourse, HttpStatus.OK);
    }

}
