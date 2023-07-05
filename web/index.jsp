<%-- Created by IntelliJ IDEA. --%>
<%@page import="Entity.Customer" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
  //判断session中不存在登录的时候放入的用户实例，则认为处于非登录状态
  if(session.getAttribute("username")==null){
    response.sendRedirect("登录界面.html");
  }
%>
<script type="text/javascript">
  function logout(){
    window.location.replace("Logout")
  }

  function add(){
    window.location.replace("addCustomer.jsp")
  }

  function upd(val){
    window.location.replace("index?type=update&id="+val);
  }

  function del(val){ //注意方法名不能用delete
    const r = confirm("确定删除此信息？");
    if (r === true) {
      //alert("删除成功");
      window.location.replace("index?type=delete&id="+val);
    }
    return false;
  }
</script>
<html>
  <head>
    <title>Customs List</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  <body>
  <h1 align="center">Customers List</h1>
  <input type="button" value="Add" id="but1"><input type="button" value="Delet" id="but2"><input type="button"value="Logout" id="but3">

  <table id="customers">
    <tr>
      <th><input type="checkbox"></th>
      <th>Id</th>
      <th>Name</th>
      <th>Source</th>
      <th>Industry</th>
      <th>Level</th>
      <th>Address</th>
      <th>Phone</th>
      <th>Operation</th>
    </tr>
    <c:forEach var="cus" items="${sessionScope.cusList}">
      <tr>
        <td><input type="checkbox"></td>
        <td>${cus.custId}</td>
        <td>${cus.custName}</td>
        <td>${cus.custSource}</td>
        <td>${cus.custIndustry}</td>
        <td>${cus.custLevel}</td>
        <td>${cus.custAddress}</td>
        <td>${cus.custPhone}</td>
       <td><a href="">Delete</a>|<a href="">Update</a> </td>
      </tr>
    </c:forEach>

  </table>
  <div id="page_div">
    <a href=""><</a> <a href="">1</a> <a href="">></a>  到第<input type="text" size="1"/>页 <input type="button" value="GO" id="but4"/>  共${fn:length(sessionScope.cusList)}条
    <select>
      <option>10条/页</option>
      <option>15条/页</option>
      <option>20条/页</option>
    </select>
  </div>
  </body>
</html>