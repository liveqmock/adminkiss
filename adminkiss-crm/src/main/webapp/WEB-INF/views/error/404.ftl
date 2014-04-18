<#assign contextPath=springMacroRequestContext.getContextPath() />
<#import "/layout/default.ftl" as dk>
<@dk.head "404">
	
</@dk.head>

<@dk.defaultFrame "404">
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="row">
			<div class="col-sm-12">
				<div class="text-center error-box">
					<h1 class="error-text tada animated"> Error 404 </h1>
					<h2 class="font-xl"><strong><i class="fa fa-fw fa-warning fa-lg text-warning"></i> 您访问的页面不存在！</strong></h2>
					<br/>
					<br/>
				</div>
			</div>
		</div>
	</div>
</div>
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