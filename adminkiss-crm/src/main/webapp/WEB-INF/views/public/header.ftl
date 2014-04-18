<#assign contextPath=springMacroRequestContext.getContextPath() />
<!-- 头部 -->
<header id="header">
    <div id="logo-group">
        <span id="logo">
            <img src="${contextPath}/static/dist/images/logo.png" alt="AdminKiss">
        </span>
        <span id="activity" class="activity-dropdown">
            <i class="fa fa-bell"></i>
            <b class="badge">21</b>
        </span>
        <!-- START AJAX-DROPDOWN -->
        <div class="ajax-dropdown">
            <div class="btn-group btn-group-justified" data-toggle="buttons">
                <label id="activityRadio1" class="btn btn-default">
                    <input type="radio" name="activity" value="1" url="ajax/notify/mail.html">消息 (14)</label>
                <label id="activityRadio2" class="btn btn-default">
                    <input type="radio" name="activity" value="2" url="ajax/notify/notifications.html">通知 (3)</label>
                <label id="activityRadio3" class="btn btn-default">
                    <input type="radio" name="activity" value="3" url="ajax/notify/tasks.html">任务 (4)</label>
            </div>
            <div class="ajax-notifications custom-scroll">
                <div class="alert alert-transparent">
                    <h4>点击这里，显示信息</h4>
					此空白页信息有助于保护您的隐私！
                </div>
                <i class="fa fa-lock fa-4x fa-border"></i>
            </div>
            <span>最后更新时间:
                <p class="display-inline" id="lastActivityTime">0000-00-00 00:00:00</p>
                <button id="refreshActivity" type="button" class="btn btn-xs btn-default pull-right">
                    <i class="fa fa-refresh"></i>
                </button>
            </span>
        </div>
        <!-- END AJAX-DROPDOWN -->
    </div>

    <!-- pulled right: nav area -->
    <div class="pull-right">
        <!-- collapse menu button -->
        <div id="hide-menu" class="btn-header pull-right">
            <span>
                <a href="javascript:void(0);" title="Collapse Menu">
                    <i class="fa fa-reorder"></i>
                </a>
            </span>
        </div>
        <!-- end collapse menu -->

        <!-- logout button -->
        <div id="logout" class="btn-header transparent pull-right">
            <span>
                <a title="退出">
                    <i class="fa fa-sign-out"></i>
                </a>
            </span>
        </div>
        <!-- end logout button -->

        <!-- search mobile button (this is hidden till mobile view port) -->
        <div id="search-mobile" class="btn-header transparent pull-right">
            <span>
                <a href="javascript:void(0)" title="搜索">
                    <i class="fa fa-search"></i>
                </a>
            </span>
        </div>
        <!-- end search mobile button -->

        <!-- input: search field -->
        <form action="#search.html" class="header-search pull-right">
            <input type="text" placeholder="输入关键字" id="search-fld">
            <button type="submit">
                <i class="fa fa-search"></i>
            </button>
            <a href="javascript:void(0);" id="cancel-search-js" title="取消搜索">
                <i class="fa fa-times"></i>
            </a>
        </form>
        <!-- end input: search field -->

    </div>
    <!-- end pulled right: nav area -->
</header>
<!-- 头部 -->