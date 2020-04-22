<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set scope="application" var="baseHref"><%= request.getContextPath() %></c:set>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- insert css files here -->
<link rel="stylesheet" href="${baseHref}/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="${baseHref}/assets/css/main.css">
<link rel="stylesheet" href="${baseHref}/assets/css/noscript.css">
<!-- insert js file here -->
<script type="text/javascript" src="${baseHref}/assets/js/breakpoints.min.js"></script>
<script type="text/javascript" src="${baseHref}/assets/js/browser.min.js"></script>
<script type="text/javascript" src="${baseHref}/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="${baseHref}/assets/js/main.js"></script>
<script type="text/javascript" src="${baseHref}/assets/js/util.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.1/jquery.twbsPagination.min.js">
</script>
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="header"/>
	<nav id="menu">
	<div class="inner">
		<h2>Menu</h2>
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="generic.html">Ipsum veroeros</a></li>
				<li><a href="generic.html">Tempus etiam</a></li>
				<li><a href="generic.html">Consequat dolor</a></li>
				<li><a href="elements.html">Elements</a></li>
			</ul>
	</div>
	<a class="close" href="#menu">Close</a>
	</nav>

<!--  		<tiles:insertAttribute name="menu"/>-->
		<tiles:insertAttribute name="body"/>
		<tiles:insertAttribute name="footer"/>
	</div>
	
</body>
</html>