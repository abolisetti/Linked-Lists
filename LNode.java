/**
 * @(#)LNode.java
 *
 *
 * @author 
 * @version 1.00 2017/2/15
 */


public class LNode {
	private int val;
	private LNode next;
	private LNode prev;

    public LNode(LNode p, int v, LNode n) {
    	val = v;
    	next = n;
    	prev = p;
    }
    
    public int getVal(){
    	return val;
    }
    
    public LNode getNext(){
    	return next;
    }
    public LNode getPrev(){
    	return prev;
    }
    public void setNext(LNode next){
    	this.next = next;    	
    }
    public void setPrev(LNode prev){
    	this.prev = prev;
    }
    public String toString(){
    	return ""+val;
    }
    public void switcheroo(){
    	LNode temp = prev;
    	prev = next;
    	next = temp;
    }

}