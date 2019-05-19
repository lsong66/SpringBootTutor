package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("JavaI")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        if(courseName.equals("JavaI")) {
            return courses;
        }

        return new ArrayList<Course>();
    }

    public List<Course> addCourseName(String courseName) {
        Course javaTwo = Course.builder()
                .className(courseName)
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();
        courses.add(javaTwo);
        return courses;
    }
    public List<Course> deleteCourseName(String courseName) {
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getClassName().equals(courseName)){
                courses.remove(i);
                break;
            }
        }
        return courses;
    }

    public List<Course> updateCourseName(String courseName, String newName) {
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getClassName().equals(courseName)){
                courses.get(i).setClassName(newName);
                break;
            }
        }
        return courses;
    }
}
