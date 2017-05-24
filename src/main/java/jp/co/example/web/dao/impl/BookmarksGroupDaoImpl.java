package jp.co.example.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.web.dao.BookmarksGroupDao;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BookmarksGroupDaoImpl implements BookmarksGroupDao {

	@Autowired
	JdbcTemplate jt;
}
