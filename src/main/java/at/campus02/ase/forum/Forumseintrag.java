package at.campus02.ase.forum;

import java.util.ArrayList;

public class Forumseintrag {

	private String titel;
	private String text;

	private ArrayList<Forumseintrag> antworten = new ArrayList<Forumseintrag>();

	public Forumseintrag(String titel, String text) {
		this.titel = titel;
		this.text = text;
	}

	public Forumseintrag antworten(String titel, String text) {
		Forumseintrag antwort = new Forumseintrag(titel, text);

		antworten.add(antwort);
		return antwort;
	}

	public ArrayList<Forumseintrag> getAntworten() {
		return antworten;
	}

	public int anzahlDerEintraege() {

		int anzahl = antworten.size();
		for (Forumseintrag forumseintrag : antworten) {
			anzahl = anzahl + forumseintrag.anzahlDerEintraege();
		}
		return anzahl;
	}

	public String toString() {
		if (antworten.isEmpty())
			return String.format("(%s,%s)", titel, text);
		else
			return String.format("(%s,%s)%s", titel, text, antworten);
	}
}
