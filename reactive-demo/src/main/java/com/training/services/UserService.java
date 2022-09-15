package com.training.services;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.data.UserData;
import com.training.model.User;
import com.training.repo.UserRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	private UserData userData;
	
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getUsers()
	{
		return userData.getUsers();
		
	}
	
	//Reactive
	public Flux<User> getUsersStream()
	{
		return userData.getUsersStream();
		
		
	}
	
	
	//Reactive
	public Flux<User> getUsersStreamDb()
	{
		return userRepo.findAll();
		
	}
	
	public Mono<User> getUser(int userId)
	{
		return userRepo.findById(userId);
		
	}
	public void addUser(User user)
	{
		userRepo.save(user).subscribe();
	}
	
	
}
