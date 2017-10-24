package com.springmvc.controller;

import com.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
