package com.hmkiet.demo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmkiet.demo2.model.Question;
import com.hmkiet.demo2.dao.QuestionDAO;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDAO questionDAO;
	
	@Transactional(readOnly = true)
	public List<Question> list() {
		return questionDAO.list();
	   }
}
