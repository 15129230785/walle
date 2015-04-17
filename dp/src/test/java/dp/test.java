package dp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

	public static void main(String[] args) throws InterruptedException {
		test luncher=new test();
        luncher.start();
		Thread.sleep(1000*60*100);
	}
	
	void start(){
        String configLocation="/applicationContext_dubbo-provider.xml";
        ApplicationContext context =new ClassPathXmlApplicationContext(configLocation);
        String[] names=context.getBeanDefinitionNames();
        System.out.print("Beans:");
        for(String string : names){
	        System.out.print(string+",");
	        System.out.println();
        }
      }

}
