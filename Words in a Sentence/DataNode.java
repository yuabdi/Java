package CS5004lab4;

/**
 * Base class to store sentence data
 * 
 * @author yusufabdi
 */
public abstract class DataNode {
	String data;

	/**
	 * Get the data value of node
	 * 
	 * @return string value of node
	 */
	public abstract String getData();

	/**
	 * check if the node is a {@code WordNode}
	 * 
	 * @return true if the node is {@code WordNode}
	 */
	public abstract boolean isWord();

	/**
	 * check if the node is a {@code PunctuationNode}
	 * 
	 * @return true if node is a {@code PunctuationNode}
	 */
	public abstract boolean isPunctuation();

	/**
	 * check if node is of {@code EmptyNode} type
	 * 
	 * @return true if node is {@code EmptyNode}
	 */
	public abstract boolean isEmptyNode();

	/**
	 * Recursively check and returns only the next {@code WordNode} in list
	 * 
	 * @return node of type {@code WordNode}
	 */
	public abstract WordNode getWord();

	/**
	 * Create a copy of the current node and return it
	 * 
	 * @return copy of the current node
	 */
	public abstract DataNode clone();
}
