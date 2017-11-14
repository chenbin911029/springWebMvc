package com.springmvc.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class Test {
    /**
     * this method will serve as default GET handler
     */
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "enroll";
    }

    /**
     * this method will be called on form submission,hading post request
     * it also validates the user input
     */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String saveRegistration(@Valid Student student,
                                   BindingResult result,
                                   Model model){
        if (result.hasErrors()) {
            return "enroll";
        }
        model.addAttribute("success","dear "+student.getFirstName()+"," +
                "your Registration completed successfully");
        return "success";
    }

    @RequestMapping(value="/testJson", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject testJson(){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("Name","菜鸟教程");
        jsonObject1.put("Country","CN");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("Name","Google");
        jsonObject2.put("Country","USA");

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("Name","Facebook");
        jsonObject3.put("Country","UK");

        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);

        jsonObject.put("sites",jsonArray);
        return jsonObject;
    }

    @RequestMapping(value="/XmlHttpRequest")
    public String XmlHttpRequest(){
        return "angular/XmlHttpRequest";
    }

    /*
	 * Method used to populate the Section list in view.
	 * Note that here you can call external systems to provide real data.
	 */
    @ModelAttribute("sections")
    public List<String> initializeSections() {

        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }

    /*
	 * Method used to populate the country list in view.
	 * Note that here you can call external systems to provide real data.
	 */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {

        List<String> countries = new ArrayList<String>();
        countries.add("USA");
        countries.add("CHINA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("UK");
        countries.add("OTHER");
        return countries;
    }

    /*
	 * Method used to populate the subjects list in view.
	 * Note that here you can call external systems to provide real data.
	 */
    @ModelAttribute("subjects")
    public List<String> initializeSubjects() {

        List<String> subjects = new ArrayList<String>();
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Life Science");
        subjects.add("Political Science");
        subjects.add("Computer Science");
        subjects.add("Mathmatics");
        return subjects;
    }
}
