回顾:
css:
	层叠样式表
	作用:
		渲染页面
		提供工作效率,将html和样式分离
	和html的整合
		方式1:内联样式表
			通过标签的style属性  <xxx style="..."/>
		方式2:内部样式表
			通过head的子标签Style子标签
				<style type="text/css">
					选择器{
						属性:值;
						属性1:值1;
					}
				</style>
		方式3:外部样式表
			有一个独立css文件.后缀名:.css
			在html中通过link标签导入
	
	选择器:
		id选择器
			html元素有id属性且有值   <xx id="d1">
			css中通过 # 导入   #d1{...}
		类选择器
			html元素有class属性且有值 <xx class="c1">
			css中通过 . 导入	.c1{...}
		元素选择器
			css中通过标签名即可  xx{...}
		属性选择器
			html元素有一个属性且有值 <xx att="val1">
			css中通过元素名[属性="值"]使用   xx[att="val1"]{...}
		后代选择器
			选择器 后代选择器
		锚伪类(了解)
	//////////////////
	字体 文本 背景 列表 分类(clear display:none block inline)
	框模型:
		一个元素外边有内边距 边框 外边距
		顺序:上右下左
//////////////////////////////////////
js
	javascript 脚本语言 解释性 基于对象 事件驱动函数
	js的组成:
		ECMAScript(语法)
		BOM(浏览器对象模型)
		DOM(文档对象模型)
	html和js的整合
		方式1:内部编写js
			<script type="text/javascript">js代码</script>
		方式2:
			外部有一个独立的js文件  后缀名:.js
			在html中通过script的src属性导入
				<script src="js的路径"></script>
		注意:
			一旦使用了src属性,那么script标签体中的js代码将不再执行了.
			
	变量:
		var 变量名=初始化值;
	数据类型:
		原始类型(5种)
			Undefined
			Null
			String 用引号引起来的内容
			Number
			Boolean
			
			通过typeof可以判断一个值或者变量是否是原始类型,若是原始类型,还可以判断属于那种.
				typeof 变量|值
		引用类型
	运算符:
		关系运算符:
			两边值都是字符串,比较ascii码
			两边都是数字,和java一样
			一边是数字,一遍是字符串形式的数字, 可以比较
			一边是数字,一遍是普通字符串 可以比较 值永远是false
		等性运算符
			"66"==66  true
			"666"===666 false
	js的语句
		if while for 和java一样
	//////////////////
	获取元素:
		var obj=document.getElementById("id值");
	获取元素的value属性
		var val=document.getElementById("id值").value;
	设置元素的value属性	
		document.getElementById("id值").value="sdfsdf";
	获取元素的标签体 
		var ht=document.getElementById("id值").innerHTML;
	设置元素的标签体
		document.getElementById("id值").innerHTML="ssss";
	
	定义函数:
		方式1:function 函数名(参数列表){函数体}
		方式2:
			var 函数名=function(参数列表){函数体}
		注意:
			函数声明的时候不用声明返回值类型
			参数列表上不要写参数类型
			通过return结束方法和将值返回
	
	事件:
		onclick 单击
		onsubmit 表单提交
		onload  页面加载成功或者元素加载成功
		
	事件和函数绑定
		方式1:通过元素的事件属性
			<xxx onxxx="函数名(参数列表)">
		方式2:派发事件
			document.getElementById("id值").onxxx=function(){...};
			document.getElementById("id值").onxxx=函数名;
/////////////////////////////////
案例1-定时弹出广告
需求:
	打开页面后4秒,展示广告,2秒之后,该广告隐藏.再停2秒,继续展示.
技术分析:
	定时器
定时器(BOM-window对象)
	setInterval(code,毫秒数):周期执行
	setTimeout(code,毫秒数):延迟多长事件后 只执行一次.
	
	清除定时器
		clearInterval(id):
		clearTimeout(id):
步骤分析:
	1.确定事件
	2.编写函数
		a.获取元素
		b.操作元素
////////////////////////
	1.html页面,先把广告隐藏
	2.页面加载成功事件 onload
	3.编写函数
		定时器:
		操作元素:
			document.getElementById("")
		操作css属性
			document.getElementById("id").style.属性="值"
			属性:就是css中属性 css属性有"-" 例如:backgroud-color
				若有"-" 只需要将"-"删除,后面第一个字母变大写即可
	注意:
		只要是window对象的属性和方法,可以把window省略
			window.onload 等价于 onload
			window.setInterval() 等价于 setInterval()
////////////////////
bom(浏览器对象模型)总结
	所有的浏览器都有5个对象
		window:窗口
		location:定位信息 (地址栏)
		history:历史
window对象详解:
	如果文档包含框架（frame 或 iframe 标签），浏览器会为 HTML 文档创建一个 window 对象，
	并为每个框架创建一个额外的 window 对象。
	常用的属性:
		通过window可以获取其他的四个对象
			window.location 等价域 location
			window.history 等价于 history
			...
	常用的方法
		消息框
			alert("...."):警告框
			confirm("你确定要删除吗?"):确定框 返回值:boolean
			prompt("请输入您的姓名"):输入框 返回值:你输入的内容
		定时器
			设置定时器
				setInterval(code,毫秒数):周期执行
				setTimeout(code,毫秒数):延迟多长事件后 只执行一次.
				
				例如:
					setInterval(showAd,4000);
					serInterval("showAd()",4000);
			
			清除定时器
				clearInterval(id):
				clearTimeout(id):
		打开和关闭
			open(url):打开
			close():关闭
/////////////////////////
location:定位信息	
	常用属性:
		href:获取或者设置当前页面的url(定位信息)
		
		location.href; 获取url
		location.href="...";设置url 相当于 a标签
//////////////////////
history:历史
	back();后退
	forward():向前
	★go(int)
		go(-1) 相当于 back()
		go(1) 相当于 forward()
//////////////////////////////////////
案例2-表单校验plus
需求:
	提示信息不用弹出框,将信息追加在文本框后面
技术分析:
	确定事件 表单提交的时候 onsubmit
			文本框失去焦点的时候 onblur
	编写函数
	获取元素
		document.getElementById("id值");
	操作元素(获取元素的值,操作标签体,操作标签value属性)
/////////////////
步骤分析:
	1.表单
	2.表单提交的时候 确定事件 onsubmit()
	3.校验用户名和密码
	4.获取用户名和密码的对象及值
	5.判断内容,当为空的时候,获取响应的span元素
		往span元素中显示错误信息
////////////////////////
注意:
	在方法中(function()) this指代的是当前的元素(当前dom对象)
例如:
	<input type="text" name="username" id="username" onblur="loseFocus(this.value)">
	方法:
		function loseFocus(obj){
			alert(obj);
		}
/////////////////////////////
事件总结:
	常见的事件:
		焦点事件:★
			onfocus
			onblur
		表单事件:★
			onsubmit
			onchange 改变
		页面加载事件:★
			onload
		
		鼠标事件(掌握)
			onclick
		鼠标事件(了解)
			ondblclick:双击
			onmousedown:按下
			onmouserup:弹起
			onmousemove:移动
			onmouserover:悬停
			onmouserout:移出
		键盘事件(理解)
			onkeydown:按下
			onkeyup:弹起
			onkeypress:按住
////////////
绑定事件:
	方式1:
		元素的事件属性
	方式2:
		派发事件
///////////////////
了解
	阻止默认事件的发生
	阻止事件传播
/////////////////
案例3-隔行换色
需求:
	一个表格,隔一行换一个色
技术分析:
	事件:onload 
	获取元素:dom操作
///////////////
获取元素:
	document.getElementById("id"):通过id获取一个元素
	document.getElementsByTagName("标签名"):通过标签名获取一种元素(多个)返回一个数组
Array:
	常用属性:
		length:数组的长度
////////////////////////
步骤分析:
	1.html表格一加载的时候 确定事件 onload
	2.编写函数
		a.获取元素(所有的tr元素)
		b.操作(若当前行是偶数的话加一个样式,若是奇数的话,加另一个样式)
////////
	//页面加载成功
			onload=function(){
				//1.获取所有的tr
				var arr=document.getElementsByTagName("tr");
				//alert(arr);
				//alert(arr.length);
				
				//2.判断奇偶数 添加不同的样式 遍历数组
				for(var i=1;i<arr.length;i++){
					if(i%2==0){
						arr[i].style.backgroundColor="#FFFFCC";
					}else{
						arr[i].style.backgroundColor="#BCD68D";
					}
				}
				
			}
//////////////////////////
案例4:全选或者全不选
步骤分析:
	1.确定事件 最上面那个复选框的单击事件 onclick
	2.编写函数:让所有的复选框和最上面的复选框状态保持一致
		a.获取最上面这个复选框选中状态 通过checkbox的checked属性即可
		b.获取其他的复选框,设置他们的checked属性即可
			可以通过以下两种方案获取元素
				document.getElementsByClassName():需要给下面所有的复选框添加class属性
				document.getElementsByName():需要给下面所有的复选框添加name属性

//////////////////////////////////
dom(文档对象模型)
	当浏览器接受到html代码的时候,浏览器会将所有的代码装载到内存中,形成一棵树(document树)
	节点(Node)
		文档节点 document
		元素节点 element
		属性节点 attribute
		文本节点 text
	获取节点:
		通过document可以获取其他节点:
			常用方法:
				document.getElementById("id值"):获取一个特定的元素
				document.getElementsByTagName("标签名"):通过标签名获取一种元素(多个)
				document.getElementsByClassName("class属性的值"):通过class属性获取一类元素(多个)
				document.getElementsByName("name属性的值"):通过name属性获取一类元素(多个)
		设置获取获取节点的value属性
			dom对象.value;获取
			dom对象.value="";设置
		设置或者获取节点的标签体
			dom对象.innerHTML;获取
			dom对象.innerHTML="";设置
		获取或者设置style属性
			dom对象.style.属性;获取
			dom对象.style.属性="";设置
		获取或者设置属性
			dom对象.属性
/////////////////////////
对于htmldom的操作若在js或者htmldom 查找不到 去查找xml dom
	关于文档的操作 在 xml dom 的document中
	关于元素的操作 在 xml dom 的element中
		appendChild(dom对象):在一个元素下添加孩子
//////////////////////////////////////
案例5-左右选中.
需求:
技术分析:
	1.确定事件,按钮的单击事件
	2.编写函数:
		点击移动单|多个的:
			a.获取左边选中的选项  select对象.options--数组
				遍历数组 判断是否选中 option对象.selected
			b.将其追加到右边的下拉选中
				rightSelect对象.appendChild(option);
		点击移动所有的
			a.获取左边的所有的选项
			b.一个个的追加过去
///////////////////////
案例6-省市联动
需求:
	选中省的时候,动态的查询当前省下的所有市,然后展示在市的下拉选中
技术分析:
	数组:
////////////////////////
数组:
	语法:
		new Array();//长度为0
		new Array(size);//指定长度的
		new Array(e1,e2..);//指定元素
		非官方
			var arr4=["aa","bb"];
	常用属性:
		length
	注意:
		数组是可变的
		数组可以存放任意值
	常用方法:(了解)
		存放值:对内容的操作
			pop():弹	最后一个
			push():插入 到最后
			
			shift():删除第一个
			unshift():插入到首位
		打印数组:
			join(分隔符):将数组里的元素按照指定的分隔符打印
		拼接数组:
			concat():连接两个或更多的数组，并返回结果。
		对结构的操作:
			sort();排序
			reverse();反转
////////////////////////
步骤分析:
	1.省的下拉选 的选项中添加value属性 当成数组的索引
	2.初始化市
	3.选择省的时候,onchange事件
	4.编写函数,
		通过获取的索引获取对象的市的数组 this.value
		遍历数组,将数组里面的每个值组装option 添加到select中即可
			
//////////////////////////////
引用类型总结:
	原始类型中的String Number Boolean都是伪对象,可以调用相应的方法
	Array:数组
	String:
		语法:
			new String(值|变量);//返回一个对象
			String(值|变量);//返回原始类型
		常用方法:
			substring(start,end):[start,end)
			substr(start,size):从索引为指定的值开始向后截取几个
			
			charAt(index):返回在指定位置的字符。
			indexOf(""):返回字符串所在索引
			
			replace():替换
			split():切割
			
		常用属性:length	
	Boolean:
		语法:
			new Boolean(值|变量);
			Boolean(值|变量);
			非0数字 非空字符串 非空对象 转成true
	Number
		语法:
			new Number(值|变量);
			Number(值|变量);
		注意:
		
			null====>0 
			fale====>0 true====>1
			字符串的数字=====>对应的数字
			其他的NaN
	Date:
		new Date();
		常用方法:
			toLocalString()
	RegExp:正则表达式
		语法:
			直接量语法  /正则表达式/参数
			直接量语法  /正则表达式/
			
			new RegExp("正则表达式")
			new RegExp("正则表达式","参数") 
			参数:
				i:忽略大小写
				g:全局
			常用方法:
				test() :返回值为boolean
	Math:
		Math.常量|方法
		Math.PI
		Math.random()  [0,1)
		
	全局:
		★
		decodeURI() 解码某个编码的 URI。 
		encodeURI() 把字符串编码为 URI。

		Number():强制转换成数字
		String():转成字符串
		
		parseInt():尝试转换成整数
		parseFloat():尝试转换成小数
		
		eval() 计算 JavaScript 字符串，并把它作为脚本代码来执行。 
		
		
			
			
//////////////////////////////////////////////////////////////////////
			

BOM(浏览器对象模型)
	window对象:窗口
		注意:
			若是window对象的属性和方法,调用的时候可以省略window
		常用属性:
			通过window可以获取其他的四个对象
				window.location 等价于 location
	
		常用方法:
			消息框
				alert() 警告框
				confirm() 确认框 返回值:boolean
				prompt()	输入框 返回值:输入的内容
			定时器
				设置
					setInterval(code,毫秒数):循环
					setTimeout(code,毫秒数):延迟 只执行一次
				清除
					clearInterval(id):
					clearTimeout(id):
			打开和关闭
				open(url)
				close()
	location对象:定位信息 地址栏
		常用属性:
			href:获取或者设置当前页面的url
				location.href:获取
				location.href="url":设置 相当于超链接
	history对象:操作历史
		常用方法:
			go()
////////////////////////////
事件:
	焦点:★
		onfocus:获取焦点
		onblur:失去焦点
	表单事件:★
		onsubmit: form表单里的
		onchange:改变(下拉选)
	页面或者对象加载:★
		onload:
	鼠标:★
		onclick:单击
	键盘:
		onkeyup:

		
dom(★)
	获取元素的方法(4个) document
	操作元素的属性  dom对象.属性;

引用类型:
	array
	string
		substring
	全局:
		编码2个
		强制转化 Number String
		尝试  parseXxx
		eval() 解析字符串形式的js代码
	Math random()
	
	

			
			
			
			
			
			