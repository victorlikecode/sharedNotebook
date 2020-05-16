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
						<th>描述</th>
						<th>操作選項</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Item One</td>
						<td>Ante turpis integer aliquet porttitor.</td>
						<td>29.99</td>
					</tr>
					<tr>
						<td>Item Two</td>
						<td>Vis ac commodo adipiscing arcu aliquet.</td>
						<td>19.99</td>
					</tr>
					<tr>
						<td>Item Three</td>
						<td>Morbi faucibus arcu accumsan lorem.</td>
						<td>29.99</td>
					</tr>
					<tr>
						<td>Item Four</td>
						<td>Vitae integer tempus condimentum.</td>
						<td>19.99</td>
					</tr>
					<tr>
						<td>Item Five</td>
						<td>Ante turpis integer aliquet porttitor.</td>
						<td>29.99</td>
					</tr>
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
