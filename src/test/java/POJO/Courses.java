package POJO;

import java.util.List;

public class Courses {
	
	private List<api> api;
	private List<mobile> mobile;
	
	private List<webAutomation> webAutomation;
	public List<webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<POJO.api> getApi() {
		return api;
	}
	public void setApi(List<POJO.api> api) {
		this.api = api;
	}
	public List<POJO.mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<POJO.mobile> mobile) {
		this.mobile = mobile;
	}
	

}
