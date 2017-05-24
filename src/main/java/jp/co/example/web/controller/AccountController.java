package jp.co.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPageEnum;
import enums.LogEnum;
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
	public String CreateAccountCommitController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping("/updateAccount")
	public String UpdateAccountController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.UPDATE_ACCOUNT_JSP.getPageName();
	}

	@RequestMapping(value = "/updateAccountCommit", method = RequestMethod.POST)
	public String UpdateAccountCommitController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}
}
