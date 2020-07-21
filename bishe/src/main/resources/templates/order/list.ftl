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
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>座位号</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list orderMasters as orderMaster>
                        <tr>
                            <td>${orderMaster.orderId}</td>
                            <td>${orderMaster.buyerName}</td>
                            <td>${orderMaster.buyerPhone}</td>
                            <td>${orderMaster.buyerAddress}</td>
                            <td>${orderMaster.orderAmount}</td>
                            <td>${orderMaster.getOrderStatusEnum().message}</td>
                            <td>${orderMaster.getPayStatusEnum().message}</td>
                            <td>${orderMaster.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/seller/order/detail?orderId=${orderMaster.orderId}">详情</a></td>
                            <td>
                                <#if orderMaster.getOrderStatusEnum().message == "新订单">
                                    <a href="/seller/order/cancel?orderId=${orderMaster.orderId}">取消</a>
                                </#if>
                            </td>
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