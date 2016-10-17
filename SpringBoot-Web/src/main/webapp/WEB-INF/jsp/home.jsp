<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/27
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

  <!-- 可选的Bootstrap主题文件（一般不用引入） -->
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover table-bordered" style="margin: 0px auto;width: 60%;text-align: center">
  <tr class="info">
    <td>科目ID</td>
    <td>科目名称</td>
    <td>课时</td>
    <td>年级名称</td>
    <td>编辑</td>
    <td>删除</td>
  </tr>
  <c:if test="countpage<=0">countpage=0</c:if>
  <c:if test="countpage>=totalPages">countpage=totalPages</c:if>
  <c:forEach items="${list.content}" var="sub">
  <tr align="center">
    <td><input type="checkbox" value="${sub.subjectNo}" name="checkbox" class="checkbox"></td>
    <td>${sub.subjectName}</td>
    <td>${sub.classHour}&nbsp;Hours</td>
    <td>${sub.gradeName}</td>
    <td><a href="toupdateSubject?subjectNo=${sub.subjectNo}" type="button" class="btn btn-primary">编辑</a></td>
    <td><button type="button" class="btn btn-danger" title="${sub.subjectNo}">删除</button></td>
  </tr>
  </c:forEach>
  <tr>
    <td colspan="6" align="left">
      <input type="button" class="btn btn-primary" id="but" value="全选" name="but">&nbsp;&nbsp;&nbsp;
      <a href="toaddSubject" type="button" class="btn btn-primary">新增</a>
    </td>
  </tr>
</table>
      <nav style="text-align: center">
        <ul class="pagination">
          <li><a href="show?page=${countpage-1}">&laquo;</a></li>
          <c:forEach var="p" begin="0" end="${list.totalPages-1}">
          <li><a href="show?page=${p}">${p+1}</a></li>
          </c:forEach>
          <li><a href="show?page=${countpage+1}">&raquo;</a></li>
        </ul>
      </nav>
<script type="text/javascript">
  $(function(){
    $(".btn-danger").click(function(){
      if(window.confirm("您确定要删除吗？")) {
        var subjectno = $(this).attr("title")
        $.post("deletSubject", {subjectNo: subjectno}, function (data) {
          if (data == 1) {
            alert("删除成功！");
            location.reload();
          } else {
            alert("删除失败！");
          }
        })
      }
    });

  })
</script>
</body>
</html>
