package com.example.demo.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionAnswerService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Questions;
import com.example.demo.model.SubTopics;
import com.example.demo.model.Topics;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SubTopicRepository;
import com.example.demo.repository.TopicRepository;

@RequestMapping("/crack")
@RestController
public class QuestionController {
    @Autowired
    SubTopicRepository subTopicRepository;

    @Autowired
    QuestionAnswerService questionService;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired 
    TopicRepository topicRepository;


    @GetMapping(value= "course/topicName/subTopicName/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<SubTopics> questionsBySubTopic(@PathVariable(value = "id") Long id)
    {
        return subTopicRepository.findById(id);
    }

    @GetMapping(value= "course/topicName/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Topics> questionsByTopic(@PathVariable(value = "id") Long id)
    {
        return topicRepository.findById(id);
    }


    @GetMapping(value = "course/{id}/questions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questions> getQuesByCourseId(@PathVariable(value = "id") Long id)
    {
        return questionService.getQuestionsbyCourse(id);
    }

    @GetMapping(value = "course/topic/{id}/questions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questions> getQuesByTopicId(@PathVariable(value = "id") Long id)
    {
        return questionService.getQuestionsbyTopic(id);
    }



    @PostMapping(value = "/questions")
    public Questions questions(@RequestBody Questions  questions)
    {
        return questionRepository.save(questions);
    }

    @GetMapping(value="/questions")
    public List<Questions> questions()
    {
        return questionRepository.findAll();
    }
    @GetMapping(value= "/question/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Questions> answerByQuestion(@PathVariable(value = "id") Long id)
    {
        return questionRepository.findById(id);
    }

    @PostMapping(value="/subtopic/{id}/question")
    public Questions addQuestionByid(@PathVariable(value = "id") Long id, @Valid @RequestBody Questions questions)
    {
        return subTopicRepository.findById(id).map(subTopics -> {
            questions.setSubTopics(subTopics);
            return questionRepository.save(questions);

        }).orElseThrow(() -> new CustomException("No Subtopic ","","","",""));
    }
    @GetMapping(value="question/{question_id}/likes/{likes}")
    public int updateLikesForQuestions(@PathVariable(value = "question_id") Long question_id,@PathVariable(value = "likes") int likes)
    {
        
       int s= questionRepository.updateLikesForQuestion(question_id, likes);
       return s;
    }


    @GetMapping(value="question/{id}/delete")
    public ResponseEntity<Long> deleteQuestion(@PathVariable(value ="id") Long id)
    {
        
         questionRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping(value="question/{id}/setDashboard")
    public ResponseEntity<Long> setDashboard(@PathVariable(value="id") Long id)
    {
        questionRepository.dashboardFlagSet(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="question/{id}/unsetDashboard")
    public ResponseEntity<Long> unsetDashboard(@PathVariable(value="id") Long id)
    {
        questionRepository.dashboardFlagUnset(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="question/{id}/index/{n}")
    public ResponseEntity<Long> setIndex(@PathVariable(value="id") Long id,@PathVariable(value="n") int n)
    {
        questionRepository.setIndex(id,n);
        //questionRepository.updateIndex(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }




    @GetMapping(value="question/show/{id}")
    public int showFlag(@PathVariable(value = "id") Long id)
    {
        int s= questionRepository.ShowFlag(id);
        return s;
    }

    @GetMapping(value="question/delete/{id}")
    public int deleteFlag(@PathVariable Long id)
    {
        System.out.println("in deleteion");
        int s= questionRepository.DeleteFlag(id);
        return s;
    }

    @GetMapping(value="admin/questions/{id}")
	public ResponseEntity<List<String>> getAllQuestions(@PathVariable(value = "id") Long subTopicId)
	{
		List<String> questions= questionRepository.findQuestionBySubTopic(subTopicId);
		return ResponseEntity.ok(questions);
    }
    
    /*
    public Questions Test(long courseId,long topicId,Questions entity) {
        Course course=CourseRepository.findById(courseId);
        Topics topics=TopicRepository.findById(topicId);
        if(Objects.nonNull(course) && Objects.nonNull(topics);
        {
            return questionRepository.save(entity);
        }
        else
        throw new RuntimeException("Failed to create question");
    }
    */

}
	