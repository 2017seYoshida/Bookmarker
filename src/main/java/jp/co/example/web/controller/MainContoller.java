package jp.co.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPageEnum;
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class MainContoller {
	@RequestMapping("/mainBookmark")
	public String MainBookmarkController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}
}
