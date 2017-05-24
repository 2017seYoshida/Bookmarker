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
	private static final String SQL_SELECT_WHERE_ACCOUNTID_AND_USERPASSWORD = "SELECT * FROM users_list WHERE account_id = ? AND user_password = ?";
	private static final String SQL_SELECT_WHERE_ACCOUNTID = "SELECT * FROM users_list WHERE account_id = ?";
	private static final String SQL_INSERT_ACCOUNTID_AND_USERPASSWORD = "INSERT INTO users_list (account_id, user_password) VALUES (?, ?)";
	private static final String SQL_UPDATE_ACCOUNTID_AND_USERPASSWORD_WHERE_USERID = "UPDATE users_list SET account_id = ?, user_password = ? WHERE user_id = ?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public UsersList login(String accountId, String userPassword) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<UsersList> list = jt.query(SQL_SELECT_WHERE_ACCOUNTID_AND_USERPASSWORD,
				new BeanPropertyRowMapper<UsersList>(UsersList.class), accountId, userPassword);

		UsersList ul = list.isEmpty() ? null : list.get(0);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ul;
	}

	@Override
	public boolean isAccountEmpty(String accountId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<UsersList> list = jt.query(SQL_SELECT_WHERE_ACCOUNTID,
				new BeanPropertyRowMapper<UsersList>(UsersList.class), accountId);

		boolean isEmpty = list.isEmpty() ? true : false;

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return isEmpty;
	}

	@Override
	public int insert(UsersList ul) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_INSERT_ACCOUNTID_AND_USERPASSWORD, ul.getAccountId(), ul.getUserPassword());
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int update(UsersList ul) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_UPDATE_ACCOUNTID_AND_USERPASSWORD_WHERE_USERID, ul.getAccountId(),
				ul.getUserPassword(), ul.getUserId());
		log.debug(LogEnum.UPDATE_COUNT.getLogValue() + updateCount);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}
}
