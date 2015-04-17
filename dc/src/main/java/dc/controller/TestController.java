package dc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dc.service.TestMng;

@Controller
public class TestController  {
    private static final Logger logger = Logger.getLogger(TestController.class);

	private TestMng testMng;
	
//	@Reference(version="1.0.0")
//	private TestDubbo testDubbo;
	
	
	@RequestMapping("/test")
	@ResponseBody   //标注为返回java对象
	public String testDo(HttpServletRequest hsrq){
        logger.info("sdfkjlskdjfsjdf092348r092384--------------------");
		StringBuffer str = new StringBuffer();
		str.append("test:");

		str.append(testMng.getStr());
		return str.toString();
	}
	
}
