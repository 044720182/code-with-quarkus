package org.acme.rest;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/books")
public class BookResource {

    private final Set<Book> books = Collections.newSetFromMap(
            Collections.synchronizedMap(new LinkedHashMap<>()));

    public BookResource() {
        books.add(new Book("Refactoring", "Martin Fowler"));
        books.add(new Book("Head First Design Patterns", "Eric Freemon"));
    }

    @GET
    public Set<Book> list() {
        return books;
    }

    @POST
    public Set<Book> add(Book book) {
        books.add(book);
        return books;
    }

    @DELETE
    public Set<Book> delete(Book book) {
        books.removeIf(existingBook -> existingBook.getTitle().contentEquals(book.getTitle()));
        return books;
    }
}
