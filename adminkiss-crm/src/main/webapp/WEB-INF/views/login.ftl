<#assign contextPath=springMacroRequestContext.getContextPath() />
<html lang="zh">
	<head>
	    <meta charset="utf-8">
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <title>登录页面</title>
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	    <link rel="shortcut icon" href="${contextPath}/static/dist/images/favicon.ico" type="image/x-icon">
	    <link rel="stylesheet" type="text/css" media="screen" href="${contextPath}/static/dist/css/adminkiss-common.css">
	    <link rel="stylesheet" type="text/css" media="screen" href="${contextPath}/static/dist/css/adminkiss-login.css">
	</head>
	<body id="login" class="animated fadeInDown">
	    <header id="header">
	        <div class="container">
	            <div id="logo-group">
	                <span id="logo">
	                    <img src="${contextPath}/static/dist/images/logo.png" alt="AdminKiss">
	                </span>
	            </div>
	            <!--
	            <span id="login-header-space">
	                <span class="hidden-mobile">没有登录帐号？</span>
	                <a href="register.html" class="btn btn-danger">申请帐号</a>
	            </span>
	            -->
	        </div>
	    </header>
	    <div id="main" role="main">
	        <div id="content" class="container">
	            <div class="row">
	                <!-- 图片轮循 start-->
	                <div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
	                    <div id="myCarousel" class="carousel fade">
	                        <ol class="carousel-indicators">
	                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	                            <li data-target="#myCarousel" data-slide-to="1" class=""></li>
	                            <li data-target="#myCarousel" data-slide-to="2" class=""></li>
	                        </ol>
	                        <div class="carousel-inner">
	                            <!-- Slide 1 -->
	                            <div class="item active">
	                                <img src="${contextPath}/static/dist/images/demo/m1.jpg" alt="">
	                            </div>
	                            <!-- Slide 2 -->
	                            <div class="item">
	                                <img src="${contextPath}/static/dist/images/demo/m2.jpg" alt="">
	                            </div>
	                            <!-- Slide 3 -->
	                            <div class="item">
	                                <img src="${contextPath}/static/dist/images/demo/m3.jpg" alt="">
	                            </div>
	                        </div>
	                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	                            <span class="glyphicon glyphicon-chevron-left"></span>
	                        </a>
	                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
	                            <span class="glyphicon glyphicon-chevron-right"></span>
	                        </a>
	                    </div>
	                </div>
	                <!-- 图片轮循 end-->
	                <!-- 登录框 start-->
	                <div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
	                    <div class="well no-padding">
	                        <form action="${contextPath}/doLogin" id="loginForm" class="smart-form client-form" method="post">
	                            <header>用户登录</header>
	                            <fieldset>
	                                <section>
	                                    <label class="label">登录邮箱</label>
	                                    <label class="input">
	                                        <i class="icon-append fa fa-user"></i>
	                                        <input id="username" type="email" name="username">
	                                        <b class="tooltip tooltip-top-right">
	                                            <i class="fa fa-user txt-color-teal"></i>请输入您的登录邮箱！</b>
	                                    </label>
	                                </section>
	                                <section>
	                                    <label class="label">密码</label>
	                                    <label class="input">
	                                        <i class="icon-append fa fa-lock"></i>
	                                        <input id="password" type="password" name="password">
	                                        <b class="tooltip tooltip-top-right">
	                                            <i class="fa fa-lock txt-color-teal"></i>请输入您的密码！</b>
	                                    </label>
	                                </section>
	                                <section>
	                                    <label class="checkbox">
	                                        <input type="checkbox" name="remember" checked="">
	                                        <i></i>记住密码
	                                    </label>
	                                </section>
	                            </fieldset>
	                            <footer>
	                            	<#if refurl?exists>
	                            		<input type="hidden" id="refurl" value="${refurl!''}">
		                        	<#else>
		                        		<input type="hidden" id="refurl" value="${contextPath}/index">
	                            	</#if>
		                           <button type="submit" class="btn btn-primary">登 录</button>
	                            </footer>
	                        </form>
	                    </div>
	                    <h5 class="text-center">- 使用其他帐号登录 -</h5>
	                    <ul class="list-inline text-center">
	                        <li>
	                            <a href="javascript:void(0);" class="btn btn-primary btn-circle">
	                                <i class="fa fa-google-plus"></i>
	                            </a>
	                        </li>
	                        <li>
	                            <a href="javascript:void(0);" class="btn btn-info btn-circle">
	                                <i class="fa fa-renren"></i>
	                            </a>
	                        </li>
	                        <li>
	                            <a href="javascript:void(0);" class="btn btn-warning btn-circle">
	                                <i class="fa fa-weibo"></i>
	                            </a>
	                        </li>
	                    </ul>
	                </div>
	                <!-- 登录框 end-->
	            </div>
	        </div>
	        <footer id="footer" class="hidden-xs hidden-sm">
	            <div class="container">
	                <span>© 2014 - 2015 - XXXXXXXX公司 - All Rights Reserved.</span>
	            </div>
	        </footer>
	        <script src="${contextPath}/static/libs/seajs/sea.min.js"></script>
	        <script type="text/javascript">
		        seajs.config({
		        	base: "/static",
		            alias: {
		                "jquery": "libs/jquery/jquery",
		                "jquery-validate": "assets/mods/jquery/src/jquery-validate",
		                "carousel": "assets/mods/bootstrap/src/carousel",
		                "message": "assets/mods/message/src/message"
		            },
		            debug: 1
		        });
		        seajs.use("assets/apps/login/src/login.js");
		    </script>
	</body>
</html>