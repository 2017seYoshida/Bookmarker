package jp.co.example.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.web.dao.BookmarksGroupDao;
import jp.co.example.web.entity.BookmarksGroup;
import jp.co.example.web.service.BookmarksGroupService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class BookmarksGroupServiceImpl implements BookmarksGroupService {

	@Autowired
	BookmarksGroupDao bgd;

	@Override
	public List<BookmarksGroup> selectGroupNameWhereUserId(Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<BookmarksGroup> list = bgd.selectWhereUserId(userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@Override
	public BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		BookmarksGroup bg = bgd.selectWhereGroupNameAndUserId(groupName, userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return bg;
	}

	@Override
	public BookmarksGroup selectWhereGroupId(Integer groupId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		BookmarksGroup bg = bgd.selectWhereGroupId(groupId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return bg;
	}

	@Override
	public BookmarksGroup findWhereMostNewRecord() {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		BookmarksGroup bg = bgd.findWhereMostNewRecord();

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return bg;
	}

	@Override
	public int insert(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = bgd.insert(groupName, userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int delete(Integer groupId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = bgd.delete(groupId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}
}
