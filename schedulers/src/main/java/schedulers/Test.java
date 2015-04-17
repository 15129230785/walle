package schedulers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Evan on 2014/8/5.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Test start.");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        //如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
        //context.getBean("startQuertz");
        System.out.print("Test end..");
    }

}