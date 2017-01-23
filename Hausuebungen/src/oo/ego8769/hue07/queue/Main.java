package oo.ego8769.hue07.queue;

public class Main {

	public static void main(String[] args) {
		MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<Integer>(new MyComparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		long millis = System.currentTimeMillis();

		// System.out.println( "Inserting into Priority-Queue:" );
		for (int i = 0; i < 50_000; i++) {
			int value = (int) (1 + Math.random() * 10);
			// System.out.println( " " + value );

			priorityQueue.enqueue(value);
		}

		// System.out.println();

		System.out.println("Insertion took " + (System.currentTimeMillis() - millis) + "ms");

		millis = System.currentTimeMillis();

		while (false == priorityQueue.isEmpty()) {
			int value = priorityQueue.dequeue();

			// System.out.println( );
		}

		System.out.println("Dequeue took " + (System.currentTimeMillis() - millis) + "ms");
	}

}
