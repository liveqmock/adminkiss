define(function (require, exports, module) {
    var $ = require("jquery");
    require('../../jquery/src/jquery-ui');
    require("../../message/src/message");
    require("../../bootstrap/src/dropdown");
    // 页面加载初始化
    $(document).ready(function () {
        // 菜单自动定位
        var activeMenuId = $('#left-panel').attr("active-menu");
        if (activeMenuId) {
            $("#leftMenu" + activeMenuId).addClass("active");
        }
        // 消息提醒
        $('#activity').click(function (e) {
            $this = $(this);
            if ($this.find('.badge').hasClass('bg-color-red')) {
                $this.find('.badge').removeClass('bg-color-red');
                $this.find('.badge').text(" 0 ");
            }
            if (!$this.next('.ajax-dropdown').is(':visible')) {
                $this.next('.ajax-dropdown').fadeIn(150);
                $this.addClass('active');
            } else {
                $this.next('.ajax-dropdown').fadeOut(150);
                $this.removeClass('active')
            }
            var mytest = $this.next('.ajax-dropdown').find('.btn-group > .active > input').attr('id');
            e.preventDefault();
        });
        $('input[name="activity"]').change(function () {
            $this = $(this);
            value = $this.val();
            url = $this.attr('url');
            $('#activity').attr('active-url', url);
            if (value == 1) {
                $('#activityRadio1').addClass('active');
                $('#activityRadio2').removeClass('active');
                $('#activityRadio3').removeClass('active');
            } else if (value == 2) {
                $('#activityRadio1').removeClass('active');
                $('#activityRadio2').addClass('active');
                $('#activityRadio3').removeClass('active');
            } else {
                $('#activityRadio1').removeClass('active');
                $('#activityRadio2').removeClass('active');
                $('#activityRadio3').addClass('active');
            }
            container = $('.ajax-notifications');
            loadMessageURL(url, container);
        });

        $(document).mouseup(function (e) {
            if (!$('.ajax-dropdown').is(e.target) && $('.ajax-dropdown').has(e.target).length === 0) {
                $('.ajax-dropdown').fadeOut(150);
                $('.ajax-dropdown').prev().removeClass("active")
            }
        });

        $('#refreshActivity').click(function (e) {
            var url = $('#activity').attr('active-url');
            if (url != '' && url.length > 0) {
                container = $('.ajax-notifications');
                loadMessageURL(url, container);
            }
            e.preventDefault();
        });

        $('#refresh').click(function (e) {
            $.SmartMessageBox({
                title: "<i class='fa fa-refresh' style='color:green'></i> 是否刷新页面",
                content: "刷新页面将会重新加载页面内容！",
                buttons: '[取消][确定]'
            }, function (ButtonPressed) {
                if (ButtonPressed == "确定" && localStorage) {
                    localStorage.clear();
                    location.reload();
                }

            });
            e.preventDefault();
        });

        notification_check();
        // 调整导航高度
        resizeMenuHight();
        // 菜单导航
        $('nav ul').kissmenu({
            accordion: true,
            speed: 235,
            closedSign: '<em class="fa fa-expand-o"></em>',
            openedSign: '<em class="fa fa-collapse-o"></em>'
        });

        // 隐藏菜单
        $('#hide-menu >:first-child > a').click(function (e) {
            $('body').toggleClass("hidden-menu");
            e.preventDefault();
        });
        // 快速导航
        $('#show-shortcut').click(function (e) {
            if ($('#shortcut').is(":visible")) {
                shortcut_buttons_hide();
            } else {
                shortcut_buttons_show();
            }
            e.preventDefault();
        });
        $('#shortcut').find('a').click(function (e) {
            e.preventDefault();
            window.location = $(this).attr('href');
            setTimeout(shortcut_buttons_hide, 300);

        });

        $(document).mouseup(function (e) {
            if (!$('#shortcut').is(e.target) && $('#shortcut').has(e.target).length === 0) {
                shortcut_buttons_hide()
            }
        });

        function shortcut_buttons_hide() {
            $('#shortcut').animate({
                height: "hide"
            }, 300, "easeOutCirc");
            $('body').removeClass('shortcut-on');

        }

        function shortcut_buttons_show() {
            $('#shortcut').animate({
                height: "show"
            }, 200, "easeOutCirc")
            $('body').addClass('shortcut-on');
        }

        // 手机模式下，显示搜索框
        $('#search-mobile').click(function () {
            $('body').addClass('search-mobile');
        });
        $('#cancel-search-js').click(function () {
            $('body').removeClass('search-mobile');
        });

        // 退出系统动作
        $('#logout a').click(function (e) {
            $.SmartMessageBox({
                title: "<i class='fa fa-sign-out txt-color-orangeDark'></i> 退出 <span class='txt-color-orangeDark'><strong>" + $('#show-shortcut').text() + "</strong></span> 账号？",
                content: "您确定安全退出系统？",
                buttons: '[取消][确定]'
            }, function (ButtonPressed) {
                if (ButtonPressed == "确定") {
                    $('body').addClass('animated fadeOutUp');
                    setTimeout(function () {
                        window.location = "/logout";
                    }, 1000);
                }

            });
            e.preventDefault();
        });
    });
    // 菜单插件
    $.fn.extend({
        kissmenu: function (options) {
            var defaults = {
                accordion: 'true',
                speed: 200,
                closedSign: '[+]',
                openedSign: '[-]'
            };
            var opts = $.extend(defaults, options);
            var $this = $(this);
            $this.find("li").each(function () {
                if ($(this).find("ul").size() != 0) {
                    $(this).find("a:first").append("<b class='collapse-sign'>" + opts.closedSign + "</b>");
                    if ($(this).find("a:first").attr('href') == "#") {
                        $(this).find("a:first").click(function () {
                            return false;
                        });
                    }
                }
            });
            $this.find("li.active").each(function () {
                $(this).parents("ul").slideDown(opts.speed);
                $(this).parents("ul").parent("li").find("b:first").html(opts.openedSign);
                $(this).parents("ul").parent("li").addClass("open")
            });
            $this.find("li a").click(function () {
                if ($(this).parent().find("ul").size() != 0) {
                    if (opts.accordion) {
                        if (!$(this).parent().find("ul").is(':visible')) {
                            parents = $(this).parent().parents("ul");
                            visible = $this.find("ul:visible");
                            visible.each(function (visibleIndex) {
                                var close = true;
                                parents.each(function (parentIndex) {
                                    if (parents[parentIndex] == visible[visibleIndex]) {
                                        close = false;
                                        return false;
                                    }
                                });
                                if (close) {
                                    if ($(this).parent().find("ul") != visible[visibleIndex]) {
                                        $(visible[visibleIndex]).slideUp(opts.speed, function () {
                                            $(this).parent("li").find("b:first").html(opts.closedSign);
                                            $(this).parent("li").removeClass("open");
                                        });

                                    }
                                }
                            });
                        }
                    }
                    if ($(this).parent().find("ul:first").is(":visible") && !$(this).parent().find("ul:first").hasClass("active")) {
                        $(this).parent().find("ul:first").slideUp(opts.speed, function () {
                            $(this).parent("li").removeClass("open");
                            $(this).parent("li").find("b:first").delay(opts.speed).html(opts.closedSign);
                        });
                    } else {
                        $(this).parent().find("ul:first").slideDown(opts.speed, function () {
                            $(this).parent("li").addClass("open");
                            $(this).parent("li").find("b:first").delay(opts.speed).html(opts.openedSign);
                        });
                    }
                }
            });
        }
    });
    // 调整导航的高度
    function resizeMenuHight() {
        var setHeight = $('#main').height(),
            menuHeight = $('#left-panel').height(),
            windowHeight = $(window).height() - 49;
        //set height

        if (setHeight > windowHeight) { // if content height exceedes actual window height and menuHeight
            $('#left-panel').css('min-height', setHeight + 'px');
            $('body').css('min-height', setHeight + 49 + 'px');
        } else {
            $('#left-panel').css('min-height', windowHeight + 'px');
            $('body').css('min-height', windowHeight + 'px');
        }
    }

    function shortcut_buttons_hide() {
        $('#shortcut').animate({
            height: "hide"
        }, 300, "easeOutCirc");
        $('body').removeClass('shortcut-on');

    }

    function shortcut_buttons_show() {
        $('#shortcut').animate({
            height: "show"
        }, 200, "easeOutCirc")
        $('body').addClass('shortcut-on');
    }

    function notification_check() {
        $this = $('#activity > .badge');
        if (parseInt($this.text()) > 0) {
            $this.addClass("bg-color-red bounceIn animated")
        }
    }

    function loadMessageURL(url, container) {
        $.ajax({
            type: "GET",
            url: url,
            dataType: 'html',
            cache: true,
            beforeSend: function () {
                container.html('<h1><i class="fa fa-cog fa-spin"></i> 加载中...</h1>');
                container.animate({
                    scrollTop: 0
                }, "fast");
            },
            success: function (data) {
                container.css({
                    opacity: '0.0'
                }).html(data).delay(50).animate({
                    opacity: '1.0'
                }, 300);
                $('#lastActivityTime').html(getNowDateFormat());
            },
            error: function (xhr, ajaxOptions, thrownError) {
                container.html('<h4 style="margin-top:10px; display:block; text-align:left"><i class="fa fa-warning txt-color-orangeDark"></i>对不起，错误404，没有找到相应页面！</h4> <br>');
            },
            async: false
        });
    }

    function getNowDateFormat() {
        var d, s;
        d = new Date();
        s = (1900 + d.getYear()) + "-"; //取年份
        s = s + (d.getMonth() + 1) + "-"; //取月份
        s += d.getDate() + " "; //取日期
        s += d.getHours() + ":"; //取小时
        s += d.getMinutes() + ":"; //取分
        s += d.getSeconds(); //取秒
        return (s);
    }
})