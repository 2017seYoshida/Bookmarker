package jp.co.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.*;
import jp.co.example.web.entity.*;
import jp.co.example.web.service.BookmarksGroupService;
import jp.co.example.web.service.BookmarksService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class MainContoller {
	@Autowired
	BookmarksService bs;

	@Autowired
	BookmarksGroupService bgs;

	@RequestMapping("/mainBookmark")
	public String MainBookmarkController(HttpSession session, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//ログインユーザ情報を保持
		UsersList loginUser = (UsersList) session.getAttribute(KeyIdEnum.USER.getKey());

		log.info(LogEnum.IF.getLogValue() + "(loginUser == null)");
		if(loginUser == null) {
			//ログインユーザ情報がない場合、ログイン画面に戻る
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPageEnum.LOGIN_JSP.getPageName();

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		List<BookmarksGroup> listGroup = bgs.selectGroupNameWhereUserId(loginUser.getUserId());

		List<List<Bookmarks>> listGroupInBookmarks = new ArrayList<List<Bookmarks>>();
		List<Bookmarks> listBookmarks;
		log.info(LogEnum.FOR.getLogValue() + "(BookmarksGroup bg : listGroup)" + LogEnum.START.getLogValue());
		for (BookmarksGroup bg : listGroup) {
			//グループありのブックマークを取得する
			listBookmarks = bs.selectWhereGroupIDAndUserId(bg.getGroupId(), loginUser.getUserId());
			listGroupInBookmarks.add(listBookmarks);
			log.info(LogEnum.METHOD_PARAM + listBookmarks.toString());
		}
		log.info(LogEnum.FOR.getLogValue() + "(BookmarksGroup bg : listGroup)" + LogEnum.END.getLogValue());

		//グループなしのブックマークを取得する
		listGroupInBookmarks.add(bs.selectWhereGroupIDAndUserId(null, loginUser.getUserId()));

		model.addAttribute(KeyIdEnum.LIST_GROUP.getKey(), listGroup);
		model.addAttribute(KeyIdEnum.LIST_GROUP_IN_BOOKMARKS.getKey(), listGroupInBookmarks);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.MAIN_BOOKMARK_JSP.getPageName();
	}
}
