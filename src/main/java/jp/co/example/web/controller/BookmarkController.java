package jp.co.example.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.web.entity.*;
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

	@RequestMapping(value = "/insertBookmark", method = RequestMethod.POST)
	public String InsertBookmarkController(@RequestParam String bookmarkName,
			@RequestParam String bookmarkUrl,
			@RequestParam String groupName,
			HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// ログインユーザ情報を保持
		UsersList loginUser = (UsersList) session.getAttribute(KeyIdEnum.USER.getKey());

		log.info(LogEnum.IF.getLogValue() + "(loginUser == null)");
		if (loginUser == null) {
			// ログインユーザ情報がない場合、ログイン画面に戻る
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		//jspで入力されたグループ名があるかSELECTをかける
		BookmarksGroup bg = bgs.selectWhereGroupNameAndUserId(groupName, loginUser.getUserId());

		log.info(LogEnum.IF.getLogValue() + "(bg == null)");
		if(bg == null) {
			//グループがなければグループを追加する
			log.info(LogEnum.TRUE.getLogValue());

			bgs.insert(groupName, loginUser.getUserId());
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}
		bs.insert(new Bookmarks(bookmarkName, bookmarkUrl, bg.getGroupId(), loginUser.getUserId()));

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ControllerActionEnum.MAIN_BOOKMARK.getActionName();
	}

	@RequestMapping("/updateBookmark")
	public String UpdateBookmarkController(@RequestParam String bookmarkId, HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(LogEnum.METHOD_PARAM.getLogValue() + bookmarkId);

		// ログインユーザ情報を保持
		UsersList loginUser = (UsersList) session.getAttribute(KeyIdEnum.USER.getKey());

		log.info(LogEnum.IF.getLogValue() + "(loginUser == null)");
		if (loginUser == null) {
			// ログインユーザ情報がない場合、ログイン画面に戻る
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.UPDATE_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping(value = "/updateBookmarkCommit", method = RequestMethod.POST)
	public String UpdateBookmarkCommitController(HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// ログインユーザ情報を保持
		UsersList loginUser = (UsersList) session.getAttribute(KeyIdEnum.USER.getKey());

		log.info(LogEnum.IF.getLogValue() + "(loginUser == null)");
		if (loginUser == null) {
			// ログインユーザ情報がない場合、ログイン画面に戻る
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ControllerActionEnum.MAIN_BOOKMARK.getActionName();
	}

	@RequestMapping("/deleteBookmark")
	public String DeleteBookmarkController(@RequestParam String bookmarkId, HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(LogEnum.METHOD_PARAM.getLogValue() + bookmarkId);

		// ログインユーザ情報を保持
		UsersList loginUser = (UsersList) session.getAttribute(KeyIdEnum.USER.getKey());

		log.info(LogEnum.IF.getLogValue() + "(loginUser == null)");
		if (loginUser == null) {
			// ログインユーザ情報がない場合、ログイン画面に戻る
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ControllerActionEnum.MAIN_BOOKMARK.getActionName();
	}
}
