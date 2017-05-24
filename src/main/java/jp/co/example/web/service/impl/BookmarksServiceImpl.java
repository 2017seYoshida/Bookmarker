package jp.co.example.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.web.dao.BookmarksDao;
import jp.co.example.web.service.BookmarksService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookmarksServiceImpl implements BookmarksService {

	@Autowired
	BookmarksDao bd;
}
