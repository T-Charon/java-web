<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/6/11
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>班级列表</title>
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

<h3>班级列表</h3>
<div id="content">
    <table border="1" cellpadding="0" cellspacing="0" >
        <tr>
            <th>id</th>
            <th>班级名称</th>
            <th>班级人数</th>
            <th colspan="4">操作</th>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.className}</td>
                <td>${c.count}</td>
                <td><a href="#" class="show_student">查看学生</a></td>
                <td><a href="#" class="add_student">添加学生</a></td>
                <td><a href="#" class="update_class">修改班级</a></td>
                <td><a href="#" class="delete_class">删除班级</a></td>
            </tr>
        </c:forEach>

    </table>
</div>


<div id="d" style="display: none">
    <br>
    <hr>
    <h3 id="msg"></h3>
</div>
<div id="student_info" style="width: 600px ;margin: auto;text-align: center"></div>
<script>
    $(function () {

        $('.show_student').click(function () {
            console.log("123")
            var tr = $(this).parent().parent();
            var id = tr.children().eq(0).text();
            var class_name = tr.children().eq(1).text();
            //显示当前是几班的学生列表
            var d = document.getElementById("d");
            d.style.display ="block";
            var msg = document.getElementById("msg");
            msg.innerText =class_name+"的学生列表";
            //载入学生信息列表
            $("#student_info").load("show_student/"+id);


        })
        $('.add_student').click(function () {
            //隐藏当前是几班的学生列表
            var d = document.getElementById("d");
            d.style.display ="none";
            console.log("123")
            var tr = $(this).parent().parent();
            var id = tr.children().eq(0).text();
            //载入添加学生页面
            $("#student_info").load("add_student/"+id);

         })

        $('.update_class').click(function () {
            //隐藏当前是几班的学生列表
            var d = document.getElementById("d");
            d.style.display ="none";
            console.log("123")
            var tr = $(this).parent().parent();
            var name = tr.children().eq(1).text();
            //载入修改学生页面
            $("#student_info").load("update_class/"+name);

        })


        $('.delete_class').click(function () {
            location.reload();
            console.log("123")
            var tr = $(this).parent().parent();
            var id = tr.children().eq(0).text();
            console.log(id)
            $.ajax({
                url:'delete_class/'+id,
                type:'post',
                processData: false,
                contentType: false,
                success:function (e) {
                    if(e == "ok"){
                        alert("成功")
                        location.reload();
                    }else {
                        alert("无法删除班级！")
                    }
                }
            })

        })

    })
</script>
</body>
</html>