<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/default.ftl" as dk>
<@dk.head "系统设置">
	
</@dk.head>

<@dk.defaultFrame "系统设置">
	系统基本设置
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
