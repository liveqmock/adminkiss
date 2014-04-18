<#assign contextPath=springMacroRequestContext.getContextPath() />
<#macro head title>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>${title}</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="shortcut icon" href="${contextPath}/static/dist/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" media="screen" href="${contextPath}/static/dist/css/adminkiss-common.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${contextPath}/static/dist/css/adminkiss-main.css">
    <#nested>
</head>
</#macro>

<#macro defaultFrame title>
<body class="fixed-header fixed-ribbon fixed-navigation">
	<#include "/public/header.ftl">
	<#include "/public/menu.ftl">
	<!-- 主要内容 -->
    <div id="main" role="main">
        <div id="ribbon">
		    <span class="ribbon-button-alignment">
		        <span id="refresh" class="btn btn-ribbon">
		            <i class="fa fa-refresh"></i>
		        </span>
		    </span>
		    <ol class="breadcrumb">
		        <li>${title}</li>
		    </ol>
		</div>
		<div id="content" class="pjax">
		    <#nested>
		</div>
    </div>
    <#include "/public/footer.ftl">
</#macro>
<#macro end>
		<script src="${contextPath}/static/libs/seajs/sea.min.js"></script>
		<#nested>
	</body>
</html>
</#macro>