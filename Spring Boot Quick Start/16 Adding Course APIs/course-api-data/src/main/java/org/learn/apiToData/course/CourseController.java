package org.learn.apiToData.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.learn.apiToData.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getTopics(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addTopic(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{coureId}")
	public void updateTopic(@PathVariable String topicId, @PathVariable String courseId,@RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{coureId}")
	public void deleteTopic(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}

}
