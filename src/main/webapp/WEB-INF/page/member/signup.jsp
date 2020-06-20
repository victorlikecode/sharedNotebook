<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>

    <body class="bg-secondary"> 
      <div class="container text-center">
        <img src="user.png" height="100" width="100"/>
      </div>
        <!-- html form -->
     <div class="container col-md-4">
      <div class="col-md-12">
      <div class="card">
        <div class="card-header">
          Sign Up
        </div>
        <div class="card-body">
          <form:form method="post" action="" modelAttribute="memberForm" id="memberForm">
          	<form:hidden path="action" value="${memberForm.action}"/>
			<form:hidden path="id" value="${memberForm.id }"/>
            <div class="form-group">
              <label for="userid">Userid</label>
              <form:input path="userid" class="form-control" value="" placeholder="userid"/>
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <form:input path="email" class="form-control" value="" placeholder="email"/>
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
			  <form:password path="password" id="demo-name" value="" placeholder="new password"/>
            </div>
             <div class="form-group">
              <label for="passwordConfirm">Password confirm</label>
			  <form:password path="passwordConfirm" id="demo-name" value="" placeholder="password confirm"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-info">Submit</button>
            </form:form>
        </div>
        </div>
      </div>
      </div>
    </body>

</html>


<script>
function doSubmit(){
	var form = $('form[id=memberForm]');
	$.ajax({
		type:'post',
		data:form.serialize(),
		url : '<c:url:"/member/SaveOrUpdate"/>',
		async:false,
		success : function(data){
			var status = data.status;
			if(status=='ok'){
				console.log('message : '+data.message);
				window.location = '<c:url:"/member/login"/>';
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