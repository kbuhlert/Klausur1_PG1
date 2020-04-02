package at.campus02.forum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import at.campus02.ase.forum.Forumseintrag;

public class Forumstest {
	@Test
	public void konstruktor() throws Exception {

		Forumseintrag eintrag = new Forumseintrag("Testtitel", "Testtext");

		assertEquals("(Testtitel,Testtext)", eintrag.toString());
	}

	@Test
	public void antworten() throws Exception {

		Forumseintrag eintrag = new Forumseintrag("Testtitel", "Testtext");
		Forumseintrag a1 = eintrag.antworten("1", "text1");
		assertNotNull(a1);

		Forumseintrag a2 = eintrag.antworten("2", "text2");
		assertNotNull(a2);

		ArrayList<Forumseintrag> antworten = eintrag.getAntworten();
		assertEquals(2, antworten.size());
	}

	@Test
	public void antwortenZaehlen() throws Exception {

		Forumseintrag eintrag = new Forumseintrag("Testtitel", "Testtext");
		Forumseintrag a1 = eintrag.antworten("1", "text1");
		assertNotNull(a1);

		Forumseintrag a2 = eintrag.antworten("2", "text2");
		assertNotNull(a2);

		a1.antworten("11", "11 text");
		a1.antworten("12", "12 text");

		a2.antworten("21", "21 text");
		a2.antworten("22", "22 text");

		assertEquals(6, eintrag.anzahlDerEintraege());
		
	}

	@Test
	public void antwortenString() throws Exception {

		Forumseintrag eintrag = new Forumseintrag("Testtitel", "Testtext");
		Forumseintrag a1 = eintrag.antworten("1", "1 text");
		assertNotNull(a1);

		Forumseintrag a2 = eintrag.antworten("2", "2 text");
		assertNotNull(a2);

		a1.antworten("11", "11 text");
		a1.antworten("12", "12 text");
		assertEquals("(1,1 text)[(11,11 text), (12,12 text)]", a1.toString());

		a2.antworten("21", "21 text");
		Forumseintrag a22 = a2.antworten("22", "22 text");
		a22.antworten("221", "221 text");

		assertEquals(
				"(Testtitel,Testtext)[(1,1 text)[(11,11 text), (12,12 text)], (2,2 text)[(21,21 text), (22,22 text)[(221,221 text)]]]",
				eintrag.toString());
	}
}
