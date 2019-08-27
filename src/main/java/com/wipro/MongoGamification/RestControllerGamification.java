package com.wipro.MongoGamification;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



//@CrossOrigin(value="http://ec2-52-66-189-143.ap-south-1.compute.amazonaws.com:3000")
@RestController
@RequestMapping("/dashboard")
public class RestControllerGamification {
	@Autowired
	private RepositoryGamification repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/teamDash", method = RequestMethod.GET)
	public List<BeanGamification> getAllTeam() {
		System.out.println("Nimisha");
		Query query = new Query();
		query.addCriteria(Criteria.where("team").is(true));
	  return mongoTemplate.find(query,BeanGamification.class);
	}
	@RequestMapping(value = "/individualDash", method = RequestMethod.GET)
	public List<BeanGamification> getAllIndividual() {
		System.out.println("Nimisha");
		Query query = new Query();
		query.addCriteria(Criteria.where("team").is(false));
	  return mongoTemplate.find(query,BeanGamification.class);
	}	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public BeanGamification createGame(@Valid @RequestBody BeanGamification game) {
		System.out.println("Hemanth");
		//RestTemplate restTemplate = new RestTemplate();
		//Rules[] response  = restTemplate.getForObject(, Rules[].class);
		game.set_id(ObjectId.get());
	  repository.save(game);
	  return game;
	}
	
}
