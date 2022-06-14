<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/6/11
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改学生信息</title>
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

    <h3>修改学生</h3>
    <form>
        <c:forEach items="${updateStudentInfo}" var="update">
            <input type="hidden" name="id" value="${update.id}">
            姓名：<input name="name" value="${update.name}"><br>
            年龄：<input name="age" value="${update.age}"><br>
            <input type="radio" name="sex" value="男"  <c:if test="${update.sex=='男'}"> checked </c:if> >男
            <input type="radio" name="sex" value="女"  <c:if test="${update.sex=='女'}"> checked </c:if> >女<br>

            <input type="hidden" name="img" value="${update.img}">
            <input type="file" name="file" class="file" ><br>


            <img id="img1" width="100px" src="/show/${update.img}">

            <input type="hidden" name="classId" value="${update.classId}">
            <button type="button" id="bt">提交</button>
        </c:forEach>
    </form>

<div id="d"></div>
<script>
    $(function () {
        var id = $('[name="id"]').val();

        $("#bt").click(function () {
            console.log("111")
            var data = $('form').serialize();
            console.log(data)
            $.post('update_student',data,function (e) {
                if(e == "ok"){
                    alert("成功")
                    var id = $('[name="classId"]').val();
                    //重新载入学生列表
                    $("#student_info").load("show_student/"+id);
                }
            })
        })

        $('.file').on('change',function () {
            $.ajax({
                url:'upload',
                type:'post',
                processData: false,
                contentType: false,
                data: new FormData($('form')[0]),
                success:function (e) {
                    //回调函数将文件名赋值给隐藏输入框
                    $('[name="img"]').val(e);

                    $("#img1").attr("src", "/show/"+e);
                }

            })
        })
    })
</script>

</body>
</html>
