package library.entity;

import java.util.List;

public class Book extends Entity {

    private static final long serialVersionUID = 1L;

    private String title;

    private Author author;

    private Publisher publisher;

    private String description;
    
    public Book(Long id, String title, List<String> authorName, String publisherName, String description) {
        super();
    }
    
    public Book(Long id, String title, Author author, Publisher publisher, String description) {
        super(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setDescription(description)
    }

    public Book(String title, List<String> authorName, String publisherName, String discription) {
        super();
    }
    
    // This is the default constructors
    public Book(Long id) {
        super(id);
    }   
   
    public Book() {
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

   

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(final Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(final Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
