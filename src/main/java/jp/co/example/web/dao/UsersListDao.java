package jp.co.example.web.dao;

import jp.co.example.web.entity.UsersList;

public interface UsersListDao {
	UsersList login(String accountId, String userPassword);
	boolean isAccountEmpty(String accountId);
	int insert(UsersList ul);
	int update(UsersList ul);
}
