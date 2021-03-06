<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户添加</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        .pm-padd{
            margin-right:120px;
        }
        .wp-idCard{
            margin:5px 90px;
        }
        .wp-name{
            padding:10px 90px;
        }
    </style>
</head>
<body>
<span style=" margin: 90px; font-size: 20px; line-height: 50px;">基本信息</span>
<div>
    <form class="form-inline " action="${pageContext.request.contextPath}/addPersonServlet" method="post" >
        <div class="wp-name">
            <div class="form-group">
                <label class="sr-only">name</label>
                <p class="form-control-static wp-text">姓名：</p>
            </div>
            <div class="form-group">
                <label for="inputPassword1" class="sr-only">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control " id="inputPassword1" >
            </div>
            <div class="form-group">
                &emsp; &emsp;&emsp; <!--         &ensp;&ensp;--> <!--        &nbsp;&nbsp;-->
            </div>
            <div class="dropdown form-group">
                <span >性别：</span>
                <select id="mySelect" name="sex" value="${condition.sex[0]}">
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
            <div class="form-group">
                &emsp; &emsp;&emsp; <!--         &ensp;&ensp;--> <!--        &nbsp;&nbsp;-->
            </div>
            <div class="form-group">
                <label class="sr-only">birthday</label>
                <p class="form-control-static wp-text">出生日期：</p>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="sr-only">出生日期：</label>
                <input type="text" name="birthday"  value="${condition.birthday[0]}" class="form-control " id="inputPassword3" >
            </div>
        </div>

        <div class="wp-idCard">
            <div class="form-group">
                <label class="sr-only">IDCart</label>
                <p class="form-control-static  wp-text">身份证号：</p>
            </div>
            <div class="form-group ">
                <label for="inputPassword2" class="sr-only">身份证号</label>
                <input type="text" name="idCard"  value="${condition.idCard[0]}"  class="form-control" id="inputPassword2" >
            </div>
        </div>

        <button type="submit"  class="btn btn-default pm-padd" style="float: right">添加</button>
    </form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
