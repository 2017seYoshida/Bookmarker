package jp.co.example.web.dao;

import jp.co.example.web.entity.UsersList;

public interface UsersListDao {
	UsersList login(String accountId, String userPassword);
}
