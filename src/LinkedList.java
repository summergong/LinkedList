import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node// 节点类
{
	public int nodeValue;
	public Node next;

	public Node()// 节点的构造函数
	{
		nodeValue = 0;
		next = null;
	}

	public Node(int item) {
		nodeValue = item;
		next = null;
	}
}

class LinkedList // 链表类
{
	private Node head;
	private Node tail;

	public LinkedList()// 链表的构造函数
	{
		head = null;
		tail = null;
	}

	// 创建链表
	public void create(int element) {
		if (head == null) {
			head = new Node(element);
			tail = head;
		} else {
			tail.next = new Node(element);
			tail = tail.next;
		}
	}

	// 由用户输入所需数值
	public int inputValue() {
		int value = 0;

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			String s = in.readLine();
			value = Integer.parseInt(s);
		} catch (Exception e) {
		}

		return value;
	}

	// 输出各个节点值
	public void display() {
		Node p = head;
		System.out.println("The nodeValues of the LinkedList are:");
		if (p != null) // 如果链表非空则输出链表值
		{
			while (p != null) {
				System.out.print(p.nodeValue + "--> ");
				p = p.next;
			}
		} else // 否则输出空
		{
			System.out.println("NULL");
		}
		System.out.println();
	}

	// 插入一个节点
	public void insert(int element) {
		int counter = 0, point = 0;
		Node p = head;

		while (p != null) {
			p = p.next;
			counter++;
		}
		p = head;

		System.out
				.println("Plese enter which point you want to insert a Node:");

		point = inputValue();// 直接调用同类中的函数输入要出入节点的位置

		if (point == 1)// 将元素插在第一位
		{
			Node newNode = new Node(element);
			newNode.next = p;
			head = newNode;
			display();
		}

		if (point > 1 && point <= counter + 1) {
			for (int i = 1; i < point - 1; i++) {
				p = p.next;// 将p移动到所要插入位子的前一位
			}
			// 插入算法
			Node newNode = new Node(element);
			newNode.next = p.next;// 若将元素插在最后一位，这步就没有必要了
			p.next = newNode;

			display();
		}

		else {
			System.out
					.println("The point is beyond the area.\nPlease enter again.");
			System.out.println("The Original LinkedList are:");
			display();
		}
	}

	// 删除某一个位置的元素
	public void deleteNode() {
		Node p = head;
		Node q = head;
		int count = 0;
		int point = 0;

		for (; p != null; p = p.next)
			count++;
		p = head;

		System.out.println("Enter the location" + "(<=" + count
				+ ") of the node you want to delete:");
		point = inputValue();

		if (point > count)
			System.out.println("Your number is beyond the count of "
					+ "nodes. Plese input another smaller.");
		else {
			if (point == 1) {
				head = head.next;
				p = head;
				q = head;
				display();
			}

			else {
				for (int i = 1; i < point; i++) {
					q = p;
					p = p.next;
				}

				q.next = p.next;
				p = q.next;
				display();
			}
		}
	}

	// 删除链表中的一个元素（相同的元素都将被删除，不管几个）
	public void deleteValue() {
		int value = 0;// 记录所要删除的元素值
		Node p = head;
		Node q = head;
		int signal = 0;// 判断是否存在所要删除的元素

		System.out.println("Plese enter which nodeValue you want to delete :");

		value = inputValue();// 直接调用同类中的函数输入要删除的元素值

		while (p != null) {
			if (head.nodeValue == value)// 判断所删除的是否是第一个节点
			{
				head = head.next;// 删除第一个节点
				p = head; // p和q分别再指向此时的头结点
				q = p;
				signal = 1;
				continue;
			}

			if (p.nodeValue == value)// 删除中间节点和尾节点
			{
				q.next = p.next;// 删除节点
				p = q.next; // 将p指向下一个节点即此时的q.next
				signal = 1;// 标记所要删除的元素已经找到
				continue;
			}

			q = p; // 若此时p.nodeValue不是所要删除的值，则将q向前移动一位（即：此时p的位置）
			p = p.next; // 将p向前移动一位

		}

		if (signal == 1)
			display();
		else
			System.out.println("The nodeValue isn't found!");

	}

	// 清除所有元素
	public void deleteAll() {
		Node p = head;
		Node q = head;
		while (p != null) {
			head = head.next;
			p = head; // p和q分别再指向此时的头结点
			q = p;

		}
		q = null;
		System.out.println("\n We have delete the linklist!");
		display();
	}

	// 将链表转化成数组
	public void toArray() {
		Node p = head;
		int counter = 0;
		for (; p != null; p = p.next)
			counter++;
		p = head;
		int array[] = new int[counter];
		System.out.println("The value of the array are:");
		for (int i = 0; i < counter; i++) {
			array[i] = p.nodeValue;
			System.out.print(array[i] + " ");
			p = p.next;
		}
	}

	// 计算链表的长度
	public void length() {
		Node p = head;
		int counter = 0;
		for (; p != null; p = p.next)
			counter++;
		System.out.println("\nThe length of the LinkedList is " + counter);
	}

	// 将链表中的元素进行排序（此方法是将链表先转化成数组在排序）
	public void sort() {
		Node p = head;
		int counter = 0;
		int temp = 0;

		for (; p != null; p = p.next)
			// 将链表转化成数组
			counter++;
		p = head;
		int array[] = new int[counter];
		for (int i = 0; i < counter; i++) {
			array[i] = p.nodeValue;
			p = p.next;
		}

		for (int i = 0; i < counter - 1; i++)// 冒泡排序
		{
			for (int j = 0; j < counter - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		System.out.println("\nThe sorted LinkedList are: ");
		for (int i = 0; i < counter; i++)
			System.out.print(array[i] + " ");
	}

}

// 主程序
class Program {
	public static void main(String[] args) {

		int number = 0, value = 0, insertValue = 0;

		LinkedList list = new LinkedList();// 建立链表

		// 输入节点个数
		System.out.println("Enter the amount of the nodes you want to create:");
		number = list.inputValue();

		System.out.println("Enter " + number + " integer as nodeValues:");

		// 输入每一个节点的值
		for (int i = 0; i < number; i++) {
			value = list.inputValue();

			list.create(value);
		}

		list.display();

		// 输入要插入节点的数值
		System.out.println("Enter the insertValue of the node:");
		insertValue = list.inputValue();// 一一输入值

		list.insert(insertValue);// 插入一个节点
		list.deleteValue();// 删除节点（某一值）
		list.deleteNode();// 删除节点（某一位置）
		list.length();// 计算长度
		list.toArray();// 转换成数组
		list.sort();// 排序
		list.deleteAll();// 清除
	}
}
