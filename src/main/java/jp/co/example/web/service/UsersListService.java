package jp.co.example.web.service;

import jp.co.example.web.entity.UsersList;

public interface UsersListService {

	public UsersList login(String accountId, String userPassword);
}
