package org.learn.apiToData.course;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.learn.apiToData.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
	private Topic topic;
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course(String id, String name, String description, String topicid) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=new Topic(topicid, "", "");
	}
	
	public Course() {
		super();
	}
}
