package CS5004lab4;

/**
 * Base type to represent sentence as nodes in a LinkedList fashion
 * 
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public interface Sentence {
	/**
	 * Count and return the total of non-punctuation words
	 * 
	 * @return total number of words in a sentence
	 */
	int countWords();

	/**
	 * Recursively Find and return the next {@code WordNode}
	 * 
	 * @return next {@code WordNode} in the sentence if any
	 */
	Sentence getWord();

	/**
	 * The Largest {@code WordNode} in a sentence based on character count
	 * 
	 * @return String of the largest length of a {@code WordNode}
	 */
	String getLargestWord();

	/**
	 * Create a copy of the current node which includes data and next part
	 * 
	 * @return Sentence object as copy of current sentence
	 */
	Sentence clone();

	/**
	 * Combines two sentences into one.
	 * 
	 * @param second sentence for merging
	 * @return Sentence object with both sentences
	 */
	Sentence merge(Sentence sentence);

	/**
	 * Get the next node in the sentence
	 * 
	 * @return Next sentence node
	 */
	Sentence getNext();

	/**
	 * Setter to change the node address
	 * 
	 * @param new node as thenext part of the sentece
	 */
	void setNext(Sentence sentence);

	/**
	 * Getter to fetch the data object
	 * 
	 * @return current node as DataNode
	 */
	DataNode getNode();

	/**
	 * Helper method to form a sentence by adding new words at the end
	 * 
	 * @param node containing data of the next node in a sentence
	 */
	void add(DataNode node);
}
