package CS5004lab4;

/**
 * Base class to store punctuation characters
 * 
 * @author Yusuf Abdi
 *  Date: 10/26/2021
 *
 */
public class PunctuationNode extends DataNode {

	/**
	 * Create an object of {@code PunctuationNode}
	 * 
	 * @param punctuation symbol
	 */
	public PunctuationNode(String data) {
		this.data = data;
	}

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
	 * Always returns true as this is not a {@code PunctuationNode} class
	 * 
	 * @return true as this is not a {@code PunctuationNode} class
	 */
	@Override
	public boolean isPunctuation() {
		return true;
	}

	/**
	 * Always returns true
	 * 
	 * @return true as this is an {@code EmptyNode}
	 */
	@Override
	public boolean isEmptyNode() {
		return false;
	}

	/**
	 * Not a {@code WordNode} so an empty null value is returned
	 * 
	 * @return null as default negative value for {@code WordNode} type
	 */
	@Override
	public WordNode getWord() {
		return null;
	}

	/**
	 * Node's default value is an empty string
	 * 
	 * @return value of punctuation
	 */
	@Override
	public String getData() {
		return data;
	}

	/**
	 * Creates a copy of the node and returns the copy
	 * 
	 * @return new {@code PunctuationNode} as copy
	 */
	@Override
	public DataNode clone() {
		return new PunctuationNode(data);
	}

	@Override
	public boolean isPunctuation() {
		// TODO Auto-generated method stub
		return false;
	}

}
