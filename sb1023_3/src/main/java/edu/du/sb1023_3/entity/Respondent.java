package edu.du.sb1023_3.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Respondent {

	@Id
	private int age;
	private String location;

}
