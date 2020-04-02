package at.campus02.ase.books;

import java.util.ArrayList;

public class Bibliothek {

	private ArrayList<Book> books = new ArrayList<Book>();

	public void addBook(Book b) {
		books.add(b);
	}

	public int countPages() {
		int result = 0;
		for (Book book : books) {
			result += book.getSeiten();
		}
		return result;
	}

	public double avaragePages() {
		return ((double) countPages()) / books.size();
	}

	public ArrayList<Book> booksByAuthor(String autor) {
		ArrayList<Book> result = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getAutor() == autor)
				result.add(book);
		}
		return result;
	}

	public ArrayList<Book> findBook(String search) {

		ArrayList<Book> result = new ArrayList<Book>();

		if (search != null) {
			for (Book book : books) {
				if (book.match(search))
					result.add(book);
			}
		}
		return result;
	}

}
