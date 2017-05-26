<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<title>メイン画面</title>
</head>
<body>
	<c:if test="${not empty result}">
		<script type="text/javascript">
			alert('${fn:escapeXml(result)}');
		</script>
	</c:if>

	<p>アカウントID：${fn:escapeXml(sessionScope.user.accountId) }</p>
	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>



	<div class="container">
		<div class="row">
			<div class="col-xs-3 col-sm-3 col-md-3"></div>
			<!-- col-3 -->

			<!-- メインコンテンツ -->
			<div class="col-xs-6 col-sm-6 col-md-6">

				<div>
					<h3>ブックマーク追加</h3>

					<div class="list-group" id="accordion3">

						<a data-toggle="collapse" data-parent="#accordion3"
							href="#collapse3" class="list-group-item"> 追加項目表示 </a>
						<div id="collapse3" class="collapse">
							<form name="inputForm" action="insertBookmark" method="post"
								onSubmit="return requiredCheck()">
								<p class="list-group-item">
									<label>表示名</label><input type="text" name="bookmarkName">
								</p>
								<p class="list-group-item">
									<label>ブックマークURL</label><input type="text" name="bookmarkUrl">
								</p>
								<p class="list-group-item">
									<label>ブックマークグループ名</label> <input type="text" name="groupName"
										list="combolist">
									<datalist id="combolist">
										<c:forEach var="listGroup" items="${listGroup}">
											<option value="${fn:escapeXml(listGroup.groupName) }"></option>
										</c:forEach>
										<option value="グループなし"></option>
									</datalist>
								</p>
								<input type="submit" value="ブックマーク追加">
							</form>
						</div>
					</div>

					<h3>ブックマーク一覧</h3>
					<c:set var="index" scope="page" value="${0}" />

					<div class="list-group" id="accordion3">
						<c:forEach var="listGroup" items="${listGroup}">
							<a data-toggle="collapse" data-parent="#accordion3"
								href="#collapse${index + 10 }" class="list-group-item">
								${fn:escapeXml(listGroup.groupName) } </a>
							<div id="collapse${index + 10 }" class="collapse">
								<c:forEach var="listBookmarks"
									items="${listGroupInBookmarks[index]}">
									<p class="list-group-item">
										<a href="${ fn:escapeXml(listBookmarks.bookmarkUrl)}">${fn:escapeXml(listBookmarks.bookmarkName) }</a>
										<a
											href="updateBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">変更</a>
										<a
											href="deleteBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">削除</a>
									</p>
								</c:forEach>
								<c:set var="index" scope="page" value="${index + 1 }" />
							</div>
						</c:forEach>
						<a data-toggle="collapse" data-parent="#accordion3"
							href="#collapse${index + 10 }" class="list-group-item">グループなし
						</a>
						<div id="collapse${index + 10 }" class="collapse">
							<c:forEach var="listBookmarks"
								items="${listGroupInBookmarks[index]}">
								<p class="list-group-item">
									<a href="${ fn:escapeXml(listBookmarks.bookmarkUrl)}">${fn:escapeXml(listBookmarks.bookmarkName) }</a>
									<a
										href="updateBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">変更</a>
									<a
										href="deleteBookmark?bookmarkId=${fn:escapeXml(listBookmarks.bookmarkId) }">削除</a>
								</p>
							</c:forEach>
						</div>
					</div>

				</div>
				<!-- col-6 -->
				<div class="col-xs-3 col-sm-3 col-md-3"></div>
				<!-- col-3 -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->

		<script src="/JavaScript/myJavaScript.js"></script>
		<!-- Latest compiled and minified JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
