package ro.stefan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.stefan.serv.interfaces.UsersService;

@Controller
public class LoginController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("msg", "Invalid username and password!");
            model.addObject("error",true);
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
            model.addObject("error",false);
        }
        model.setViewName("login");

        return model;

    }
}
