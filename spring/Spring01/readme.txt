## ����γ̣�Spring��ܵ�һ�� ##
	
----------
	
**Spring��ܵ�ѧϰ·��**
	
	1. Spring��һ�죺Spring��IOC����֮XML�ķ�ʽ��Spring�����Web��Ŀ����
	2. Spring�ڶ��죺Spring��IOC����֮ע��ķ�ʽ��Spring��AOP����
	3. Spring�����죺Spring���������Spring��ܵ�JDBCģ��
	4. Spring�����죺SSH�����ܵ�����
	
----------
	
**�������ݸ���**
	
	1. Spring��ܵĸ���
	2. SpringIOC�Ŀ�������
	3. IoC����XML�ķ�ʽ
	4. ��web��Ŀ�м���Spring
	
----------
	
### ����һ��ʹ��Spring��IOC������ɿͻ��ı��湦�� ###
	
----------
	
**�������**
	
	1. ʹ��Spring��IOC������ɿͻ��ı��湦��
	
----------
	
### ��������֮Spring��ܵĸ��������� ###
	
----------
	
**��������֮ʲô��Spring���**
	
	1. Spring��ܵĸ���
		* Spring��һ����Դ���
		* Spring����2003 �������һ����������Java������ܣ���Rod Johnson��������Expert One-On-One J2EE Development and Design�в����Ĳ��������ԭ������������
		* ����Ϊ�˽����ҵӦ�ÿ����ĸ����Զ������ġ���ܵ���Ҫ����֮һ������ֲ�ܹ����ֲ�ܹ�����ʹ����ѡ��ʹ����һ�������ͬʱΪ J2EE Ӧ�ó��򿪷��ṩ���ɵĿ�ܡ�
		* Springʹ�û�����JavaBean�������ǰֻ������EJB��ɵ����顣Ȼ����Spring����;�������ڷ������˵Ŀ������Ӽ��ԡ��ɲ����Ժ�����ϵĽǶȶ��ԣ��κ�JavaӦ�ö�����	��Spring�����档
		* Spring�ĺ����ǿ��Ʒ�ת��IoC�����������棨AOP��������˵��Spring��һ���ֲ��JavaSE/EEfull-stack(һվʽ) ��������Դ��ܡ�
		
		* EE�����ֳ�����ṹ
			* WEB��		-- Spring MVC
			* ҵ���	-- Bean����:(IOC)
			* �־ò�	-- Spring��JDBCģ��.ORMģ���������������ĳ־ò���
	
----------
	
**��������֮Spring��ܵ��ص�**
	
	1. ΪʲôҪѧϰSpring�Ŀ��
		* �������򻯿���
			* Spring����һ���󹤳������Խ����ж��󴴽���������ϵά��������Spring����
		* AOP��̵�֧��
			* Spring�ṩ���������̣����Է����ʵ�ֶԳ������Ȩ�����ء����м�صȹ���
		* ����ʽ�����֧��
			* ֻ��Ҫͨ�����þͿ�����ɶ�����Ĺ����������ֶ����
		* �������Ĳ���
			* Spring��Junit4֧�֣�����ͨ��ע�ⷽ��Ĳ���Spring����
		* ���㼯�ɸ���������
			* Spring���ų��������Ŀ�Դ��ܣ����ڲ��ṩ�˶Ը��������ܣ��磺Struts2��Hibernate��MyBatis��Quartz�ȣ���ֱ��֧��
		* ����JavaEE API��ʹ���Ѷ�
			* Spring ��JavaEE�����зǳ����õ�һЩAPI��JDBC��JavaMail��Զ�̵��õȣ������ṩ�˷�װ��ʹ��ЩAPIӦ���Ѷȴ�󽵵�
	
	2. Spring��ܵİ汾
		* Spring3.x��Spring4.x�İ汾
	
----------
	
**��������֮Spring��ܵ�IOC���Ĺ��ܿ�������**
	
	1. ʲô��IOC�Ĺ��ܣ�
		* IoC		-- Inverse of Control�����Ʒ�ת��������Ĵ���Ȩ��ת��Spring����
		* ʹ��IOC���Խ���ĳ�������Ըߵ����⣡��
	
![](./ͼƬ/01-IOC.bmp)	
	
	2. ����һ������Spring��ܵĿ�����
		* ������http://spring.io/
		* ���ص�ַ��http://repo.springsource.org/libs-release-local/org/springframework/spring��ѹ:(SpringĿ¼�ṹ:)
			* docs		-- API�Ϳ����淶
			* libs		-- jar����Դ��
			* schema	-- Լ��
	
	3. �����������JavaWEB��Ŀ������Spring�Ŀ�����
		* ����Spring���IOC���Ĺ�����Ҫ�ľ����jar��
			* Spring��ܵ�IOC�Ĺ��ܣ���ô����Spring��ܵ���ϵ�ṹͼ�ܿ�����ֻ��Ҫ�������µ�jar��
				* Beans
				* Core
				* Context
				* Expression Language
			
			* Spring���Ҳ��Ҫ������־��ص�jar��
				* ��spring-framework-3.0.2.RELEASE-dependencies/org.apache.commons/com.springsource.org.apache.commons.logging/1.1.1
					* com.springsource.org.apache.commons.logging-1.1.1.jar
				
				* ����Ҫ����log4j��jar�� spring-framework-3.0.2.RELEASE-dependencies\org.apache.log4j\com.springsource.org.apache.log4j\1.2.15
					* com.springsource.org.apache.log4j-1.2.15.jar
	
	4. ��������������Ӧ�İ��ṹ����дJava���࣬Ҫע�⣺�Ժ�ʹ��Spring���������������Ҫ����д�ӿ���ʵ���࣡��
		* com.itcast.demo1
			* UserService			-- �ӿ�
			* UserServiceImpl		-- �����ʵ����
	
	5. �����ģ����UserServiceImplʵ����Ĵ�������Spring�����������Ҫ����Spring��ܵ������ļ����������
		* ��srcĿ¼�´���applicationContext.xml�������ļ��������ǿ�������ģ�����һ�㶼��ʹ��Ĭ�����ƣ���
		
		* ����spring��Լ������Ҫ���ҵ������Լ��ͷ��Ϣ����
			* spring-framework-3.2.0.RELEASE\docs\spring-framework-reference\html\xsd-config.html
			* �����Լ�����£�		
				<beans xmlns="http://www.springframework.org/schema/beans"
				    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				    xsi:schemaLocation="
				        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
				</beans>
		
		* ���UserService������
			<!-- Spring�Ŀ������� -->
			<bean id="userService" class="com.itcast.demo1.UserServiceImpl"/>
	
	6. �����壺��д���Գ��򣬲���Spring��ܵĹ�����ʽ����ȡ��UserService�ӿڵľ���ʵ���࣡��
		public void demo2(){
			// ʹ��Spring�Ĺ���:
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			// ͨ�����������:
			UserService userService = (UserService) applicationContext.getBean("userService");
			userService.sayHello();
		}
	
----------
	
**�����ܽ�֮Spring����еĹ������˽⣩**
	
	1. ApplicationContext�ӿ�
		* ʹ��ApplicationContext�����Ľӿڣ�ʹ�øýӿڿ��Ի�ȡ�������Bean����
		* �ýӿ��������������ʵ����
			* ClassPathXmlApplicationContext			-- ������·���µ�Spring�����ļ�
			* FileSystemXmlApplicationContext			-- ���ر��ش����µ�Spring�����ļ�
	
	2. BeanFactory��������Spring������ڵĴ���Bean����Ĺ����ӿڣ�
		* ʹ��BeanFactory�ӿ�Ҳ���Ի�ȡ��Bean����
			public void run(){
				BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
				UserService us = (UserService) factory.getBean("us");
				us.sayHello();
			}
		
		* BeanFactory��ApplicationContext������
			* BeanFactory				-- BeanFactory��ȡ�ӳټ��أ���һ��getBeanʱ�Ż��ʼ��Bean
			* ApplicationContext		-- �ڼ���applicationContext.xmlʱ��ͻᴴ�������Bean�����ʵ�������ṩ��һЩ�����Ĺ���
				* �¼�����
				* Bean�Զ�װ��
				* ���ֲ�ͬӦ�ò��Contextʵ��
	
----------
	
**�����ܽ�֮����Spring��ܱ�дXML����ʾ**
	
	1. ����һ���ȸ��ƣ� http://www.springframework.org/schema/beans/spring-beans.xsd	
	2. �����������XML Catalog�����Add��ť
	3. ����������ѡ��Location��schema��Լ����ַ
		* E:\class\2016\JavaEE28\day35_Spring��ܵ�һ��\����\spring-framework-4.2.4.RELEASE-schema\beans\spring-beans-4.2.xsd
	4. �����ģ�ע�⣺Key typeҪѡ��Schema location
	5. �����壺Key��http://www.springframework.org/schema/beans/spring-beans.xsd������
	
----------
	
### ��������֮Spring��ܵ�Bean����������ļ���ʽ ###
	
----------
	
**��������֮Spring�����<bean>��ǩ������**
	
	1. id���Ժ�name���Ե�����
		* id		-- Bean������֣���Լ���в���ID��Լ����Ψһ
			* ȡֵҪ�󣺱�������ĸ��ʼ������ʹ����ĸ�����֡����ַ����»��ߡ��仰��ð��	id:���ܳ��������ַ�
		
		* name		-- Bean������֣�û�в���ID��Լ�����˽⣩
			* ȡֵҪ��name:���������ַ�.���<bean>û��id�Ļ� , name���Ե���idʹ��
			* Spring���������Struts1�Ŀ�ܵ�ʱ��Struts1�Ŀ�ܵķ���·������/��ͷ�ģ����磺/bookAction
	
	2. class����			-- Bean�����ȫ·��
	3. scope����			-- scope���Դ���Bean�����÷�Χ
		* singleton			-- ������Ĭ��ֵ��
		* prototype			-- ��������Spring�������Struts2��ܵ�ʱ��Action��Ҳ��Ҫ����Spring���������ð�Action�����óɶ�������
		* request			-- Ӧ����Web��Ŀ��,ÿ��HTTP���󶼻ᴴ��һ���µ�Bean
		* session			-- Ӧ����Web��Ŀ��,ͬһ��HTTP Session ����һ��Bean
		* globalsession		-- Ӧ����Web��Ŀ��,����������session
	
	4. Bean����Ĵ��������ٵ������������ã��˽⣩
		* ˵����Spring��ʼ��bean������beanʱ����ʱ��Ҫ��һЩ�����������spring�����ڴ����Ͳ�жbean��ʱ�����bean�������������ڷ���
		* init-method		-- ��bean�����뵽������ʱ�����init-method����ָ���ķ���
		* destroy-method	-- ��bean��������ɾ����ʱ�����destroy-method����ָ���ķ���
			* ��鿴destroy-method��Ч��������������
				* scope= singleton��Ч
				* web�����л��Զ����ã�����main���������������Ҫ�ֶ����ã���Ҫʹ��ClassPathXmlApplicationContext��close()������
	
----------
	
**��������֮����ע�루DI��**
	
	1. IOC��DI�ĸ���
		* IOC		-- Inverse of Control�����Ʒ�ת��������Ĵ���Ȩ��ת��Spring����
		* DI		-- Dependency Injection������ע�룬��Spring��ܸ��𴴽�Bean����ʱ����̬�Ľ���������ע�뵽Bean����У���
	
	2.  DI������ע�룩
		* ���磺���UserServiceImpl��ʵ��������һ�����ԣ���ôʹ��Spring��ܵ�IOC����ʱ������ͨ������ע��Ѹ����Ե�ֵ�����������
		* �������������
			<bean id="us" class="com.itheima.demo1.UserServiceImpl">
				<property name="uname" value="С��"/>
			</bean>
	
----------
	
**��������֮Spring��ܵ�����ע��**
	
	1. �������Ա���������õ�ע�뷽ʽ������
		* ���캯��ע��
		* ����setter����ע��
	
	2. ��Spring������ṩ��ǰ���ֵ�����ע��ķ�ʽ
		1. ���췽����ע�뷽ʽ������
			* ��дJava���࣬�ṩ���췽��
				public class Car {
					private String name;
					private double money;
					public Car(String name, double money) {
						this.name = name;
						this.money = money;
					}
					@Override
					public String toString() {
						return "Car [name=" + name + ", money=" + money + "]";
					}
				}
			
			* ��д�����ļ�
				<bean id="car" class="com.itheima.demo4.Car">
					<constructor-arg name="name" value="��"/>
					<constructor-arg name="money" value="100"/>
				</bean>
		
		2. ���Ե�setter������ע�뷽ʽ
			* ��дJava���࣬�ṩ���ԺͶ�Ӧ��set��������
			* ��д�����ļ�
		
		3. ���Java�����������һ��Java���࣬��ô��Ҫ��ô��ע��ֵ�أ�
			* <property name="name" rel="�����Bean��ID����name��ֵ"/>
			* ���磺
				<bean id="person" class="com.itheima.demo4.Person">
					<property name="pname" value="����"/>
					<property name="car2" ref="car2"/>
				</bean>
	
----------
	
**��������֮Spring��2.5�汾���ṩ��һ��:p���ƿռ��ע�루�˽⣩**
	
	1. ����һ����Ҫ������ p ���ƿռ�
		* ��schema�����ƿռ��м�����У�xmlns:p="http://www.springframework.org/schema/p"
	
	2. �������ʹ��p���ƿռ���﷨
		* p:������ = ""
		* p:������-ref = ""
	
	3. ������������
		* <bean id="person" class="com.itheima.demo4.Person" p:pname="����" p:car2-ref="car2"/>
	
----------
	
**��������֮Spring��3.0�ṩ��һ��:SpELע�뷽ʽ���˽⣩**
	
	1. SpEL��Spring Expression Language��Spring�ı��ʽ���ԣ���һЩ�Լ����﷨
	2. �﷨
		* #{SpEL}
	
	3. �������µĴ���
		<!-- SpEL�ķ�ʽ -->
		<bean id="person" class="com.itheima.demo4.Person">
			<property name="pname" value="#{'С��'}"/>
			<property name="car2" value="#{car2}"/>
		</bean>
	
	4. ��֧�ֵ������е����Ի��߷���
		* ������ͷ���������
			public class CarInfo {
				public String getCarname(){
					return "����QQ";
				}
			}
	
----------
	
**��������֮���飬����(List,Set,Map)��Properties�ȵ�ע��**
	
	1. ������������List���ϣ�ע�������ļ��ķ�ʽ��һ����
		<bean id="collectionBean" class="com.itheima.demo5.CollectionBean">
			<property name="arrs">
				<list>
					<value>����</value>
					<value>С��</value>
				</list>
			</property>
		</bean>
	
	2. �����Set���ϣ�ע��������ļ���ʽ���£�
		<property name="sets">
			<set>
				<value>����</value>
				<value>�Ǻ�</value>
			</set>
		</property>
	
	3. �����Map���ϣ�ע������÷�ʽ���£�
		<property name="map">
			<map>
				<entry key="����2" value="38"/>
				<entry key="���" value="38"/>
				<entry key="�绨" value="29"/>
			</map>
		</property>
	
	4. �����properties�����ļ��ķ�ʽ��ע����������£�
		<property name="pro">
			<props>
				<prop key="uname">root</prop>
				<prop key="pass">123</prop>
			</props>
		</property>
	
----------
	
**��������֮Spring��ܵ������ļ��ֿ������˽⣩**
	
	1. ���磺��src��Ŀ¼���ֶഴ����һ�������ļ����������������ĵ������ļ�����ô���������������ļ��ķ�ʽ�����֣�
		* �������ļ��а��������������ļ�:
			<import resource="applicationContext2.xml"/>
		
		* ����������ʱ��ֱ�Ӽ��ض�������ļ�:
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
						"applicationContext.xml","applicationContext2.xml");
	
----------
	
### Spring�������WEB ###
	
----------
	
**Spring�������WEB���������յķ�����**
	
	1. ����JavaWEB��Ŀ������Spring�Ŀ���������д�������ͷ�����
		* ������ú�������������������Ŀ������ÿ����һ�ζ������һ�������ļ�������Ч�ʻ�ǳ��ǳ�������
	
	2. ������������
		* ���������������Ժ���뵽ServletContext����.ʹ�ù�����ʱ��,��ServletContext�л��.
			* ServletContextListener:��������ServletContext����Ĵ��������ٵļ�����.
			* ��ServletContext���󴴽���ʱ��:�������� , ���������뵽ServletContext
	
	3. Spring����Web��Ŀ
		* ����spring-web-4.2.4.RELEASE.jar��
		* ���ü�����
			 <!-- ����Spring�ĺ��ļ�����: -->
			 <listener>
			 	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
			 </listener>
			 <context-param>
			 	<param-name>contextConfigLocation</param-name>
			 	<param-value>classpath:applicationContext.xml</param-value>
			 </context-param>
	
	4. �޸�servlet�Ĵ���
		* ��ServletContext�л�ù���
		* �����������
			ServletContext servletContext = ServletActionContext.getServletContext();
			// ��Ҫʹ��WEB�Ĺ����ķ�ʽ
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			CustomerService cs = (CustomerService) context.getBean("customerService");
			cs.save();	
	
----------
	
	
	

	
