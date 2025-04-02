package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Book;
import org.acme.repository.BookRepository;

import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    @Transactional
    public Book add(Book book) {
        bookRepository.persist(book);
        return book;
    }

    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book update(Long id, Book book) {
        Book entity = bookRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Book with id " + id + " does not exist.", 404);
        }
        entity.title = book.title;
        entity.author = book.author;
        return entity;
    }
}