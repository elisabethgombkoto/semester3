package hue03.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedListTest {
	private Object data1 = "ei";
	private Object data2 = "öl";
	private Object data3 = "rührei";

	@Test
	public void test() {

		Node node1 = new Node(data1, null);
		LinkedList linkedList = new LinkedList();
		linkedList.insert(data1);
		Node head = linkedList.getHead();

		assertEquals(head, node1);

	}

}
