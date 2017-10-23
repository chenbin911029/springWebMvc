package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/userController")
public class UserController {
    /**
     * 返回用户页面
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView user(){
        User user = new User();
        user.setFavoriteFrameworks((new String []{"Spring MVC","Struts 2"}));
        user.setGender("M");
        return new ModelAndView("user","command",user);
    }

    /**
     * 新增用户
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user, Model model){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("address",user.getAddress());
        model.addAttribute("receivePaper", user.isReceivePaper());
        model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());
        model.addAttribute("gender",user.getGender());
        model.addAttribute("favoriteNumber", user.getFavoriteNumber());
        model.addAttribute("country", user.getCountry());
        model.addAttribute("skills", user.getSkills());
        return "userlist";
    }

    /**
     * 返回Json数据
     * @param name
     * @return
     */
    @RequestMapping(value = "/json/{name}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String name){
        User user = new User();
        user.setFavoriteNumber("1");
        user.setGender("M");
        return user;
    }

    /**
     *
     * @return
     */
    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList()
    {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }

    /**
     *
     * @return
     */
    @ModelAttribute("numbersList")
    public List<String> getNumbersList()
    {
        List<String> numbersList = new ArrayList<String>();
        numbersList.add("1");
        numbersList.add("2");
        numbersList.add("3");
        numbersList.add("4");
        return numbersList;
    }

    @ModelAttribute("countryList")
    public Map<String, String> getCountryList()
    {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }
    @ModelAttribute("skillsList")
    public Map<String, String> getSkillsList()
    {
        Map<String, String> skillList = new HashMap<String, String>();
        skillList.put("Hibernate", "Hibernate");
        skillList.put("Spring", "Spring");
        skillList.put("Apache Hadoop", "Apache Hadoop");
        skillList.put("Struts", "Struts");
        return skillList;
    }
}
