package org.learn.apiToData.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	/*private List<Course> topics=new ArrayList<> (Arrays.asList(
								new Course("spring","Spring Framework","Spring Framework Description"),
								new Course("java","Core Java","Core Java Description"),
								new Course("javascript","Javascript","Javascript Description")
								));
	*/
	public List<Course> getAllCourses(String topicId){
		/*
		 * List<Topic> topics=new ArrayList<>();
		 * topicRepository.findAll().forEach(topics::add);
		 * return topics;
		 * */
		return (List<Course>) courseRepository.findAll();
	}
	
	public Course getCourse(String id){
		Optional<Course> course=courseRepository.findById(id);
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
