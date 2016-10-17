<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/28
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增科目</title>
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
<table class="table table-bordered" align="center" style="width:40%;margin: 0px auto">
  <tr class="info">
    <td align="center">
      <h2>新增科目</h2>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">科目名称：</div>
          <input class="form-control" type="text" placeholder="科目名称" id="subjectName" name="subjectName">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">课时数量：</div>
          <input class="form-control" type="number" placeholder="课时数量" id="classHour" name="classHour">
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">所属年级：</div>
          <select name="gradeId" id="gradeId" class="form-control">
            <c:forEach items="${glist}" var="g">
              <c:if test="${g.gradeId==subject.gradeId}">
              <option value="${g.gradeId}" selected="selected">${g.gradeName}</option>
            </c:if>
              <c:if test="${g.gradeId!=subject.gradeId}">
                <option value="${g.gradeId}">${g.gradeName}</option>
              </c:if>
            </c:forEach>
          </select>
        </div>
      </div>
    </td>
  </tr>
  <tr>
    <td align="right"><button type="button" class="btn btn-primary" id="butsub">新增科目</button></td>
  </tr>
</table>
</body>
<script>
  $(function(){
    $("#butsub").click(function(){
      $.post("addSubject",{"subjectName":$("#subjectName").val(),"classHour":$("#classHour").val(),"gradeId":$("#gradeId").val()},function(data){
        if(data==true){
          alert("新增成功");
          location="show";
        }else{
          alert("新增失败");
        }
      });
    });
  });
</script>
</html>
