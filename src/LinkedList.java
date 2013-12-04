import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node// �ڵ���
{
	public int nodeValue;
	public Node next;

	public Node()// �ڵ�Ĺ��캯��
	{
		nodeValue = 0;
		next = null;
	}

	public Node(int item) {
		nodeValue = item;
		next = null;
	}
}

class LinkedList // ������
{
	private Node head;
	private Node tail;

	public LinkedList()// ����Ĺ��캯��
	{
		head = null;
		tail = null;
	}

	// ��������
	public void create(int element) {
		if (head == null) {
			head = new Node(element);
			tail = head;
		} else {
			tail.next = new Node(element);
			tail = tail.next;
		}
	}

	// ���û�����������ֵ
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

	// ��������ڵ�ֵ
	public void display() {
		Node p = head;
		System.out.println("The nodeValues of the LinkedList are:");
		if (p != null) // �������ǿ����������ֵ
		{
			while (p != null) {
				System.out.print(p.nodeValue + "--> ");
				p = p.next;
			}
		} else // ���������
		{
			System.out.println("NULL");
		}
		System.out.println();
	}

	// ����һ���ڵ�
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

		point = inputValue();// ֱ�ӵ���ͬ���еĺ�������Ҫ����ڵ��λ��

		if (point == 1)// ��Ԫ�ز��ڵ�һλ
		{
			Node newNode = new Node(element);
			newNode.next = p;
			head = newNode;
			display();
		}

		if (point > 1 && point <= counter + 1) {
			for (int i = 1; i < point - 1; i++) {
				p = p.next;// ��p�ƶ�����Ҫ����λ�ӵ�ǰһλ
			}
			// �����㷨
			Node newNode = new Node(element);
			newNode.next = p.next;// ����Ԫ�ز������һλ���ⲽ��û�б�Ҫ��
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

	// ɾ��ĳһ��λ�õ�Ԫ��
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

	// ɾ�������е�һ��Ԫ�أ���ͬ��Ԫ�ض�����ɾ�������ܼ�����
	public void deleteValue() {
		int value = 0;// ��¼��Ҫɾ����Ԫ��ֵ
		Node p = head;
		Node q = head;
		int signal = 0;// �ж��Ƿ������Ҫɾ����Ԫ��

		System.out.println("Plese enter which nodeValue you want to delete :");

		value = inputValue();// ֱ�ӵ���ͬ���еĺ�������Ҫɾ����Ԫ��ֵ

		while (p != null) {
			if (head.nodeValue == value)// �ж���ɾ�����Ƿ��ǵ�һ���ڵ�
			{
				head = head.next;// ɾ����һ���ڵ�
				p = head; // p��q�ֱ���ָ���ʱ��ͷ���
				q = p;
				signal = 1;
				continue;
			}

			if (p.nodeValue == value)// ɾ���м�ڵ��β�ڵ�
			{
				q.next = p.next;// ɾ���ڵ�
				p = q.next; // ��pָ����һ���ڵ㼴��ʱ��q.next
				signal = 1;// �����Ҫɾ����Ԫ���Ѿ��ҵ�
				continue;
			}

			q = p; // ����ʱp.nodeValue������Ҫɾ����ֵ����q��ǰ�ƶ�һλ��������ʱp��λ�ã�
			p = p.next; // ��p��ǰ�ƶ�һλ

		}

		if (signal == 1)
			display();
		else
			System.out.println("The nodeValue isn't found!");

	}

	// �������Ԫ��
	public void deleteAll() {
		Node p = head;
		Node q = head;
		while (p != null) {
			head = head.next;
			p = head; // p��q�ֱ���ָ���ʱ��ͷ���
			q = p;

		}
		q = null;
		System.out.println("\n We have delete the linklist!");
		display();
	}

	// ������ת��������
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

	// ��������ĳ���
	public void length() {
		Node p = head;
		int counter = 0;
		for (; p != null; p = p.next)
			counter++;
		System.out.println("\nThe length of the LinkedList is " + counter);
	}

	// �������е�Ԫ�ؽ������򣨴˷����ǽ�������ת��������������
	public void sort() {
		Node p = head;
		int counter = 0;
		int temp = 0;

		for (; p != null; p = p.next)
			// ������ת��������
			counter++;
		p = head;
		int array[] = new int[counter];
		for (int i = 0; i < counter; i++) {
			array[i] = p.nodeValue;
			p = p.next;
		}

		for (int i = 0; i < counter - 1; i++)// ð������
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

// ������
class Program {
	public static void main(String[] args) {

		int number = 0, value = 0, insertValue = 0;

		LinkedList list = new LinkedList();// ��������

		// ����ڵ����
		System.out.println("Enter the amount of the nodes you want to create:");
		number = list.inputValue();

		System.out.println("Enter " + number + " integer as nodeValues:");

		// ����ÿһ���ڵ��ֵ
		for (int i = 0; i < number; i++) {
			value = list.inputValue();

			list.create(value);
		}

		list.display();

		// ����Ҫ����ڵ����ֵ
		System.out.println("Enter the insertValue of the node:");
		insertValue = list.inputValue();// һһ����ֵ

		list.insert(insertValue);// ����һ���ڵ�
		list.deleteValue();// ɾ���ڵ㣨ĳһֵ��
		list.deleteNode();// ɾ���ڵ㣨ĳһλ�ã�
		list.length();// ���㳤��
		list.toArray();// ת��������
		list.sort();// ����
		list.deleteAll();// ���
	}
}
