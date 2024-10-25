package edu.du.sbproject.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnsweredData {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private int id;

	@ElementCollection
	@CollectionTable(
			name = "responses",
			joinColumns = @JoinColumn(name = "MEMBER_ID")
	)
	@OrderColumn
	@Column(name = "seq")
	private List<String> responses;

	@OneToOne
	@JoinColumn(name = "RESPONDENT_ID")
	private Respondent res;
}
