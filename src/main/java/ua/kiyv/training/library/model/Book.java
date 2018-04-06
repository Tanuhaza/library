package ua.kiyv.training.library.model;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String description;
    private String pictureId;
    private int rate;
    private Date year;
    private boolean avaliable;
    private int quantity;

    public Book() {
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
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
        if (avaliable != book.avaliable) return false;
        if (quantity != book.quantity) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (pictureId != null ? !pictureId.equals(book.pictureId) : book.pictureId != null) return false;
        return year != null ? year.equals(book.year) : book.year == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureId != null ? pictureId.hashCode() : 0);
        result = 31 * result + rate;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (avaliable ? 1 : 0);
        result = 31 * result + quantity;
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
                '}';
    }

    public static class Builder {
        Book instance = new Book();

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

        public Book.Builder setRate(int rate) {
            instance.setRate(rate);
            return this;
        }

        public Book.Builder setYear(Date year) {
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

        public Book build() {
            return instance;
        }
    }
}
