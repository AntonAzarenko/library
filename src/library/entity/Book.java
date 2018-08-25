package library.entity;

import java.util.List;

public class Book extends Entity {

    private static final long serialVersionUID = 1L;

    private String title;

    private List<Author> author;

    private Publisher publisher;

    private String description;

    public Book() {
    }

    public Book(Long id, String title, List<Author> author, Publisher publisher, String discription) {
	id = super.getId();
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.description = discription;

    }

    public String getTitle() {
	return title;
    }

    public void setTitle(final String title) {
	this.title = title;
    }

    public List<Author> getAuthor() {
	return author;
    }

    public void setAuthor(List<Author> author) {
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
