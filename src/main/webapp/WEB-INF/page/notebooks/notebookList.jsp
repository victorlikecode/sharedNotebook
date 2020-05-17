<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- Main -->
<div id="main">
	<div class="inner">
		<header>
			<h1>管理筆記本</h1>
			<p>在這裏你可以新增或設定是否公開筆記本</p>
		</header>
		<ul class="actions">
			<li><a href="#" class="button">新增筆記本</a></li>
			<li><a href="#" class="button">複製筆記本</a></li>
		</ul>
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>筆記本名稱</th>
						<th>觀看人數</th>
						<th>是否公開</th>
						<th>操作選項</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${notebook}" >
						<tr>
						<td>${book.title}</td>
						<td>${book.view}</td>
						<td>${book.isPrivate ? '是' : '否'}</td>
						<td>測試</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"></td>
						<td>100.00</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</div>
