package jp.co.example.web.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bookmarks {
	private Integer bookmarkId;
	private String bookmarkName;
	private String bookmarkUrl;
	private Integer groupId;
	private Integer userId;
}
