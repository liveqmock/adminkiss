<#assign contextPath=springMacroRequestContext.getContextPath() />
<!-- 左菜单 -->
<aside id="left-panel" active-menu="${activeMenu!'0'}">
    <!-- User info -->
    <div class="login-info">
        <span>
            <#if loginUser.avatar?exists>
				<img src="${contextPath}/common/viewAvatar?path=${loginUser.avatar!''}" alt="${loginUser.name!''}" />
			<#else>
				<img src="${contextPath}/static/dist/images/demo/avatars.png" alt="${loginUser.name!''}" />
			</#if>
            <a href="javascript:void(0);" id="show-shortcut">${loginUser.name!''}
                <i class="fa fa-angle-down"></i>
            </a>
        </span>
    </div>
    <!-- end user info -->
    <nav>
        <@subMenu roleId=loginUser.roleId context=contextPath/>
    </nav>
</aside>
<!-- 左菜单 -->