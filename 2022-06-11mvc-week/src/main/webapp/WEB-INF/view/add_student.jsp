<%--
  Created by IntelliJ IDEA.
  User: 云
  Date: 2022/6/12
  Time: 12:40
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

<h3>添加学生</h3>
<form>
        <input type="hidden" name="id" value="0">
        姓名：<input name="name" ><br>
        年龄：<input name="age" ><br>
        <input type="radio" name="sex" value="男"   checked  >男
        <input type="radio" name="sex" value="女"   checked  >女<br>
        <input type="hidden" name="img" >
        <input type="file" name="file" class="file" ><br>
        <div style="display: none" id="div"><img id="img1" width="100px" alt="" src="" ></div>

        <input type="hidden" name="classId" value="${cId}">
        <button type="button" id="bt">提交</button>
</form>
<div id="d"></div>
<script>
    $(function () {
        var id = $('[name="id"]').val();
        $("#bt").click(function () {
            var data = $('form').serialize();
            console.log(data)
            $.ajax({
                url:'add_student',
                type:'post',
                data:data,
                success:function (e) {
                    if(e == "ok"){
                        alert("成功")
                        location.reload();
                    }
                }
            })
        })

        $('.file').on('change',function () {
            var d = document.getElementById("div");
            d.style.display ="block";
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
