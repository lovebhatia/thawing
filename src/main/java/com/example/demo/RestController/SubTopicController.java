package com.example.demo.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Questions;
import com.example.demo.model.SubTopics;
import com.example.demo.repository.SubTopicRepository;
import com.example.demo.repository.TopicRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/crack")
public class SubTopicController {

	@Autowired
	SubTopicRepository subTopicRepository;
	@Autowired
	TopicRepository topicRepository;

	@GetMapping(value="/subTopics/{id}")
	public ResponseEntity<List<String>> getAllSubTOpics(@PathVariable(value = "id") Long subTopicId)
	{
		List<String> topics= subTopicRepository.findSubTopicByTopic(subTopicId);
		return ResponseEntity.ok(topics);
	}

	@PostMapping(value = "/topic/{id}/subtopic")
	@Consumes(MediaType.APPLICATION_JSON)
	public SubTopics createSubtopic(@PathVariable(value = "id") Long topicid, @Valid @RequestBody SubTopics subTopics)
	{
		return topicRepository.findById(topicid).map(topics -> {
			subTopics.setTopics(topics);
			return subTopicRepository.save(subTopics);

		}).orElseThrow(()-> new ResourceNotFoundException("topic id "+topicid+ "not found"));
	}

	@PostMapping(value = "subtopics")
	public SubTopics createSubtopics(SubTopics subTopics)
	{
		return subTopicRepository.save(subTopics);

	}

	@GetMapping(value="subtopic/{id}/setDashboard")
	public ResponseEntity<Long> setDashboard(@PathVariable(value="id") Long id)
	{
		subTopicRepository.dashboardFlagSet(id);
		return  new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value="subtopic/{id}/unsetDashboard")
	public ResponseEntity<Long> unsetDashboard(@PathVariable(value="id") Long id)
	{
		subTopicRepository.dashboardFlagUnset(id);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping(value="subtopic/{id}/index/{n}")
	public ResponseEntity<Long> setIndex(@PathVariable(value="id") Long id,@PathVariable(value="id") Long n)
	{
		subTopicRepository.setIndex(id,n);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
}

