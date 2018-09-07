package library.entity;

import java.util.Objects;

public class Metadata extends Entity {

    private String uresource;

    private String preview;

    public Metadata() {
    }

    public Metadata(Long id, String uri, String picture) {
        super(id);
        this.uresource = uri;
        this.preview = picture;
    }

    public Metadata(String uri, String picture) {
        this.uresource = uri;
        this.preview = picture;
    }

    public Metadata(Metadata metadata) {
        super(metadata.getId());
        uresource = metadata.getUri();
        preview = metadata.getPicture();
    }

    public String getUri() {
        return uresource;
    }

    public void setUri(String uri) {
        this.uresource = uri;
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
        return Objects.equals(uresource, metadata.uresource) &&
                Objects.equals(preview, metadata.preview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uresource, preview);
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "uri='" + uresource + '\'' +
                ", picture='" + preview + '\'' +
                '}';
    }
}
