package jp.co.example.web.controller;

import java.util.List;

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

	private static final String NOT_BOOKMARK_GROUP = "グループなし";

	@Autowired
	BookmarksService bs;

	@Autowired
	BookmarksGroupService bgs;

	@RequestMapping(value = "/insertBookmark", method = RequestMethod.POST)
	public String InsertBookmarkController(@RequestParam String bookmarkName, @RequestParam String bookmarkUrl,
			@RequestParam String groupName, HttpSession session, Model model) {
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

		log.info(LogEnum.IF + "(groupName.length() == 0 || NOT_BOOKMARK_GROUP.equals(groupName))");
		if (groupName.length() == 0 || NOT_BOOKMARK_GROUP.equals(groupName)) {
			// グループを指定しなかった場合
			log.info(LogEnum.TRUE.getLogValue());

			bs.insert(new Bookmarks(bookmarkName, bookmarkUrl, null, loginUser.getUserId()));

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		// 動的にグループを追加
		BookmarksGroup bg = hotBookmarksGroupInsert(bgs, groupName, Integer.valueOf(loginUser.getUserId()));

		// Insert処理
		bs.insert(new Bookmarks(bookmarkName, bookmarkUrl, bg.getGroupId(), loginUser.getUserId()));

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ControllerActionEnum.MAIN_BOOKMARK.getActionName();
	}

	@RequestMapping("/updateBookmark")
	public String UpdateBookmarkController(@RequestParam String bookmarkId, HttpSession session, Model model) {
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

		Bookmarks book = bs.selectWhereBookmarkId(Integer.valueOf(bookmarkId));
		model.addAttribute(KeyIdEnum.BOOKMARKS.getKey(), book);

		log.info(LogEnum.IF.getLogValue() + "(book.getGroupId() != null)");
		if (book.getGroupId() != null) {
			// 変更するブックマークがグループに所属していた場合
			log.info(LogEnum.TRUE.getLogValue());

			BookmarksGroup bg = bgs.selectWhereGroupId(book.getGroupId());
			model.addAttribute(KeyIdEnum.GROUP_NAME.getKey(), bg.getGroupName());

		} else {
			log.info(LogEnum.FALSE.getLogValue());

			model.addAttribute(KeyIdEnum.GROUP_NAME.getKey(), NOT_BOOKMARK_GROUP);
		}

		List<BookmarksGroup> listGroup = bgs.selectGroupNameWhereUserId(loginUser.getUserId());
		model.addAttribute(KeyIdEnum.LIST_GROUP.getKey(), listGroup);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPageEnum.UPDATE_BOOKMARK_JSP.getPageName();
	}

	@RequestMapping(value = "/updateBookmarkCommit", method = RequestMethod.POST)
	public String UpdateBookmarkCommitController(@RequestParam String bookmarkId, @RequestParam String bookmarkName,
			@RequestParam String bookmarkUrl, @RequestParam String groupName, HttpSession session, Model model) {
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

		Bookmarks afterBook;
		//変更前のブックマークを取得
		Bookmarks beforeBook = bs.selectWhereBookmarkId(Integer.valueOf(bookmarkId));

		log.info(LogEnum.IF + "(groupName.length() == 0 || NOT_BOOKMARK_GROUP.equals(groupName))");
		if (groupName.length() == 0 || NOT_BOOKMARK_GROUP.equals(groupName)) {
			// グループを指定しなかった場合
			log.info(LogEnum.TRUE.getLogValue());

			afterBook = new Bookmarks(Integer.valueOf(bookmarkId), bookmarkName, bookmarkUrl, null,
					Integer.valueOf(loginUser.getUserId()));

		} else {
			// 変更するブックマークがグループに所属していた場合
			log.info(LogEnum.FALSE.getLogValue());

			//グループを動的に追加
			BookmarksGroup bg = hotBookmarksGroupInsert(bgs, groupName, Integer.valueOf(loginUser.getUserId()));

			afterBook = new Bookmarks(Integer.valueOf(bookmarkId), bookmarkName, bookmarkUrl, bg.getGroupId(),
					Integer.valueOf(loginUser.getUserId()));
		}
		//ブックマーク更新
		bs.update(afterBook);

		//グループを動的に削除
		hotBookmarksGroupDelete(bs, bgs, beforeBook.getGroupId(), loginUser.getUserId());

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

		// 削除するブックマークを取得
		Bookmarks book = bs.selectWhereBookmarkId(Integer.valueOf(bookmarkId));
		// 指定のブックマークを削除
		bs.delete(Integer.valueOf(bookmarkId));

		log.info(LogEnum.IF + "(book.getGroupId() != null)");
		if (book.getGroupId() != null) {
			// 削除したブックマークがグループに所属していた場合
			log.info(LogEnum.TRUE.getLogValue());

			//グループを動的に削除
			hotBookmarksGroupDelete(bs, bgs, book.getGroupId(), loginUser.getUserId());

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return ControllerActionEnum.MAIN_BOOKMARK.getActionName();
	}

	/**
	 * グループをSELECTし、見つからなければグループを追加する
	 * @param bgs
	 * @param groupName
	 * @param userId
	 * @return
	 */
	private static BookmarksGroup hotBookmarksGroupInsert (BookmarksGroupService bgs, String groupName, Integer userId) {
		BookmarksGroup bg = bgs.selectWhereGroupNameAndUserId(groupName, userId);

		log.info(LogEnum.IF.getLogValue() + "(bg == null)");
		if (bg == null) {
			// グループがなければグループを追加する
			log.info(LogEnum.TRUE.getLogValue());

			bgs.insert(groupName, userId);
			return bgs.findWhereMostNewRecord();
		} else {
			log.info(LogEnum.FALSE.getLogValue());
			return bg;
		}
	}

	private static void hotBookmarksGroupDelete(BookmarksService bs,BookmarksGroupService bgs, Integer groupId, Integer userId) {
		List<Bookmarks> list = bs.selectWhereGroupIDAndUserId(groupId, userId);
		log.info(LogEnum.IF.getLogValue() + "list.isEmpty()");
		if (list.isEmpty()) {
			// 削除したブックマークと同じグループに所属しているブックマークがなければグループを削除
			log.info(LogEnum.TRUE.getLogValue());

			bgs.delete(Integer.valueOf(groupId));

		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}
	}
}
