package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	/*
	 * private static List<Book> list=new ArrayList<>();
	 * 
	 * static { list.add(new Book(111,"javatpoint", "ins")); list.add(new
	 * Book(112,"paython", "abc")); list.add(new Book(113,"kotlin", "mks"));
	 * list.add(new Book(114,"database", "jdw"));
	 * 
	 * }
	 */
	 
	//get all books
	public List<Book> getallBooks(){
		List<Book>list=(List<Book>)this.bookRepository.findAll();
		return list;	
	}
	
	//get single book by id
	Book book=null;
	public Book getBookById(int id) {
		//list.stream().filter(e->e.getId()==id).findFirst().get();
		book=this.bookRepository.findById(id);
		return book;
		
	}
	
	//adding the book
	public Book addBook(Book b) {
		//list.add(b);
		Book result=bookRepository.save(b);
		return b;
	}
	//delete the book
	public void deleteBook(int bid) {
		/*
		 * list=list.stream().filter(book->{ if(book.getId()!=bid) { return true; }else
		 * { return false; } }).collect(Collectors.toList());
		 */
		bookRepository.deleteById(bid);
		
	}
	//update the book
	public void updateBook(Book book,int bookId) {
		/*
		 * list=list.stream().map(b->{ if(b.getId()==bookId) {
		 * b.setTitle(book.getTitle()); b.setTitle(book.getAuther()); } return b;
		 * }).collect(Collectors.toList());
		 */
		book.setId(bookId);
		bookRepository.save(book);
	}

}
