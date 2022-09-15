package com.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	@Id
	private Long userId;
	
	@NotBlank(message = "Value cannot be blank")
	private String name;
	
	@Email(message = "Email Format not right")
	private String email;
	
	
	@Min(message = "Minimun age is 18", value = 18)
	@Max(message = "Maximum age is 60", value = 60)
	private int age;
}
