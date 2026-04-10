package kt.ss06.service;

import kt.ss06.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(int id);
}
