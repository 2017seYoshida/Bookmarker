package jp.co.example.web.dao;

import java.util.List;

import jp.co.example.web.entity.Bookmarks;

public interface BookmarksDao {
	List<Bookmarks> selectWhereGroupIDAndUserId(Integer groupId, Integer userId);
	int insert(Bookmarks book);
	int update(Bookmarks book);
	int delete(Integer bookmarkId);
}
