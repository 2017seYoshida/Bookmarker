package enums;

import lombok.Getter;

@Getter
public enum LogEnum {
	START(" ------>  開始"),
	END(" ------>  終了"),
	;
	private final String logValue;

	LogEnum(String logValue) {
		this.logValue = logValue;
	}
}
