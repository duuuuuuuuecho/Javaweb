回顾:
html:
	作用:展示
	文件标签:
		<html>
			<head>
				<title></title>
			</head>
			<body></body>
		</html>
	排版标签:
		p 段落
		hr 水平线
		br 换行
	字体
		h1~h6 标题
		font 字体 大小 颜色
		b strong 加粗
		i 斜体
	图片★
		<img src="图片的路径" alt="替代文字" width="" height=""/>
		路径的写法:
			相对路径:
				./ 或者 什么都不写  当前目录
				../ 上一级目录
			绝对路径:常用
				http://www.itheima.com/xx
	超链接★
		<a href="跳转的路径" target="在什么地方打开"></a>
	
	表格标签 ★★
		<table border="" width="" height="" bgcolor="" align="表格对齐方式">
			<tr align="内容对齐方式">
				<th></th>  	<!--表头单元格-->
				<td></td> 	<!--普通单元格-->
			</tr>
		</table>
		
		td重要的属性:
			colspan:列合并
			rowspan:行合并
	
	列表:
		<ol></ol>
		<ul></ul>
		
		子标签:列表项
			<li></li>
	
	
	form 表单标签:
		常用属性
			action:提交的路径
			method:提交的方式(get和post)
		常用子标签
			input
			select
			textarea
			
		input标签
			常用属性:
				type:
					text
					password
					radio
					checkbox
					file
					
					submit
					reset
					button
					
					hidden
					image
				name:
					要想将信息提交到服务器必须提供name属性
					将单选框和复选框设置成一组
				
				value:
					text password  设置默认值
					radio checkbox 设置选中后提交的值
					submit reset button 给按钮起个显示的名字
		select:下拉选
			<select name="">
				<option value="">显示的名字</option>
			</select>
		
		textarea:文本域
			<textarea cols="" rows="" name="">默认值</textarea>
		
		给单选框多选框设置默认值
			设置属性 checked="checked"
		给下拉选设置默认值
			设置属性 selected="selected"
			
		提交的路径(get)
			http://ssdfsdfsfd?key=vaule&key=value
			例如:
				http://localhost/day/login.jsp?username=tom&password=123
					
	框架(了解)
		frameset:规定框架结构  框架集
			常用属性:
				rows:水平qiege
				cols:垂直切割
			常用子标签	
				frame:具体实现
				
			例如:水平切割3份
				<frameset rows="15%,*,10%">
					<frame>
					<frame>
					<frame>
				</frameset>
		frame:
			常用的属性:
				src:具体展示那个网页
				name:给当前的frame起个名称 方便超链接使用
////////////////////
案例1-用div+css重新布局首页
技术分析:
	div
	css
/////////////
div:
	块标签
	<div></div>
span:行内的块标签
	<span><span>
////////////
css:渲染
	层叠样式表
	作用:
		渲染页面
		提高工作效率
	格式:
		选择器{属性:值;属性1:值1;}
	后缀名:
		.css 独立的css(样式)文件
	和html元素的整合★
		方式1:内联样式表 通过标签的style属性设置样式
		方式2:内部样式表 在当前页面中使用的样式
			通过head标签的style子标签导入
			例如:
				<style>
					#divId2{
						background-color: #0f0;
					}
				</style>
				
		方式3:外部样式表 有独立的css文件
			通过head标签的link子标签导入
			例如:
				<link rel="stylesheet" href="css/1.css" type="text/css"/>
	选择器:★
		id选择器
			要求:
				html元素必须有id属性且有值   <xxx id="id1"></xxx>
				css中通过"#"引入,后面加上id的值  #id1{...}
		class选择器
			要求:
				html元素必须有class属性且有值 <xxx class="cls1"/>
				css中通过"."引入,后面加上class的值  .cls1{...}
		元素选择器
			直接用元素(标签)名即可   xxx{...}
		
	派生的选择器
		属性选择器★
			要求:
				html元素必须有一个属性不论属性是什么且有值  <xxx nihao="wohenhao"/>
				css中通过下面的方式使用
					元素名[属性="属性值"]{....}
					例如:
						xxx[nihao="wohenhao"]{....}
		后代选择器
			选择器 后代选择器{...}   在满足第一个选择器的条件下找后代的选择器,给满足条件的元素添加样式
	了解的选择器
		锚伪类选择器
			a:link {color: #FF0000}	/* 未访问的链接 */
			a:visited {color: #00FF00}	/* 已访问的链接 */
			a:hover {color: #FF00FF}	/* 鼠标移动到链接上 */
			a:active {color: #0000FF}	/* 选定的链接 */

	
	选择器使用小结:
		id选择器:一个元素(标签)
		class选择器:一类元素 
		元素选择器:一种元素
		属性选择器:元素选择器的特殊用法
	使用的时候注意:(了解)
		若多个样式作用于一个元素的时候
			不同的样式,会叠加
			相同的样式,最近原则
		若多个选择器作用于一个元素的时候
			越特殊优先级越高 id优先级最高
//////////////////////
属性(了解)
	字体
		font-family:设置字体(隶书) 设置字体家族
		font-size:设置字体大小
		font-style:设置字体风格
	文本:改变文本的颜色、字符间距，对齐文本，装饰文本，对文本进行缩进
		color:文本颜色
		line-height:设置行高
		text-decoration: 向文本添加修饰。 none underline
		text-align:对齐文本
	列表:
		list-style-type:设置列表项的类型 例如:a 1  实心圆 
		list-style-image:设置图片最为列表项类型 使用的时候使用 url函数  url("/i/arrow.gif");
	背景:
		background-color:设置背景颜色
		background-image:设置图片作为背景 url
	尺寸:
		width:
		height:
	浮动:
		float: 可选值 left right
		
	分类:
		clear:设置元素的两边是否有其他的浮动元素
			值为:both 两边都不允许有浮动元素
		display:设置是否及如何显示元素。
			none 此元素不会被显示。 
			block 此元素将显示为块级元素，此元素前后会带有换行符。 
			inline 默认。此元素会被显示为内联元素，元素前后没有换行符。
框模型:(理解)
	一个元素外面有padding(内边距) border(边框) margin(外边距)
		padding:元素和边框的距离
		margin:元素最外层的空白
	上面这三个属性都有简写的属性
		若设置大小的时候 四个值:顺序 上右下左
			padding:10px 10px 10px 10px
			若只写一个的话 代表四个边使用同一个值  padding:10px
			若只写两个个的话 代表四个边使用同一个值 padding:10px 20px
			若只写三个个的话 代表四个边使用同一个值 padding:10px 20px 30px
	border(边框)
		还可以设置颜色 风格
		简写属性:
			border:宽度	风格 颜色;

			border:5px solid red;
			
			solid:实线
			dashed:虚线
			double:双实线
步骤分析:
	1.创建一个div
	2.在这个div中创建8个div
	3.第1个div logo
		嵌套三个div
	4.第2个div 菜单
		嵌套一个列表 display:inline
	5.第3个div 轮播图
		
	6.第4个div 热门商品 
		标题标签 图片display:inline
		a:两个div
			左边的div 展示一张图片
			右边的div 展示所有商品
		b.右边的div中嵌套10个div
	3.第5个div 广告
	3.第6个div 最新商品
	3.第7个div 广告
	3.第8个div foot 版权
		两个p标签
////////////////////////////////	
javascript 俗称 js
案例1-校验表单
需求:
	表单提交的时候需要校验数据是否完整,若不满足条件,则使用弹出框提示.
技术分析:
	js
//////////////////////
JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，
	内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言
组成部分:
	ECMAScript:js基础语法(规定 关键字 运算符 语句 函数等等...)
	BOM:浏览器对象模型
	DOM:文档对象模型
作用:
	修改html页面的内容
	修改html的样式
	完成表单的验证
注意:
	js可以在页面上直接写,也可以单独出去
	js的文件的后缀名 .js
js和html整合
	方式1:在页面上直接写
		将js代码放在 <script></script>标签中,一般放在head标签中
	方式2:独立的js文件
		通过script标签的src属性导入
js中变量声明:
	var 变量名=初始化值;
	var 变量名;
		变量名=初始化值;
	注意:
		var可以省略 建议不要省略
		一行要以分号结尾,最后一个分号可以省略,建议不要省略
js的数据类型:
	原始类型:(5种)
		Null
		String
		Number
		Boolean
		Undefined
		通过 typeof运算符可以判断一个值或者变量是否属于原始类型,若属于原始类型,他还可以判断出属于那种原始类型
			typeof 变量|值;
		若变量为null,使用typeof弹出的值 object
		
		使用typeof的返回值
			undefined - 如果变量是 Undefined 类型的 
			boolean - 如果变量是 Boolean 类型的 
			number - 如果变量是 Number 类型的 
			string - 如果变量是 String 类型的 
			object - 如果变量是一种引用类型或 Null 类型的 

	引用类型:
//////////////////////
js:事件驱动函数
	函数定义格式:
		方式1:
			function 函数名(参数){
				函数体;
			}
		注意:函数不用声明返回值类型 
			参数不需要加类型
			函数调用的时候
				函数名(参数)
js中的事件:
	常见的事件:
		单击:  onclick
		表单提交: onsubmit 加在form表单上的 onsubmit="return 函数名()"  注意函数返回值为boolean类型
		页面加载: onload
		
js事件和函数的绑定:
	方式1:
		通过标签的事件属性   <xxx onclick="函数名(参数)"></xxx>
js获取元素:
	方式1:
		var obj=documnet.getElementById("id值");
获取元素的value值
	obj.value;
获取元素的标签体中的内容
	obj.innerHTML;
////////////////////
案例2-步骤分析:
	1.先有一个表单
	2.在form上添加一个事件 onsubmit="return checkForm()"
	3.编写checkForm这个方法
	4.获取每个表单子标签的内容
	5.判断是否满足要求,
		若满足,不用管他
		若不满足,表单不能提交,返回false,且提示信息.
///////////////////////////
函数的定义:
	方式1:
		function 函数名(参数){
			函数体;
		}	
	
	方式2:
		var 函数名=function(参数){
			函数体;
		}
		
js事件和函数的绑定:
	方式1:
		通过标签的事件属性   <xxx onclick="函数名(参数)"></xxx>
	方式2:
		给元素派发事件
			document.getElementById("id值").onclick=function(参数){....}
			document.getElementById("id值").onclick=函数名
		注意:
			内存中应该存在该元素才可以派发事件
		a.将方式2的js代码放在html页面的最下面
		b.在页面加载成功之后在运行方式2的js代码  onload事件.
////////////////////////
案例3-轮播图片
需求:
	每隔3秒图片更新一下
技术分析:
	bom中window对象的定时器方法
定时器:
	var id=setInterVal(code,毫秒数):每隔指定的毫秒数执行一次函数 周期
	var id=setTimeout(code,毫秒数):延迟指定的毫秒数之后 只执行一次函数
	
	清除定时器:
		clearInterval(id);
		claerTimeout(id);
String对象
	原始类型的String是一个为对象可以直接调用String类对象的方法
	substring(0,endIndex);
////////////////
步骤分析:
	1.在首页上面绑定一个onload事件
	2.事件绑定的函数中编写一个定时器
	3.定时器每隔3秒更换图片
		imgObj.src="";
///////////////
补充:
	运算符:
		比较运算符: > >= < <=
		若两边都是数字 和java一样
		若一般为数字,另一边为字符串形式的数字,将字符串形式的数字转换成数字在进行比较   3>"2"
		若一般为数字,另一边为字符串,返回一个false   3>"hello"
		两边都是字符串的时候,比较ascii
	等性运算符 == ===
		== :只判断值是否相同
		===:不仅判断是否相同,还要判断类型是否相同
语句:
	if语句 和java一样
	for while 语句和java一样
	switch 和java一样(区别,switch 后面跟字符串. 还可以跟变量)
/////////////////////////////////////



总结:掌握
	1.css和html整合
		方式3种 
	2.css中选择器:
		id class 元素
		属性 后代 
	3.js
		js和html整合
			方式两种
	4.变量定义
	5.函数定义
		2中格式
	6.事件
		onclick onload onsubmit
	7.事件和函数的绑定
		2中方式
	8.定时器 2种
	9.for while if
	