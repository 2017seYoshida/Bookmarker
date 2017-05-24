package jp.co.example.web.service;

import jp.co.example.web.entity.BookmarksGroup;

public interface BookmarksGroupService {
	BookmarksGroup selectWhereGroupNameAndUserId(String groupName, Integer userId);
	int insert(String groupName, Integer userId);
	int delete(String groupName, Integer userId);
}
