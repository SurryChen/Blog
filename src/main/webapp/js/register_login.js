/**
 * 下面是关于注册校验的方法
 */

/**
 * 检测名字
 * 名字要求是小于或等于20个字符，且没有空白字符，可以任意字符，不能为空
 * @returns {boolean}
 */
function name_test() {
    var name = document.getElementById("name").value;
    // 测试是否存在空白符
    var test = /\s/;
    var flag = test.test(name);
    if(flag == true){
        // 存在空白符
        document.getElementById("name_error").innerHTML = "不要空白符哦！";
        return false;
    } else {
        // 强转判断是否为空，不能直接==null判断
        var name_string = name+"";
        if(name_string.length == 0){
            document.getElementById("name_error").innerHTML = "不能为空喔！";
            return false;
        }
        // 测试长度是否符合
        if(name_string.length<=20){
            // 正确清空错误提示
            document.getElementById("name_error").innerHTML = "";
            return true;
        } else {
            document.getElementById("name_error").innerHTML = "格式不对喔！";
            return false;
        }
    }
}

/**
 * 检测账号
 * 要求是多于或等于6个数字，少于或等于12个数字，只能是数字
 * @returns {boolean}
 */
function account_test() {
    var account = document.getElementById("register_account").value;
    // 强转判断是否为空，不能直接==null判断
    var account_string = account+"";
    if(account_string.length == 0){
        document.getElementById("account_register_error").innerHTML = "不能为空喔！";
        return false;
    }
    var test = /^\d{6,12}$/;
    var flag = test.test(account);
    if(flag == false){
        document.getElementById("account_register_error").innerHTML = "格式不对喔！";
    } else{
        // 正确清空错误提示
        document.getElementById("account_register_error").innerHTML = "";
    }
    return flag;
}

/**
 * 检测密码
 * 大于或等于6个字符，小于或等于16个字符
 * @returns {boolean}
 */
function password_test() {
    var password = document.getElementById("register_password").value;
    // 强转判断是否为空，不能直接==null判断
    var password_string = password+"";
    if(password_string == 0){
        document.getElementById("password_register_error").innerHTML = "不能为空喔！";
        return false;
    }
    var test = /^\w{6,16}$/;
    var flag = test.test(password);
    if(flag == false){
        document.getElementById("password_register_error").innerHTML = "格式不对喔！";
    } else{
        // 正确清空错误提示
        document.getElementById("password_register_error").innerHTML = "";
    }
    return flag;
}

/**
 * 检测密码是否相同
 * 下面用了比较多的return，不好
 * @returns {boolean}
 */
function confirm_test() {
    var password = document.getElementById("register_password").value;
    var confilm = document.getElementById("confirm").value;
    // 强转判断是否为空，不能直接==null判断
    var password_string = password+"";
    var confilm_string = confilm+"";
    if(confilm_string.length == 0){
        document.getElementById("confirm_error").innerHTML = "不能为空喔！"
        return false;
    }
    if(password_string.length == 0){
        document.getElementById("confirm_error").innerHTML = "密码框是空喔！";
        return false;
    }
    if(password != null && confilm != null){
        if(password === confilm){
            // 正确清空错误提示
            document.getElementById("confirm_error").innerHTML = "";
            return true;
        } else {
            document.getElementById("confirm_error").innerHTML = "密码不一致喔！";
            return false;
        }
    }
}








/**
 * 检测是否有设置生日
 * @returns {boolean}
 */
function birthday_test() {
    var birthday = document.getElementById("birthday").value;
    // 转换成字符串，判断是否有设置生日，不能使用null判断，无效
    var birthday_string = birthday+"";
    if(birthday_string.length != 0){
        // 正确清空错误提示
        document.getElementById("birthday_error").innerHTML = "";
        return true;
    } else {
        document.getElementById("birthday_error").innerHTML = "生日要写喔！";
        return false;
    }
}


/**
 * 下面是关于登录的方法
 */

/**
 * 主要目的是先进行格式判断，不要直接传入到服务器判断，浪费时间
 * @returns {boolean}
 */
function account_login_test() {
    var account = document.getElementById("login_account").value;
    // 强转判断是否为空，不能直接==null判断
    var account_string = account+"";
    if(account_string.length == 0){
        document.getElementById("account_login_error").innerHTML = "不能为空喔！";
        return false;
    }
    var test = /^\d{6,12}$/;
    var flag = test.test(account);
    if(flag == false){
        document.getElementById("account_login_error").innerHTML = "账号格式不对！";
    } else{
        // 正确清空错误提示
        document.getElementById("account_login_error").innerHTML = "";
    }
    return flag;
}

/**
 * 先进行密码格式判断
 * @returns {boolean}
 */
function password_login_test() {
    var password = document.getElementById("login_password").value;
    // 强转判断是否为空，不能直接==null判断
    var password_string = password+"";
    if(password_string == 0){
        document.getElementById("password_login_error").innerHTML = "不能为空喔！";
        return false;
    }
    var test = /^\w{6,16}$/;
    var flag = test.test(password);
    if(flag == false){
        document.getElementById("password_login_error").innerHTML = "格式不对喔！";
    } else{
        // 正确清空错误提示
        document.getElementById("password_login_error").innerHTML = "";
    }
    return flag;
}