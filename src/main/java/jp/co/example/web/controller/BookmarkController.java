package jp.co.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPageEnum;
import enums.LogEnum;
import jp.co.example.web.service.BookmarksGroupService;
import jp.co.example.web.service.BookmarksService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class BookmarkController {

	@Autowired
	BookmarksService bs;

	@Autowired
	BookmarksGroupService bgs;

	@RequestMapping("/insertBookmark")
	public String InsertBookmarkController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping("/updateBookmark")
	public String UpdateBookmarkController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.UPDATE_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping(value="/updateBookmarkCommit", method = RequestMethod.POST)
	public String UpdateBookmarkCommitController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping("/deleteBookmark")
	public String DeleteBookmarkController(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}
}
