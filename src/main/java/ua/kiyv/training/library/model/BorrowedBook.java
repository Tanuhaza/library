package ua.kiyv.training.library.model;


import java.util.Date;

public class BorrowedBook extends Book {
    private Date startDate;
    private Date dueToReturnDate;

    public BorrowedBook() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueToReturnDate() {
        return dueToReturnDate;
    }

    public void setDueToReturnDate(Date dueToReturnDate) {
        this.dueToReturnDate = dueToReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowedBook that = (BorrowedBook) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return dueToReturnDate != null ? dueToReturnDate.equals(that.dueToReturnDate) : that.dueToReturnDate == null;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (dueToReturnDate != null ? dueToReturnDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "id=" + getId()+
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", pictureId='" + getPictureId() + '\'' +
                ", rate=" + getRate() +
                ", year=" + getYear() +
                ", avaliable=" + isAvaliable()+
                ", quantity=" + getQuantity() +
                "startDate=" + startDate +
                ", dueToReturnDate=" + dueToReturnDate +
                '}';
    }

    public static class Builder {
        private BorrowedBook instance = new BorrowedBook();

        public BorrowedBook.Builder setId(int id) {
            instance.setId(id);
            return this;
        }

        public BorrowedBook.Builder setTitle(String firstName) {
            instance.setTitle(firstName);
            return this;
        }

        public BorrowedBook.Builder setDiscription(String discription) {
            instance.setDescription(discription);
            return this;
        }

        public BorrowedBook.Builder setPictureId(String pictureId) {
            instance.setPictureId(pictureId);
            return this;
        }

        public BorrowedBook.Builder setGenreId(int id) {
            instance.setRate(id);
            return this;
        }

        public BorrowedBook.Builder setAddedDate(Date date) {
            instance.setAddedDate(date);
            return this;
        }

        public BorrowedBook.Builder setRate(int rate) {
            instance.setRate(rate);
            return this;
        }

        public BorrowedBook.Builder setYear(int year) {
            instance.setYear(year);
            return this;
        }

        public BorrowedBook.Builder setAvaliable(boolean avaliable) {
            instance.setAvaliable(avaliable);
            return this;
        }

        public BorrowedBook.Builder setQuantity(int quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public BorrowedBook.Builder setKeywords(String keywords) {
            instance.setKeywords(keywords);
            return this;
        }

        public BorrowedBook.Builder setStartDate(Date startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public BorrowedBook.Builder setDueToReturnDate(Date dueToRuturnDate) {
            instance.setDueToReturnDate(dueToRuturnDate);
            return this;
        }

        public BorrowedBook build() {
            return instance;
        }
    }

//    public static Builder builder(){
//        return new Builder();
//    }
}
