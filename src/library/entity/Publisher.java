package library.entity;

import java.util.Objects;

public class Publisher extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

    public Publisher() {
    }

    public Publisher(Long id, String name) {
	super(id);
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name)&&Objects.equals(getId(),publisher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id= " + getId() +
                "name='" + name + '\'' +
                '}';
    }
}
