package com.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/new")
@Controller
public class HelloWorld {

	private final String SUCCESS = "success";
	/**
	 * 1. ʹ�� @RequestMapping ע����ӳ������� URL
	 * 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ, ���� InternalResourceViewResolver ��ͼ������, �������µĽ���:
	 * ͨ�� prefix + returnVal + ��׺ �����ķ�ʽ�õ�ʵ�ʵ�������ͼ, Ȼ����ת������
	 * 
	 * /WEB-INF/views/success.jsp
	 * 
	 * @return
	 */
	@RequestMapping("/helloWorld")
	public String hello(){
		System.out.println("hello world");
		return "success";
	}

	/**
	 * method = RequestMethod.POST ָ������ʽ��
	 * @return
	 */
	@RequestMapping(value = "/testRest",
			method = RequestMethod.POST,
			params = { "username","age!=10" },
			headers = { "Accept-Language=en-US,zh;q=0.8" })
	public String testRest() {
		System.out.println("testRest POST");
		return SUCCESS;
	}

	/**
	 * ����·��ͨ�����Ant·��ģʽ��
	 * ? �����ַ�
	 * * �����ַ�
	 * ** ������Ŀ¼
	 * @return
	 */
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}

	@RequestMapping(value="/testRest/{id}",method = RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("testRest Put: " + id);
		return SUCCESS;
	}
}
