package cn.itcast.oa.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	private Log log=LogFactory.getLog(getClass());
	
	@Test
	public void testLog() throws Exception{
		log.debug("这是debug");
		log.info("这是info");
		log.warn("这是warn");
		log.error("这是error");
		log.fatal("这是fatal");
	}
	
	// 测试SessionFactory
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}

	// 测试事务
	@Test
	public void testTransaction() throws Exception {
		TestService testService  = (TestService) ac.getBean("testService");
		testService.saveTwoUsers();
		logToFile("保存了两个用户");
	}
	
	private static void logToFile(String message){
		System.out.println(message);
	}
}
