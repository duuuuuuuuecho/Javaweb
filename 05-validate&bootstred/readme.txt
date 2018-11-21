案例1-表单校验
需求:
	通过validate插件来校验表单
技术分析:
	jqery validate
validate使用步骤:
	validate是别人封装好的第三方工具
	1.导入jquery.js
	2.导入validate.js
	3.在页面加载成功之后 对表单进行校验  $("选择器").validate()
	4.在validate中编写校验规则
		$("选择器").validate({
			rules:{},
			messages:{}
		});
//////////////////////////////////////////	
	rules格式:
		格式1:
			字段的name属性:"校验器"
		格式2:				
			字段的name属性:{校验器:值,校验器:值}
	例如:
		username:"required",
		password:{
			required:true,
			digits:true
		},
		repassword:{
			equalTo:"[name='password']"
		},
		zuixiaozhi:{
			min:5
		},
		shuzhiqujian:{
			range:[5,10]
		}
///////////////////////////////////////////	
	messages的格式:
		格式1:
			字段的name属性:"提示信息"
		格式2:
			字段的name属性:{校验器:"提示信息",校验器:提示信息"}
	例如:
		username:"用户名不能为空",
		password:{
			required:"密码不能为空",
			digits:"密码只能是数字"
		},
		repassword:{
			equalTo:"两次输入的内容不一致"
		},
		zuixiaozhi:{
			min:"最小值应该大于{0}"
		},
		shuzhiqujian:{
			range:"输入的范围在{0}~{1}之间"
		}
////////////////////////////////////////////


////////////////////////////////////////////	
案例2-创建一个响应式的页面
需求:
	创建一套页面,可以根据上网设备的不同自动调节显示的效果.
技术分析:
	bootstrap
bootstrap:
	webcss框架,
	集合了html/css/jquery为一家
	创建响应式的页面
	响应式:适配不同的上网设备
bootstarp的入门
	1.下载bootstarp
		网站:http://www.bootcss.com/
		下载:用于生产环境的 Bootstrap
	2.导入bootstarp.css
	3.导入jquery.js
	4.导入bootstrap.js
	5.添加一个meta标签 支持移动设备
		<meta name="viewport" content="width=device-width, initial-scale=1">
	6.将所有的内容放入到布局容器中.
		Bootstrap 需要为页面内容和栅格系统包裹一个 .container 容器。我们提供了两个作此用处的类
		方式1:
			<div class="container"></div>
		方式1:
			<div class="container-fluid"></div>
注意:
	bootstrap将每一行分成12份
媒体查询:
	假如大屏幕,每行显示6个
		超大电脑,屏幕分辨率>1200		使用: col-lg-2
		
	假如屏幕小点,每行显示4个
		992<屏幕分辨率<1200			使用: col-md-3
			
	再小点,每行显示2个
		768<屏幕分辨率<992			使用: col-sm-6
	
	继续小,每行显示1个	
		屏幕分辨率<768				使用:col-xs-12
////////////////////////////
bootstrap组成部分:
	全局css样式--定义了一套css样式
	组件--定义了很多可以直接使用的组件 例如:字体图标 导航条 
	js插件--例如:轮播图 选项卡
/////////////////////////////
步骤分析:
	1.先有一个模版页面 0.html
	2.先创建一个导航条
	3.下面创建一个轮播图
	4.下面再创建3个div
		中等屏幕的时候 3个在一行
		小屏幕的时候 2个一行
		最小屏幕的时候1个一行
/////////////////////
案例3-布局首页
需求:
	当屏幕为小屏幕的时候和超小屏幕的时候隐藏热门商品中的左边那张图片
	当屏幕为超小屏幕隐藏middle图片
技术分析:
	hidden-xxxx
步骤分析:
	1.布局页面
	2.创建8个div
	3.第一个:logo
		3个div 
		小屏幕 2个一行 
		超小屏幕一个一行
	4.第二个div:导航条
	5.第三个div:轮播图
	6.第四个div:最新商品
		先分成左右两个div
			左边的div 放一张图片 
				屏幕为小屏幕的时候和超小屏幕的时候 隐藏
				中等屏幕 占2份
			右边的div 
				中等屏幕 占10份
				屏幕为小屏幕的时候和超小屏幕的时候 占12份
					middle 
						中等屏幕 6份
						小屏幕	12份
						超小屏幕 隐藏
					商品:
						中等屏幕 2份
						小屏幕 	 4份
						超小屏幕 12份
////////////////////////////////////////////////	
////////////////////////////////////////////////
validate
	使用步骤:
		1.导入jquery.js
		2.导入validate.js
		3.在页面加载成功之后	$(function(){})
		4.对表单进行校验
			$(function(){
				$("选择器").validate();
			})
		5.编写校验的规则
			$(function(){
				$("选择器").validate({
					rules:{},
					messages:{}
				});
			})
		6.编写具体的规则
			$(function(){
				$("选择器").validate({
					rules:{
						// name属性值:"校验器" 
						// name属性值:{校验器:值,校验器:值}
					},
					messages:{
						//name属性值:"提示信息"
						//name属性值:{校验器:"提示信息",校验器:"提示信息"}
					}
				});
			})
		
		/////////////
		常用的校验器
			必填:	required
			最值:	min|max
			取值范围:range		值:[min,mix]
			相等:	equalTo		值:jquery表达式
			长度:	minlength|maxlength
			长度范围:rangelength 	值:[min长度,max长度]
////////////////////////////////////
bootstrap:编写一套页面,适应不同的设备(响应式)
	使用步骤:
		1.导入bootstarp.css
		2.导入jquery.js
		3.导入bootstarp.js
		4.在head标签添加一个meta标签  支持移动设备
		5.必须将所有的内容防止一个布局容器中
			方式1:
				放入一个class为.container容器中
			方式1:
				放入一个class为.container-fluid容器中
			
/////////////////
栅格系统:
	
	屏幕分辨率>1200px    样式:col-lg-x
	992<屏幕分辨率<1200px    样式:col-md-x   中等屏幕
	768<屏幕分辨率<992px    样式:col-sm-x   小屏幕
	屏幕分辨率<768px    样式:col-xs-x   最小屏幕

隐藏:
	hidden-xs 在最小屏幕时候隐藏

将一个超链接伪装成一个按钮
	class="btn btn-primary"

浮动到右边
	class="pull-right"
	
		
		
		
		
		
		
		
		
		
		
	
	