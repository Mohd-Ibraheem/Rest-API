package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	//Read all books
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.getallBooks();
	}
	 
	//Read one book
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id ) {
		
		return bookService.getBookById(id);
		
	}
	
	//create new book
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b=this.bookService.addBook(book);
		System.out.println(book);
		return b;
		
	}
	//Delete book by Id
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId){
		this.bookService.deleteBook(bookId);
		
	}
	//Update book by Id
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book,bookId);
		   return book;
	}

}
