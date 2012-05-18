package ru.geochat.web.controllers;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.geochat.model.dao.IPersonManager;
import ru.geochat.model.dto.Person;
import ru.geochat.web.forms.UserForm;

@Controller
@RequestMapping("/users")
public class UserController {
  
  private IPersonManager profileManager;
  
  @Required
  public void setProfileManager(IPersonManager profileManager) {
    this.profileManager = profileManager;
  }

  @RequestMapping("/index")
  public String getIndex() {
    return "users_index";
  }
  
  @RequestMapping("/view/{id}")
  public ModelAndView getPerson(@PathVariable("id") Integer id) {
    ModelAndView mav = new ModelAndView("users_view");
    
    mav.addObject("person", profileManager.getPersonById(id));
    
    return mav;
  }
  
  @RequestMapping("/new")
  public String getNewUser() {
    return "users_new";
  }
  
  @RequestMapping(value="/create", method=RequestMethod.POST)
  public ModelAndView createUser(@ModelAttribute("user") UserForm user, BindingResult result) {
    ModelAndView mv = new ModelAndView();
    
    Person p = new Person();
    p.setName(user.getName());
    p.setEmail(user.getEmail());
    profileManager.createNewPerson(p);
    
    mv.setViewName("users_create");
    mv.addObject("user", user);
    return mv;
  }
  
  @ModelAttribute("user")
  public UserForm getUserForm() {
    return new UserForm();
  }

}
