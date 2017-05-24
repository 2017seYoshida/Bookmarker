package jp.co.example.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.web.dao.UsersListDao;
import jp.co.example.web.entity.UsersList;
import jp.co.example.web.service.UsersListService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class UsersListServiceImpl implements UsersListService {

	@Autowired
	UsersListDao uld;

	@Override
	public UsersList login(String accountId, String userPassword) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		UsersList ul = uld.login(accountId, userPassword);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ul;
	}
}
