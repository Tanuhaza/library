package ua.kiyv.training.library.model;


import java.util.Date;

public class BorrowedBook {
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
                "startDate=" + startDate +
                ", dueToReturnDate=" + dueToReturnDate +
                '}';
    }
    public static class Builder {
        BorrowedBook instance = new BorrowedBook();

        public BorrowedBook.Builder setStartDate(Date startDate) {
            instance.setStartDate(startDate);
            return this;
        }

        public BorrowedBook.Builder setDueToRuturnDate(Date dueToRuturnDate) {
            instance.setDueToReturnDate(dueToRuturnDate);
            return this;
        }

        public BorrowedBook build() {
            return instance;
        }
    }

}
