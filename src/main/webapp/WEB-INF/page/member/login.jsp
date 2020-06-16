<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
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
          <div class="card-header">login</div>
          <div class="card-body">
            <form:form method="post" action="" modelAttribute="memberForm">
              <div class="form-group">
                <form:label path="userid"></form:label>
                <form:input path="userid" class="form-control" value="" placeholder="Userid"/>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                <form:label path="password"></form:label>
                <form:password path="password" id="demo-name" value="" placeholder="Password"/>
              </div>
              <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Check me out</label>
              </div>
              <button type="submit" class="btn btn-primary" onclick="doLogin();">Submit</button>
              <button type="reset" class="btn">Forget Password</button>
              </form:form>          
          </div>
        </div>
       </div>
    </div>
    </body>

</html>
<script>
function doLogin(){
	var form = $("form");
	$.ajax({
		data:form.serialize(),
		url:"${baseHref}/member/dologin",
		type:'post',
//		async:false,
		success:function(data){
			console.log(data);
			if(data.status=='ok'){
				window.location.href="${baseHref}/member/center";				
			}
		},
		error: function () {
            console.log('goes error') ;
        }
	});
	
}

</script>