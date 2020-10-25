package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Questions;
import com.example.demo.model.Topics;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.TopicRepository;

@Service("QuestionAnswerService")
public class QuestionAnswerService{
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	TopicRepository topicRepository;

	@PersistenceContext
	private EntityManager entityManager;




	public List<String> getAllCourses()
	{
		final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		final CriteriaQuery<String> query = cb.createQuery(String.class);
		final Root<Course> course = query.from(Course.class);
		query.select(course.<String>get("courseName"));
		final TypedQuery<String> typedQuery = entityManager.createQuery(query);
		final List<String> courseNames = (List<String>)typedQuery.getResultList();
		return courseNames;
	}






	public HashMap<Long,Topics> getTopicbySelectedTopic(final Long courseId,final Long topicId)
	{
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Topics> query = builder.createQuery(Topics.class);
		final Root<Topics> root = query.from(Topics.class);
		query.select(root).where(builder.equal(root.get("topicId"), topicId));
		final TypedQuery<Topics> q=entityManager.createQuery(query);
		final Topics topics=q.getSingleResult();
		query.select(root);
		final TypedQuery<Topics> q1=entityManager.createQuery(query);

		final List<Topics> list=new ArrayList<Topics>();
		list.add(topics);
		//list.add(topicRepository.findAll());



		final HashMap<Long, Topics>  hashMap=new HashMap<>();
		hashMap.put(topicId,topics);
		//getTopicbySelectedTopic1(courseId, topicId);

		//
		//HashMap<Long, List<Topics>> hashmap=new HashMap();
		//hashmap.put(2l, list);



		return hashMap;
	}


	public HashMap<Long,Topics> getTopicbySelectedTopic1(final Long courseId,final Long topicId)
	{
		final CriteriaBuilder builder1 = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Topics> query1 = builder1.createQuery(Topics.class);
		final Root<Topics> root1 = query1.from(Topics.class);
		query1.select(root1).where(builder1.notEqual(root1.get("topicId"), topicId));
		final TypedQuery<Topics> q2=entityManager.createQuery(query1);
		final Topics topics1=q2.getSingleResult();
		query1.select(root1);
		final TypedQuery<Topics> q3=entityManager.createQuery(query1);

		final HashMap<Long, Topics>  hashMap1=new HashMap<>();
		hashMap1.put(2l,topics1);
		return hashMap1;
	}

	public List<Questions> getQuestionsbyCourse(final Long id) {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Questions> criteria = builder.createQuery(Questions.class);
		final Root<Questions> from = criteria.from(Questions.class);
		criteria.select(from);
		//criteria.where(builder.equal(from.get())));
		//criteria.where(builder.equal(from.get("courseId"));
		final TypedQuery<Questions> typed = entityManager.createQuery(criteria);
		final List<Questions> courseNames = (List<Questions>)typed.getResultList();
		try {
			return courseNames;
			//return (List<Questions>) typed.getSingleResult();
		} catch (final NoResultException nre) {
			return null;
		}
	}

	public List<Questions> getQuestionsbyTopic(final Long id) {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Questions> criteria = builder.createQuery(Questions.class);
		final Root<Questions> from = criteria.from(Questions.class);
		criteria.select(from);
		//criteria.where(builder.equal(from.get())));
		//criteria.where(builder.equal(from.get("courseId"));
		final TypedQuery<Questions> typed = entityManager.createQuery(criteria);
		final List<Questions> courseNames = (List<Questions>)typed.getResultList();
		try {
			return courseNames;
			//return (List<Questions>) typed.getSingleResult();
		} catch (final NoResultException nre) {
			return null;
		}
	}



	public List<Questions> getQuestionsbyCourse1(final Long id)
	{
		final Questions user = null;
		final Query query = entityManager.createQuery("select questions_name from Questions where course_id = "+id,Questions.class);
		query.setParameter("courseId",2);

		final List<Questions> list = (List<Questions>) query.getSingleResult();
		return list;
	}

	public List<Questions> getQuestionsBySubTopic(final Long id)
	{
		final Questions user = null;
		final Query query = entityManager.createQuery("select questions_name from Questions where sub_topic_id = "+id,Questions.class);
		query.setParameter("sub_topic_id",2);

		final List<Questions> list = (List<Questions>) query.getSingleResult();
		return list;
	}

	@Transactional
	public void executeNativeQuery(String query1){
		System.out.println(query1+"quesry to update");
		String queryString=query1;
		
			entityManager.createNativeQuery(queryString).executeUpdate();
			//query.setParameter(name, value)
		
		//return query.getResultList();

	}
	

}