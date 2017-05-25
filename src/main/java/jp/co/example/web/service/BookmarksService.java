package jp.co.example.web.service;

import java.util.List;

import jp.co.example.web.entity.Bookmarks;

public interface BookmarksService {
	List<Bookmarks> selectWhereGroupIDAndUserId(Integer groupId, Integer userId);

	int insert(Bookmarks book);

	int update(Bookmarks book);

	int delete(Integer bookmarkId);
}
