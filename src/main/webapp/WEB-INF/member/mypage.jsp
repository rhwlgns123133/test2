<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Insert title here</title>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">내정보</h1>
    </div>
</div>
<div class="bottom-nav">
    <h4 class="title">이름</h4>
    <p class="caption">${loginInfo.name}</p>
    <hr>
    <h4 class="title">아이디</h4>
    <p class="caption">${loginInfo.memberId}</p>
    <hr>
    <h4 class="title">연락처</h4>
    <p class="caption">${loginInfo.phone}</p>
    <hr>
    <div><a href="/logOut">LOGOUT</a></div>
    <div><a href="/modify">내정보 수정</a></div>
</div>
</body>
</html>