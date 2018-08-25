package library.entity;

public class Author extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    public Author(){
    }

    public Author(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Author(Author author) {
        super(author.getId());
        this.name = author.name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
