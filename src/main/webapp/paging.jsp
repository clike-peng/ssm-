<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>faceTest</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/personFind-style.css" rel="stylesheet">
    <script>
        // <a class="btn btn-default pm-padd " href="javascript:void(0);" id="delSelect"  role="button">删除选中</a>
        window.onload= function(){
            document.getElementById("delSelect").onclick=function() {
                var flag = false;
                var ids=  document.getElementsByName("id");
                for (var i = 0; i <  ids.length; i++) {
                    if (ids[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if ( flag && confirm("你确定要删除选中的条目吗？")){
                    document.getElementById("form").submit();
                }
                if (!flag){
                    window.alert("请选中条目！");
                }

            }
            document.getElementById("firstTh").onclick =function () {
                var ids = document.getElementsByName("id");
                for (var i = 0; i < ids.length; i++) {
                    ids[i].checked = this.checked;
                }
            }
        }
    </script>

</head>
<body>
<form class="form-inline pm-pad" action="${pageContext.request.contextPath}/pagingServlet?currentPage=1&row=5" method="post">

    <div class="form-group">
        <label class="sr-only">name</label>
        <p class="form-control-static wp-text">姓名：</p>
    </div>
    <div class="form-group">
        <label for="inputPassword1" class="sr-only">姓名</label>
        <input type="text" name="name" value="${parameterMap.name[0]}"  class="form-control " id="inputPassword1" >
    </div>
    <div class="form-group">
        &emsp; &emsp;&emsp; <!--         &ensp;&ensp;--> <!--&nbsp;&nbsp;-->
    </div>
    <div class="form-group">
        <label class="sr-only">IDCart</label>
        <p class="form-control-static  wp-text">身份证号：</p>
    </div>
    <div class="form-group ">
        <label for="inputPassword2" class="sr-only">身份证号</label>
        <input type="text" name="idCard" value="${parameterMap.idCard[0]}"  class="form-control" id="inputPassword2" >
    </div>


     <%--  javascript:void(0);  是一个什么都不会发生的地址 --%>
    <a class="btn btn-default pm-padd " href="javascript:void(0);" id="delSelect"  role="button">删除选中</a>
    <a class="btn btn-default pm-padd " href="${pageContext.request.contextPath}/addPerson.jsp" role="button">添加</a>
    <button type="submit" class="btn btn-default pm-padd">查询</button>
</form>

<div class="table-responsive pm-table">
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
    <table class="table">
        <thead>
        <tr>
            <th><input type="checkbox" id="firstTh" > </th>
            <th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>身份证号</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${paging.page}" var="person" varStatus="s">
            <tr>
                <td><input type="checkbox"  name="id" value="${person.personId}" ></td>
                <td>${s.count}</td>
                <td>${person.name}</td>
                <td>${person.sex}</td>
                <td>${person.birthday}</td>
                <td>${person.idCard}</td>
                <td>
                    <div style="text-align: center">
                        <a class="btn btn-default  " href="#" role="button">修改</a>
                        <a class="btn btn-default  " href="${pageContext.request.contextPath}/removePersonServlet?personId=${person.personId}" role="button">删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    </form>
</div>

<div class="wp-float">
    <div class="pm-a">
        <nav>
            <ul class="pagination">
                <c:if test="${paging.currentPage == 1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${paging.currentPage != 1}">
                    <li>
                </c:if>

                    <a href="${pageContext.request.contextPath}/pagingServlet?currentPage=${paging.currentPage - 1}&row=5&name=${parameterMap.name[0]}&idCard=${parameterMap.idCard[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" var="i" step="1" end="${paging.pageCount}"  >
                    <c:if test="${paging.currentPage == i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/pagingServlet?currentPage=${i}&row=5&name=${parameterMap.name[0]}&idCard=${parameterMap.idCard[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${paging.currentPage != i}">
                    <li ><a href="${pageContext.request.contextPath}/pagingServlet?currentPage=${i}&row=5&name=${parameterMap.name[0]}&idCard=${parameterMap.idCard[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${paging.currentPage == paging.pageCount}">
                    <li class="disabled">
                </c:if>
                <c:if test="${paging.currentPage != paging.pageCount}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/pagingServlet?currentPage=${paging.currentPage + 1}&row=5&name=${parameterMap.name[0]}&idCard=${parameterMap.idCard[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>