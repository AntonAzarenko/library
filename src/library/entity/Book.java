package library.entity;

import java.util.List;

public class Book extends Entity {

    private static final long serialVersionUID = 1L;

    private String title;

    private List<Author> author;

    private Publisher publisher;

    private String description;

    private Metadata metadata;

    public Book() {
    }

    public Book(String title, List<Author> author, Publisher publisher, String description) {
        super();
        this.title = title;
        this.author = author;
        this.publisher=publisher;
        this.description = description;
    }
    
    public Book(Long id,String title, List<Author> author, Publisher publisher, String description) {
        super(id);
        this.title = title;
        this.author = author;
        this.publisher=publisher;
        this.description = description;
    }

    public Book(Long id,String title, List<Author> author, Publisher publisher, String description, Metadata metadata) {
        super(id);
        this.title = title;
        this.author = author;
        this.publisher=publisher;
        this.description = description;
        this.metadata = metadata;
    }

    public Book(Book book) {
        super(book.getId());
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher=book.getPublisher();
        this.description = book.getDescription();
        this.metadata = book.getMetadata();
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

    public void setAuthor(final List<Author> author) {
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

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", description="
                + description + ", metadata=" + metadata +"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!getId().equals(book.getId())) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        if (!getPublisher().equals(book.getPublisher())) return false;
        if (!getMetadata().equals(book.getMetadata())) return false;
        return getDescription() != null ? getDescription().equals(book.getDescription()) : book.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getPublisher().hashCode();
        result = 31 * result + getMetadata().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
