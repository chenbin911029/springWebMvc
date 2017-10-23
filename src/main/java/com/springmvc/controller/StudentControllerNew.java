package com.springmvc.controller;

import com.springmvc.pojo.StudentNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/studentControllerNew")
public class StudentControllerNew {
    @Autowired
    @Qualifier("studentValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    @RequestMapping(value ="/addStudent",method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("addStudent","studentNew",new StudentNew());
    }

    @ModelAttribute("studentNew")
    public StudentNew createStudentModel(){
        return new StudentNew();
    }

    @RequestMapping(value="/addStudent",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("studentNew")
                             @Validated StudentNew studentNew,
                             BindingResult bindingResult,
                             Model model){
        if (bindingResult.hasErrors()){
            return "addStudent";
        }
        model.addAttribute("name",studentNew.getName());
        model.addAttribute("age",studentNew.getAge());
        model.addAttribute("id",studentNew.getId());

        return "result";
    }
}

