/**
 * 打开应用
 * @param appid
 * @param redirect 回调地址 可为空
 */
function openApp() {
    var appid = $("#softwareid").val();
    var redirect = $("#redirect").val();

    if (typeof Desktop == "undefined") {
        console.log("Desktop undefined");
        _service_._openApp_(appid, redirect);
    } else {
        console.log("openApp");
        Desktop.__openApp__(appid, redirect);
    }
}

/**
 * 设置新窗口打开大小
 * @param wide 宽
 * @param hight 高
 */
function setWinSize() {
    var wide = $("#wide").val();
    var hight = $("#hight").val();
    console.log("wide:"+wide+" hight:"+hight);
    if (typeof Desktop == "undefined") {
        console.log("Desktop undefined");
        _service_._setLinkWindowSize_(wide, hight);
    } else {
        console.log("__setLinkWindowSize__");
        Desktop.__setLinkWindowSize__(wide, hight);
    }
}

/**
 * 获取应用列表
 * @param  回调方法
 */
function getAppList() {
    if (typeof Desktop == "undefined") {
        console.log('Desktop undefined');
       var appids = _service_._getAppList_();
        __onGetAppList__(appids);
    } else {
        //回调方法data为一个形参  json格式
        Desktop.__getAppList__(function (data) {
                console.log('获取应用列表成功：' + data);
                $("#textareaid").text(formatJson(JSON.stringify(data)));
                var appIdList = JSON.parse(data);
                appIdList.forEach(function (appId) {
                    console.log(appId);
                });
            });
    }
}

/**
 * 获取应用列表详情
 * @param callback 回调方法
 */
function getAppListInfo(callback) {
    if (typeof Desktop == "undefined") {
        console.log('Desktop undefined');
       var appInfoList =  _service_._getAppInfoList_();
        __onGetAppInfoList__(appInfoList);
    } else {
        Desktop.__getAppInfoList__(function (data) {
                console.log('获取应用信息列表成功：' + data);
            $("#textareaid").text(formatJson(JSON.stringify(data)));
                var appInfoList = JSON.parse(data);
                appInfoList.forEach(function (appInfo) {
                    console.log(appInfo);
                });
            });
    }
}

/**
 * 重新加载 布尔类型 是否忽略缓存 为true时强制刷新
 * @param bypassCache
 */
function reload() {
    var bypassCache;
    if ($('#isTrue').is(':checked')) {
        bypassCache = 'true';
    }
    if ($('#isFalse').is(':checked')) {
        bypassCache = 'false';
    }
    if (typeof Desktop == "undefined") {
        console.log('Desktop undefined');
        __reload__(bypassCache)
    } else {
        Desktop.__reload__(bypassCache);
    }

}

/**
 * 清空缓存
 * @param bypassCache  是否忽略清理Cookie
 */
function clearCache(bypassCache) {
    var bypassCookie;
    if ($('#isTrue').is(':checked')) {
        bypassCookie = 'true';
    }
    if ($('#isFalse').is(':checked')) {
        bypassCookie = 'false';
    }
    if (typeof Desktop == "undefined") {
        console.log('Desktop undefined');
        __clearCache__(bypassCookie);
    } else {
        Desktop.__clearCache__(bypassCookie);
    }
}

//初始化接口，可通过判断新接口的“Desktop”是否“undefined”，判断新接口是否可用。
function __init__() {
    console.log('初始化...');
    if (typeof(Desktop) == 'undefined') {
        console.warn('Desktop异常...');
        return ;
    }
    //当办公桌面上应用数据发生变动时（如应用代办数发生变化）调用该方法，应用可在该方法中实现更新应用列表、更新待办事项数等业务操作。
    Desktop.__dataUpdated__.connect(function () {
        console.log('*****数据更新*****');
    })
}


//配套旧接口使用
function __onGetAppList__(appIds) {
    console.warn(appIds);
    console.warn(appIds.split(";"));
}
// 获取应用信息列表成功；appInfoList为应用数据对象数
function __onGetAppInfoList__(appInfoList) {
    console.warn(JSON.stringify(appInfoList));
}
