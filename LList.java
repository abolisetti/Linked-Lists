/**
 * @(#)LList.java
 *
 *
 * Arvind Bolisetti
 * Linked List Assignment
 *Assignment is on Linked Lists, and how to implement new methods, 
 *fields, and understanding how linked lists and doubly linked lists work.
 */


public class LList {
	//Main 2 fields of the LList class, head and tail. 
	//Opposite ends of the LList.
	private LNode head;
	private LNode tail;

    public LList() {
    	//Initializing it, both head and tail need to be null.
    	head = null;
    	tail = null;
    }
    public void push(int n){
    	//Push add item to front of list. This is new head,
    	// so nothing in previous. Old head becomes
    	//Next of new head.
		LNode temp = new LNode(null, n, head);
		if(tail == null){
			tail = temp;
			//if this is first item, then tail and head both become temp
		}
		else{
			head.setPrev(temp);
			//otherwise u just set prev of old head to new head
		}
		head = temp;
	}
    public void enqueue(int n){
    	//same as push but u add to end
    	//Temp is going to be new tail, so nothing 
    	//behind it there fore itsnull
        LNode temp = new LNode(tail, n, null);
        if(tail == null){
        	head = temp;
        	//if this is first item, then head is also temp.
        }
        else{
        	tail.setNext(temp);
        	//otherwise next item of old tail is the new tail.
        }
        tail = temp;
    }
    
 	public LNode dequeue(){
 		//dequeue has to delete first item of llist and return it
  		LNode temp;
  		LNode answer=head;
  		
  		head=head.getNext();
  		
  		//answer is current head, and then u change head to next head
  		
  		if(head==null){
  			//cases where head or tail is null, so head has 
  			//to be tail and tail has to be head too
   			temp=head;
   			head=tail;
   			tail=temp;
  		}
  		if(tail==null){
   			temp=head; 
   			head=tail;
   			tail=temp;
  		}
  		
  		return answer;
 	}
 	public LNode pop(){
 		return dequeue();
 		//pop is basically dequeue but i understood dequeue 
 		//first so i did that first
 	}
 	public void reverse(){
 		//skipped to 6
 		//basically u just reverse the direction of the LList
 		//If a.next was b, then a.prev = b
 		
 		LNode temp = head;
 		//start at the head and work to the tail
 		while(temp!=null){
 			temp.switcheroo();
 			//the switcheroo fucntion does a lil switcheroo and 
 			//reverses the prev and next in the lnode
 			temp = temp.getPrev();
 			//since u swith prev and next, to get to next item u 
 			//actaully have to do prev instead of .getNext()
 		}
 		LNode temp2 = tail;
 		tail = head;
 		head = temp2;
 		//the list still needs the tail and head variables so even tho 
 		//u reverse, you need to reset them
 	}
 	public LList clone(){
 		//clone makes a deep?? copy of the LList
 		//this requires a new LList bc the Lnodes r spots in memory, 
 		//so u can just return same list
 		
 		LList clone = new LList();
 		LNode temp = head;
 		//start at the head, and then work way to tail by enqueing
 		// all the old values back in
 		while(temp!=null){
 			int n = temp.getVal();
 			clone.enqueue(n);
 			temp = temp.getNext();
 		}
 		return clone;
 	}
 	public void removeDuplicates(){
 		LNode temp = head;
 		while(temp!=null){
 			int n = temp.getVal();
 			temp = temp.getNext();
 			LNode temp2 = temp;
 			while(temp2!=null){
 				if(temp2.getVal()==n){
 					LNode temp3 = temp2.getPrev();
 					delete(temp2);
 					temp2 = temp3;
 				}
 				temp2 = temp2.getNext();
 			}
 		}
 	}
 	public void delete(LNode node){
 		//this delete is main delete, otherre deletes work around this
 		
 		LNode p = node.getPrev();
 		LNode n = node.getNext();
 		//keep track of whats b4 n after thw node
 		if(p!=null && n!=null){
 			p.setNext(n);
 			n.setPrev(p);
 			//connect p and n if ur deleting sth from the middle
 		}
 		if(p==null){
 			//if u deleting from front, u can only set prev of 
 			//this to it cz u cant set anyting for null
 			n.setPrev(p);
 			head = n;
 			//need to change the head
 		}
 		if(n==null){
 			//in case of deleting from back
 			p.setNext(n);
 			tail = p;
 			//need to change the tail
 		}

 	}
 	public void sortedInsert(int n){
 		//This is an insert in the situation where LList is alr sorted
 		//u have to insert the new number in the right spot
 		LNode temp = head;
 		//start at head and working ur way down
 		int cur = head.getVal();
 		while(temp!=null){
 			if(n>cur && temp.getNext().getVal()>n){
 				//if n is bigger than cur and n is smaller
 				// than next node, this is wehre u insert
 				LNode prev = temp;
 				LNode next = temp.getNext();
 				LNode insert = new LNode(prev,n,next);
 				prev.setNext(insert);
 				next.setPrev(insert);
 				break;
 				
 			} 
 			temp = temp.getNext();
 			cur = temp.getVal();	
 		}
 	}
 	
 	public void delete(int n){
 		//this delete uses a number, and delete all lnodes that have that number
 		LNode temp = head;
 		while(true){
 			if(temp.getVal()==n)
 				//when u find it, delete the lnode with the other delete
 				delete(temp);
 			else{
 				temp = temp.getNext();
 			}
 		}
 	}
 	public void deleteAt(int index){
 		//delete but at an index
 		LNode temp = head;
 		for(int i = 0; i<index; i++){
 			temp = temp.getNext();
 		}
 		delete(temp);
 		//after u find delete using ther delete
 	}
 	
    public String toString(){
    	//this overrides system toString and u can print 
    	//the lnode list this way
    	String ans = "";
    	LNode temp = head;
    	while (temp!=null){
    		ans+=temp+", ";
    		temp = temp.getNext();
    	}
    	return ans;
    }
    
    
}