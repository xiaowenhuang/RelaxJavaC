//置顶弹窗消息
function windowTopMsg(msg){
	$.messager.show({
        title:'消息提示',
        msg:msg,
        showType:'slide',
        style:{
            right:'',
            top:document.body.scrollTop+document.documentElement.scrollTop,
            bottom:''
        }
    });
}

//初始化选中下拉框。在select标签加上initSel属性，值即为要选中的值
function ljbInitSel(){
	$("select[value]").each(function(){
		$(this).val($(this).attr("value"));
	});
}

$(function(){
	ljbInitSel();
	/**
	 * 试下用json来加载下拉框
	 * 通过这种方式加载的下拉选项<option>标签都有class="jsonOp"属性
	 * 通过id来获取select，暂不支持用class来获取
	 * @author ljb
	 */
	$.fn.jsonOption = function(jsons,option) {
		var _id = $(this).attr("id");
		if(!jsons) {
			console.log("加载的数据不对"); 
			$("#"+_id+" .jsonOp").remove();
			return false;
		}
		value = option.value?option.value:"value";
		text = option.text?option.text:"text";
		
		//先移除
		$("#"+_id+" .jsonOp").remove();
		var options = "";
		var opStyle;
		for(var i = 0; i < jsons.length; i++)
		{
			opStyle = jsons[i]['opStyle']?jsons[i]['opStyle']:"";
			options += '<option class="jsonOp" style="'+opStyle+'" value="'+jsons[i][value]+'">'+jsons[i][text]+'</option>';
		}
		$(this).append(options);
	};
	
	/**
	 * table要用id来筛选
	 * 列名在<table><thead><tr><td(h) 的colName属性>定义
	 * eg<table><thead><tr><td colName="userName"><th colName="eMail">
	 * 如果一列数据要经过函数处理，如“小计”，“操作”等，则在funName属性定义函数句柄（不加括号），
	 * 参数是一行的数据，返回值是要嵌在该列<td>里面的内容。
	 */
	//只能往table的tbody上加tr
	$.fn.jsonTr = function(jsons,root){
		if(!jsons || jsons.length == 0)
		{
			$(this).find("tbody").empty();
			//$.messager.alert("提示","查询结果为0","info");
			return ;
		}
		if(root != null)
		{
			jsons = jsons[root];
		}
		var _id = $(this).attr("id");
		
		$(this).data("jsonData",jsons);
		var thead = $(this).find("thead").find("tr").children();
		var tr ="";
		$(this).find("tbody").empty();
		for(var i = 0; i < jsons.length; i++)
		{
			var tds = "";
			for(var j = 0; j < thead.length; j++)
			{	
				var colName = $(thead.get(j)).attr("colName");
				var funName = $(thead.get(j)).attr("funName");
				if(colName == "__ESCAPE__"){
					continue;
				}
				var value = jsons[i][colName];
				if(funName != null)
				{
					value = _funName(funName,jsons[i],i);
				}
				if(value == null || typeof(value) == "undefined")
				{
					value = "&nbsp;";
				}
				tds += '<td class="ljbcol_'+colName+'">' + value + '</td>';
			}
			tr = "<tr rowindex='"+i+"'>" + tds + "</tr>";
			$(this).find("tbody").append(tr);
		}
	};
	
	function _funName(funcName,row,index)
	{
		if(typeof(eval(funcName))=="function")
	    {
			var value = eval(funcName + "(row,index)");
			return value;
	    }
	}
});

//JavaScript生成GUID的算法
function uuid(len, radix) {
	var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz'.split('');
	var uuid = [], i;
	radix = radix || chars.length;

	if (len) {
		// Compact form
		for (i = 0; i < len; i++) {
			uuid[i] = chars[0 | Math.random()*radix];
		}
	} else {
		// rfc4122, version 4 form
		var r;
	
		// rfc4122 requires these characters
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';
		
		// Fill in random data. At i==19 set the high bits of clock sequence as
		// per rfc4122, sec. 4.1.5
		for (i = 0; i < 36; i++) {
			if (!uuid[i]) {
				r = 0 | Math.random()*16;
				uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
			}
		}
	}
	
	return uuid.join('');
}

function yyyy_mm_dd(){
	var today = new Date();
	var yyyy = today.getFullYear();
	var mm = today.getMonth()+1;
	var dd = today.getDate();
	mm = mm >=10 ? mm : '0' + mm; //补零
	dd = dd >=10 ? dd : '0' + dd; //补零
	var result = yyyy+'-'+mm+'-'+dd;
	return result;
}

/* 
* 获得时间差,时间格式为 年-月-日 小时:分钟:秒 或者 年/月/日 小时：分钟：秒 
* 其中，年月日为全格式，例如 ： 2010-10-12 01:00:00 
* 返回精度为：秒，分，小时，天
*/
function GetDateDiff(startTime, endTime, diffType) {
    //将xxxx-xx-xx的时间格式，转换为 xxxx/xx/xx的格式 
    startTime = startTime.replace(/\-/g, "/");
    endTime = endTime.replace(/\-/g, "/");
    //将计算间隔类性字符转换为小写
    diffType = diffType.toLowerCase();
    var sTime = new Date(startTime);      //开始时间
    var eTime = new Date(endTime);  //结束时间
    //作为除数的数字
    var divNum = 1;
    switch (diffType) {
        case "second":
            divNum = 1000;
            break;
        case "minute":
            divNum = 1000 * 60;
            break;
        case "hour":
            divNum = 1000 * 3600;
            break;
        case "day":
            divNum = 1000 * 3600 * 24;
            break;
        default:
            break;
    }
    return parseInt((eTime.getTime() - sTime.getTime()) / parseInt(divNum));
}

 
/*
 * Demo
var result = GetDateDiff("2010-02-26 16:00:00", "2011-07-02 21:48:40", "day");

使用的方法很简单，比如计算天数可以这样：

GetDateDiff("2010-02-26 16:00:00", "2011-07-02 21:48:40", "day");

计算秒数则可以这样： 

GetDateDiff("2010-02-26 16:00:00", "2011-07-02 21:48:40", "second");
*/

/**
 * Mysql 动态条件组合插件
 * @author ljb
 */
$.fn.xpCondition = function(options) {
	var $id = "#"+$(this).attr("id");
	var logicType = "<select class='logic'>";
	logicType += "<option value='and'>并且</option>";
	logicType += "<option value='or'>或者</option>";
	logicType += "<option value=''>&nbsp;</option>";
	logicType += "<select> ";
	
	var conditionType = "<select class='condition'>";
	conditionType += "<option value='='>等于</option>";
	conditionType += "<option value='!='>不等于</option>";
	conditionType += "<option value='<'>小于</option>";
	conditionType += "<option value='>'>大于</option>";
	conditionType += "<option value='like'>包含</option>";
	conditionType += "<option value='not like'>不包含</option>";
	conditionType += "<option value='start with'>开头是</option>";
	conditionType += "<option value='not start with'>开头不是</option>";
	conditionType += "<option value='end with'>结尾是</option>";
	conditionType += "<option value='not end with'>结尾不是</option>";
	conditionType += "<option value='in'>在集合中</option>";
	conditionType += "<option value='not in'>不在集合</option>";
	conditionType += "</select> ";
	
	var fieldDiv = "<div class='fieldRow'>";
	fieldDiv += logicType;
	fieldDiv += "<select class='fieldName' onchange='changeFieldName(this,\""+$id+"\",null)'>";
	for(var i in options){
		if(options[i].inputType == "select"){
			$($id).data("fieldRowOption_"+options[i].inputName,options[i].option);
		}
		fieldDiv += "<option value='"+options[i].inputName+"'>"+options[i].text+"</option>";
	}
	fieldDiv += "</select> ";
	fieldDiv += conditionType;
	fieldDiv += " <span class='inputType'><input class='inputVal'/></span> ";
	fieldDiv += " <button onclick='removeXPfieldRow(this,\""+$id+"\")' style='width:100px;'><i class='Hui-iconfont'>&#xe60b;</i>移除条件</button>";
	fieldDiv += "</div>";
	
	$($id).data("fieldRow",fieldDiv);
	
	var fieldStr = "<div id='fieldRows'></div>";
	var addStr = '<button type="button" style="width:100px;" class="btnAddXPfieldRow" onclick="addXPfieldRow(\''+$id+'\',{})"><i class="Hui-iconfont">&#xe604;</i> 添加条件</button> ';
	addStr += '<button type="button" class="btnSel" onclick="sel()" style="width:100px;"><i class="Hui-iconfont">&#xe665;</i> 筛选</button>';
	$(this).html(addStr+fieldStr);
};

function addXPfieldRow($id,option){
	var fieldRow = $($($id).data("fieldRow"));
	changeFieldName(fieldRow.find(".fieldName"),$id,option["fieldName"]);
	
	$($id).find("#fieldRows").append(fieldRow);
	if(!option){
		$($id+" .logic:first").prop("disabled","disabled").val('');
		return ;
	}
	if(option["logic"]){
		fieldRow.find(".logic").val(option["logic"]);
	}
	if(option["condition"]){
		fieldRow.find(".condition").val(option["condition"]);
	}
	if(option["fieldName"]){
		fieldRow.find(".fieldName").val(option["fieldName"]);
	}
	if(option["inputVal"]){
		fieldRow.find(".inputVal").val(option["inputVal"]);
	}
	$($id+" .logic:first").prop("disabled","disabled").val('');
}

function removeXPfieldRow(el,$id){
	$(el).parent().remove();
	$($id+" .logic:first").prop("disabled","disabled").val('');
}

$.fn.getXPCondition = function() {
	var $id = "#"+$(this).attr("id");
	var where = "";
	var values = [];
	$($id+" .fieldRow").each(function(index){
		var fieldWhere = [];
		var inputVal = $(this).find(".inputVal").val();
		var condition = $(this).find(".condition").val();
		var logic = $(this).find(".logic").val();
		var fieldName = $(this).find(".fieldName").val();

		if(condition == 'like'){
			condition = "like";
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push("%"+inputVal+"%");
		}
		else if(condition == 'not like'){
			condition = "not like";
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push("%"+inputVal+"%");
		}
		else if(condition == 'start with' ){
			condition = "like";
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push(inputVal+"%");
		}
		else if(condition == 'not start with'){
			condition = "not like";
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push(inputVal+"%");
		}
		else if(condition == 'end with'){
			condition = "like";
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push("%"+inputVal);
		}
		else if(condition == 'not end with'){
			condition = "not like";
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push("%"+inputVal);
		}
		else if(condition == 'in' || condition == 'not in'){
			var inValArr = inputVal.split(",");
			var _valArr = [];
			for(var i = 0;i<inValArr.length;i++){
				_valArr.push("?");
				values.push(inValArr[i]);
			}
			where += " " + logic + " " + fieldName + " " + condition + " ("+_valArr.join(",")+") ";
		}
		else{
			where += " " + logic + " " + fieldName + " " + condition + " ? ";
			values.push(inputVal);
		}
	});
	return {"where":where,"values":values.join("~@~")};
}

function changeFieldName(el,$id,fieldName){
	fieldName = fieldName?fieldName:$(el).val();
	var fieldRowOption = $($id).data("fieldRowOption_"+fieldName);
	var inputTypeSpan = $(el).parent().find(".inputType");
	if(fieldRowOption){
		inputTypeSpan.empty();
		var select = "<select class='inputVal'>";
		for(var i in fieldRowOption){
			select += "<option value='"+fieldRowOption[i].value+"'>"+fieldRowOption[i].text+"</option>";
		}
		select += "</select>";
		inputTypeSpan.append(select);
	}
	else{
		inputTypeSpan.empty();
		inputTypeSpan.append("<input class='inputVal' />");
	}
}


//*******************end Mysql 动态条件组合插件

//**************数字格式 金币*********//
function formatNumber(number) {
	if(number*1 == 0){
		return 0;
	}
	if(!number){
		return "";
	}
	number = number+"";
    number = number.replace(/,/g, "");
    var digit = number.indexOf("."); // 取得小数点的位置
    var int = number.substr(0, digit); // 取得小数中的整数部分
    var i;
    var mag = new Array();
    var word;
    if (number.indexOf(".") == -1) { // 整数时
        i = number.length; // 整数的个数
        while (i > 0) {
            word = number.substring(i, i - 3); // 每隔3位截取一组数字
            i -= 3;
            mag.unshift(word); // 分别将截取的数字压入数组
        }
        number = mag;
    } else { // 小数时
        i = int.length; // 除小数外，整数部分的个数
        while (i > 0) {
            word = int.substring(i, i - 3); // 每隔3位截取一组数字
            i -= 3;
            mag.unshift(word);
        }
        number = mag + number.substring(digit);
    }
    return number;
}

//************浮点数运算**************//
function accAdd(arg1,arg2){ 
	var r1,r2,m; 
	try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0} 
	try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0} 
	m=Math.pow(10,Math.max(r1,r2)); 
	return (arg1*m+arg2*m)/m; 
} 
function ForDight(Dight,How){ 
	if(Dight*1 == 0)
		return 0;
    Dight = Math.round(Dight*Math.pow(10,How))/Math.pow(10,How);  
    return Dight;  
}  

//**************ajax**********//
function xpAjax(url,pramData,callBackFunc,dataType,settings){
	var obj = {
		type: "POST",
		url:url,
		data:pramData,
		success:callBackFunc,
		dataType:dataType,
		error:function(msg){
			var alertMsg = getErrorInfo(msg.status,null,"Error:" + msg.status+"-"+msg.statusText);
			layer.msg(alertMsg, {
			  icon: 1,
			  time: 10*1000 //10秒关闭（如果不配置，默认是3秒）
			}, function(){
			  window.location.reload();
			});  
		}
	};
	settings = jQuery.extend(obj, settings);
	$.ajax(settings);
}

//错误集合
function getErrorInfo(errId,errType,defaultInfo){
	errType = errType?errType:"http";
	defaultInfo = defaultInfo?defaultInfo:"操作失败-_-!";
	var errInfo = {};
	errInfo["http-404"] = "错误404，请求地址失效";
	errInfo["http-401"] = "登录过时，请先登录-_-!";
	errInfo["http-412"] = "没有权限,请联系管理员-_-!";
	errInfo["http-500"] = "服务器发生异常，请联系管理员-_-!";
	var msg = errInfo[errType+"-"+errId]?errInfo[errType+"-"+errId]:defaultInfo;
	return msg;
}

