package CS5004lab4;

/**
 * Base class to store word data as {@code String}
 * 
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public class WordNode extends DataNode {

	/**
	 * Creates an object of WordNode
	 * 
	 * @param string data as node value
	 */
	public WordNode(String data) {
		this.data = data;
	}

	/**
	 * Getter for the Node's value
	 * 
	 * @return data value
	 */
	@Override
	public String getData() {
		return data;
	}

	/**
	 * Always returns true as this is not a {@code WordNode} class
	 * 
	 * @return true as this is not a {@code WordNode} class
	 */
	@Override
	public boolean isWord() {
		return true;
	}

	/**
	 * Always returns false as this is not a {@code PunchuationNode} class
	 * 
	 * @return false as this is not a {@code PunchuationNode} class
	 */
	@Override
	public boolean isPunctuation() {
		return false;
	}

	/**
	 * Always returns false as this is not a {@code EmptyNode} class
	 * 
	 * @return false as this is not a {@code EmptyNode} class
	 */
	@Override
	public boolean isEmptyNode() {
		return false;
	}

	/**
	 * Getter for current object as {@code WordNode}
	 * 
	 * @return current object
	 */
	@Override
	public WordNode getWord() {
		return this;
	}

	/**
	 * Creates a copy of the node and returns the copy
	 * 
	 * @return new {@code WordNode} as copy
	 */
	@Override
	public DataNode clone() {
		return new WordNode(data);
	}

	/**
	 * Setter to set the value of current node
	 * 
	 * @param value of current node
	 */
	public void set(String data) {
		this.data = data;
	}

}
