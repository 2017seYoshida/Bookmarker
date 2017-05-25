package jp.co.example.web.dao;

import java.util.List;

import jp.co.example.web.entity.BookmarksGroup;

public interface BookmarksGroupDao {
	List<BookmarksGroup> selectWhereUserId(Integer userId);

	BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId);

	BookmarksGroup selectWhereGroupId(Integer groupId);

	int insert(String groupName, Integer userId);

	int delete(Integer groupId);

	BookmarksGroup findWhereMostNewRecord();
}
