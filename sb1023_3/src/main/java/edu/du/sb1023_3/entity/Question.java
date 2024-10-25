package edu.du.sb1023_3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class Question {

	private String title;
	private List<String> options;

	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
