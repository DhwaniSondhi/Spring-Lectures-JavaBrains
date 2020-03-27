package org.learn.apiToData.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId){
		/*
		 * List<Topic> topics=new ArrayList<>();
		 * topicRepository.findByTopicId(topicId).forEach(topics::add);
		 * return topics;
		 * */
		return (List<Course>) courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(String topicId, String courseId){
		List<Course> courses=(List<Course>) courseRepository.findByTopicId(topicId);
		Optional<Course> course=courses.stream().filter(c->c.getId().equals(courseId)).findFirst();
		if(course.isPresent()) {
			return course.get();
		}
		return null;
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
