package jp.co.example.web.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersList {
	private Integer userId;
	private String accountId;
	private String userPassword;
}
