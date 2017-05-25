package jp.co.example.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.web.dao.BookmarksDao;
import jp.co.example.web.entity.Bookmarks;
import jp.co.example.web.service.BookmarksService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class BookmarksServiceImpl implements BookmarksService {

	@Autowired
	BookmarksDao bd;

	@Override
	public List<Bookmarks> selectWhereGroupIDAndUserId(Integer groupId, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Bookmarks> list = bd.selectWhereGroupIDAndUserId(groupId, userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@Override
	public Bookmarks selectWhereBookmarkId(Integer bookmarkId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Bookmarks book = bd.selectWhereBookmarkId(bookmarkId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return book;
	}

	@Override
	public int insert(Bookmarks book) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = bd.insert(book);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int update(Bookmarks book) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = bd.update(book);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int delete(Integer bookmarkId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = bd.delete(bookmarkId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}
}
