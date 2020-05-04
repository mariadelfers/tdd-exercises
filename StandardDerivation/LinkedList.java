/*
	Class LinkedList
*/
class LinkedList{
	/*
		Variables
	*/
	private Node firstNode; 
	private Node lastNode;
	private int size;
	/*
		Constructor
	*/
	public LinkedList(){
		this.firstNode = null;
		this.lastNode = null;
		this.size = 0; 
	}
	/*
		Method Empty
		Check if the linked list doesn't have a node
	*/
	public boolean empty(){
		return(this.firstNode == null); 
	}
	/*
		Method Add
		Add a node in the linked list
	*/
	public void add(String number){ 
		
		if(empty()){
			Node newNode = new Node(number);
			firstNode = newNode;
			lastNode = newNode;
			newNode.nodeRig = null;
		}
		else{
			Node newNode = new Node(number);
			newNode.nodeRig = null;
			lastNode.nodeRig= newNode;
			lastNode = newNode;
		}
		this.size++;
	}
	/*
		Method delete
		Delete a specific node from de list
	*/
	public Node delete(Node node){
		if(empty()){
			System.out.println("Empty list. You can't delete.");
		}else if(node.getNumber() == this.firstNode.getNumber()){
			Node aux = this.firstNode;
			this.firstNode = nextNode(node);
			aux.nodeRig = null;
			return this.firstNode;
		}else{
			Node before = this.firstNode;
			Node aux = before.nodeRig;
			while(node.getNumber() != aux.getNumber()){
				before = nextNode(before);
				aux = nextNode(aux);
			}
			if(aux.getNumber() == this.lastNode.getNumber()){
				before.nodeRig = null;
				this.lastNode = before;
				return this.lastNode;
			}
			before.nodeRig = aux.nodeRig;
			node = before;
			aux.nodeRig = null;
		}
		return node;
	}
	/*
		Metho addMiddle
		Add a new node in the after a specific node
	*/
	public void addMiddle(Node node, String number){ 
		Node newNode = new Node(number);
		newNode.nodeRig = node.nodeRig;
		node.nodeRig = newNode;
		this.size++;
	}
	/* 
		Method addBefore
		Add a new node before a specific node
	*/
	public void addBefore(Node node, String number){
		if(node.getNumber() == this.firstNode.getNumber()){
			Node newNode = new Node(number);
			newNode.nodeRig = this.firstNode;
			//this.firstNode = newNode;
		}
		Node before = this.firstNode;
		Node aux = before.nodeRig;
		while(node.getNumber() != aux.getNumber()){
			before = nextNode(before);
			aux = nextNode(aux);
		}
		Node newNode = new Node(number);
		newNode.nodeRig = aux;
		before.nodeRig = newNode;
	}		
	/*
		Method GetList
		return as String all the list
	*/
	public String getList(){
		String result = "";
		if(size != 0){
			Node aux = this.firstNode;
			while(aux.nodeRig != null){
				result = result + aux.getNumber();
				aux = aux.nodeRig;
			}
			result = result + aux.getNumber();
		}
		return result;
	}
	public Node firstNode(){
		return firstNode;
	}
	/*
		Method nextNode
		return the following node
	*/
	public Node nextNode(Node node){
			Node aux = node;
			aux = aux.nodeRig;
		return aux;
	}

}