package jp.co.example.web.controller;

import javax.servlet.http.HttpSession;

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
public class AuthController {

	@Autowired
	UsersListService uls;

	@RequestMapping("/login")
	public String LoginController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.LOGIN_JSP.getPageName();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPostController(HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String LogoutController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.LOGOUT_JSP.getPageName();
	}
}
