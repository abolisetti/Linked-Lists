/**
 * @(#)LL-test.java
 *
 *
 * @author 
 * @version 1.00 2017/2/15
 */


public class LLtest{
	public static void main(String[]args){
		LList linkList = new LList();
		linkList.enqueue(1);
		linkList.enqueue(2);
		
		linkList.enqueue(3);
		
		linkList.enqueue(7);
		
		linkList.enqueue(7);
		linkList.enqueue(7);
		
		System.out.println(linkList);
		linkList.removeDuplicates();
		System.out.println(linkList.clone());
	}

//  public LL-test() {
//  }
    
    
}