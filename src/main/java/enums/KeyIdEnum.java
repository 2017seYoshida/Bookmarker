package enums;

/**
 * セッション、リクエストスコープで使用するキーを一括管理
 * @author Yukihiro Yoshida
 *
 */
public enum KeyIdEnum {
	ID("id"),
	PASS("pass"),
	RESULT("result"),
	NAME("name"),
	TEL("tel"),
	LIST("list"),
	USER_INFO("userInfo"),
	ADMIN("admin"),
	REPASS("rePass"),
	UPDATE_BEFORE("updateBefore"),
	UPDATE_AFTER("updateAfter"),
	NEW_NAME("newName"),
	NEW_TEL("newTel"),
	NEW_PASS("newPass"),
	LOGIN("login"),
	;

	private final String key;

	KeyIdEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
