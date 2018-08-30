package library.to;

import library.entity.Book;
import library.service.AuthorService;
import library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Anton
 */

public class BookTo {

    private Long id;

    private String title;

    private String discription;

    private List<Long> authors;

    private Long publisherId;

    public Book asBook() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setDescription(this.discription);
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

    public List<Long> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Long> authors) {
        this.authors = authors;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
}
