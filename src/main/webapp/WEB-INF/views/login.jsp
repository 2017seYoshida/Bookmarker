<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<c:if test="${not empty result}">
		<p class="error">${fn:escapeXml(result)}</p>
	</c:if>

	<form action="login" method="post">
		<fieldset>
			<div>
				<label>アカウントID</label><input type="text" name="id">
			</div>
			<div>
				<label>Password</label><input type="password" name="pass">
			</div>
		</fieldset>
		<input type="submit" value="ログイン">
	</form>
	<div>
		<a href="createAccount">アカウント作成</a>
	</div>
</body>
</html>
