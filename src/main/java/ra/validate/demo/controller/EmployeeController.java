package ra.validate.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ra.validate.demo.dto.request.CreateEmployeeRequest;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/add")
    public  String add(Model model){
        model.addAttribute("employee",new CreateEmployeeRequest());
        return "add";
    }
    // thêm mới nhân viên

    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute("employee") CreateEmployeeRequest request, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("employee",request);
           return "add";
        }
        return "list";
    }
}
