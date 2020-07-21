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
                    <form role="form" method="post" action="/seller/restaurant/save">
                        <div class="form-group">
                            <label>餐馆名字</label>
                            <input name="restaurantName" type="text" class="form-control" value="${(restaurantInfo.restaurantName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input name="restaurantAddress" type="text" class="form-control" value="${(restaurantInfo.restaurantAddress)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>电话</label>
                            <input name="restaurantPhone" type="text" class="form-control" value="${(restaurantInfo.restaurantPhone)!''}"/>
                        </div>
                        <input hidden type="text" name="restaurantId" value="${(restaurantInfo.restaurantId)!''}">
                        <button type="submit" class="btn btn-default">确认修改</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>