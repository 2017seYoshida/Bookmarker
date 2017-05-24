package jp.co.example.web.dao;

import jp.co.example.web.entity.BookmarksGroup;

public interface BookmarksGroupDao {
	BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId);
	int insert(String groupName, Integer userId);
	int delete(String groupName, Integer userId);
}
