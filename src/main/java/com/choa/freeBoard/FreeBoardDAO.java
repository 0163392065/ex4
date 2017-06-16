package com.choa.freeBoard;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository("freeBoard")
public class FreeBoardDAO {
	
	@Inject
	private DataSource dataSource;
	
	
}
