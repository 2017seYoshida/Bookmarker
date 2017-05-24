package jp.co.example.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.web.dao.UsersListDao;
import jp.co.example.web.service.UsersListService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersListServiceImpl implements UsersListService {

	@Autowired
	UsersListDao uld;
}
