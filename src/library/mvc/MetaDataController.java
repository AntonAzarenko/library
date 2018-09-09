package library.mvc;

import library.entity.Book;
import library.entity.Metadata;
import library.service.AuthorService;
import library.service.BookService;
import library.service.MetadataService;
import library.service.PublisherService;
import library.to.BookTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;

@Controller
public class MetaDataController {

    @Autowired
    private BookService srv;

    @Autowired
    private MetadataService mService;

    @Autowired
    private PublisherService pService;

    @Autowired
    private AuthorService aServise;

    @PostMapping(value = "booksave.html")
    @ResponseBody
    public ModelAndView saveBook(BookTo bookTo, @RequestParam(required = false) @PathVariable("files")
                                    MultipartFile[] files) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookTo.asBook();
        book.setAuthor(aServise.getListAuthorsById(bookTo.getAuthors()));
        book.setPublisher(pService.getById(bookTo.getPublisherId()));
        String resourcePath = null;
        String previewPath = null;
        if (Objects.nonNull(files)) {
            if (files[0] != null)
                previewPath = srv.upload(files[0], "images");
            if (files[1] != null)
                resourcePath = srv.upload(files[1], "resources");
        }

        //mService.save(new Metadata(previewPath, resourcePath));
        // book.setMetadata(new Metadata(state.getPictureName(), state.getZipName()));

        srv.save(book);
        RedirectView redirectView = new RedirectView("books.html");
        redirectView.setStatusCode(HttpStatus.FOUND);
        modelAndView.setView(redirectView);
        return modelAndView;
    }
}
