package com.training.config;

import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.bean.Movie;

@Configuration
public class MovieConfiguration {


	@Bean
	public Function<KStream<String, Movie>, KStream<String, Movie>> movieProcessor() {

		return kstream -> kstream.filter((key, movie) -> {
			if (movie.getGenre().equalsIgnoreCase("thriller")) {
				System.out.println("Movie Details: " + movie);
			} 
			return movie.getGenre().equalsIgnoreCase("thriller");
		});

	}
}
