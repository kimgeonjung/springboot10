package edu.du.sbproject.survey;

import lombok.Data;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Data
@ToString
public class Question {

	private String title;
	private List<String> options;

	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

}
