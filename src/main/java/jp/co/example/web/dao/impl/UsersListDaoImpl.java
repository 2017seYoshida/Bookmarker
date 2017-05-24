package jp.co.example.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.web.dao.UsersListDao;
import jp.co.example.web.entity.UsersList;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class UsersListDaoImpl implements UsersListDao {

	/**
	 * SQL文を一括管理
	 */
	private static final String SQL_SELECT_WHERE_ADMINID_AND_PASSWORD =
					"SELECT * FROM users_list WHERE account_id = ? AND user_password = ?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public UsersList login(String accountId, String userPassword) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<UsersList> list = jt.query(SQL_SELECT_WHERE_ADMINID_AND_PASSWORD,
				new BeanPropertyRowMapper<UsersList>(UsersList.class), accountId, userPassword);

		UsersList ul = list.isEmpty() ? null : list.get(0);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ul;
	}
}
