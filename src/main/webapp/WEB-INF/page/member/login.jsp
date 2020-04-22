<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div id="main">
	<div class="inner">
		<section>
			<h2>會員登入</h2>
			<div class="row">
				<div class="col-12-large">
					<form:form method="post" action="" modelAttribute="memberForm">
						<div class="row gtr-uniform">
							<div class="col-6 col-12">
								<form:input path="username" id="demo-name" value="" placeholder="Username"/>
							</div>
						<div class="col-6 col-12">
							<form:input path="password" id="demo-name" value="" placeholder="Password"/>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="Login" class="primary" onclick="doLogin();"></li>
								<li><input type="reset" value="Forget Password"></li>
							</ul>
						</div>
						</div>
					</form:form>
				</div>
			</div>
		</section>
	</div>
</div>

<script>
function doLogin(){
	var form = $("form");
	$.ajax({
		data:form.serialize(),
		url:"${baseHref}/member/dologin",
		type:'post',
		async:false,
		success:function(data){
			console.log(data);
		},
		error: function () {
            console.log('goes error') ;
        }
	});
	
}

</script>