package com.example.demo.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Answers;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/crack")
public class AnswerController {
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	QuestionRepository questionRepository;

	@PostMapping(value = "/answer")
	public Answers answer(@RequestBody Answers answer)
	{
		return answerRepository.save(answer);
	}

	@PostMapping(value="/question/{id}/answer")
	public Answers  createAnswer(@PathVariable(value = "id") Long id,@Valid @RequestBody Answers answers )
	{
		return questionRepository.findById(id).map(questions -> {
			answers.setQuestions(questions);
			return answerRepository.save(answers);
		}).orElseThrow(()-> new ResourceNotFoundException("topic id" +id+ "not found"));
	}

	@GetMapping(value = "/question/{id}/answer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAnswersById(@PathVariable(value = "id") Long id)
	{
		System.out.println("love");
		return answerRepository.getAnswerById(id);
	}


}

