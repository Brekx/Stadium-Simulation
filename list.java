import java.util.Random ;

// Class for Doubly Linked List
public class list {
	Node head; // head of list

	/* Doubly Linked list Node*/
	class Node {
		int strength, speed, prep;
		Node prev;
		Node next;

		// Constructor to create a new node
		// next and prev is by default initialized as null
		Node(int st,int sp,int p){
			 this.strength=st;
			 this.speed=sp;
			 this.prep=p; 
		}
	}

	// Add a node at the end of the list
	void append(int st,int sp, int p)
	{
		/* 1. allocate node
		* 2. put in the data */
		Node new_node = new Node(st,sp,p);

		Node last = head; /* used in step 5*/

		/* 3. This new node is going to be the last node, so
		* make next of it as NULL*/
		new_node.next = null;

		/* 4. If the Linked List is empty, then make the new
		* node as head */
		if (head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}

		/* 5. Else traverse till the last node */
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;

		/* 7. Make last node as previous of new node */
		new_node.prev = last;
	}

	
	public void printList(Node node)
	{
		System.out.println("Competitors list: ");
		while (node != null) {
			System.out.println(node.strength + " " + node.speed + " " + node.prep );
			node = node.next;
		}
	}

	public static void main(String[] args)
	{
		Random random = new Random();
		list list1 = new list();

		for(int i=0;i<8;i++){
		int a = random.nextInt(100);
		int b = random.nextInt(100);
		int c = random.nextInt(100);

		list1.append(a, b, c);
		}	
		
		list1.printList(list1.head);

	}
}
