package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.service.BookService;

import jakarta.inject.Inject;
import java.util.List;
import org.acme.entity.Book;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Operation(summary = "List all books", description = "Returns a list of all books in the system")
    public List<Book> list() {
        return bookService.listAll();
    }

    @POST
    @Operation(summary = "Add a new book", description = "Adds a new book to the system")
    public Book add(Book book) {
        return bookService.add(book);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a book", description = "Deletes a book from the system")
    public void delete(@PathParam("id") Long id) {
        bookService.delete(id);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update a book", description = "Updates an existing book in the system")
    public Book update(@PathParam("id") Long id, Book book) {
        return bookService.update(id, book);
    }
}