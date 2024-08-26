package com.prog.medicalAppointment.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.medicalAppointment.Entity.User;
import com.prog.medicalAppointment.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@Tag(name="Login Controller", description ="Login Page")
@Controller
public class LoginController {
	
	    @Autowired
	    private UserService userService;

	    
	    @GetMapping("/")
	    public String index(){
	        return "Login";
	    }
	   
	    @GetMapping("/login")
	    public String loginPage() {
	        return "Login";
	    }
	    
	    @Operation(summary = "Login", description = "Login")
	    @PostMapping("/login")
	    public String login(@ModelAttribute("User") User user) {	    	
	    	return "redirect:/home";
	    }
	   
	    @GetMapping("/register")
	    public String registerForm(Model model){
	        model.addAttribute("user", new User());
	        return "Register";
	    }
	    
	    @Operation(summary = "Register", description = "Register")
	    @PostMapping("/register")
	    public String saveUser(@ModelAttribute User user, HttpSession session) {
	        try {
	            User userInfo = userService.saveUser(user);

	            if (userInfo != null) {
	                session.setAttribute("msg", "Register successfully");
	            } else {
	                session.setAttribute("msg", "Something wrong server");
	            }
	        } catch (Exception e) {
	            session.setAttribute("msg", e.getMessage());
	            return "redirect:/register";
	        }

	        return "redirect:/login";
	    }
	    	    

}
