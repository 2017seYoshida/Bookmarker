<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty result}">
		<p class="error">${fn:escapeXml(result)}</p>
	</c:if>

	<p>アカウント作成情報を入力してください<br></p>
	<form action="createAccountCommit" method="post">
		<div>
			<label>アカウントID</label><input type="text" name="id">
		</div>
		<div>
			<label>Password</label><input type="password" name="pass">
		</div>
		<div>
			<label>Password(再確認)</label><input type="password" name="rePass">
		</div>

		<input type="submit" value="アカウント作成">
	</form>
	<div>
		<a href="login">ログイン画面に戻る</a>
	</div>
</body>
</html>
