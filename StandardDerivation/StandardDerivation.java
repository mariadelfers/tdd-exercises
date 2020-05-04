import java.util.*;
import java.io.*;
/**
	@author María Fernanda Hernández Enriquez A01329383
	Problem PSP 1B
*/
class StandardDerivation{
	/*
		Global variable declaration
	*/
	public static Scanner x = new Scanner(System.in);
	public static int size = 0;
	public static File file = null;
	/*
		Main class
	*/
	public static void main(String args[]) throws IOException{
		System.out.print("Name file:  ");
		String fileName = x.nextLine();
		LinkedList list = new LinkedList();
		list = library(fileName);
		list = modifyMode(list);
		//saveChanges(list);
		//list = library(fileName);
		System.out.println("Do you want ...");
		System.out.println("1) Save the change in the same file");
		System.out.println("2) Save the change in a new file");
		String opt = x.nextLine();
		while(!isNumber(opt)){
			System.out.print("Please, insert a number:  ");
			String newNumber = x.nextLine();
		}
		if(opt.equals("1")){
			saveChanges(list);
		}else{
			System.out.println("Name:  ");
			String name = x.nextLine();
			createNew(list,name);
		}
		//calculate(library(fileName));
	}
	/*
		Library Method
		Check if the file exists and display the data.
		If not, the class create one and save the numbers.
	*/
	public static LinkedList library(String fileName) throws IOException{
		/*
			Variables
		*/	
		BufferedWriter bw;
		BufferedReader br;
		LinkedList list = new LinkedList();
		size = 0;
		//Check if the input is longer than 0.
		while(fileName.length() == 0){
			System.out.println("You must enter a name.");
			fileName = x.nextLine();
		}
		//Create the object File with the name of the user.
		fileName =  fileName + ".txt";
		file = new File(fileName);
        //Check if the file already exists
        if(file.exists()) {
            System.out.println("The file already exists.\n The numbers are: ");
            try{
            	//Create an object to reader the file
            	FileReader reader = new FileReader (file);
	            br = new BufferedReader(reader);
	            String line = br.readLine();
	            int j = 0;
				String str = "";
				for(int i = 0; i < line.length(); i++){
					if(line.charAt(i) != '#'){
						str = str + line.charAt(i);
					}else{
						System.out.println(str);
						size++;
						list.add(str);
						str = "";
					}
				}
	        }catch(Exception e){
	        	
	        }
        } else {
        	//Create an writer object to write on the file
            bw = new BufferedWriter(new FileWriter(file));
            System.out.println("The file had been already created.");
            System.out.print("How many number your are going to enter?");
            String ns = x.nextLine();
            while(!isNumber(ns)){
            	System.out.print("Not numnber \nHow many number your are going to enter?\n");
            	ns = x.nextLine();
            }
            //Check if the input is an integer
            int n = Integer.parseInt(ns);
            int cont = 0;
            String saveList = "";
            while(cont < n){
            	String num = x.nextLine();
            	while(!isNumber(num)){
            		System.out.println("You have to enter a number.");
            		num = x.nextLine();
            	}
            	list.add(num);
            	cont++;
            	size = size + 1;
            	saveList = saveList+ num + "#";
            }
            bw.write(saveList);
        	bw.close();
        	System.out.println("Data saved.");
        }

        return list;
	}
	/*
		Calculate method
		Calculate, with all the numbers of the file, the standard derivation.
		Read all the number in the file, and save it in array
	*/
	public static void calculate(LinkedList list){
		/*
			Variables
		*/
		double average = 0;
		Node node = list.firstNode();
		double number = 0;
		double sum = 0;
		for(int i = 0; i < size; i++){
				number = Double.parseDouble(node.getNumber());
				average = average + number;
				node = list.nextNode(node);
		}
		node = list.firstNode();
		average =  average / size;
		for(int i = 0; i < size; i++){
				number = Double.parseDouble(node.getNumber());
				number = number - average;
				number = number * number;
				sum = sum + number;
				node = list.nextNode(node);
		}
		double x = 1;
		x = x / (size - 1);
		x = x * sum;
		x = Math.sqrt (x);
		System.out.println("Answer: " + x);
	}

	/*
		Method modifyMode
		Describes that the user can change the data
		of one of the files that want.
	*/
	public static LinkedList modifyMode(LinkedList list){
		Node node = list.firstNode();
		int cond = 0;
		String newNumber =  "";	
		int i = 1;	
		int cont = size;
		while(i < cont){
			System.out.println("Selected number: " + node.getNumber());
			System.out.println("1) Accept");
			System.out.println("2) Replace");
			System.out.println("3) Delete");
			cond = x.nextInt();
			switch(cond){
				case 1: 
					System.out.println("Number accepted.");
					break;
				case 2: 
					System.out.println("Number to replace: ");
					newNumber = x.nextLine();
					while(!isNumber(newNumber)){
						System.out.println("You must enter a number:");
						newNumber = x.nextLine();
					}
					node.setNumber(newNumber);
					break;
				case 3: 
					System.out.println("Number deleted.");
					node = list.delete(node);
					size--;
					break;
				default:
					System.out.println("Is not an option.");
			}
			i++;
			
			System.out.print("Do you want add a number after this?  ");
			String opt = x.nextLine();
			while(!isNumber(opt)){
				System.out.println("Enter 1 for yes");
				opt = x.nextLine();
			}
			if(opt.equals("1")){
				System.out.print("What number?  ");
				newNumber = x.nextLine();
				while(!isNumber(newNumber)){
					System.out.print("Please, insert a number:  ");
					newNumber = x.nextLine();
				}
				list.addMiddle(node, newNumber);
				node = list.nextNode(node);
				size++;
			}

			System.out.print("Do you want add a number before this?");
			opt = x.nextLine();
			while(!isNumber(opt)){
				System.out.println("Enter 1 for yes");
				opt = x.nextLine();
			}
			if(opt.equals("1")){
				System.out.print("What number?  ");
				newNumber = x.nextLine();
				while(!isNumber(newNumber)){
					System.out.print("Please, insert a number:  ");
					newNumber = x.nextLine();
				}
				list.addBefore(node, newNumber);
				size++;
			}
			node = list.nextNode(node);
		}
		return list;
	}
	/*
		Method saveChanges
		Save all the dara modify for the user
	*/
	public static void saveChanges(LinkedList list) throws IOException{
		if(file.exists()){
			String newList = "";
			String str = "";
			Node node = list.firstNode();
			PrintWriter writer = new PrintWriter(file);

			for(int i = 0; i < size; i++){
				str = node.getNumber();
				newList = newList + str + "#";
				node = list.nextNode(node);
			}
			writer.write(newList);
			writer.close();
			System.out.println("Data saved.");
		}
	}
	/*
		Method createNew
		Create a new file with data modified for the user
	*/

	public static void createNew(LinkedList list, String nameFile) throws IOException{
		nameFile =  nameFile + ".txt";
		File newFile = new File(nameFile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));;
		String newList = "";
		String str = "";
		Node node = list.firstNode();

			for(int i = 0; i < size; i++){
				str = node.getNumber();
				newList = newList + str + "#";
				node = list.nextNode(node);
			}
			bw.write(newList);
        	bw.close();
			System.out.println("Data saved in new file.");
	}
	/*
		Method isNumber
		Check if the input is number
	*/
	private static boolean isNumber(String line){
		try{
			//Integer.parseInt(line);
			Double.parseDouble(line);
			return true;
		}catch(NumberFormatException x){
			return false;
		}
	}

}
