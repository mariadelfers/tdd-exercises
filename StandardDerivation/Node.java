/*
	Class Node
*/
class Node{
	/*
		Variables
	*/
	Node nodeRig;
	String number;

	public Node(String number){
		this.number = number;
		this.nodeRig = null;
	}
	/*
		Method getNumber
		return the number of the node
	*/
	public String getNumber(){
		return this.number;
	}
	/*
		Method setNumber
		Change the value of the number
	*/
	public void setNumber(String number){
		this.number = number;
	}
}