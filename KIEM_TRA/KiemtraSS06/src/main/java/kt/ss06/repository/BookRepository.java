package kt.ss06.repository;

import kt.ss06.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(int id);
}
