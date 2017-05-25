<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<title>メイン画面</title>
</head>
<body>

	<p>アカウントID：${fn:escapeXml(sessionScope.user.accountId) }</p>

	<div>
		<p>ブックマーク追加項目</p>
		<form action="insertBookmark" method="post">
			<div>
				<label>表示名</label><input type="text" name="bookmarkName">
			</div>
			<div>
				<label>ブックマークURL</label><input type="text" name="bookmarkUrl">
			</div>
			<div>
				<label>ブックマークグループ名</label> <input type="text" name="groupName"
					list="combolist">
				<datalist id="combolist">
					<c:forEach var="listGroup" items="${listGroup}">
						<option value="${fn:escapeXml(listGroup.groupName) }"></option>
					</c:forEach>
				</datalist>
			</div>
			<input type="submit" value="ブックマーク追加">
		</form>
	</div>

	<c:set var="index" scope="page" value="${0}" />
	<c:forEach var="listGroup" items="${listGroup}">
		<table>
			<caption>${fn:escapeXml(listGroup.groupName) }</caption>
			<thead>
				<tr>
					<th>URL</th>
					<th>変更</th>
					<th>削除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listBookmarks"
					items="${listGroupInBookmarks[index]}">
					<tr>
						<td><a href="${ fn:escapeXml(listBookmarks.bookmarkUrl)}">${fn:escapeXml(listBookmarks.bookmarkName) }</a></td>
						<td><a
							href="updateBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">変更</a></td>
						<td><a
							href="deleteBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">削除</a></td>
					</tr>
				</c:forEach>
				<c:set var="index" scope="page" value="${index + 1 }" />
			</tbody>
		</table>
	</c:forEach>

	<table>
		<caption>グループなし</caption>
		<thead>
			<tr>
				<th>URL</th>
				<th>変更</th>
				<th>削除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="listBookmarks" items="${listGroupInBookmarks[index]}">
				<tr>
					<td><a href="${ fn:escapeXml(listBookmarks.bookmarkUrl)}">${fn:escapeXml(listBookmarks.bookmarkName) }</a></td>
					<td><a
						href="updateBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">変更</a></td>
					<td><a
						href="deleteBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">削除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>
