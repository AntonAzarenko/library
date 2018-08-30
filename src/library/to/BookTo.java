package library.to;

import library.entity.Book;
import library.service.AuthorService;
import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookTo {

    @Autowired
    private PublisherService service;

    @Autowired
    private AuthorService authorService;

    private Long id;

    private String title;

    private String discription;

    private List<Long> authorId;

    private Long publisherId;

    public Book asBook(Long id, String title, String discription, List<Long> authorId, Long publisherId) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setDescription(discription);
        book.setPublisher(service.getById(publisherId));
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<Long> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Long> authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}
