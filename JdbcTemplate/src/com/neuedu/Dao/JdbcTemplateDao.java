package com.neuedu.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcTemplateDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void update(String sql,Object ...args){
		jdbcTemplate.update(sql, args);
	}
	
}
