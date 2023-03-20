package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookStatus;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Reader;
import com.crud.library.service.BookService;
import com.crud.library.service.CopyService;
import com.crud.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {

    private final BookService bookService;
    private final CopyService copyService;
    private final ReaderService readerService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping("/reader/{id}")
    public ResponseEntity<Reader> findReaderById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(readerService.findReaderById(id));
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<String> getCountBookTitles(@PathVariable int id) throws NotFoundException {
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok(bookService.countBookTitles(book));
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        return ResponseEntity.ok(readerService.saveReader(reader));
    }

    @PostMapping
    public ResponseEntity<Copy> createCopy(@RequestBody Copy copy) {
        return ResponseEntity.ok(copyService.saveCopy(copy));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Copy> returnBook(@PathVariable int id, @RequestBody String status) throws NotFoundException {
        Copy book = copyService.findCopyById(id);
        switch (status) {
            case "return" -> book.setBookStatus(BookStatus.AVAILABLE);
            case "loan" -> book.setBookStatus(BookStatus.BORROWED);
            case "lost" -> book.setBookStatus(BookStatus.LOST);
        }
        return ResponseEntity.ok().build();
    }
}
