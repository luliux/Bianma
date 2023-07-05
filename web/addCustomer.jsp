<%@page import="Entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% // 判断session中不存在登录的时候放入的用户实例，则认为处于非登录状态
if(session.getAttribute("username")==null){
	response.sendRedirect("login.htm");
} 
%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<script>
    function validateForm() {
        /*
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        let passconf = document.getElementById("passconf").value;
        let age = document.getElementById("age").value;
        let email = document.getElementById("email").value;

        if (username == "" || password == "" || passconf == "" || age == "" || email == "") {
            alert("All fields must be filled out");
            return;
        }

        if(password != passconf){
            alert("The two passwords are inconsistent");
            document.getElementById("password").value = "";
            document.getElementById("passconf").value = "";
            document.getElementById("password").focus();
            return;
        }

        if(!isNumber(age)){
            alert("The age must be filled numbers");
            return;
        }

        if(!isEmail(email)){
            alert("The email format is not correct");
            return;
        }
        */

        document.getElementById("myForm").submit();
    }

    function gotoIndex(){
        window.location.replace("index.jsp")
    }

</script>
<style>
    body{
        background: #1f88cb;
    }
    .register{
        width: 380px;
        height: 380px;
        background:#d9e3e8;
        margin:100px auto;/*盒子顶部距离200，水平居中*/
        border-radius: 10px;/*圆角10个像素*/
    }
    .register_top{
        width: 100%;
        height: 50px;
        background:#093f63;
        float: left;
        border-radius: 10px 10px 0px 0px;/* 圆角四个参数的写法分别指左上，右上，右下 左下 */
        color: white;
        text-align: center; /* 水平居中 */
        line-height: 50px; /* 垂直居中 */
    }
    .ref{
        width: 350px;
        height: 40px;
        /*background:red;  这个背景色后面是要去掉的*/
        margin-left: 10px;
        margin-top: 5px;
        /* 以上两句可以简写为margin:5px opx opk 10px; */
        float: left; /*在这里你可以试着不加浮动，就知道浮动的作用了*/
        text-align: center;
        line-height: 40px;
    }
    .ref1{
        width: 160px;
        height: 40px;
        /*background:green; 这个背景色后面是要去掉的*/
        margin-left: 0px;
        margin-top: 0px;
        /* 以上两句可以简写为margin:5px opx opk 10px; */
        float: left; /*在这里你可以试着不加浮动，就知道浮动的作用了*/
        text-align: right;
        line-height: 40px;
    }
    .ref2{
        width: 190px;
        height: 40px;
        /*background:blue; 这个背景色后面是要去掉的*/
        margin-left: 0px;
        margin-top: 0px;
        /* 以上两句可以简写为margin:5px opx opk 10px; */
        float: left; /*在这里你可以试着不加浮动，就知道浮动的作用了*/
        text-align: left;
        line-height: 40px;
    }
    #btn,#res,#return{
        width: 70px;
        height: 25px;
        font-size: 10pt;
    }
</style>

<body>
<div class="register">
    <div class="register_top">Add Customer Form</div>
    <form id="myForm" action="index?type=add"  method="post">
        <div class="ref">
            <div class="ref1">
                Name:
            </div>
            <div class="ref2">
                <input type="text" id="cust_name" name="cust_name"/>
            </div>
        </div>
        <div class="ref">
            <div class="ref1">
                Source:
            </div>
            <div class="ref2">
                <input type="text" id="cust_source" name="cust_source"/>
            </div>
        </div>
        <div class="ref">
            <div class="ref1">
                Industry:
            </div>
            <div class="ref2">
                <input type="text" id="cust_industry" name="cust_industry"/>
            </div>
        </div>
        <div class="ref">
            <div class="ref1">
                Phone:
            </div>
            <div class="ref2">
                <input type="text" id="cust_phone" name="cust_phone"/>
            </div>
        </div>
        <div class="ref">
            <div class="ref1">
                Level:
            </div>
            <div class="ref2">
                <input type="radio" id="cust_leve" name="cust_level" value="VIP" checked>VIP <input
                    type="radio" id="cust_level" name="cust_level" value="Normal">Normal
            </div>
        </div>
        <div class="ref">
            <div class="ref1">
                Address:
            </div>
            <div class="ref2">
                <input type="text" id="cust_address" name="cust_address"/>
            </div>
        </div>
        <div class="ref">
            <input type="button" value="Add" id="btn" onclick="validateForm()"/>
            <input type="button" value="Return" id="return" onclick="gotoIndex()"/>
        </div>
    </form>
</div>
</body>
</html>

