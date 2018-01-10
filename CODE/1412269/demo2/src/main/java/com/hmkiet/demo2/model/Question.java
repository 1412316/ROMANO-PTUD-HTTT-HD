package com.hmkiet.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "Question")
	private String question;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long _id) {
		this.id = _id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String _question) {
		this.question = _question;
	}
}
