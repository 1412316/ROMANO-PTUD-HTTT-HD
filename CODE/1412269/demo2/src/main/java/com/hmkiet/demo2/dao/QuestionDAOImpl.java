package com.hmkiet.demo2.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hmkiet.demo2.model.Question;

@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		}
	
	public List<Question> list() {
		@SuppressWarnings("unchecked")
	    TypedQuery<Question> query = sessionFactory.getCurrentSession().createQuery("from Question");
	    return query.getResultList();
	    }
}
