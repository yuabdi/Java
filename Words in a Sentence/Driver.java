package CS5004lab4;

import java.util.Arrays;
/**
 * test all methods
 * 
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public class Driver {

	public static void main(String[] args) {
		// create words, punctuations etc. to form a sentence
		WordNode nord = new WordNode("original");
		WordNode nord1 = new WordNode("sentences");
		WordNode end = new WordNode("end");
		PunctuationNode p1 = new PunctuationNode(",");
		PunctuationNode p2 = new PunctuationNode(";");
		PunctuationNode comma = new PunctuationNode(".");

		// create a sentence
		Sentence sentence = new Node(nord,
				new Node(p1, new Node(end, new Node(nord1, new Node(new EmptyNode(), null)))));
		System.out.println(sentence.countWords()); // task 1: count number of Words
		System.out.println(sentence.getLargestWord());// task 2 get the Largest Word
		System.out.println(sentence); // task 3 print the sentence as string wit formatting

		// demonstrate the use of clone and coping a reference
		Sentence sCopy = sentence;// coping a reference
		Sentence trueCopy = sentence.clone();// task 4 create a copy of a sentence

		System.out.println("before " + sentence);
		// modify the original sentence and the copied sentence should not be changed
		nord.set("new");
		nord1.set("value");
		System.out.println("after " + sentence);
		System.out.println("falseCopy " + sCopy);
		System.out.println("trueCopy " + trueCopy);

		// task 5 combine two sentences
		Sentence merge = sentence.merge(trueCopy);
		System.out.println("merge " + merge);

	}

}