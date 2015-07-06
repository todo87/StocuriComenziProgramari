package ro.stefan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainViewerController {

    @RequestMapping(value = "/viewer", method = RequestMethod.GET)
    public String main(Model model){
        return "viewer/viewerMain";
    }

}
