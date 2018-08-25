package library.mvc;

import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService service;

    @RequestMapping(value = "publishers.html", method = RequestMethod.GET)
    public String getAll(final Model model) {
        model.addAttribute("publishers", service.getAll());
        return "publishers";
    }
}
