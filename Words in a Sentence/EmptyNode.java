package CS5004lab4;

/**
 * Represents an empty/blank node in a sentence
 * 
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public class EmptyNode extends DataNode {

	/**
	 * Always returns false as this is not a {@code WordNode} class
	 * 
	 * @return false as this is not a {@code WordNode} class
	 */
	@Override
	public boolean isWord() {
		return false;
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
	 * Always returns true
	 * 
	 * @return true as this is an {@code EmptyNode}
	 */
	@Override
	public boolean isEmptyNode() {
		return true;
	}

	/**
	 * Not a {@code WordNode} so an empty null value is returned
	 * 
	 * @return null as default negative value for {@code WordNode} type
	 */
	@Override
	public WordNode getWord() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Node's default value is an empty string
	 * 
	 * @return en empty string
	 */
	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "";
	}

	/**
	 * Creates a copy of the node and returns the copy
	 * 
	 * @return new {@code EmptyNode} as copy
	 */
	@Override
	public DataNode clone() {
		return new EmptyNode();
	}

}
