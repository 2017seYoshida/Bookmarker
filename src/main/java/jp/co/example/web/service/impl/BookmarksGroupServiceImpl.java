package jp.co.example.web.service.impl;

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
	public BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		BookmarksGroup bg = bgd.selectWhereGroupNameAndUserId(groupName, userId);

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
	public int delete(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = bgd.delete(groupName, userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}


}
