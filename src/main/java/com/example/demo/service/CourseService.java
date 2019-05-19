package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses(){

        return courseRepository.findAllClasses();
    }

    public List<Course> searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }

    public List<Course> addCourseName(String input){

        return courseRepository.addCourseName(input);
    }

    public List<Course> deleteCourseName(String input){

        return courseRepository.deleteCourseName(input);
    }

    public List<Course> updateCourseName(String input, String name){

        return courseRepository.updateCourseName(input, name);
    }
}
