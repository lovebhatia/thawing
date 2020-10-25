package com.example.demo.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionAnswerService;
import com.example.demo.Service.TruncateDatabaseService;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")

@CrossOrigin("http://localhost:4200")
@RequestMapping("/crack")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    private QuestionAnswerService questionService;
    @Autowired
    private TruncateDatabaseService truncateDs;

    @PostMapping(value = "/course")
    public Course subject(@RequestBody Course language)
    {
        return courseRepository.save(language);
    }
    @Transactional
    @GetMapping(value= "/course")
    @CrossOrigin("http://localhost:4200")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAllsubject()
    {
        return courseRepository.findAll();

    }

    @GetMapping(value="/courses")
    public ResponseEntity<List<String>> getAllCourses()
    {
        System.out.println("test");
        List<String> courses= courseRepository.findAllCourses();
        /*List<Map<String,String>> result = courses.stream()
                .map(arr->{
                    Map<String,String> map = new HashMap<>();
                    map.put("name",arr[0]);
                    map.put("id",arr[1]);
                    return map;
                })
                .collect(Collectors.toList());

        */
        return ResponseEntity.ok(courses);
    }

    @GetMapping(value="/courses1")
    public List<Course> getAllCourses1()
    {
        //return questionService.getAllCourses();
        return (List<Course>) courseRepository.getCourse();
    }

    @GetMapping(value= "/course/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Course> topicsbyCourse(@PathVariable Long id)
    {
        return courseRepository.findById(id);
    }


    @GetMapping(value="/truncate")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String truncateTable()
    {
        truncateDs.truncate();
        return "test";

    }



}

