define(function (require, exports, module) {
    var $ = require("jquery");
    //公司账号唯一性验证
    exports.doLogin = function (param, callback) {
        $.ajax({
            type: "POST",
            url: "/doLogin",
            dataType: "json",
            data: param,
            success: function (data) {
                callback(data);
            }
        });
    };

    exports.loginStatus = {
        0: '用户名或密码不正确',
        1: '登录成功',
        2: '用户名或密码为空',
        3: '登录用户不存在',
        4: '您的账号不可用',
        5: '账号已冻结，请30分钟后再登录',
        6: '账号在其他地方登录'
    };

});