package com.springmvc.handler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@RequestMapping("/springmvc")
@Controller
public class MvcHello {

    private final String SUCCESS = "success";

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("index jsp");
        return "index";
    }

    /**
     * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
     *
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     * @throws IOException
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + ", " + response);
        out.write("hello springmvc");
//		return SUCCESS;
    }

    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配，
     * 自动为该对象填充属性值。支持级联属性。
     * 如：dept.deptId、dept.address.tel 等
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }

    /**
     * 了解:
     *
     * @CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return SUCCESS;
    }

    /**
     * 了解: 映射请求头信息 用法同 @RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader, Accept-Language: " + al);
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数. value 值即请求参数的参数名 required 该参数是否必须. 默认为 true
     *               defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username") String un,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam,username:" + un + "age: " + age);
        return SUCCESS;
    }

    /**
     * Rest 风格的 URL. 以 CRUD 为例:
     * 新增: /order POST
     * 修改: /order/1 PUT update?id=1
     * 获取: /order/1 GET get?id=1
     * 删除: /order/1 DELETE delete?id=1
     * 1. 需要配置 HiddenHttpMethodFilter
     * 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     *
     * @return
     */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable Integer id) {
        System.out.println("testRest GET" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest PUT" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest DELETE" + id);
        return SUCCESS;
    }

    /**
     * restFul风格 POST风格
     * @return
     */
    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("testRest POST");
        return SUCCESS;
    }

    /**
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器, 会做如下的解析:
     * 通过 prefix + returnVal + 后缀 这样的方式得到实际的物理视图, 然会做转发操作
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
     * method = RequestMethod.POST 指定请求方式。
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
     * 访问路径通配符，Ant路径模式。
     * ? 单个字符
     * * 任意字符
     * ** 包含子目录
     * @return
     */
    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

}
