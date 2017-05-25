package enums;

/**
 * セッション、リクエストスコープで使用するキーを一括管理
 * @author Yukihiro Yoshida
 *
 */
public enum KeyIdEnum {
	RESULT("result"),
	USER("user"),
	LIST_GROUP_IN_BOOKMARKS("listGroupInBookmarks"),
	LIST_GROUP("listGroup"),
	BOOKMARK_ID("bookmarkId"),
	BOOKMARKS("bookmarks"),
	GROUP_NAME("groupName"),
	;

	private final String key;

	KeyIdEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
