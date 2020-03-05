function request_ajax(url, data, type) {

    $.ajax({
        //async: false,
        url: url,
        data: data,
        type: type,
        dataType: "JSON",
        success: function (data) {
            //alert('data:'+typeof(data));
            $("#textareaid").text(formatJson(JSON.stringify(data)));
        },
        error: function (jqXHR, textStatus, errorThrown) {
            $("#textareaid").text(formatJson(jqXHR.responseText));
        }
    });
}

//发送contentType: "application/json" 请求用
function request_ajax_json(url, data, type) {
    // console.log(data);
    $.ajax({
        //async: false,
        url: url,
        data: data,
        type: type,
        contentType: "application/json",
        dataType: "JSON",
        success: function (data) {
            //alert('data:'+typeof(data));
            $("#textareaid").text(formatJson(JSON.stringify(data)));

        },
        error: function (jqXHR, textStatus, errorThrown) {
            $("#textareaid").text(formatJson(jqXHR.responseText));
        }
    });
}

//获取微服务token和单点登录token 专用
function request_ajax_token(url, data, type, get_token_type) {

    $.ajax({
        //async: false,
        url: url,
        data: data,
        type: type,
        dataType: "JSON",
        success: function (data) {
            //alert('data:'+typeof(data));
            $("#textareaid").text(formatJson(JSON.stringify(data)));
            $("#" + get_token_type).text(data.access_token);
            // result = data;
        },
        error: function (error) {
            $("#textareaid").text(formatJson(JSON.stringify(error)));
            //   result = data;
        }
    });

}

function get_m_token() {//1.2.1获取微服务access_token
    var ip = $("#ip").val();
    //console.log(ip)
    var port = $("#port").val();
    //console.log(port)
    var appid = $("#appid").val();
    var secret = $("#secret").val();
    // var url = 'http://'+ip+':'+port+'/api/uaa/oauth/token?client_id='+appid+'&client_secret='+secret+'&grant_type=client_credentials';
    var url = 'getToken?client_id=' + appid + '&client_secret=' + secret;
    request_ajax_token(url, '{}', 'POST', 'microservice_token');

}

function get_sso_token() {//2.2.1获取单点登录access_token
    var ip = $("#ip").val();

    var port = $("#port").val();
    var username = $("#sso_username").val();
    var password = $("#sso_password").val();
    var loginMode = $("#sso_loginmodel").val();
    var service = $("#sso_service").val();
    var url = '/getSso';
    // var url = 'http://' + ip + ':' + port + '/api/sso/authen';
    var body = {username: username, password: password, loginMode: loginMode, service: service};
    request_ajax_token(url, body, 'POST', 'sso_token');
}

function get_sso_user() { //2.2.2获取单点登录用户信息
    var ip = $("#ip").val();
    var port = $("#port").val();
    var url = '/getSsoInfo';
    // var url = 'http://'+ip+':'+port+'/api/sso/user';
    var body = {access_token: $('label#sso_token').text()};
    request_ajax(url, body, 'POST');
}

function valid_sso_token() { //2.2.3验证token
    var ip = $("#ip").val();
    var port = $("#port").val();
    // var token =$('label#sso_token').text();
    // console.log(token);
    // var url = 'http://'+ip+':'+port+'/api/sso/valtoken/'+$('label#sso_token').text();
    var url = '/checkToken/';
    var body = {access_token: $('label#sso_token').text()};
    request_ajax(url, body, 'POST');
}

function refresh_sso_token() {//2.2.4刷新单点登录token有效期
    var ip = $("#ip").val();
    var port = $("#port").val();
    var url = '/refresh';
    // var url = 'http://'+ip+':'+port+'/api/sso/refresh/'+$('label#sso_token').text();
    var body = {access_token: $('label#sso_token').text()};
    request_ajax(url, body, 'POST');
}

function sso_password() { //2.2.5修改密码
    var ip = $("#ip").val();
    var port = $("#port").val();
    var username = $("#sso_username").val();
    var old_password = $("#sso_old_password").val();
    var new_password = $("#sso_new_password").val();
    var re_password = $("#sso_re_password").val();
    var url = '/token/updatePassword';
    // var url = 'http://'+ip+':'+port+'/api/sso/password';
    var body = {userName: username, oldPassword: old_password, newPassword: new_password, repassword: re_password};
    request_ajax(url, body, 'POST');
}

function sso_oapassword() { //2.2.5修改密码
    var ip = $("#ip").val();
    var port = $("#port").val();
    var username = $("#sso_username").val();
    var old_password = $("#sso_old_password").val();
    var new_password = $("#sso_new_password").val();
    var re_password = $("#sso_re_password").val();
    var url = '/token/updateoaPassword';
    // var url = 'http://'+ip+':'+port+'/api/sso/password';
    var body = {userName: username, oldPassword: old_password, newPassword: new_password, repassword: re_password};
    request_ajax(url, body, 'POST');
}

function logou_sso() {//2.2.6注销单点登录token
    var url =  '/logout' ;
    var body = {access_token: $('label#sso_token').text()};
    request_ajax(url, body, 'POST');
}

function get_deparement_list() {//3.2.1获取部门列表
    var ip = $("#ip").val();
    var port = $("#port").val();
    var isSublevel = '';
    var isInvalid = '';
    var departmentid = $("#m_departmentid").val();
    if ($('#sublevel').is(':checked')) {
        isSublevel = 'true';
    }
    if ($('#invalid').is(':checked')) {
        isInvalid = 'true';
    }
    var url = '/getDepartmentList';
    // var url = 'http://'+ip+':'+port+'/api/org/department/'+departmentid+'/subdepartments?access_token='+$('label#microservice_token').text()+param;
    var body = {
        access_token: $('label#microservice_token').text(),
        departmentid: departmentid,
        isSublevel: isSublevel,
        isInvalid: isInvalid
    };
    request_ajax(url, body, 'GET');
}

function get_more_department_list() {//3.2.2获取多部门列表
    var ip = $("#ip").val();
    var port = $("#port").val();
    var isSublevel = '';
    var isInvalid = '';
    var departmentid = $("#m_departmentid").val();
    if ($('#sublevel').is(':checked')) {
        isSublevel = 'true';
    }
    if ($('#invalid').is(':checked')) {
        isInvalid = 'true';
    }
    var url = '/getDepartmentList';
    // var url = 'http://'+ip+':'+port+'/api/org/department/'+departmentid+'/subdepartments?access_token='+$('label#microservice_token').text()+param;
    var body = {
        access_token: $('label#microservice_token').text(),
        departmentid: departmentid,
        isSublevel: isSublevel,
        isInvalid: isInvalid
    };
    request_ajax(url, body, 'GET');
}

function get_department_info() {//3.2.3获取部门详情
    var ip = $("#ip").val();
    var port = $("#port").val();

    var departmentid = $("#m_departmentid").val();

    var url = '/getDepartmentDetail';
    // var url = 'http://'+ip+':'+port+'/api/org/department/'+departmentid+'?access_token='+$('label#microservice_token').text();
    var body = {access_token: $('label#microservice_token').text(), departmentid: departmentid};
    request_ajax(url, body, 'GET');
}

function get_user_list() {//3.2.4获取人员列表
    var ip = $("#ip").val();
    var port = $("#port").val();
    var isSublevel = '';
    var isInvalid = '';
    var departmentid = $("#m_departmentid").val();
    if ($('#sublevel').is(':checked')) {
        isSublevel = 'true';
    }
    if ($('#invalid').is(':checked')) {
        isInvalid = 'true';
    }
    var url = '/getPersonList';
    // var url = 'http://'+ip+':'+port+'/api/org/department/'+departmentid+'/userinfos?access_token='+$('label#microservice_token').text()+param;
    var body = {
        access_token: $('label#microservice_token').text(),
        departmentid: departmentid,
        isSublevel: isSublevel,
        isInvalid: isInvalid
    };
    request_ajax(url, body, 'GET');
}

function get_userinfoByAccount() { //3.2.5获取人员详情(根据account)
    var ip = $("#ip").val();
    var port = $("#port").val();

    var account = $("#m_userid").val();

    var url = '/getPersonDetailByAccount';
    // var url = 'http://'+ip+':'+port+'/api/org/userinfo/'+userid+'?access_token='+$('label#microservice_token').text();
    var body = {access_token: $('label#microservice_token').text(), account: account};
    request_ajax(url, body, 'GET');
}

function get_userinfoById() { //3.2.6获取人员详情（根据id）
    var ip = $("#ip").val();
    var port = $("#port").val();

    var userid = $("#m_userid").val();

    var url = '/getPersonDetailById';
    // var url = 'http://'+ip+':'+port+'/api/org/userinfo/'+userid+'?access_token='+$('label#microservice_token').text();
    var body = {access_token: $('label#microservice_token').text(), id: userid};
    request_ajax(url, body, 'GET');
}

function sync() {//3.2.7增量同步接口
    var ip = $("#ip").val();
    var port = $("#port").val();
    var param = '';
    var starttime = $("#starttime").val();
    param = '&starttime=' + starttime;
    var departmentid = $("#m_departmentid").val();
    if (null !== departmentid || departmentid !== undefined || departmentid !== '') {
        param = param + '&department=' + departmentid;
    }
    var url = '/IncrSyn';
    // var url = 'http://'+ip+':'+port+'/api/org/syncdepartments?access_token='+$('label#microservice_token').text()+param;
    var body = {access_token: $('label#microservice_token').text(), starttime: starttime, department: departmentid};
    request_ajax(url, body, 'GET');
}

function msg_one_user() {//4.3.1发送消息至个人
    var ip = $("#ip").val();
    var port = $("#port").val();

    var userid = $("#m_userid").val();
    var m_content = $("#m_content").val();

    var url = '/sendPerson';
    // var url = 'http://'+ip+':'+port+'/api/msg/message/user/'+userid+'?access_token='+$('label#microservice_token').text();
    var body = {access_token: $('label#microservice_token').text(), userid: userid, content: m_content};
    request_ajax(url, body, 'POST');
}

function msg_more_user() { //4.3.2.发送消息至多人
    var ip = $("#ip").val();
    var port = $("#port").val();

    var userid = $("#m_userid").val();
    var m_content = $("#m_content").val();

    var url = '/sendPerson';
    // var url = 'http://'+ip+':'+port+'/api/msg/message/user/'+userid+'?access_token='+$('label#microservice_token').text();
    var body = {access_token: $('label#microservice_token').text(), userid: userid, content: m_content};
    request_ajax(url, body, 'POST');
}

function msg_one_department() {//4.3.3.发送消息至部门
    var ip = $("#ip").val();
    var port = $("#port").val();

    var m_departmentid = $("#m_departmentid").val();
    var m_content = $("#m_content").val();
    var url = '/sendDepartment';
    // var url = 'http://' + ip + ':' + port + '/api/msg/message/department/' + m_departmentid + '?access_token=' + $('label#microservice_token').text();
    var body = {access_token: $('label#microservice_token').text(), departmentid: m_departmentid, content: m_content};
    request_ajax(url, body, 'POST');
}

function msg_more_department() {//4.3.4.发送消息至多部门
    var ip = $("#ip").val();
    var port = $("#port").val();

    var m_departmentid = $("#m_departmentid").val();
    var m_content = $("#m_content").val();

    var url = '/sendDepartment';
    // var url = 'http://' + ip + ':' + port + '/api/msg/message/department/' + m_departmentid + '?access_token=' + $('label#microservice_token').text();
    var body = {access_token:$('label#microservice_token').text(), departmentid: m_departmentid, content: m_content};
    request_ajax(url, body, 'POST');
}

function add_log() {//5.1.增加日志操作
    var ip = $("#ip").val();
    var port = $("#port").val();

    var log_detail = $('#logdetail').val();
    // console.log(log_detail);
    // var log_json=$.parseJSON(log_detail);
    // console.log(log_detail);

    var  url = '/addlog';
    // var url = 'http://' + ip + ':' + port + '/api/log/addlog?access_token=' + $('label#microservice_token').text();
    var body ={access_token:$('label#microservice_token').text(),content:log_detail};
    request_ajax(url, body, 'POST');
}

function get_log1() {//5.2.查询日志（条件一）
    var ip = $("#ip").val();
    var port = $("#port").val();
    var userid = $("#m_userid").val();
    var starttime = $("#log_starttime").val();
    var endtime = $("#log_endtime").val();

    var  url = '/getlogs';
    // var url = 'http://' + ip + ':' + port + '/api/log/' + userid + '/getlogs?access_token=' + $('label#microservice_token').text() + '&starttime=' + starttime + '&endtime=' + endtime;
    // console.log(url);
    var body ={access_token:$('label#microservice_token').text(),useraccount:userid,starttime:starttime,endtime:endtime};
    request_ajax(url, body, 'GET');
}

function get_log2() {//5.3.查询日志（条件二）
    var ip = $("#ip").val();
    var port = $("#port").val();
    var appid = $("#log_appid").val();
    var starttime = $("#log_starttime").val();
    var endtime = $("#log_endtime").val();
    var url = '/getloginfo';
    // var url = 'http://' + ip + ':' + port + '/api/log/' + appid + '/getloginfo?access_token=' + $('label#microservice_token').text() + '&starttime=' + starttime + '&endtime=' + endtime;
    var body ={access_token:$('label#microservice_token').text(),appid:appid,starttime:starttime,endtime:endtime};
    request_ajax(url, body, 'GET');
}
function get_log3() {//5.3.查询日志（条件三）
    var ip = $("#ip").val();
    var port = $("#port").val();
    var appid = $("#log_appid").val();
    var starttime = $("#log_starttime").val();
    var endtime = $("#log_endtime").val();
    var url = '/getplatformlogs';
    // var url = 'http://' + ip + ':' + port + '/api/log/' + appid + '/getloginfo?access_token=' + $('label#microservice_token').text() + '&starttime=' + starttime + '&endtime=' + endtime;
    var body ={access_token:$('label#microservice_token').text(),appid:appid,starttime:starttime,endtime:endtime};
    request_ajax(url, body, 'GET');
}
function search() {//6.1.获取应用基本信息
    var ip = $("#ip").val();
    var port = $("#port").val();
    var param = '';
    var arch = $("#search_arch").val();
    var apps = $("#search_apps").val();
    var time = $("#search_time").val();
    var token = $("#search_token").val();
    if (null !== arch || arch !== undefined || arch !== '') {
        param = param + '&arch=' + arch;
    }
    if (null !== apps || apps !== undefined || apps !== '') {
        param = param + '&apps=' + apps;
    }
    if (null !== time || time !== undefined || time !== '') {
        param = param + '&time=' + time;
    }
    var url = 'http://' + ip + ':' + port + '/api/search/apps?token=' + token + param;
    // var body={content:m_content};
    request_ajax(url, '{}', 'GET');
}

function subscribe_add() {//6.1添加订阅信息
    var ip = $("#ip").val();
    var port = $("#port").val();

    var subscribe_detail = $('#subscribe_detail').val();
    // var subscribe_json=$.parseJSON(subscribe_detail);
    var url ='/addSubscribe';
    // var url = 'http://' + ip + ':' + port + '/api/subscribe/add?access_token=' + $('label#microservice_token').text();
    var body={access_token:$('label#microservice_token').text(),content:subscribe_detail};
    request_ajax(url, body, 'POST');
}

function subscribe_delete() {//6.2.删除订阅信息
    var ip = $("#ip").val();
    var port = $("#port").val();

    var subscribe_delete_detail = $('#subscribe_delete_detail').val();
    // var body=$.parseJSON(subscribe_delete_detail);
    var url = '/DelSubscribe';
    // var url = 'http://' + ip + ':' + port + '/api/subscribe/delete?access_token=' + $('label#microservice_token').text();
    var body={access_token:$('label#microservice_token').text(),content:subscribe_delete_detail};
    request_ajax(url, body, 'POST');
}

function subscribe_user() {//6.3.查询用户的订阅信息
    var ip = $("#ip").val();
    var port = $("#port").val();

    var userid = $("#search_userid").val();
    var limit = $("#search_limit").val();
    var page = $("#search_page").val();

    var url = '/findAll';
    // var url = 'http://' + ip + ':' + port + '/api/subscribe/findAll?access_token=' + $('label#microservice_token').text() + '&id=' + userid + '&page=' + page + '&limit=' + limit;
    var body={access_token:$('label#microservice_token').text(),id:userid,limit:limit,page:page};
    request_ajax(url, body, 'GET');
}

function subscribe_article_user() {//6.4.查询用户是否订阅了该文章
    var ip = $("#ip").val();
    var port = $("#port").val();

    var userid = $("#search_userid").val();
    var articleId = $("#search_articleid").val();
    var url = '/find';
    // var url = 'http://' + ip + ':' + port + '/api/subscribe/find?access_token=' + $('label#microservice_token').text() + '&userId=' + userid + '&articleId=' + articleId;
    var body={access_token:$('label#microservice_token').text(),userId:userid,articleId:articleId};
    request_ajax(url, body, 'GET');
}


