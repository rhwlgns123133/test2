<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  <title>DONASS</title>
</head>
<body>
<div class="container">
  <div class="row justify-content-center">
    <c:if test="${param.result == 'error'}">
      <h1 style="color: red" alert>로그인 에러</h1>
    </c:if>
    <div class="col-sm-3" style="padding-top: 50px">
      <form action="/login" method="post">
        <div class="form-group">
          <label for="memberId" class="sr-only">User Id</label>
          <input type="text" name="memberId" class="form-control">
        </div>
        <div class="form-group">
          <label for="passwd" class="sr-only">Password</label>
          <input type="password" name="passwd" class="form-control">
        </div>
        <div class="form-check form-check-inline">
          <input type="checkbox" name="auto" class="form-check-input">
          <label for="auto" class="form-check-label">자동로그인</label>
        </div>
        <div class="row justify-content-center">
          <button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
          <a href="/join" class="btn btn-lg btn-secondary btn-block mt-2">회원가입</a>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
