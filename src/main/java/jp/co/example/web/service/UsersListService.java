package jp.co.example.web.service;

import jp.co.example.web.entity.UsersList;

public interface UsersListService {

	UsersList login(String accountId, String userPassword);
	boolean isAccountEmpty(String accountId);
	int insert(UsersList ul);
	int update(UsersList ul);
}
