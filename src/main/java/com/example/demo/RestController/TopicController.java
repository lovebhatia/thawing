package com.example.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Topics;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/crack")

public class TopicController {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    QuestionAnswerService service;

    @PostMapping(value = "/topic")
    public Topics topic(@RequestBody Topics topic)
    {
        return topicRepository.save(topic);
    }

    @GetMapping(value="/topics/{id}")
    public ResponseEntity<List<String>> getAllTopics(@PathVariable(value = "id") Long topicId)
    {
        List<String> topics= topicRepository.findTopicByCourse(topicId);
        return ResponseEntity.ok(topics);
    }


    @PostMapping(value="/course/{id}/topic")
    @Consumes(MediaType.APPLICATION_JSON)
    public Topics createTopic(@PathVariable(value = "id") Long courseid,@Valid @RequestBody Topics topics )
    {
        return courseRepository.findById(courseid).map(course -> {
            topics.setCourse(course);
            return topicRepository.save(topics);
        }).orElseThrow(()-> new ResourceNotFoundException("topic id" +courseid+ "not found"));
    }

    @GetMapping(value= "/topics")
    @Produces(MediaType.APPLICATION_JSON)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<Topics> topics()
    {
        return topicRepository.findAll();
    }

    @GetMapping(value = "/course/{id}/topics")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Topics> getTopicByCourse(@PathVariable(value="id") Long id)
    {
        return topicRepository.findById(id);
        //return topicRepository.g
        //return service.getTopicbySelectedTopic(1l, 1l);
    }

    @GetMapping(value = "/course/topics/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<Long, Topics> getTopicbySelection(@PathVariable(value="id") Long id)
    {
        //return topicRepository.findById(id);
        //return topicRepository.g
        return service.getTopicbySelectedTopic(id, id);
    }


    @GetMapping(value= "/topic/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Topics> questionsByTopic(@PathVariable(value = "id") Long id)
    {
        return topicRepository.findById(id);
    }


    @GetMapping(value="topic/{id}/setDashboard")
    public ResponseEntity<Long> setDashboard(@PathVariable(value="id") Long id)
    {

        topicRepository.dashboardFlagSet(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="topic/{id}/unsetDashboard")
    public ResponseEntity<Long> unsetDashboard(@PathVariable(value="id") Long id)
    {
        topicRepository.dashboardFlagUnset(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="topic/{id}/index/{n}")
    public ResponseEntity<Long> setIndex(@PathVariable(value="id") Long id,@PathVariable(value="id") Long n)
    {
        topicRepository.setIndex(id,n);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}

