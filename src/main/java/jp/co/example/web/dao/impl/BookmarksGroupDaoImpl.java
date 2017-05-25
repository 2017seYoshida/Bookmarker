package jp.co.example.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.web.dao.BookmarksGroupDao;
import jp.co.example.web.entity.BookmarksGroup;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class BookmarksGroupDaoImpl implements BookmarksGroupDao {

	private static final String SQL_SELECT_WHERE_GROUPNAME_AND_USERID =
			"SELECT * FROM bookmarks_group WHERE group_name = ? AND user_id = ?";
	private static final String SQL_SELECT_WHERE_USERID =
			"SELECT * FROM bookmarks_group WHERE user_id = ?";
	private static final String SQL_INSERT_GROUPNAME_USERID =
			"INSERT INTO bookmarks_group (group_name, user_id) VALUES (?, ?)";
	private static final String SQL_DELETE_WHERE_GROUPNAME_AND_USERID =
			"DELETE FROM bookmarks_group WHERE group_name = ? AND user_id = ?";
	private static final String SQL_SELECT_MOST_NEW_RECORD =
			"SELECT * FROM bookmarks_group WHERE group_id  = (SELECT MAX(group_id) FROM bookmarks_group)";

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<BookmarksGroup> selectWhereUserId(Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<BookmarksGroup> list = jt.query(SQL_SELECT_WHERE_USERID,
				new BeanPropertyRowMapper<BookmarksGroup>(BookmarksGroup.class),userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@Override
	public BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<BookmarksGroup> list = jt.query(SQL_SELECT_WHERE_GROUPNAME_AND_USERID,
				new BeanPropertyRowMapper<BookmarksGroup>(BookmarksGroup.class),
				groupName, userId);


		BookmarksGroup bg = list.isEmpty() ? null : list.get(0);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return bg;
	}

	@Override
	public BookmarksGroup findWhereMostNewRecord() {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<BookmarksGroup> list = jt.query(SQL_SELECT_MOST_NEW_RECORD, new BeanPropertyRowMapper<BookmarksGroup>(BookmarksGroup.class));

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int insert(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_INSERT_GROUPNAME_USERID,
				groupName, userId);
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int delete(String groupName, Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_DELETE_WHERE_GROUPNAME_AND_USERID,
				groupName, userId);
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

}
