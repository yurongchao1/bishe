<html>
<head>
    <meta charset="utf-8">
    <title>卖家管理系统后台</title>
    <link href="favicon.ico" rel="shortcut icon" />
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">

</head>

<script type="text/javascript">
    function check() {
        var x=document.forms["myform"]["username"].value;
        var y=document.forms["myform"]["password"].value;
        if (x==null || x==""){
            alert("用户名不能为空");
            return false;
        }
        if (y==null || y==""){
            alert("密码不能为空");
            return false;
        }
    }
</script>

<body style=" background: url(http://global.bing.com/az/hprichbg/rb/RavenWolf_EN-US4433795745_1920x1080.jpg) no-repeat center center fixed; background-size: 100%;">


<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">卖家管理系统后台</h4>
        </div>


        <form  name="myform" role="form"  method="post" action="/seller/login"  onsubmit="return check()" >
        <div class="modal-body" id = "model-body">
            <div class="form-group">

                <input type="text"   name="username" id="username" class="form-control"placeholder="用户名" autocomplete="off">
            </div>
            <div class="form-group">

                <input type="password"   name="password" id="password"   class="form-control" placeholder="密码" autocomplete="off">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button    type="submit" class="btn btn-primary form-control">登录</button>
            </div>
        </form>

        </div>
    </div>
</div>

</body>


</html>