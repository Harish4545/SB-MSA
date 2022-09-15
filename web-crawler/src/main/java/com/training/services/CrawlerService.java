package com.training.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.training.bean.Movie;

import reactor.core.publisher.Mono;
import java.util.stream.Collectors;
@Service
public class CrawlerService {
	
	private String producerUrl ="http://localhost:8083/movies";
	
	@Autowired
	private KafkaTemplate<String,Movie> movieTemplate;
	
	private String kafkaTopic = "kafkamovie1";
	
	public void crawlMovies()
	{
		Mono<Movie[]> movieMono = WebClient.create()
		.get()
		.uri(producerUrl)
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(Movie[].class);
		/*
		 * movieMono.subscribe(movieArray->Arrays.stream(movieArray).collect(Collectors.
		 * toList()) .forEach(movie->System.out.println(movie)));
		 */
		
		
		  movieMono.subscribe(movieArray->Arrays.stream(movieArray).collect(Collectors.
		  toList()) .forEach(movie->movieTemplate.send(kafkaTopic, movie)));
		 
		
		
	}

}
