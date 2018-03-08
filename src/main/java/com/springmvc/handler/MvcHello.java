package com.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/new")
@Controller
public class MvcHello {

    private final String SUCCESS = "success";
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

    /**
     * 访问路径带参数
     * @param id
     * @return
     */
    @RequestMapping(value="/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest Put: " + id);
        return SUCCESS;
    }
}
