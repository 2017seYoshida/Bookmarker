package enums;

import lombok.Getter;

@Getter
public enum LogEnum {
	START(" ------>  START"),
	END(" ------>  END"),
	RETURN("RETURN ------>"),
	IF_PARAM("If Conditions ------>"),
	METHOD_PARAM("Method Parameter ------->"),
	IF("IF ------>"),
	TRUE("TRUE"),
	FALSE("FALSE"),
	;
	private final String logValue;

	LogEnum(String logValue) {
		this.logValue = logValue;
	}
}
