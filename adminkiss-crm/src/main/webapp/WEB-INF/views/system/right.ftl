<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/default.ftl" as dk>
<@dk.head "权限管理">
	
</@dk.head>

<@dk.defaultFrame "权限管理">
	权限信息管理
</@dk.defaultFrame>

<@dk.end>
	<script type="text/javascript">
        seajs.config({
        	base: "/static",
            alias: {
                "jquery": "libs/jquery/jquery",
                "jquery-ui": "assets/mods/jquery/src/jquery-ui",
                "dropdown": "assets/mods/bootstrap/src/dropdown",
                "message": "assets/mods/message/src/message",
                "common": "assets/mods/common/src/common"
            },
            debug: 1
        });
        seajs.use("assets/apps/index/src/index.js");
    </script>
</@dk.end>