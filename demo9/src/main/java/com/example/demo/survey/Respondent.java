package com.example.demo.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respondent {

	@Id @GeneratedValue
	@Column(name = "RESPONDENT_ID")
	private int id;

	private int age;
	private String location;

}
