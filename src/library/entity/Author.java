package library.entity;

import java.util.Objects;

public class Author extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    public Author() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(getId(), author.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id= " + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
