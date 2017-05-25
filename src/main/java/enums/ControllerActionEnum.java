package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ControllerActionEnum {
	MAIN_BOOKMARK("forward:mainBookmark"),
	;
	
	String ActionName;
}
