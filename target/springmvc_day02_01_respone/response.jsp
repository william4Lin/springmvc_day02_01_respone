<%--
  Created by IntelliJ IDEA.
  User: pactera
  Date: 2020/6/3
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery-3.5.1.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("hello btn");
                $.ajax({
                    //设置属性值，用json格式
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"林","password":"123","age":12}',
                    datatype:"json",
                    type:"post",
                    success:function(data){
                        alert(data);
                        alert(data.username);
                        alert(data.age);
                        alert(data.password);
                    }
                });
            })
        });
    </script>
</head>
<body>

    <a href="user/testRespString">testRespString</a><br>

    <a href="user/testRespVoid">testRespVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

    <button id="btn">发送ajax请求</button>

</body>
</html>
