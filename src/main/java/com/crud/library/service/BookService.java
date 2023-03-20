package com.crud.library.service;

import com.crud.library.controller.NotFoundException;
import com.crud.library.domain.Book;
import com.crud.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book findBookById(final int id) throws NotFoundException {
        return repository.findBookById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteBook(final int id) {
        repository.deleteById(id);
    }

    public Book saveBook(final Book book) {
        return repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public String countBookTitles(Book book) {

        int count = 0;
        List<Book> bookList = repository.findAll();
        for (Book books : bookList) {
            if (books.getTitle().equals(book.getTitle())) {
                count++;
            }
        }
        return "the number of book duplicates: " + book.getTitle() + " is" + count;
    }

//    public List<Book> removeDuplicateBooks() {
//    }
}
