package com.myspring.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	
	//@Test
	public void test01() {
		//使用Java原生的方法 创建HelloWorld 并且调用其中的方法和属性
		HelloWorld world = new  HelloWorld();
		world.setName("Java");
		world.sayHello();
	}
	//@Test
	public void test02() {
		/**
		 * 1.利用Spring: 导包
		 * 2.书写配置文件 application.xml
		 * 3.在配置文件中为其设置JavaBean
		 */
		/**
		 * 1.加载当前Spring中的application.xml文件
		 * 2.通过id获取想要使用类的对象
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		//通过唯一标识id 获取要使用的bean
		HelloWorld world = (HelloWorld) context.getBean("helloWorld");
//		world.setName("Spring");
		world.sayHello();
	}
	//@Test
	public void test03() {
		//java	创建日历
		//构造方法
		Calendar calendar = new GregorianCalendar();
		System.out.println(calendar);
		//工厂对象
		Calendar calendar2 = Calendar.getInstance();
		System.out.println(calendar2);
		//工厂静态方法
		Date date = calendar2.getTime();
		System.out.println(date);
	}
	
	/**
	 * 利用SpringIOC创建对象
	 * 一、创建对象
	 * 1.构造方法
	 * 	Java:Calendar calendar = new GregorianCalendar();
	 * 	Spring:<bean id="helloWorld" class="com.myspring.demo.HelloWorld"></bean>
	 * 	要求:当前该类必须有无参构造方法
	 * 	获取:实例化容器:ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
	 * 	 context.getBean("helloWorld");
	 * 2.工厂静态方法
	 * 	Java:Date date = calendar2.getTime();
	 * 3.工厂对象
	 * 	Java:Calendar calendar2 = Calendar.getInstance();
	 * 二、为属性赋值
	 * 
	 * 	要求:有无参构造方法
	 * 1.<bean id="helloWorld" class="com.myspring.demo.HelloWorld"></bean>
	 * 	<property name="name" value="Spring"></property>
		</bean>
		要求:name与对象中的属性名字一致,value:默认为当前属性赋的值
		当前属性必须有setName()方法
		3.为对象中的属性赋值
	
	 */
	//@Test
	public void test04() {
		//实例化容器
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Calendar calendar = context.getBean("calendar",Calendar.class);
		System.out.println(calendar);
		//采用静态工厂类的方式创建对象
		Calendar calendar2 = context.getBean("calendar1",Calendar.class);
		System.out.println(calendar2);
		//采用工厂对象的方法创建对象
		Date date = context.getBean("date",Date.class);
		System.out.println(date);
	}
	//@Test
	public void test05() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//		Upan upan = context.getBean("upan",Upan.class);
//		System.out.println(upan);
		Computer computer = new Computer(new Upan());
		computer.readData();
		
	}
	//@Test
	public void test06() {
		//获取容器
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Computer computer = context.getBean("computer",Computer.class);
		computer.readData();
	}
	/**
	 * 利用注解方式添加IOC
	 * 1.在application中添加统一注解扫描
	 * 	base-package:项目根目录
	 * 	<context:component-scan base-package="com.myspring.demo"></context:component-scan>
		2.在所需要的类前加注释:
			@Controller:建议在控制器组件中使用
			@Service:建议在业务组件中使用
			@Repository:建议在DAO组件中使用
			@Componet:其他组件使用
			@Name://需要引入jar包
		3.获取
			3-1:获取容器
			3-2:获取对象:容器.getBean("id",类型);
				id:默认类名首字母小写,剩下的不变
				@Componet:("c"):id变为c 但是不建议更改
			特点:1.Spring默认创建对象的方式为单例模式
			如何更改是否单例: @Scope("prototype"):非单例
						@Scope("singleton"):单例也是默认的属性值
			等同于:<bean id = "" class = "" scope="prototype(非单例)singleton(默认单例)"
			2.默认需要一个无参构造方法
	 */
	@Test
	public void test07() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context);
		Car car = context.getBean("car",Car.class);
		System.out.println(car);
		car.setCarType("三厢");
		
		HelloWorld world = context.getBean("helloWorld",HelloWorld.class);
		System.out.println(world);
		
		Computer computer = context.getBean("computer",Computer.class);
		System.out.println(computer);
		Upan upan = context.getBean("upan",Upan.class);
		MovePan movePan = context.getBean("movePan",MovePan.class);
		System.out.println(upan);
		System.out.println(movePan);
		
//		computer.setiUsb(movePan);
		computer.readData();
	}
	

}
