<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/books/addbook" method="get">
        <div class="form-group">
            <label for="bkname">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="bkname" >
        </div>
        <div class="form-group">
            <label for="bkname1">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="bkname1" >
        </div>
        <div class="form-group">
            <label for="bkname2">书籍描述</label>
            <input type="text" name="detail" class="form-control" id="bkname2" >
        </div>

        <button type="submit" class="btn btn-default">Submit</button>

    </form>
</div>