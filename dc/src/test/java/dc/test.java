package dc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dc.service.TestMng;
import dp.dubbo.db.service.TestDubbo;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test test = new test();
		test.start();
	}
	
	void start(){
		  String configLocation="applicationContext_dubbo-consumer.xml";
		  ApplicationContext context =new ClassPathXmlApplicationContext(configLocation);
		  TestDubbo td=(TestDubbo) context.getBean("testDubbo");
		  String[] names=context.getBeanDefinitionNames();
		  System.out.print("Beans:");
		  for(String string : names) {
	          System.out.print(string);
	          System.out.println(",");
		  }
		  TestMng tmg=(TestMng) context.getBean("testMng");
		  System.out.println(tmg.getStr());
		  System.out.println(td.getStr());
		  
	}
	
}
