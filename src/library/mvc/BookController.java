package library.mvc;

import library.entity.Author;
import library.entity.Book;
import library.entity.Publisher;
import library.service.AuthorService;
import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import library.service.BookService;

import java.util.List;

/**
 * @Author by Azarenka Anton
 */
@Controller
public class BookController {

    @Autowired
    private BookService srv;

    @Autowired
    private PublisherService pService;

    @Autowired
    private AuthorService aServise;

    /**
     * This method gets all books and show their on the index.jsp
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String getAll(final Model model) {
        model.addAttribute("books", srv.getBooks());
        return "index";
    }

    /**
     * This method gets book by Title and redirect to book.jsp
     *
     * @param title
     * @param model
     * @return
     */
    @GetMapping(value = "booksByName.html")
    public String getBooksByName(@RequestParam("title") final String title, final Model model) {
        model.addAttribute("book", srv.getBooksByTitle(title));
        return "books";
    }

    /**
     * This method gets book by ID, put them to model and redirect to book.jsp
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "booksByAuthors.html", method = RequestMethod.POST)
    public String getBooksByAuthor(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("listBooks", srv.getBooksByAuthor(id));
        return "books";
    }

    /**
     * This method save new book, or update book and redirect to index.jsp
     *
     * @param id
     * @param title
     * @param discription
     * @param authorName    maybe plurals if book has got a few authors
     * @param publisherName
     * @return
     */
    @PostMapping(value = "booksave.html")
    public String save(@RequestParam(required = false) @PathVariable("id") final Long id,
                       @RequestParam("title") final String title,
                       @RequestParam("discription") final String discription,
                       @RequestParam(required = false) @PathVariable("author_id") final List<Long> authorId,
                       @RequestParam("name_author") final List<String> authorName,
                       @RequestParam(required = false) @PathVariable("publisher_id") final Long publisherId,
                       @RequestParam("name_publisher") final String publisherName) {
        //todo нужно сделать в bookServise дополнительный метод для конвертации List<String> в List<Authors>
        //todo и поиск по имени автора чтобы возвращал Автора или создавал нового
        //todo - list<Author> list = srv.getListAuthors(List<String>);
        //todo Publisher publisher = publisherService.findPublisher(String name_publisher)
        //todo  srv.save(new Book(id, title, list, publisher, discription));

        List<Author> author = checkAuthor(authorId, authorName);//проверка на наличие автора и  получение
        Publisher publisher = checkPublisher(publisherId, publisherName);
        srv.save(new Book(id, title, author, publisher, discription));
        return "redirect:index";
    }

    private Publisher checkPublisher(Long publisherId, String publisherName) {
        Publisher publisher = null; //Создаем ссылкку на обьект
        if (publisherId == null) {// проверяем пришедший с UI id на NUll
            if (pService.getByName(publisherName) == null) {//если в базе нету издателя с таким именем то создаем нового и добовляем в базу
                publisher = new Publisher(null, publisherName);
                pService.save(publisher);
            }else { // иначе берем из базы по имени
                publisher = pService.getByName(publisherName);
            }
        }
        else {
            publisher = pService.getById(publisherId);//иначе берем из базы по id
        }
        return publisher;
    }

    private List<Author> checkAuthor(List<Long> authorId, List<String> authorName) {
        List<Author> list = null;
        for (int i = 0; i < authorId.size(); i++) {
            if (authorId.get(i) == null) {
                if (aServise.getByName(authorName.get(i)) == null) {
                    Author author = new Author(null, authorName.get(i));
                    aServise.save(author);
                    list.add(author);
                }else {
                    Author author = (Author) aServise.getByName(authorName.get(i));
                    list.add(author);
                }

            }else {
                Author author = aServise.getById(authorId.get(i));
                list.add(author);
            }
        }
        return list;
    }


    /**
     * This method gets all books, put him to model and redirect to books.jsp
     *
     * @param name
     * @param model
     * @return
     */
    @GetMapping(value = "booksByPublisher.html")
    public String getBooksByPublisher(@RequestParam("publisher_name") final String name, final Model model) {
        model.addAttribute("books", srv.getBooksByPublisher(name));
        return "books";
    }

    /**
     * This method removes book by id and redirect to index
     *
     * @param id
     * @return
     */
    @PostMapping(value = "remove.html")
    public String delete(@RequestParam("id") final Long id) {
        srv.delete(id);
        return "redirect:index.html";
    }

    /**
     * This method gets book and put in model and redirect to edit page editbook.jsp
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "edit.html")
    public String edit(@RequestParam("id") final Long id, final Model model) {
        model.addAttribute("book", srv.getById(id));
        return "editbook";
    }
}
