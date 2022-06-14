<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/6/11
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align: center;
        }
        table {
            margin: auto;
            width: 600px;
            text-align: center;
        }
    </style>
    <script src="/static/js/jquery.min.js"></script>
</head>
<body>


<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>头像</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${studentList}" var="u" >
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>${u.sex}</td>
            <td>
                <img src="/show/${u.img}" height="50px">
            </td>
            <td><a href="#" class="update">修改</a></td>
            <td><a href="#" class="delete">删除</a></td>
            <input type="hidden" value="${u.classId}" name="cid">

        </tr>
    </c:forEach>
</table>
<div id="update" style="width: 600px ;margin: auto;text-align: center"></div>
<script>
    $(function () {
        $(".update").click(function () {
            var tr = $(this).parent().parent();
            var id = tr.children().eq(0).text();
            console.log(id);
            //重新载入修改学生列表
            $("#update").load("update_student/"+id);
        })

        $(".delete").click(function () {
            var tr = $(this).parent().parent();
            var id = tr.children().eq(0).text();
            console.log(id);
            $.ajax({
                url:'delete_student/'+id,
                type:'post',
                processData: false,
                contentType: false,
                success:function (e) {
                    if(e == "ok"){
                        var id = $('[name="cid"]').val();
                        alert("成功")
                        location.reload()
                        //重新载入学生列表
                        $("#student_info").load("show_student/"+id);
                    }
                }
            })

        })
    })
</script>
</body>
</html>
