package library.entity;

import java.util.Objects;

public class Metadata extends Entity {

    private String uri;

    private String picture;

    public Metadata() {
    }

    public Metadata(Long id, String uri, String picture) {
        super(id);
        this.uri = uri;
        this.picture = picture;
    }

    public Metadata(String uri, String picture) {
        this.uri = uri;
        this.picture = picture;
    }

    public Metadata(Metadata metadata) {
        super(metadata.getId());
        uri = metadata.getUri();
        picture = metadata.getPicture();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Metadata)) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(uri, metadata.uri) &&
                Objects.equals(picture, metadata.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, picture);
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "uri='" + uri + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
