package library.mvc;

import library.entity.Publisher;
import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anton
 */

@Controller
public class PublisherController {

    @Autowired
    private PublisherService service;

    /**
     * This method gets all publishers put in model and show them on publishers.jsp
     * @param model
     * @return
     */
    @RequestMapping(value = "publishers.html", method = RequestMethod.GET)
    public String getAll(final Model model) {
        model.addAttribute("publishers", service.getAll());
        return "publishers"; //publishers.jsp
    }

    /**
     * This method finds publisher by name, put in model and show on publisher.jsp
     * @param name
     * @param model
     * @return
     */
    @GetMapping(value = "publisherByName.html")
    public String getByName(@RequestParam("name") final String name, final Model model) {
        model.addAttribute("publishers", service.getByName(name));
        return "publishers";  //publisher.jsp
    }

    /**
     * This method finds publisher by id, put in model and show on publisher.jsp
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "publisherById.html")
    public String getById(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("publisher", service.getById(id));
        return "publisher";  //publisher.jsp
    }

    /**
     * This method finds publisher by  id of author, put in model and show on publisher.jsp
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "publisherByAuthorId.html")
    public String getByAuthorId(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("publishers", service.getByAuthorId(id));
        return "publishers";  //publishers.jsp
    }

    /**
     * save
     * @param id
     * @param name
     * @return
     */
    @PostMapping (value = "savePublisher.html")
    public String save(@RequestParam(required = false) @PathVariable("id") final Long id,
                       @RequestParam("name") final String name) {
        service.save(new Publisher(id, name));
        return "redirect:publishers.html";
    }

    /**
     * This method  finds publisher by id and redirect to editpublisher.jsp
     * @param id
     * @param model
     * @return
     */
    @PostMapping(value = "edit.html")
    public String edit(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("publisher", service.getById(id));
        return "editpublisher";
    }

    /**
     *
     * @param id
     * @return
     */
    @PostMapping(value = "removePublisher.html")
    public String delete(@RequestParam("id")final Long id){
        service.delete(id);
        return "redirect:publishers";
    }


}
