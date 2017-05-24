<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブックマーク変更画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<form action="updateBookmarkCommit" method="post">
		<fieldset>
			<div>
				<label class="required">ID</label><input type="text" name="id">
			</div>
		</fieldset>
		<input type="submit" value="アカウント登録">
	</form>
	<div>
		<a href="mainBookmark">メイン画面に戻る</a>
	</div>
</body>
</html>
