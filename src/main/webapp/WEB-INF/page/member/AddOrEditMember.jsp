<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="main">
	<div class="inner">
		<section>
			<h1>Login Page</h1>
			<div class="row">
				<div class="col-12-large">
					<form:form method="post" action="" modelAttribute="memberForm">
					<form:hidden path="action"/>
						<div class="row gtr-uniform">
							<div class="col-6 col-12-xsmall">
								<form:input path="username" id="demo-name" value="" placeholder="Name"/>
							</div>
							<div class="col-6 col-12-xsmall">
								<form:input path="email" id="demo-name" value="" placeholder="Email"/>
							</div>

							<div class="col-6 col-12-xsmall">
								<form:password path="password" id="demo-name" value="" placeholder="new password"/>
							</div>


							<div class="col-6 col-12-xsmall">
								<form:password path="passwordConfirm" id="demo-name" value="" placeholder="password confirm"/>
							</div>
							<div class="col-12">
								<ul class="actions">
									<li><input type="submit" value="確定" class="primary"></li>
									<li><input type="reset" value="取消"></li>
								</ul>
							</div>
						</div>
					</form:form>
				</div>
			</div>

		</section>
	</div>
</div>