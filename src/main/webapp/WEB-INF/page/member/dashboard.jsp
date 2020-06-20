<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </head>

    <body>
            <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand h1" href="#">Start Sharenotes ! </a>

                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Create Account</a>
                        </li>
                    </ul>
                </div>
 
                <ul class="navbar-nav ">
                    <li class="nav-item">
                      <a class="nav-link" href="#">
                        <i class="fa fa-bell">
                          <span class="badge badge-info">11</span>
                        </i>
                      </a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">
                        <i class="fa fa-globe">
                          <span class="badge badge-success">11</span>
                        </i>
                      </a>
                    </li>
                  </ul>
        </nav>
 
        <div class="container-fluid scrollable row" style="margin-top:30px;">
            <div class="col-3">
                <img src="<c:url value="/images/user.png"/>" height="100" width="100"/>
                <h1>name</h1>
                <p>UserId</p>
                <button>edit</button>
                <p>"It was so great to hear from you today and it was such weird timing,"
                     he said. "This is going to sound funny and a little strange, 
                     but you were in a dream I had just a couple of days ago. 
                     I'd love to get together and tell you about it if you're up for a cup of coffee,
                     " he continued, laying the trapped he's been planning for years.</p>
                <hr/>
                <h1>test divider</h1>
            </div>
            <div class="col-9">
                <div class="card text-center">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs">
                            <li class="nav-item">
                              <a class="nav-link active" href="#">Notebooks</a>
                            </li>
<!--                              <li class="nav-item">
                              <a class="nav-link" href="#">group</a>
                            </li>-->
                            <li class="nav-item">
                              <a class="nav-link" href="#">group</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Special title treatment</h5>
                        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>

            </div>
        </div>
    </body>

</html>