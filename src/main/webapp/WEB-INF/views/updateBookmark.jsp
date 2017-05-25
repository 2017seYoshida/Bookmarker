<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ブックマーク変更画面</title>
<link href="css/mycss.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty result}">
		<p class="error">${fn:escapeXml(result)}</p>
	</c:if>
	<form name="inputForm" action="updateBookmarkCommit" method="post" onSubmit="return requiredCheck()">
		<div>
			<input type="hidden" name="bookmarkId"
				value="${fn:escapeXml(bookmarks.bookmarkId) }"> <label>表示名</label>
			<input type="text" name="bookmarkName"
				value="${fn:escapeXml(bookmarks.bookmarkName) }">
		</div>
		<div>
			<label>ブックマークURL</label> <input type="text" name="bookmarkUrl"
				value="${fn:escapeXml(bookmarks.bookmarkUrl) }">
		</div>
		<div>
			<label>ブックマークグループ名</label> <input type="text" name="groupName"
				list="combolist" value="${fn:escapeXml(groupName) }">
			<datalist id="combolist">
				<c:forEach var="listGroup" items="${listGroup}">
					<option value="${fn:escapeXml(listGroup.groupName) }"></option>
				</c:forEach>
				<option value="グループなし"></option>
			</datalist>
		</div>

		<input type="submit" value="変更">
	</form>
	<div>
		<a href="mainBookmark">メイン画面に戻る</a>
	</div>

	<script src="/JavaScript/myJavaScript.js"></script>
</body>
</html>
