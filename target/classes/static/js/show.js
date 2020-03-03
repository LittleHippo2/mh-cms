

function todo() {
    window.__set_todo_count__(5);
}

function get_m_token_show(apiname){ //1.2.1获取微服务access_token
 
	var div = document.getElementById("content");
			
			div.innerHTML ='<p>'+apiname+'</p>'
			+'请输入appid : <input  id="appid" type="text" value="base.csse.desktop"   style="width:500px;"  value="" /> </br></br>'
			+'请输入secret: <input  id="secret" type="text"  value="a75b5772-f005-4dbe-b5e0-9ac7793533cc"  style="width:500px;"  value="" /> '
			+'</br> </br>'
		    +'<input type="submit"   value="测试" onclick="get_m_token()" />'
		    +'<p>返回结果</p>'
			+'<textarea id="textareaid" rows="30" cols="120"   />'
			+'</textarea>'
		    ;
	// <p>apiname</p>
			// 请输入appid : <input  id="appid" type="text"   style="width:500px;"  value="" /> </br>
			// 请输入secret: <input  id="secret" type="text"   style="width:500px;"  value="" /> 
			
			
			// </br>
			// </br>
			// <input type="submit"   value="测试" onclick="test()" />
			// <p>返回结果</p>
			// <textarea id="123" rows="10" cols="80"   />		
			// </textarea>
 }
 function get_sso_token_show(apiname){ //2.2.1获取单点登录access_token
		var div = document.getElementById("content");
			
			div.innerHTML ='<p>'+apiname+'</p>'
			+'请输入用用户账号 : <input  id="sso_username" type="text"  style="width:500px;"  value="admin" /></br> </br>'
			+'请输入密码 : &emsp;&emsp;&emsp;<input  id="sso_password" type="text"   style="width:500px;"  value="password02!" /></br></br> '
			+'请输入登录模式:&emsp;&nbsp; <input  id="sso_loginmodel" type="text"   style="width:500px;"  value="110" /></br></br>'
			+'请输入service:&emsp;&emsp;<input  id="sso_service" type="text"   style="width:500px;"  value="172.16.5.200:10004/zrsso51/index.html" /></br>'
			+'</br></br>'
			+'<input type="submit"   value="测试" onclick="get_sso_token()" />'
		    +'<p>返回结果</p>'
			+'<textarea id="textareaid" rows="30" cols="120"   />'
			+'</textarea>'
		    ;
		
			// 请输入用户名 : <input  id="sso_username" type="text"   style="width:500px;"  value="" /> </br>
			 // 请输入密码: <input  id="sso_password" type="text"   style="width:500px;"  value="" /></br> 
			 // 请输入登录模式: <input  id="sso_loginmodel" type="text"   style="width:500px;"  value="" /></br>
			
			 // </br>
			 // </br>
			 // <input type="submit"   value="测试" onclick="get_sso_token()" />
			 // <p>返回结果</p>
			 // <textarea id="textareaid" rows="10" cols="80"   />		
			 // </textarea>
 }
 function get_sso_user_show(apiname){  //2.2.2获取单点登录用户信息
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_sso_user()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function valid_sso_token_show(apiname){  //2.2.3验证token
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="valid_sso_token()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function refresh_sso_token_show(apiname){ //2.2.4刷新单点登录token有效期
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="refresh_sso_token()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function change_sso_password_show(apiname){  //2.2.5修改密码
		var div = document.getElementById("content");

		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入用户账号 : <input  id="sso_username" type="text"   style="width:500px;"  value="" /></br> </br>'
		+'请输入旧密码: <input  id="sso_old_password" type="text"   style="width:500px;"  value="" /></br></br> '
		+'请输入新密码: <input  id="sso_new_password" type="text"   style="width:500px;"  value="" /></br></br>'
		+'请重复新密码: <input  id="sso_re_password" type="text"   style="width:500px;"  value="" /></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="sso_password()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function logou_sso_show(apiname){//2.2.6注销单点登录token
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="logou_sso()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function get_deparement_list_show(apiname){ //3.2.1获取部门列表
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></br>'
		+'<input type="checkbox" id="sublevel"  />包含子级(sublevel)'
		+'<input type="checkbox" id="invalid"  />包含无效数据(invalid)'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_deparement_list()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 
		// <p>获取部门列表</p>
			// 请输入部门id：<input  id="111" type="text"   style="width:500px;"  value="" />(id之间以&符号隔开)
			// </br>
			// <input type="checkbox" id="sublevel"  />包含子级(sublevel)
			// <input type="checkbox" id="invalid"  />包含无效数据(invalid)
			// </br>
			// </br>
			// <input type="submit"   value="测试" onclick="test()" />
			// <p>返回结果</p>
			// <textarea id="123" rows="10" cols="80"   />		
			// </textarea>
 }
 function get_more_department_list_show(apiname){ //3.2.2获取多部门列表
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入多部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="a29211c1-211f-4c2a-8747-1905055ec6d0,root" />(id之间以,符号隔开)</br>'
		+'<input type="checkbox" id="sublevel"  />包含子级(sublevel)'
		+'<input type="checkbox" id="invalid"  />包含无效数据(invalid)'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_more_department_list()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function get_department_info_show(apiname){ //3.2.3获取部门详情
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_department_info()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function get_user_list_show(apiname){ //3.2.4获取人员列表
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></br>'
		+'<input type="checkbox" id="sublevel"  />包含子级(sublevel)'
		+'<input type="checkbox" id="invalid"  />包含无效数据(invalid)'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_user_list()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function get_userinfoByAccount_show(apiname){  //3.2.5获取人员详情
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入人员在账号：<input  id="m_userid" type="text"   style="width:500px;"  value="sysadmin" /></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_userinfoByAccount()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
function get_userinfo_show(apiname){  //3.2.6获取人员详情
    var div = document.getElementById("content");

    div.innerHTML ='<p>'+apiname+'</p>'
        +'请输入人员id：<input  id="m_userid" type="text"   style="width:500px;"  value="1" /></br>'
        +'</br></br>'
        +'<input type="submit"   value="测试" onclick="get_userinfoById()" />'
        +'<p>返回结果</p>'
        +'<textarea id="textareaid" rows="30" cols="120"   />'
        +'</textarea>'
    ;
}
 function sync_show(apiname){ //3.2.7增量同步接口
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入starttime：<input  id="starttime" type="text"   style="width:500px;"  value="1512727052" /></br></br>'
		+'请输入部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="root" />(部门id可选填)</br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="sync()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function msg_one_user_show(apiname){ //4.3.1发送消息至个人
		var div = document.getElementById("content");
		var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入人员id：<input  id="m_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
		+'请输入消息内容：<input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></br></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="msg_one_user()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function msg_more_user_show(apiname){  //4.3.2.发送消息至多人
		var div = document.getElementById("content");
		var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入多人id：<input  id="m_userid" type="text"   style="width:500px;"  value="1,3c88f676-8699-4c40-a436-3d220453e5a4" />(id之间以,符号隔开)</br></br>'
		+'请输入消息内容：<input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></br></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="msg_more_user()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function msg_one_department_show(apiname){ //4.3.3.发送消息至部门
		var div = document.getElementById("content");
		var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="root" /></br></br>'
		+'请输入消息内容：<input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></br></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="msg_one_department()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function msg_more_department_show(apiname){ //4.3.4.发送消息至多部门
		var div = document.getElementById("content");
		var content_demo='{"appid":"legacycpk.csse.dddemo","type":"application","title":"title","content":"中文","display":{"system":true,"notification":true,"msgbox":true}}';
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入多部门id：<input  id="m_departmentid" type="text"   style="width:500px;"  value="root,a29211c1-211f-4c2a-8747-1905055ec6d0" />(id之间以,符号隔开)</br></br>'
		+'请输入消息内容：<input  id="m_content" type="text"   style="width:500px;"  value='+content_demo+' /></br></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="msg_more_department()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
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
						
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入日志内容：</br><textarea id="logdetail" rows="10" cols="80"   />'+test_log+'</textarea></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="add_log()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function get_log1_show(apiname){ //5.2.查询日志（条件一）
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入用户账号：<input  id="m_userid" type="text"   style="width:500px;"  value="sysadmin" /></br></br>'
		+'请输入开始时间：<input  id="log_starttime" type="text"   style="width:500px;"  value="1470154736000" /></br></br>'
		+'请输入结束时间：<input  id="log_endtime" type="text"   style="width:500px;"  value="1570154736000" /></br></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_log1()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function get_log2_show(apiname){ //5.3.查询日志（条件二）
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入appid：<input  id="log_appid" type="text"   style="width:500px;"  value="legacycpk.csse.dddemo" /></br></br>'
		+'请输入开始时间：<input  id="log_starttime" type="text"   style="width:500px;"  value="1470154736000" /></br></br>'
		+'请输入结束时间：<input  id="log_endtime" type="text"   style="width:500px;"  value="1570154736000" /></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="get_log2()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function search_show(apiname){ //6.1.获取应用基本信息
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
 }
 function subscribe_add_show(apiname){//6.1添加订阅信息
		var div = document.getElementById("content");
		var  content ='{'
					+		'"useruuid":"342189d5-d5ea-458b-9928-fb91588dfe81",'
					+		'"id":"22222",'
					+		'"title":"文章标题test",'
					+		'"createDate":"2017-11-21 07:30:30"'
					+	'}';	
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入订阅信息：</br><textarea id="subscribe_detail" rows="10" cols="80"   />'+content+'</textarea></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="subscribe_add()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function subscribe_delete_show(apiname){ //6.2.删除订阅信息
		var div = document.getElementById("content");
		var  content2 ='{'
					+		'"useruuid":"342189d5-d5ea-458b-9928-fb91588dfe81",'
					+		'"id":"22222"'	
					+	'}';
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入删除信息：</br><textarea id="subscribe_delete_detail" rows="10" cols="80"   />'+content2+'</textarea></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="subscribe_delete()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function subscribe_user_show(apiname){ //6.3.查询用户的订阅信息
		var div = document.getElementById("content");
			
		div.innerHTML ='<p>'+apiname+'</p>'
		+'请输入人员id：<input  id="search_userid" type="text"   style="width:500px;"  value="342189d5-d5ea-458b-9928-fb91588dfe81" /></br></br>'
		+'请输入每页显示条数：<input  id="search_limit" type="text"   style="width:500px;"  value="10" /></br></br>'
		+'请输入当前页数：<input  id="search_page" type="text"   style="width:500px;"  value="1" /></br>'
		+'</br></br>'
		+'<input type="submit"   value="测试" onclick="subscribe_user()" />'
		+'<p>返回结果</p>'
		+'<textarea id="textareaid" rows="30" cols="120"   />'
		+'</textarea>'
		;
 }
 function subscribe_article_user_show(apiname){ //6.4.查询用户是否订阅了该文章
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

