package jp.co.example.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.web.dao.BookmarksGroupDao;
import jp.co.example.web.service.BookmarksGroupService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookmarksGroupServiceImpl implements BookmarksGroupService {

	@Autowired
	BookmarksGroupDao bgd;
}
