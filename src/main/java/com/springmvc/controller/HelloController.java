package com.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("helloController")
@RequestMapping("/hello")
public class HelloController {
    /*@Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                               HttpServletResponse response) throws Exception{
        ModelAndView model = new ModelAndView("hello");
        model.addObject("message","hello world!");
        return model;
    }*/
    private static final Logger LOGGER = Logger.getLogger(HelloController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(Model model){
        LOGGER.info("printHello started.");
        model.addAttribute("message","hello spring MVC framework.");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("inside printHello");
        }
        //LOGGER.error("Logging a sample exception",new Exception("testing"));
        LOGGER.info("end");
        return "hello";
    }
}