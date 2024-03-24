package CS5004lab4;

/**
 * A LinkedList type node to data and next link
 * 
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public class Node implements Sentence {

	DataNode node;
	Sentence next;

	/**
	 * Constructs an object of node with data and next value
	 * 
	 * @param data
	 * @param words
	 */
	public Node(DataNode data, Sentence next) {

		this.node = data;
		this.next = next;
	}

	/**
	 * Using recursion, Count and return the total of non-punctuation words
	 * 
	 * @return total number of words in a sentence
	 */
	@Override
	public int countWords() {
		int count = 0;
		if (node.isWord()) {
			count++;
		}
		if (next == null) {
			return count;
		}
		return count + next.countWords();
	}

	/**
	 * Recursively Find and return the next {@code WordNode}
	 * 
	 * @return next {@code WordNode} in the sentence if any
	 */
	@Override
	public Sentence getWord() {
		if (node.isWord()) {
			return new Node(node, next.getWord());
		}
		return next.getWord();
	}

	/**
	 * Recursively calculates the Largest {@code WordNode} in a sentence based on
	 * character count
	 * 
	 * @return String of the largest length of a {@code WordNode}
	 */
	@Override
	public String getLargestWord() {
		if (next != null) {
			String data = node.getData();
			String value = next.getLargestWord();// endsisbig
			if (data.length() < value.length()) {
				return value;
			} else {
				return data;
			}
		} else {
			return this.node.getData();
		}
	}

	/**
	 * Returns a string representation of node data with formatting
	 * 
	 * @return string formatted value
	 */
	@Override
	public String toString() {
		if (next != null) {
			if (node.isPunctuation() || node.isEmptyNode())
				return node.getData() + next.toString();
			else {
				return " " + node.getData() + next.toString();
			}
		} else {
			boolean isPunctucation = node.isPunctuation();
			boolean isComma = node.getData().equals(".");
			if (isPunctucation || node.isEmptyNode())
				return isComma ? node.getData() : node.getData() + ".";
			else {
				return " " + node.getData() + ".";
			}
		}
	}

	/**
	 * Create a copy of the current node which includes data and next part
	 * 
	 * @return Sentence object as copy of current sentence
	 */
	@Override
	public Sentence clone() {
		if (next != null) {
			return new Node(node.clone(), next.clone());
		} else {
			return new Node(node.clone(), null);
		}
	}

	/**
	 * Combines two sentences into one.
	 * 
	 * @param second sentence for merging
	 * @return Sentence object with both sentences
	 */
	@Override
	public Sentence merge(Sentence sentence) {
		Sentence first = this.clone();
		Sentence second = sentence.clone();
		Sentence lastOfFirst = lastNode(first);
		lastOfFirst.setNext(second);
		return first;
	}

	// takes a node and reruns the last node in the sentence chain
	private Sentence lastNode(Sentence sentence) {
		return (sentence.getNext() != null) ? lastNode(sentence.getNext()) : sentence;
	}

	/**
	 * Getter the next node in the sentence
	 * 
	 * @return Next sentence node
	 */
	@Override
	public Sentence getNext() {
		return next;
	}

	/**
	 * Setter to change the node address
	 * 
	 * @param new node as the next part of the sentence
	 */
	@Override
	public void setNext(Sentence sentence) {
		this.next = sentence;
	}

	/**
	 * Getter to fetch the data object
	 * 
	 * @return current node as DataNode
	 */
	@Override
	public DataNode getNode() {
		return node;
	}

	/**
	 * Helper method to form a sentence by adding new words at the end
	 * 
	 * @param node containing data of the next node in a sentence
	 */
	@Override
	public void add(DataNode node) {
		Node newNode = new Node(node, null);
		lastNode(this).setNext(newNode);

	}

}
