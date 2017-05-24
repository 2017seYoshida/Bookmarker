package jp.co.example.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.web.dao.BookmarksDao;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BookmarksDaoImpl implements BookmarksDao {

	@Autowired
	JdbcTemplate jt;
}
