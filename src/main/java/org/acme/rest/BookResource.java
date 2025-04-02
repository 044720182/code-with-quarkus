package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.service.BookService;

import jakarta.inject.Inject;
import java.util.List;
import org.acme.entity.Book;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public List<Book> list() {
        return bookService.listAll();
    }

    @POST
    public Book add(Book book) {
        return bookService.add(book);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        bookService.delete(id);
    }

    @PUT
    @Path("/{id}")
    public Book update(@PathParam("id") Long id, Book book) {
        return bookService.update(id, book);
    }
}