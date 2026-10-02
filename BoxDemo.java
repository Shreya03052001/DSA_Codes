package day_5;
//Reference number in linked list
class Box {
	int data;
	Box box;

}

public class BoxDemo {

	public static void main(String[] args) {

		Box first = new Box();
		first.data = 10;
		first.box = null;

		Box second = new Box();
		second.data = 20;
		first.box = second;

		System.out.println(first.box.data);
		//System.out.println(second.box.data);
//ask here for that why we are not able to print this commented line
	}

}
