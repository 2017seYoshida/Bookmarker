package jp.co.example.web.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarksGroup {
	private Integer groupId;
	private String groupName;
	private Integer userId;
}
