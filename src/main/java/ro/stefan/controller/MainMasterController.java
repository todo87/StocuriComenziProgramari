package ro.stefan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainMasterController {

    @RequestMapping(value = "/master", method = RequestMethod.GET)
    public String main(Model model){
        return "master/masterMain";
    }

}
