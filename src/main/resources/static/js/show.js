

function todo() {
    window.__set_todo_count__(5);
}

function get_m_token_show(apiname){ //1.2.1获取微服务access_token
 
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>获取微服务access_token</p></b>'
		+'<p>1、接口说明</p>'
		+'<p style="text-indent:2em;">各众创应用在调用平台提供的核心服务接口（除登录服务外）时，需携带微服务access_token以便通过认证从而获取返回信息。该access_token表示应用的身份，是应用的全局唯一凭证，需通过应用id（client_id）及秘钥（client_secret）调用获取微服务access_token接口获得。</p>'
		+'<p style="text-indent:2em;">其中，应用id（client_id）及秘钥（client_secret）需向平台统一申请。</p>'
		+'<p>2、接口测试</p>'
		+'<input type="submit"   value="测试" onclick="get_m_token()" style=""/><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入appid :</label></td>'
		+'<td><input  id="appid" type="text" value="legacycpk.csse.cms"   style="width:500px;"  value="" /></td></tr>'
		+'<tr><td><label>请输入secret: </label></td>'
		+'<td><input  id="secret" type="text"  value="test123"  style="width:500px;"  value="" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';


 }
 function get_sso_token_show(apiname){ //2.2.1获取单点登录access_token
	var div = document.getElementById("content");
			
	div.innerHTML ='<b><p>获取单点登录access_token</p></b>'
		+'<p>1、接口说明</p>'
		+'<p style="text-indent:2em;">各个众创应用在获取到单点登录token后，需先调用验证token接口，验证该token的合法性，若token合法则表示登录成功，实现免等操作。具体登录的人员信息，可通过调用获取用户信息接口获得。</p>'
		+'<p style="text-indent:2em;">验证token相关说明：</p>'
		+'<p style="text-indent:4em;">1）桌面应用在token到期前自动续租保持不变；</p>'
		+'<p style="text-indent:4em;">2）桌面崩溃后，通过桌面守护进程自动重启，启动完成后继续使用之前有效的token；</p>'
		+'<p style="text-indent:4em;">3）桌面守护进程崩溃了，提示桌面发生重大错误，需要重新登录，强制退出所有app，再次登录，获取新的有效token；</p>'
		+'<p style="text-indent:4em;">4）桌面会定期刷新验证token有效性。</p>'
		+'<p>2、接口测试</p>'
		+'<input type="submit"   value="测试" onclick="get_sso_token()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入用用户账号 :</label></td>'
		+'<td><input  id="sso_username" type="text"  style="width:500px;"  value="sysadmin" /></td></tr>'
		+'<tr><td><label>请输入密码 :</label></td>'
		+'<td><input  id="sso_password" type="text"   style="width:500px;"  value="password02!" /></td></tr>'
		+'<tr><td><label>请输入登录模式:</label></td>'
		+'<td><input  id="sso_loginmodel" type="text"   style="width:500px;"  value="100" /></td></tr>'
		+'<tr><td><label>请输入service地址:</label></td>'
		+'<td><input  id="sso_service" type="text"   style="width:500px;"  value="172.16.5.200:10004/zrsso51/index.html" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';


 }
 function get_sso_user_show(apiname){  //2.2.2获取单点登录用户信息
	var div = document.getElementById("content");
			
	div.innerHTML ='<b><p>获取单点登录用户信息</p></b>'
		+'<input type="submit"   value="测试" onclick="get_sso_user()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function valid_sso_token_show(apiname){  //2.2.3验证token
	var div = document.getElementById("content");
			
	div.innerHTML ='<b><p>验证token</p></b>'
		+'<input type="submit"   value="测试" onclick="valid_sso_token()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function refresh_sso_token_show(apiname){ //2.2.4刷新单点登录token有效期
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>刷新单点登录token有效期</p></b>'
		+'<input type="submit"   value="测试" onclick="refresh_sso_token()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function change_sso_password_show(apiname){  //2.2.5修改密码
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>修改密码</p></b>'
		+'<input type="submit"   value="测试" onclick="sso_password()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入用户账号:</label></td>'
		+'<td><input  id="sso_username" type="text"   style="width:500px;"  value="" /></td></tr>'
		+'<tr><td><label>请输入旧密码:</label></td>'
		+'<td><input  id="sso_old_password" type="text"   style="width:500px;"  value="" /></td></tr>'
		+'<tr><td><label>请输入新密码:</label></td>'
		+'<td><input  id="sso_new_password" type="text"   style="width:500px;"  value="" /></td></tr>'
		+'<tr><td><label>请重复新密码:</label></td>'
		+'<td><input  id="sso_re_password" type="text"   style="width:500px;"  value="" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function logou_sso_show(apiname){//2.2.6注销单点登录token
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>注销单点登录token</p></b>'
		+'<input type="submit"   value="测试" onclick="logou_sso()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_deparement_list_show(apiname){ //3.2.1获取部门列表
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>获取部门列表</p></b>'
		+'<input type="submit"   value="测试" onclick="get_deparement_list()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入部门id：</label></td>'
		+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></td></tr>'
		+'<tr><td><label>是否包含子级和无效数据：</label></td>'
		+'<td><input type="checkbox" id="sublevel"  /><label>包含子级(sublevel)</label><input type="checkbox" id="invalid"  /><label>包含无效数据(invalid)</label></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_more_department_list_show(apiname){ //3.2.2获取多部门列表
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>获取部门列表</p></b>'
		+'<input type="submit"   value="测试" onclick="get_more_department_list()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入部门id：</label></td>'
		+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="a29211c1-211f-4c2a-8747-1905055ec6d0,root" /><label>(id之间以,符号隔开)</label></td></tr>'
		+'<tr><td><label>是否包含子级和无效数据：</label></td>'
		+'<td><input type="checkbox" id="sublevel"  /><label>包含子级(sublevel)</label><input type="checkbox" id="invalid"  /><label>包含无效数据(invalid)</label></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_department_info_show(apiname){ //3.2.3获取部门详情
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>获取部门详情</p></b>'
		+'<input type="submit"   value="测试" onclick="get_department_info()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入部门id：</label></td>'
		+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_user_list_show(apiname){ //3.2.4获取人员列表
	var div = document.getElementById("content");
			
	div.innerHTML ='<b><p>获取人员列表</p></b>'
		+'<input type="submit"   value="测试" onclick="get_user_list()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入部门id：</label></td>'
		+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></td></tr>'
		+'<tr><td><label>是否包含子级和无效数据：</label></td>'
		+'<td><input type="checkbox" id="sublevel"  /><label>包含子级(sublevel)</label><input type="checkbox" id="invalid"  /><label>包含无效数据(invalid)</label></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_userinfoByAccount_show(apiname){  //3.2.5获取人员详情（根据account）
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>获取人员详情（根据account）</p></b>'
		+'<input type="submit"   value="测试" onclick="get_userinfoByAccount()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入人员在账号：</label></td>'
		+'<td><input  id="m_userid" type="text"   style="width:500px;"  value="sysadmin" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
function get_userinfo_show(apiname){  //3.2.6获取人员详情
    var div = document.getElementById("content");

    div.innerHTML ='<b><p>获取人员详情</p></b>'
		+'<input type="submit"   value="测试" onclick="get_userinfoById()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入人员id：</label></td>'
		+'<td><input  id="m_userid" type="text"   style="width:500px;"  value="1" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

}
 function sync_show(apiname){ //3.2.7增量同步接口
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>获取人员详情</p></b>'
		+'<input type="submit"   value="测试" onclick="sync()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入starttime：</label></td>'
		+'<td><input  id="starttime" type="text"   style="width:500px;"  value="1512727052" /></td></tr>'
		+'<tr><td><label>请输入部门id：</label></td>'
		+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /><label>(部门id可选填)</label></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function msg_one_user_show(apiname) { //4.3.1发送消息至个人
	 var div = document.getElementById("content");
	 var content_demo = '{"appid":"legacycpk.csse.cms","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
	 div.innerHTML = '<b><p>发送消息至个人</p></b>'
		 + '<input type="submit"   value="测试" onclick="msg_one_user()" /><br><br>'
		 + '<table class="table table-striped table-bordered table-hover">'
		 + '<tr><td><label>请输入人员id：</label></td>'
		 + '<td><input  id="m_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></td></tr>'
		 + '<tr><td><label>请输入消息内容：</label></td>'
		 + '<td><input  id="m_content" type="text"   style="width:500px;"  value=' + content_demo + ' /></td></tr>'
		 + '<tr><td><label>返回结果</label></td>'
		 + '<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

 }
 function msg_more_user_show(apiname){  //4.3.2.发送消息至多人
	var div = document.getElementById("content");
	var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
	div.innerHTML ='<b><p>发送消息至多人</p></b>'
		+'<input type="submit"   value="测试" onclick="msg_more_user()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入人员id：</label></td>'
		+'<td><input  id="m_userid" type="text"   style="width:500px;"  value="1,3c88f676-8699-4c40-a436-3d220453e5a4" /><label>(id之间以,符号隔开)</label></td></tr>'
		+'<tr><td><label>请输入消息内容：</label></td>'
		+'<td><input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

 }
 function msg_one_department_show(apiname){ //4.3.3.发送消息至部门
	var div = document.getElementById("content");
	var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
	div.innerHTML ='<b><p>发送消息至部门</p></b>'
		+'<input type="submit"   value="测试" onclick="msg_one_department()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入部门id：</label></td>'
		+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></td></tr>'
		+'<tr><td><label>请输入消息内容：</label></td>'
		+'<td><input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function msg_more_department_show(apiname){ //4.3.4.发送消息至多部门
		var div = document.getElementById("content");
		var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
		div.innerHTML ='<b><p>发送消息至多部门</p></b>'
			+'<input type="submit"   value="测试" onclick="msg_more_department()" /><br><br>'
			+'<table class="table table-striped table-bordered table-hover">'
			+'<tr><td><label>请输入多个部门id：</label></td>'
			+'<td><input  id="m_departmentid" type="text"   style="width:500px;"  value="root,a29211c1-211f-4c2a-8747-1905055ec6d0" /><label>(id之间以,符号隔开)</label></td></tr>'
			+'<tr><td><label>请输入消息内容：</label></td>'
			+'<td><input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></td></tr>'
			+'<tr><td><label>返回结果</label></td>'
			+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

 }
 function add_log_show(apiname){ //5.1.增加日志操作
	var div = document.getElementById("content");
	var test_log='{'
		+	'"useraccount":"sysadmin",'
		+	'"appname": "ceshi",'
		+	'"appid": "client",'
		+	'"appip": "10.55.10.65",'
		+	'"clientip":"10.55.30.1",'
		+	'"currenttime":"1470154736000",'
		+	'"systemid":"单点登录系统123123",'
		+	'"functionname":"单点登录",'
		+	'"success":"1",'
		+	'"objectid":"admin",'
		+	'"classname":"55",'
		+	'"methodname":"55",'
		+	'"codeLine":16,'
		+	'"description":"do something",'
		+	'"tag":"5",'
		+	'"callbackurl":"http://localhost:8080"'
		+	'}'	;

	div.innerHTML ='<b><p>增加日志操作</p></b>'

		+'<input type="submit"   value="测试" onclick="add_log()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入日志内容：</label></td>'
		+'<td><textarea id="logdetail" rows="10" cols="80"   />'+test_log+'</textarea></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

 }
 function get_log1_show(apiname){ //8.2.2　根据用户名审计应用日志
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>根据用户名审计应用日志</p></b>'
		+'<input type="submit"   value="测试" onclick="get_log1()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入用户账号：</label></td>'
		+'<td><input  id="m_userid" type="text"   style="width:500px;"  value="sysadmin" /></td></tr>'
		+'<tr><td><label>请输入开始时间：</label></td>'
		+'<td><input  id="log_starttime" type="text"   style="width:500px;"  value="1470154736000" /></td></tr>'
		+'<tr><td><label>请输入结束时间：</label></td>'
		+'<td><input  id="log_endtime" type="text"   style="width:500px;"  value="1570154736000" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_log2_show(apiname){ //根据应用标识审计应用日志
	var div = document.getElementById("content");

	div.innerHTML ='<b><p>根据应用标识审计应用日志</p></b>'
		+'<input type="submit"   value="测试" onclick="get_log2()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入appid：</label></td>'
		+'<td><input  id="log_appid" type="text"   style="width:500px;"  value="legacycpk.csse.cms" /></td></tr>'
		+'<tr><td><label>请输入开始时间：</label></td>'
		+'<td><input  id="log_starttime" type="text"   style="width:500px;"  value="1470154736000" /></td></tr>'
		+'<tr><td><label>请输入结束时间：</label></td>'
		+'<td><input  id="log_endtime" type="text"   style="width:500px;"  value="1570154736000" /></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function get_log3_show(apiname){ //根据应用标识审计平台日志
	 var div = document.getElementById("content");

	 div.innerHTML ='<b><p>根据应用标识审计平台日志</p></b>'
		 +'<input type="submit"   value="测试" onclick="get_log3()" /><br><br>'
		 +'<table class="table table-striped table-bordered table-hover">'
		 +'<tr><td><label>请输入appid：</label></td>'
		 +'<td><input  id="log_appid" type="text"   style="width:500px;"  value="legacycpk.csse.cms" /></td></tr>'
		 +'<tr><td><label>请输入开始时间：</label></td>'
		 +'<td><input  id="log_starttime" type="text"   style="width:500px;"  value="1470154736000" /></td></tr>'
		 +'<tr><td><label>请输入结束时间：</label></td>'
		 +'<td><input  id="log_endtime" type="text"   style="width:500px;"  value="1570154736000" /></td></tr>'
		 +'<tr><td><label>返回结果</label></td>'
		 +'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }

/* function search_show(apiname){ //6.1.获取应用基本信息
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入应用架构：<input  id="search_arch" type="text"   style="width:500px;"  value="" /></br></br>'
		+'请输入apps：<input  id="search_apps" type="text"   style="width:500px;"  value="" />(多个id之间用;分隔)</br></br>'
		+'请输入时间戳：<input  id="search_time" type="text"   style="width:500px;"  value="" /></br></br>'
		+'请输入单点登录用户的token：<input  id="search_token" type="text"   style="width:500px;"  value="" /></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="search()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }*/
 function subscribe_add_show(apiname){//6.1添加订阅信息
	var div = document.getElementById("content");
	var  content ='{'
				+		'"useruuid":"342189d5-d5ea-458b-9928-fb91588dfe81",'
				+		'"id":"22222",'
				+		'"title":"文章标题test",'
				+		'"createDate":"2017-11-21 07:30:30"'
				+	'}';
	div.innerHTML ='<b><p>1添加订阅信息</p></b>'
		+'<input type="submit"   value="测试" onclick="subscribe_add()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入订阅信息：</label></td>'
		+'<td><textarea id="subscribe_detail" rows="10" cols="80"   />'+content+'</textarea></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function subscribe_delete_show(apiname){ //6.2.删除订阅信息
	var div = document.getElementById("content");
	var  content2 ='{'
				+		'"useruuid":"342189d5-d5ea-458b-9928-fb91588dfe81",'
				+		'"id":"22222"'
				+	'}';
	div.innerHTML ='<b><p>删除订阅信息</p></b>'
		+'<input type="submit"   value="测试" onclick="subscribe_delete()" /><br><br>'
		+'<table class="table table-striped table-bordered table-hover">'
		+'<tr><td><label>请输入删除信息：</label></td>'
		+'<td><textarea id="subscribe_delete_detail" rows="10" cols="80"   />'+content2+'</textarea></td></tr>'
		+'<tr><td><label>返回结果</label></td>'
		+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';
 }
 function subscribe_user_show(apiname){ //6.3.查询用户的订阅信息
		var div = document.getElementById("content");
			
		div.innerHTML ='<b><p>查询用户的订阅信息</p></b>'
			+'<input type="submit"   value="测试" onclick="subscribe_user()" /><br><br>'
			+'<table class="table table-striped table-bordered table-hover">'
			+'<tr><td><label>请输入人员id：</label></td>'
			+'<td><input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></td></tr>'
			+'<tr><td><label>请输入每页显示条数：</label></td>'
			+'<td><input  id="search_limit" type="text"   style="width:500px;"  value="10" /></td></tr>'
			+'<tr><td><label>请输入当前页数：</label></td>'
			+'<td><input  id="search_page" type="text"   style="width:500px;"  value="1" /></td></tr>'
			+'<tr><td><label>返回结果</label></td>'
			+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

 }
 function subscribe_article_user_show(apiname){ //6.4.查询用户是否订阅了该文章
		var div = document.getElementById("content");
			
		div.innerHTML ='<b><p>查询用户是否订阅了该文章</p></b>'
			+'<input type="submit"   value="测试" onclick="subscribe_article_user()" /><br><br>'
			+'<table class="table table-striped table-bordered table-hover">'
			+'<tr><td><label>请输入人员id：</label></td>'
			+'<td><input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></td></tr>'
			+'<tr><td><label>请输入文章id：</label></td>'
			+'<td><input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></td></tr>'
			+'<tr><td><label>返回结果</label></td>'
			+'<td><textarea id="textareaid" rows="20" cols="120"/></textarea></td></tr></table>';

 }
 //负一屏接口
function openApp(){ //打开应用
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
        +'请输入文章id：<input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="subscribe_article_user()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}
function setWinSize(){ //设置新窗口打开大小
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
        +'请输入文章id：<input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="subscribe_article_user()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}
function getAppList(){ //获取应用列表
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
        +'请输入文章id：<input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="subscribe_article_user()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}
function getAppListInfo(){ //获取应用详情
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
        +'请输入文章id：<input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="subscribe_article_user()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}
function reload(){ //重新加载
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
        +'请输入文章id：<input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="subscribe_article_user()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}
function clearCache(){ //清空缓存
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
        +'请输入文章id：<input  id="search_articleid" type="text"   style="width:500px;"  value="22222" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="subscribe_article_user()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}