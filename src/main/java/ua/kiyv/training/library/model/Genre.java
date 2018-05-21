package ua.kiyv.training.library.model;


/**
 * this class represents  genre entity
 */
public class Genre {
    private int id;
    private String name;

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        return name != null ? name.equals(genre.name) : genre.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        Genre instance = new Genre();

        public Genre.Builder setId(int id) {
            instance.setId(id);
            return this;
        }

        public Genre.Builder setName(String name) {
            instance.setName(name);
            return this;
        }

        public Genre build() {
            return instance;
        }
    }
}
