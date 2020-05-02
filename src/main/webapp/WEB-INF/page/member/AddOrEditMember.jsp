<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="main">
	<div class="inner">
		<section>
			<c:if test="${memberForm.action eq 'add'}">
				<h1>註冊會員</h1>
			</c:if>
			<c:if test="${memberForm.action eq 'edit'}">
				<h1>更新會員</h1>
			</c:if>
			<div class="row">
				<div class="col-12-large">
					<form:form method="post" action="" modelAttribute="memberForm">
					<form:hidden path="action" value="${memberForm.action}"/>
					<form:hidden path="id" value="${memberForm.id }"/>
						<div class="row gtr-uniform">
							<div class="col-6 col-12-xsmall">
								<c:if test="${memberForm.action eq 'add'}"><form:input path="userid" id="demo-name" value="" placeholder="userid"/></c:if>
  								<c:if test="${memberForm.action eq 'edit'}"><form:input path="userid" id="demo-name" value="" placeholder="userid" readonly="true"/></c:if>
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
									<li><input type="submit" value="確定" class="primary" onclick="doSubmit();"></li>
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

<script>
function doSubmit(){
	var form = $('form#memberForm');
	$.ajax({
		type:'post',
		form:form.serialize(),
		url : '${baseHref}/member/SaveOrUpdate',
		success : function(data){
			var status = data.status;
			if(status=='ok'){
				console.log('message : '+data.message);
				window.location = '${baseHref}/member/login';
			}else{
				console.log('some exception : '+data.message);
			}
		},
		error:function(){
			console.log('goes error');
		}
	});
}
</script>