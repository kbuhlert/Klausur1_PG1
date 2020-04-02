package at.campus02.books;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import at.campus02.ase.books.Bibliothek;
import at.campus02.ase.books.Book;

public class BookTest {
	@Test
	public void konstruktor() throws Exception {

		Book b = new Book("Hofstadter", "test", 400);

		assertEquals("[Hofstadter,test,400]", b.toString());
	}

	@Test
	public void seiten() throws Exception {

		Bibliothek bibliothek = new Bibliothek();

		bibliothek.addBook(new Book("author1", "1", 200));
		bibliothek.addBook(new Book("author1", "2", 100));
		bibliothek.addBook(new Book("author2", "3", 400));
		bibliothek.addBook(new Book("author1", "4", 50));
		bibliothek.addBook(new Book("author3", "5", 50));

		assertEquals(800, bibliothek.countPages());
	}

	@Test
	public void durchschnitt() throws Exception {

		Bibliothek bibliothek = new Bibliothek();

		bibliothek.addBook(new Book("author1", "1", 200));
		bibliothek.addBook(new Book("author1", "2", 100));
		bibliothek.addBook(new Book("author2", "3", 400));
		bibliothek.addBook(new Book("author1", "4", 50));
		bibliothek.addBook(new Book("author3", "5", 57));

		assertEquals(161.4, bibliothek.avaragePages(), 0.001);
	}

	@Test
	public void author01() throws Exception {

		Bibliothek bibliothek = new Bibliothek();

		bibliothek.addBook(new Book("author1", "1", 200));
		bibliothek.addBook(new Book("author1", "2", 100));
		bibliothek.addBook(new Book("author2", "3", 400));
		bibliothek.addBook(new Book("author1", "4", 50));
		bibliothek.addBook(new Book("author3", "5", 57));

		ArrayList<Book> booksByAuthor = bibliothek.booksByAuthor("author1");
		assertEquals(3, booksByAuthor.size());
	}
	@Test
	public void author02() throws Exception {

		Bibliothek bibliothek = new Bibliothek();

		bibliothek.addBook(new Book("author1", "1", 200));
		bibliothek.addBook(new Book("author1", "2", 100));
		bibliothek.addBook(new Book("author2", "3", 400));
		bibliothek.addBook(new Book("author1", "4", 50));
		bibliothek.addBook(new Book("author3", "5", 57));

		ArrayList<Book> booksByAuthor = bibliothek.booksByAuthor(null);
		assertEquals(0, booksByAuthor.size());
	}

	@Test
	public void find01() throws Exception {

		Bibliothek bibliothek = new Bibliothek();

		bibliothek.addBook(new Book("author1", "1", 200));
		bibliothek.addBook(new Book("author1", "2", 100));
		bibliothek.addBook(new Book("author2", "3", 400));
		bibliothek.addBook(new Book("author1", "4", 50));
		bibliothek.addBook(new Book("author3", "5", 57));

		ArrayList<Book> find = bibliothek.findBook("3");
		assertEquals(2, find.size());
	}

	@Test
	public void find02() throws Exception {

		Bibliothek bibliothek = new Bibliothek();

		bibliothek.addBook(new Book("author1", "1", 200));
		bibliothek.addBook(new Book("author1", "2", 100));
		bibliothek.addBook(new Book("author2", "3", 400));
		bibliothek.addBook(new Book("author1", "4", 50));
		bibliothek.addBook(new Book("author3", "5", 57));

		ArrayList<Book> find = bibliothek.findBook(null);
		assertEquals(0, find.size());
	}
}
