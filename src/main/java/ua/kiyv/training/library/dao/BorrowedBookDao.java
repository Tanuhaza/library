package ua.kiyv.training.library.dao;

import java.util.List;

public interface BorrowedBookDao extends GenericDao<BorrowedBookDao> {
    public List<BorrowedBookDao> findAllByUserId(int id);
}
