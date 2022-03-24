/**
 * 检测名字
 * 名字要求是小于或等于20个字符，且没有空白字符，可以任意字符
 * @returns {boolean}
 */
function name_test() {
    var name = document.getElementById("person_name").value;
    // 测试是否存在空白符
    var test = /\s/;
    var flag = test.test(name);
    if(flag == true){
        // 存在空白符
        document.getElementById("person_name_error").innerHTML = "不要空白符哦！";
        return false;
    } else {
        // 强转判断是否为空，不能直接==null判断
        var name_string = name+"";
        if(name_string.length == 0){
            document.getElementById("person_name_error").innerHTML = "不能为空喔！";
            return false;
        }
        // 测试长度是否符合
        if(name_string.length<=20){
            // 正确清空错误提示
            document.getElementById("person_name_error").innerHTML = "";
            return true;
        } else {
            document.getElementById("person_name_error").innerHTML = "格式不对喔！";
            return false;
        }
    }
}



/**
 * 检测是否有设置生日
 * @returns {boolean}
 */
function birthday_test() {
    var birthday = document.getElementById("person_birthday").value;
    // 转换成字符串，判断是否有设置生日，不能使用null判断，无效
    var birthday_string = birthday+"";
    if(birthday_string.length != 0){
        // 正确清空错误提示
        document.getElementById("person_birthday_error").innerHTML = "";
        return true;
    } else {
        document.getElementById("person_birthday_error").innerHTML = "生日要写喔！";
        return false;
    }
}

/**
 * 密码格式判断
 * @returns {boolean}
 */
function start_password_test() {
    var password = document.getElementById("start_password").value;
    // 强转判断是否为空，不能直接==null判断
    var password_string = password+"";
    if(password_string == 0){
        document.getElementById("start_password_error").innerHTML = "不能为空喔！";
        return false;
    }
    var test = /^\w{6,16}$/;
    var flag = test.test(password);
    if(flag == false){
        document.getElementById("start_password_error").innerHTML = "格式不对喔！";
    } else{
        // 正确清空错误提示
        document.getElementById("start_password_error").innerHTML = "";
    }
    return flag;
}

/**
 * 密码格式判断
 * @returns {boolean}
 */
function end_password_test() {
    var password = document.getElementById("end_password").value;
    // 强转判断是否为空，不能直接==null判断
    var password_string = password+"";
    if(password_string == 0){
        document.getElementById("end_password_error").innerHTML = "不能为空喔！";
        return false;
    }
    var test = /^\w{6,16}$/;
    var flag = test.test(password);
    if(flag == false){
        document.getElementById("end_password_error").innerHTML = "格式不对喔！";
    } else{
        // 正确清空错误提示
        document.getElementById("end_password_error").innerHTML = "";
    }
    return flag;
}



/**
 * 检测密码是否相同
 * @returns {boolean}
 */
function confirm_test() {
    var password = document.getElementById("end_password").value;
    var confilm = document.getElementById("confirm_password").value;
    // 强转判断是否为空，不能直接==null判断
    var password_string = password+"";
    var confilm_string = confilm+"";
    if(confilm_string.length == 0){
        document.getElementById("confirm_password_error").innerHTML = "不能为空喔！"
        return false;
    }
    if(password_string.length == 0){
        document.getElementById("end_password_error").innerHTML = "密码框是空喔！";
        return false;
    }
    if(password != null && confilm != null){
        if(password === confilm){
            // 正确清空错误提示
            document.getElementById("confirm_password_error").innerHTML = "";
            return true;
        } else {
            document.getElementById("confirm_password_error").innerHTML = "密码不一致喔！";
            return false;
        }
    }
}


/**
 * 检验文章名字是否符合要求
 * 要求：不能为空，不多于70个字符
 */
function novel_name_test () {
    var name = document.getElementById("title").value;
    // 测试是否存在空白符
    var test = /\s/;
    var flag = test.test(name);
    if(flag == true){
        // 存在空白符
        document.getElementById("title_name_error").innerHTML = "不要空白符哦！";
        return false;
    } else {
        // 强转判断是否为空，不能直接==null判断
        var name_string = name+"";
        if(name_string.length == 0){
            document.getElementById("title_name_error").innerHTML = "不能为空喔！";
            return false;
        }
        // 测试长度是否符合
        if(name_string.length<=70){
            // 正确清空错误提示
            document.getElementById("title_name_error").innerHTML = "";
            return true;
        } else {
            document.getElementById("title_name_error").innerHTML = "格式不对喔！";
            return false;
        }
    }
}

/**
 * 检验文章内容是否符合要求
 * 要求：不能少于100字符，不能多于2000字符
 */
function novel_test () {
    var novel = document.getElementById("novel").value;
    // 强转判断是否为空，不能直接==null判断
    var novel_string = novel+"";
    if(novel_string.length == 0){
        document.getElementById("novel_error").innerHTML = "不能为空喔！";
        return false;
    } else if (novel_string.length < 100) {
        document.getElementById("novel_error").innerHTML = "字数不足！";
        return false;
    } else if(novel_string.length<=2000){
        document.getElementById("novel_error").innerHTML = "";
        return true;
    } else {
        document.getElementById("novel_error").innerHTML = "字数太多！";
        return false;
    }
}


/**
 * 检验文章标签是否符合要求
 * 要求：不能少于2字符，不能多于10字符
 */
function label_test () {
    var labelOne = document.getElementById("label_one").value;
    var labelTwo = document.getElementById("label_two").value;
    var labelThree = document.getElementById("label_three").value;
    // 强转判断是否为空，不能直接==null判断
    var labelOne_string = labelOne+"";
    var labelTwo_string = labelTwo+"";
    var labelThree_string = labelThree+"";
    if( labelOne_string.length == 0 || labelTwo_string.length == 0 || labelThree_string.length ==0 ){
        document.getElementById("label_error").innerHTML = "不能有空喔！";
        return false;
    } else if (labelOne_string.length < 2 || labelTwo_string.length < 2 || labelThree_string.length < 2) {
        document.getElementById("label_error").innerHTML = "字数太少！";
        return false;
    } else if(labelOne_string.length > 10 || labelTwo_string.length > 10 || labelThree_string.length > 10){
        document.getElementById("label_error").innerHTML = "字数太多！";
        return false;
    } else {
        document.getElementById("label_error").innerHTML = "";
        return true;
    }
}