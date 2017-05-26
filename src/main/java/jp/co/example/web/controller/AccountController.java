package jp.co.example.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.web.entity.UsersList;
import jp.co.example.web.service.UsersListService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class AccountController {

	@Autowired
	UsersListService uls;

	@RequestMapping("/createAccount")
	public String CreateAccountController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.CREATE_ACCOUNT_JSP.getPageName();
	}

	@RequestMapping(value = "/createAccountCommit", method = RequestMethod.POST)
	public String CreateAccountCommitController(@RequestParam String id,
													@RequestParam String pass,
													@RequestParam String rePass,
													HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(LogEnum.IF.getLogValue() + "(id.length() == 0 || pass.length() == 0 || rePass.length() == 0)");
		if(id.length() == 0 || pass.length() == 0 || rePass.length() == 0) {
			log.info(LogEnum.TRUE.getLogValue());

			model.addAttribute(KeyIdEnum.RESULT.getKey(), "未入力項目があります");

		} else if (!pass.equals(rePass)){
			log.info(LogEnum.FALSE.getLogValue());
			log.info(LogEnum.IF.getLogValue() + "pass.equals(rePass)\n" + LogEnum.TRUE.getLogValue());

			model.addAttribute(KeyIdEnum.RESULT.getKey(), "パスワードの入力値が一致しません");

		} else if(!uls.isAccountEmpty(id)) {
			log.info(LogEnum.FALSE.getLogValue());
			log.info(LogEnum.IF.getLogValue() + "(!pass.equals(rePass))\n" + LogEnum.FALSE.getLogValue());
			log.info(LogEnum.IF.getLogValue() + "(!uls.isAccountEmpty(id))\n" + LogEnum.TRUE.getLogValue());

			model.addAttribute(KeyIdEnum.RESULT.getKey(), "すでに登録されているアカウントIDです");

		} else {
			log.info(LogEnum.FALSE.getLogValue());
			log.info(LogEnum.IF.getLogValue() + "(!pass.equals(rePass))\n" + LogEnum.FALSE.getLogValue());
			log.info(LogEnum.IF.getLogValue() + "(!uls.isAccountEmpty(id))\n" + LogEnum.TRUE.getLogValue());

			uls.insert(new UsersList(id, pass));
			UsersList ul = uls.login(id, pass);
			//セッションにログインユーザ情報を保持
			session.setAttribute(KeyIdEnum.USER.getKey(), ul);

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.CREATE_ACCOUNT_JSP.getPageName();
	}

//	@RequestMapping("/updateAccount")
//	public String UpdateAccountController(Model model) {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//
//
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//		return JspPageEnum.UPDATE_ACCOUNT_JSP.getPageName();
//	}
//
//	@RequestMapping(value = "/updateAccountCommit", method = RequestMethod.POST)
//	public String UpdateAccountCommitController(Model model) {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//
//
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
//	}
}
