package com.george.spring.mvc.controller;

import com.george.spring.mvc.dao.EmployeeDAO;
import com.george.spring.mvc.entity.Employee;
import com.george.spring.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askData")
    public String askData(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "ask-data-view";
    }

//    @RequestMapping("/showData")
//    public String showDetails(){
//        return "show-data-view";
//    }

    @RequestMapping("/showData")
    public String showDetails(HttpServletRequest request, Model model){

        String yourName = request.getParameter("yourName");
        yourName = "Mr. " + yourName;
        model.addAttribute("nameAttribute", yourName);

        return "show-data-view";
    }

    @PostMapping("/askData")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:https://www.google.com";
    }
}

