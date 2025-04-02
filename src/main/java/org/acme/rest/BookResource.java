package org.acme.rest;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.repository.BookRepository;

import jakarta.inject.Inject;
import java.util.List;
import org.acme.entity.Book;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> list() {
        return bookRepository.listAll();
    }

    @POST
    @Transactional
    public Book add(Book book) {
        bookRepository.persist(book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        bookRepository.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Book update(@PathParam("id") Long id, Book book) {
        Book entity = bookRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Book with id " + id + " does not exist.", 404);
        }
        entity.title = book.title;
        entity.author = book.author;
        return entity;
    }
}