package library.to;

import library.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Anton
 */

public class BookTo {

    private Long id;

    private String title;

    private String description;

    private List<Long> authors;

    private Long publisherId;

    public Book asBook() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setDescription(this.description);
        return book;
    }

    public BookTo() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
