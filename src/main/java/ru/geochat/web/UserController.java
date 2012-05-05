package ru.geochat.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.geochat.web.forms.UserForm;

@Controller
@RequestMapping("/users")
public class UserController {
  

  @RequestMapping("/index")
  public String getIndex() {
    return "users_index";
  }
  
  @RequestMapping("/new")
  public String getNewUser() {
    return "users_new";
  }
  
  @RequestMapping(value="/create", method=RequestMethod.POST)
  public ModelAndView createUser(@ModelAttribute("user") UserForm user, BindingResult result) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("users_create");
    mv.addObject("user", user);
    return mv;
  }
  
  @ModelAttribute("user")
  public UserForm getUserForm() {
    return new UserForm();
  }

}
