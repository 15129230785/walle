package dc.service;

import dp.dubbo.db.service.TestDubbo;

public class TestMng {

	private TestDubbo testDubbo;
	
	public TestDubbo getTestDubbo() {
		return testDubbo;
	}

	public void setTestDubbo(TestDubbo testDubbo) {
		this.testDubbo = testDubbo;
	}

	public String getStr(){
//		return "TestMng";
		if(testDubbo==null) return "";
		return testDubbo.getStr();
	}
	
}
