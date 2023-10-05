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
        <h1 class="display-3">회원가입</h1>
    </div>
</div>
<div class="container">
    <form name="frmProduct" action="./join" method="post" onsubmit="return validateForm()">
        <div class="form-group row">
            <label class="col-sm-2">아이디</label>
            <div class="col-sm-3">
                <input type="text" name="memberId" class="form-control">
                <span class="memberIdCheck"></span>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">비밀번호</label>
            <div class="col-sm-3">
                <input type="password" name="passwd" id="passwd" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">비밀번호 확인</label>
            <div class="col-sm-3">
                <input type="password" name="passwdCheck" id="passwdCheck" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">이름</label>
            <div class="col-sm-3">
                <input type="text" name="name" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2">연락처</label>
            <div class="col-sm-3">
                <input type="text" name="phone" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-100">
                <input type="submit" class="btn btn-primary" value="회원가입">
            </div>
        </div>
    </form>
    <hr>
</div>

<script>
    function validateForm() {
        const passwd = document.getElementById("passwd").value;
        const passwdCheck = document.getElementById("passwdCheck").value;

        if (passwd !== passwdCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return false; // 제출 중지
        }
        return true; // 제출 허용
    }
</script>
<script>

    document.addEventListener("DOMContentLoaded", function (){
        const xhr = new XMLHttpRequest();//XMLHttpRequest() ajaxid 활용할때 사용
        const inputId = document.querySelector('input[name=memberId]');
        const frmProduct = document.frmProduct;
        inputId.addEventListener('keyup', function (){
            const id = frmProduct.memberId.value; // 아이디 input 에 있는 값
            const memberIdCheck = document.querySelector('.memberIdCheck')//결과 문자열이 표현될 영역
            xhr.open('GET', 'ajaxIdCheck.jsp?memberId=' + id);//http 요청 초기화 통신 방식과 utl설정
            xhr.send();//url에 요청을보넴

            //이벤트 등록, XMLHttpRequset 객체의 readyState 프로퍼티값이 변할때마다 자동으로 호출
            xhr.onreadystatechange =() =>{
                if(xhr.readyState !== XMLHttpRequest.DONE) return;

                if(xhr.status === 200){//서버 url 에 문서가 존재함
                    const json = JSON.parse(xhr.response);
                    if(json.result === 'true'){
                        memberIdCheck.style.color='red';
                        memberIdCheck.innerHTML = `동일한 아이디가 존재합니다`;
                    }
                    else{
                        memberIdCheck.style.color='gray';
                        memberIdCheck.innerHTML = `사용가능한 아이디 입니다`;
                    }
                }
                else{
                    console.error('Error', xhr.status, xhr.statusText);
                }
            }
        });
    })
</script>
</body>
</html>