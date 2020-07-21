<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>评论id</th>
                            <th>订单id</th>
                            <th>买家姓名</th>
                            <th>评论内容</th>
                            <th>创建时间</th>

                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list comments as comment>
                        <tr>
                            <td>${comment.commentId}</td>
                            <td>${comment.orderID}</td>
                            <td>${comment.name}</td>
                            <td>${comment.content}</td>

                            <td>${comment.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>

                            <td><a href="/seller/order/detail?orderId=${comment.orderID}">查看订单详情</a></td>

                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>


            </div>
        </div>
    </div>

</div>
</body>
</html>