package ua.kiyv.training.library.model.dto;

import ua.kiyv.training.library.model.Author;
import ua.kiyv.training.library.model.Book;

import java.util.Date;
import java.util.List;

public class BookData {
    private Integer id;
    private String title;
    private String description;
    private String pictureId;
    private String year;
    private boolean avaliable;
    private String quantity;
    private String keywords;
    private Integer genreId;
    private String firstAuthorName;
    private String firstAuthorSurname;
    private String secondAuthorName;
    private String secondAuthorSurname;

    public BookData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getFirstAuthorName() {
        return firstAuthorName;
    }

    public void setFirstAuthorName(String firstAuthorName) {
        this.firstAuthorName = firstAuthorName;
    }

    public String getFirstAuthorSurname() {
        return firstAuthorSurname;
    }

    public void setFirstAuthorSurname(String firstAuthorSurname) {
        this.firstAuthorSurname = firstAuthorSurname;
    }

    public String getSecondAuthorName() {
        return secondAuthorName;
    }

    public void setSecondAuthorName(String secondAuthorName) {
        this.secondAuthorName = secondAuthorName;
    }

    public String getSecondAuthorSurname() {
        return secondAuthorSurname;
    }

    public void setSecondAuthorSurname(String secondAuthorSurname) {
        this.secondAuthorSurname = secondAuthorSurname;
    }

    public static class Builder {
        private BookData instance = new BookData();

        public BookData.Builder setId(Integer id) {
            instance.setId(id);
            return this;
        }

        public BookData.Builder setTitle(String firstName) {
            instance.setTitle(firstName);
            return this;
        }

        public BookData.Builder setDiscription(String discription) {
            instance.setDescription(discription);
            return this;
        }

        public BookData.Builder setPictureId(String pictureId) {
            instance.setPictureId(pictureId);
            return this;
        }

        public BookData.Builder setGenreId(Integer genreId) {
            instance.setGenreId(genreId);
            return this;
        }

        public BookData.Builder setYear(String year) {
            instance.setYear(year);
            return this;
        }

        public BookData.Builder setAvaliable(boolean avaliable) {
            instance.setAvaliable(avaliable);
            return this;
        }

        public BookData.Builder setQuantity(String quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public BookData.Builder setKeywords(String keywords) {
            instance.setKeywords(keywords);
            return this;
        }

        public BookData.Builder setFirstAuthorName(String name) {
            instance.setFirstAuthorName(name);
            return this;
        }
        public BookData.Builder setFirstAuthorSurname(String surname) {
            instance.setFirstAuthorSurname(surname);
            return this;
        }
        public BookData.Builder setSecondAuthorName(String name) {
            instance.setSecondAuthorName(name);
            return this;
        }
        public BookData.Builder setSecondAuthorSurname(String surname) {
            instance.setSecondAuthorSurname(surname);
            return this;
        }

        public BookData build() {
            return instance;
        }
    }
}
