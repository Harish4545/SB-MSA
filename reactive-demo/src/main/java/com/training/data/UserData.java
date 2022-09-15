package com.training.data;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.training.model.User;

import reactor.core.publisher.Flux;

@Component 
public class UserData {

	public static void sleepThread(int i)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Web
	public List<User> getUsers()
	{
		return IntStream.range(1, 11)
		.peek(UserData::sleepThread)		
		.peek(i->System.out.println("processing..."+i))
		.mapToObj(i->new User(i, "user"+i, "user"+i+"gmail.com"))
		.collect(Collectors.toList());
	}
	
	//Reactive
	public Flux<User> getUsersStream()
	{
		return Flux.range(1, 11)
		.delayElements(Duration.ofSeconds(2))
		.doOnNext(i->System.out.println("Processing....."+i))
		.map(i->new User(i, "user"+i, "user"+i+"gmail.com"))
		.log();
		
		
	}
	
}
