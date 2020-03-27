package org.learn.apiToData.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	/*private List<Topic> topics=new ArrayList<> (Arrays.asList(
								new Topic("spring","Spring Framework","Spring Framework Description"),
								new Topic("java","Core Java","Core Java Description"),
								new Topic("javascript","Javascript","Javascript Description")
								));
	*/
	public List<Topic> getAllTopics(){
		/*
		 * List<Topic> topics=new ArrayList<>();
		 * topicRepository.findAll().forEach(topics::add);
		 * return topics;
		 * */
		return (List<Topic>) topicRepository.findAll();
	}
	
	public Topic getTopic(String id){
		Optional<Topic> topic=topicRepository.findById(id);
		if(topic.isPresent()) {
			return topic.get();
		}
		return null;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
