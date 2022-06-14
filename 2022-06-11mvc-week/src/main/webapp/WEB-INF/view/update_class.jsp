<%--
  Created by IntelliJ IDEA.
  User: 云
  Date: 2022/6/12
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改班级信息</title>
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
<br>
<br>
<form>
    <input type="hidden" value="${class_id}" name="id">
    <input name="className" value="${cName}" placeholder="请输入要修改的班级名称">
    <button type="button" id="bt">提交</button>
</form>
<script>
    $(function () {
        $('#bt').click(function () {
            var data = $('form').serialize();
            console.log(data)
            $.post('update_class',data,function (e) {
                if(e == "ok"){
                    alert("成功")
                    location.reload();
                }else {
                    alert("班级名已存在，请重新输入！")
                }
            })
        })
    })
</script>
</body>
</html>
