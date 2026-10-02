package day_4;

class CircularQueue1 {
	int maxSize;
	String queue[];
	int rear;
	int front;
	int count;

	public CircularQueue1(int size) {
		this.maxSize = size;
		queue = new String[maxSize];
		this.rear = -1;
		this.front = 0;
		this.count = 0;

	}
	  public void enque(String data) {
		  rear=(rear+1)%maxSize;
		  queue[rear]=data;
		  count++;
		}
	  public String deque() {
		  String data = queue[front];
			front = (front + 1) % maxSize;
			count--;
			return data;
	      }
	    boolean isEmpty() {
	    	
			return count==0;
	    }
	  
	}

public class BinaryNumbers {
	public static void main(String[] args) {

		int n=5;
		CircularQueue1 q=new CircularQueue1(n+1);
		//first binary number
		q.enque("1");
		for(int i=0;i<n;i++) {
			
		//remove front element
			String current=q.deque();
			
			//Display binary element
			System.out.println(current);
			
			//Generate next binary numbers
			q.enque(current+"0");
			q.enque(current+"1");
			
		}
			
	}
}
