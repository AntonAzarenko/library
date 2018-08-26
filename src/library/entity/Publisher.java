package library.entity;

public class Publisher extends Entity {

    private static final long serialVersionUID = 1L;

    private String name;

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

   
}
