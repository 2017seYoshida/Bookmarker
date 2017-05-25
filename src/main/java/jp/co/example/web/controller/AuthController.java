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
	public String LoginPostController(@RequestParam String id,
										@RequestParam String pass,
											HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(LogEnum.IF.getLogValue() + "(\"\".equals(id) || \"\".equals(pass))");
		if("".equals(id) || "".equals(pass)) {
			log.info(LogEnum.TRUE.getLogValue());
			model.addAttribute(KeyIdEnum.RESULT.getKey(), "未入力項目があります");

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();
		} else  {
			log.info(LogEnum.FALSE.getLogValue());
		}

		UsersList ul = uls.login(id, pass);

		log.info(LogEnum.IF.getLogValue() + "(ul != null)");
		if (ul != null) {
			log.info(LogEnum.TRUE.getLogValue());

			//セッションにログインユーザ情報を保持
			session.setAttribute(KeyIdEnum.USER.getKey(), ul);

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return ControllerActionEnum.MAIN_BOOKMARK.getActionName();
		} else {
			log.info(LogEnum.FALSE.getLogValue());

			// idとパスワードがマッチングしなかった場合
			model.addAttribute(KeyIdEnum.RESULT.getKey(), "IDまたはPASSが間違っています");

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String LogoutController(HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		session.removeAttribute(KeyIdEnum.USER.getKey());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.LOGOUT_JSP.getPageName();
	}
}
