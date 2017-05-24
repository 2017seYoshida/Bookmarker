package enums;

/**
 * Servletで遷移するページを一括管理
 * @author Yuihiro Yoshida
 *
 */
public enum JspPageEnum {
	LOGIN_JSP("login"),
	LOGOUT_JSP("logout"),
	MAIN_BOOKMARK_JSP("mainBookmark"),
	UPDATE_BOOKMARK_JSP("updateBookmark"),
	CREATE_ACCOUNT_JSP("createAccount"),
	UPDATE_ACCOUNT_JSP("updateAccount"),
	;

	private final String pageName;

	JspPageEnum(String pageName) {
		this.pageName = pageName;
	}

	public String getPageName() {
		return pageName;
	}
}
