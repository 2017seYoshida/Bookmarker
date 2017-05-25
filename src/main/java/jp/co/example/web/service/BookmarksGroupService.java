package jp.co.example.web.service;

import java.util.List;

import jp.co.example.web.entity.BookmarksGroup;

public interface BookmarksGroupService {
	List<BookmarksGroup> selectGroupNameWhereUserId(Integer userId);

	BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId);

	BookmarksGroup selectWhereGroupId(Integer groupId);

	int insert(String groupName, Integer userId);

	int delete(Integer groupId);

	BookmarksGroup findWhereMostNewRecord();
}
