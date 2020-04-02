package at.campus02.ase.books;

public class Book {

	private String autor;
	private String titel;
	private int seiten;

	public Book(String autor, String titel, int seiten) {

		this.autor = autor;
		this.titel = titel;
		this.seiten = seiten;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitel() {
		return titel;
	}

	public int getSeiten() {
		return seiten;
	}

	public boolean match(String search) {
		if(autor.contains(search))
			return true;
		if(titel.contains(search))
			return true;
		
		return false;
	}

	public String toString() {
		return String.format("[%s,%s,%d]", autor, titel, seiten);
	}
}
