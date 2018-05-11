package ua.kiyv.training.library.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String description;
    private String pictureId;
    private int rate;
    private int year;
    private boolean avaliable;
    private int quantity;
    private String keywords;
    private Date addedDate;
    private int genreId;
    private List<Author> authors;

    public Book( String title, String description, String pictureId, int rate,  boolean avaliable, int quantity,int year,  int genreId, String keywords) {

        this.title = title;
        this.description = description;
        this.pictureId = pictureId;
        this.rate = rate;
        this.year = year;
        this.avaliable = avaliable;
        this.quantity = quantity;
        this.keywords = keywords;

        this.genreId = genreId;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Book() {
        authors=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (rate != book.rate) return false;
        if (year != book.year) return false;
        if (avaliable != book.avaliable) return false;
        if (quantity != book.quantity) return false;
        if (genreId != book.genreId) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (pictureId != null ? !pictureId.equals(book.pictureId) : book.pictureId != null) return false;
        if (keywords != null ? !keywords.equals(book.keywords) : book.keywords != null) return false;
        return addedDate != null ? addedDate.equals(book.addedDate) : book.addedDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureId != null ? pictureId.hashCode() : 0);
        result = 31 * result + rate;
        result = 31 * result + year;
        result = 31 * result + (avaliable ? 1 : 0);
        result = 31 * result + quantity;
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + genreId;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pictureId='" + pictureId + '\'' +
                ", rate=" + rate +
                ", year=" + year +
                ", avaliable=" + avaliable +
                ", quantity=" + quantity +
                ", keywords='" + keywords + '\'' +
                ", addedDate=" + addedDate +
                ", genreId=" + genreId +
                ", authors=" + authors +
                '}'+'\n';
    }

    public static class Builder {
        private  Book instance = new Book();

        public Book.Builder setId(int id) {
            instance.setId(id);
            return this;
        }

        public Book.Builder setTitle(String firstName) {
            instance.setTitle(firstName);
            return this;
        }

        public Book.Builder setDiscription(String discription) {
            instance.setDescription(discription);
            return this;
        }

        public Book.Builder setPictureId(String pictureId) {
            instance.setPictureId(pictureId);
            return this;
        }

        public Book.Builder setGenreId(int id) {
            instance.setGenreId(id);
            return this;
        }

        public Book.Builder setAddedDate(Date date) {
            instance.setAddedDate(date);
            return this;
        }

        public Book.Builder setRate(int rate) {
            instance.setRate(rate);
            return this;
        }

        public Book.Builder setYear(int year) {
            instance.setYear(year);
            return this;
        }

        public Book.Builder setAvaliable(boolean avaliable) {
            instance.setAvaliable(avaliable);
            return this;
        }

        public Book.Builder setQuantity(int quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Book.Builder setKeywords(String keywords) {
            instance.setKeywords(keywords);
            return this;
        }

        public Book build() {
            return instance;
        }
    }

//    public static Builder builder(){
//        return new Builder();
//    }
}
