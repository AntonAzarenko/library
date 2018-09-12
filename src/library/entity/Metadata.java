package library.entity;

import java.util.Objects;

public class Metadata extends Entity {

    private String resource;

    private String preview;

    private Book book;

    public Metadata() {
    }

    public Metadata(Long id, String resource, String preview) {
        super(id);
        this.resource = resource;
        this.preview = preview;
    }

    public Metadata(String resource, String preview) {
        this.resource = resource;
        this.preview = preview;
    }

    public Metadata(Metadata metadata) {
        super(metadata.getId());
        resource = metadata.getResource();
        preview = metadata.getPreview();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metadata)) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(resource, metadata.resource) &&
                Objects.equals(preview, metadata.preview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, preview);
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "uri='" + resource + '\'' +
                ", picture='" + preview + '\'' +
                '}';
    }
}
