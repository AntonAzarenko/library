package library.entity;

import java.util.Objects;

public class Metadata extends Entity {

    private String resource;

    private String preview;

    public Metadata() {
    }

    public Metadata(Long id, String uri, String picture) {
        super(id);
        this.resource = uri;
        this.preview = picture;
    }

    public Metadata(String uri, String picture) {
        this.resource = uri;
        this.preview = picture;
    }

    public Metadata(Metadata metadata) {
        super(metadata.getId());
        resource = metadata.getUri();
        preview = metadata.getPicture();
    }

    public String getUri() {
        return resource;
    }

    public void setUri(String uri) {
        this.resource = uri;
    }

    public String getPicture() {
        return preview;
    }

    public void setPicture(String picture) {
        this.preview = picture;
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
