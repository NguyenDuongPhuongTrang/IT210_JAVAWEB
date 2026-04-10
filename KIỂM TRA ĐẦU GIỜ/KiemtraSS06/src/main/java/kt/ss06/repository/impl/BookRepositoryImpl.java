package kt.ss06.repository.impl;

import kt.ss06.model.Book;
import kt.ss06.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    List<Book> books = new ArrayList<>();

    public BookRepositoryImpl() {
        books.add(new Book(1, "Dế mèn phưu lưu ký", "Tô Hoài", 50000));
        books.add(new Book(2, "Tư duy ngược", "Sơn Bùi", 70000));
        books.add(new Book(3, "Điện thoại, biển cả và tôi", "Kiên Vũ", 45000));
        books.add(new Book(4, "Địa lý 1", "Phạm Hoàng Sơn", 55000));
        books.add(new Book(5, "Sách tham khảo", "Huy Vũ", 60000));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
