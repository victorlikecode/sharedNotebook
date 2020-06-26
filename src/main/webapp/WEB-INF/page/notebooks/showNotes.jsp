<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>

    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-center align-items-center">
            <span class="navbar-brand h1">
                <p>notebook name</p>
            </span>
            </nav>
        </div>
        <div class="container-fluid">

            <div class="row justify-content-center align-items-center">
                <div class="col-sm-12 col-md-2 col-2 bg-info text-center list-note"><span>1</span></div>
                <div class="col-sm-12 col-md-2 col-2 bg-warning text-center list-note"><span>2</span></div>
                <div class="col-sm-12 col-md-2 col-2 bg-info text-center list-note"><span>3</span></div>
                <div class="col-sm-12 col-md-2 col-2 bg-warning text-center list-note">
                    <span>
                        4
                    </span>
                </div>
                <div class="col-sm-12 col-md-2 col-2 bg-info text-center list-note">
                    <span>
                        5
                    </span>
                </div>
                <div class="col-sm-12 col-md-2 col-2 bg-warning text-center list-note">
                    <a href="#">
                    <span>
                        <img src="icon-add.png" height="100px" width="80px"/>
                        <p>add note!</p>
                    </span>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>