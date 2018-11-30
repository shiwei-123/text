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
		//ʹ��Javaԭ���ķ��� ����HelloWorld ���ҵ������еķ���������
		HelloWorld world = new  HelloWorld();
		world.setName("Java");
		world.sayHello();
	}
	//@Test
	public void test02() {
		/**
		 * 1.����Spring: ����
		 * 2.��д�����ļ� application.xml
		 * 3.�������ļ���Ϊ������JavaBean
		 */
		/**
		 * 1.���ص�ǰSpring�е�application.xml�ļ�
		 * 2.ͨ��id��ȡ��Ҫʹ����Ķ���
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		//ͨ��Ψһ��ʶid ��ȡҪʹ�õ�bean
		HelloWorld world = (HelloWorld) context.getBean("helloWorld");
//		world.setName("Spring");
		world.sayHello();
	}
	//@Test
	public void test03() {
		//java	��������
		//���췽��
		Calendar calendar = new GregorianCalendar();
		System.out.println(calendar);
		//��������
		Calendar calendar2 = Calendar.getInstance();
		System.out.println(calendar2);
		//������̬����
		Date date = calendar2.getTime();
		System.out.println(date);
	}
	
	/**
	 * ����SpringIOC��������
	 * һ����������
	 * 1.���췽��
	 * 	Java:Calendar calendar = new GregorianCalendar();
	 * 	Spring:<bean id="helloWorld" class="com.myspring.demo.HelloWorld"></bean>
	 * 	Ҫ��:��ǰ����������޲ι��췽��
	 * 	��ȡ:ʵ��������:ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
	 * 	 context.getBean("helloWorld");
	 * 2.������̬����
	 * 	Java:Date date = calendar2.getTime();
	 * 3.��������
	 * 	Java:Calendar calendar2 = Calendar.getInstance();
	 * ����Ϊ���Ը�ֵ
	 * 
	 * 	Ҫ��:���޲ι��췽��
	 * 1.<bean id="helloWorld" class="com.myspring.demo.HelloWorld"></bean>
	 * 	<property name="name" value="Spring"></property>
		</bean>
		Ҫ��:name������е���������һ��,value:Ĭ��Ϊ��ǰ���Ը���ֵ
		��ǰ���Ա�����setName()����
		3.Ϊ�����е����Ը�ֵ
	
	 */
	//@Test
	public void test04() {
		//ʵ��������
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Calendar calendar = context.getBean("calendar",Calendar.class);
		System.out.println(calendar);
		//���þ�̬������ķ�ʽ��������
		Calendar calendar2 = context.getBean("calendar1",Calendar.class);
		System.out.println(calendar2);
		//���ù�������ķ�����������
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
		//��ȡ����
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Computer computer = context.getBean("computer",Computer.class);
		computer.readData();
	}
	/**
	 * ����ע�ⷽʽ���IOC
	 * 1.��application�����ͳһע��ɨ��
	 * 	base-package:��Ŀ��Ŀ¼
	 * 	<context:component-scan base-package="com.myspring.demo"></context:component-scan>
		2.������Ҫ����ǰ��ע��:
			@Controller:�����ڿ����������ʹ��
			@Service:������ҵ�������ʹ��
			@Repository:������DAO�����ʹ��
			@Componet:�������ʹ��
			@Name://��Ҫ����jar��
		3.��ȡ
			3-1:��ȡ����
			3-2:��ȡ����:����.getBean("id",����);
				id:Ĭ����������ĸСд,ʣ�µĲ���
				@Componet:("c"):id��Ϊc ���ǲ��������
			�ص�:1.SpringĬ�ϴ�������ķ�ʽΪ����ģʽ
			��θ����Ƿ���: @Scope("prototype"):�ǵ���
						@Scope("singleton"):����Ҳ��Ĭ�ϵ�����ֵ
			��ͬ��:<bean id = "" class = "" scope="prototype(�ǵ���)singleton(Ĭ�ϵ���)"
			2.Ĭ����Ҫһ���޲ι��췽��
	 */
	@Test
	public void test07() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		System.out.println(context);
		Car car = context.getBean("car",Car.class);
		System.out.println(car);
		car.setCarType("����");
		
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
