<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/22
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="<%=basePath%>statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    function pageEnd(index) {
        var title = $("#title").val();
        $.post("<%=basePath%>invitation/init", {"indexPage": index, "title": title}, function (result) {
            var s = $.parseJSON(result);
            var content = "";
            var bgColor = "";
            if (s.list.length == 0) {
                $("#none").html("没有" + "${param.title}" + "关键词，请换关键词进行搜索");
                $("table").remove();
            } else {
                for (var i = 0; i < s.list.length; i++) {
                    if (i % 2 == 1) {
                        bgColor = "#B0E11E"
                    } else {
                        bgColor = "";
                    }
                    content += "<tr style='background-color: " + bgColor + "\'>" +
                        "<th>" + s.list[i].iid + "</th>" +
                        "<th>" + s.list[i].title + "</th>" +
                        "<th>" + s.list[i].context + "</th>" +
                        "<th>" + s.list[i].author + "</th>" +
                        "<th>" + s.list[i].date + "</th>" +
                        "</tr>";
                }

                var page = "<a href='javascript:pageEnd(1)'>首页</a>" +
                    "<a href='javascript:pageEnd(" + (s.indexPage > 1 ? s.indexPage - 1 : 1) + ")'>上一页</a>" +
                    "<a href='javascript:pageEnd(" + (s.indexPage < s.sumPage ? s.indexPage + 1 : s.sumPage) + ")'>下一页</a>" +
                    "<a href='javascript:pageEnd(" + (s.sumPage) + ")'>尾页</a>";
                $("#content").html(content);
                $("#end").html(page);
            }
        });
    };
    $(function () {
        pageEnd(1)
    });
</script>
<form method="post" action="">
    <p align="center">请输入要查询的标题<input type="text" name="title" id="title" value="${param.title}"/>
        <button onclick="pageEnd(1)">提交</button>
    </p>
</form>
<table align="center" border="solid">
    <tr style="background-color: aliceblue">
        <th>编号</th>
        <th>标题</th>
        <th>内容</th>
        <th>作者</th>
        <th>时间</th>
        <tbody id="content">

        </tbody>
    </tr>
</table>
<p id="end" align="center"></p>
<p id="none" align="center"></p>
</body>
</html>
