package library.mvc;

import library.entity.Book;
import library.entity.Metadata;
import library.service.AuthorService;
import library.service.BookService;
import library.service.PublisherService;
import library.to.BookTo;
import library.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class MetaDataController {
    @Autowired
    private State state;

    @Autowired
    private BookService srv;

    @Autowired
    private PublisherService pService;

    @Autowired
    private AuthorService aServise;

    @Autowired
    private FileValidator fileValidator;

    @PostMapping(value = "booksave.html")
    public String save(BookTo bookTo) {
        Book book = bookTo.asBook();
        book.setAuthor(aServise.getListAuthorsById(bookTo.getAuthors()));
        book.setPublisher(pService.getById(bookTo.getPublisherId()));
        book.setMetadata(new Metadata(state.getPictureName(), state.getZipName()));
        srv.save(book);
        return "redirect:books.html";
    }

    @PostMapping(value = "upload.html")
    @ResponseBody
    public ModelAndView uploadZip(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        MultipartFile file = uploadedFile.getFile();
        String name = file.getOriginalFilename();
        if (name.endsWith("zip")) {
            RedirectView redirectView = new RedirectView(upload(uploadedFile, result, "zip"));
            redirectView.setStatusCode(HttpStatus.FOUND);
            modelAndView.setView(redirectView);
            state.setZipName(file.getOriginalFilename());
        } else {
            RedirectView redirectView = new RedirectView(upload(uploadedFile, result, "image"));
            redirectView.setStatusCode(HttpStatus.FOUND);
            modelAndView.setView(redirectView);
            state.setPictureName(file.getOriginalFilename());
        }
        return modelAndView;
    }


    private String upload(UploadedFile uploadedFile, BindingResult result, String path) {
        MultipartFile file = uploadedFile.getFile();
        String name = null;
        fileValidator.validate(uploadedFile, result);
        if (result.hasErrors()) {
            return ("errorUpload");
        } else {
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                Path resourceDirectory = Paths.get("../library", "data", path);
                File dir = new File(resourceDirectory + File.separator);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File loadFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
                stream.write(bytes);
                stream.flush();
                stream.close();
            } catch (IOException e) {

            }
        }
        return "edit.html";
    }


    @Component
    @Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public static class State {

        private Long authorId;

        private String authorName;

        private Long publisherId;

        private String publisherName;

        private String pictureName;

        private String zipName;

        public Long getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Long authorId) {
            this.authorId = authorId;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public Long getPublisherId() {
            return publisherId;
        }

        public void setPublisherId(Long publisherId) {
            this.publisherId = publisherId;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }

        public String getPictureName() {
            return pictureName;
        }

        public void setPictureName(String pictureName) {
            this.pictureName = pictureName;
        }

        public String getZipName() {
            return zipName;
        }

        public void setZipName(String zipName) {
            this.zipName = zipName;
        }
    }
}
