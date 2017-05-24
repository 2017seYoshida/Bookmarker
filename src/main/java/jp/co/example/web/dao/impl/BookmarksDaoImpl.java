package jp.co.example.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.web.dao.BookmarksDao;
import jp.co.example.web.entity.Bookmarks;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class BookmarksDaoImpl implements BookmarksDao {

	private static final String SQL_SELECT_WHERE_GROUPID_AND_USERID_GROUPID_IS_NOT_NULL =
			"SELECT * FROM bookmarks WHERE group_id = ? AND user_id = ? AND group_id IS NOT NULL";
	private static final String SQL_SELECT_WHERE_GROUPID_IS_NULL_AND_USERID =
			"SELECT * FROM bookmarks WHERE user_id = ? AND group_id IS NULL";
	private static final String SQL_INSERT_BOOKMARKNAME_BOOKMARKURL_GROUPID_USERID =
			"INSERT INTO bookmarks (bookmark_name, bookmark_url, group_id, user_id) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE_WHERE_BOOKMARKID =
			"UPDATE bookmarks SET bookmark_name = ?, bookmark_url = ?, group_id = ? WHERE bookmark_id = ?";
	private static final String SQL_DELETE_WHERE_BOOKMARKID =
			"DELETE FROM bookmarks WHERE bookmark_id = ?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Bookmarks> selectWhereGroupIDAndUserId(Bookmarks book) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Bookmarks> list;
		log.info(LogEnum.IF + "(book.getGroupId() == null || book.getGroupId() == 0)");
		if(book.getGroupId() == null || book.getGroupId() == 0) {
			log.info(LogEnum.TRUE.getLogValue());

			list = jt.query(SQL_SELECT_WHERE_GROUPID_AND_USERID_GROUPID_IS_NOT_NULL, new BeanPropertyRowMapper<Bookmarks>(Bookmarks.class),
					book.getGroupId(), book.getUserId());
		} else {
			log.info(LogEnum.FALSE.getLogValue());

			list = jt.query(SQL_SELECT_WHERE_GROUPID_IS_NULL_AND_USERID, new BeanPropertyRowMapper<Bookmarks>(Bookmarks.class),
					book.getUserId());
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@Override
	public int insert(Bookmarks book) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_INSERT_BOOKMARKNAME_BOOKMARKURL_GROUPID_USERID,
				book.getBookmarkName(), book.getBookmarkUrl(), book.getGroupId(), book.getUserId());
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int update(Bookmarks book) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_UPDATE_WHERE_BOOKMARKID, book.getBookmarkName(),
				book.getBookmarkUrl(), book.getBookmarkId());
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int delete(Integer bookmarkId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_DELETE_WHERE_BOOKMARKID, bookmarkId);
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}
}
