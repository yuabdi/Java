package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CS5004lab4.EmptyNode;
import CS5004lab4.Node;
import CS5004lab4.PunctuationNode;
import CS5004lab4.Sentence;
import CS5004lab4.WordNode;
/**
 * Test class {@code Sentence} features
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public class SentenceTest {
	
	// reference for testing
	private Sentence s;
	private Sentence s2;

	@Before
	public void setUp() throws Exception {
		
		// Create nodes to form a sentence later 
		WordNode nord = new WordNode("this");
		WordNode is = new WordNode("is");
		WordNode apple = new WordNode("apple");
		WordNode end = new WordNode("testing");
		PunctuationNode fs = new PunctuationNode(".");
		PunctuationNode comma = new PunctuationNode(",");
		
		// create first sentence
		s = new Node(nord, null);
		s.add(is);
		s.add(comma);
		s.add(end);
		s.add(fs);
		
		// create second sentence
		s2 = new Node(nord, null);
		s2.add(is);
		s2.add(comma);
		s2.add(apple);
		s2.add(fs);

	}

	/**
	 * Test the return count of {@code WordNode} in sentences
	 */
	@Test
	public void testCountWords() {
		assertEquals(3, s.countWords());
		assertEquals(3, s2.countWords());
	}
	
	/**
	 * test the largest word value in  a sentence
	 */
	@Test
	public void testLngestWord() {
		assertEquals("testing", s.getLargestWord());
		assertEquals("apple", s2.getLargestWord());
	}
	
	/**
	 * test the string representation of a sentence
	 */
	@Test
	public void testToString() {
		assertEquals(" this is, testing.", s.toString());
		assertEquals(" this is, apple.", s2.toString());
	}
	
	/**
	 * Test clone of a sentence then validate new and old sentence 
	 * by setting the next node as null in the source
	 */
	@Test
	public void testClone() {
		Sentence cloned  = s2.clone();
		s2.setNext(null);
		assertEquals(" this.", s2.toString());
		assertEquals(" this is, apple.", cloned.toString());
	}

	/**
	 * Test the merging call of two sentences
	 * Validate the original and merged sentence values
	 */
	@Test
	public void testMerge() {
		Sentence merged  = s.merge(s2);
		assertEquals(" this is, testing. this is, apple.", merged.toString());
		assertEquals(" this is, testing.", s.toString());
		assertEquals(" this is, apple.", s2.toString());
	}

}
