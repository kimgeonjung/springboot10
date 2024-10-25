package edu.du.sb1023_3.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AnsweredData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private List<String> responses;

	@ManyToOne
	@JoinColumn(name = "res")
	private Respondent res;
}
