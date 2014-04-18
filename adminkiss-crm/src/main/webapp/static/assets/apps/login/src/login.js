define(function (require, exports) {
    var $ = require("jquery");
    require('jquery-validate');
    require('carousel');
    require('message');
    var m_login = require('./m_login');

    $(document).ready(function () {
        $("#loginForm").validate({
            // 表单验证规则
            rules: {
                username: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 20
                }
            },
            // 表单验证消息
            messages: {
                username: {
                    required: '请输入您的邮箱',
                    email: '请输入正确的邮箱'
                },
                password: {
                    required: '输入您的密码',
                    minlength: '密码长度不能小于6位',
                    maxlength: '密码长度不能大于20位'
                }
            },
            // 错误显示位置
            errorPlacement: function (error, element) {
                error.insertAfter(element.parent());
            },
            submitHandler: function (form) {
                var param = {};
                param['username'] = $('#username').val();
                param['password'] = $('#password').val();
                m_login.doLogin(param, function (data) {
                    if (data['code'] == 1) {
                        $.smallBox({
                            title: "登录成功",
                            content: "<i class='fa fa-bell-o'></i> <i>" + m_login.loginStatus[data['result']] + "</i>",
                            color: "#296191",
                            iconSmall: "fa fa-thumbs-up bounce animated",
                            timeout: 4000
                        });
                        $('body').addClass('animated fadeOutUp');
                        setTimeout(function () {
                            window.location.href = $("#refurl").val();
                        }, 1000);
                    } else {
                        var result = data['result'];
                        $.smallBox({
                            title: "登录失败",
                            content: "<i class='fa fa-bell-o'></i> <i>" + m_login.loginStatus[data['result']] + "</i>",
                            color: "#296191",
                            iconSmall: "fa fa-thumbs-down bounce animated",
                            timeout: 4000
                        });
                    }
                });
            },
        });
    });
});