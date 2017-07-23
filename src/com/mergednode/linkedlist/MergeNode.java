package com.mergednode.linkedlist;
class MergeNode

{
	static Node LTopNode, RTopNode;
	static class Node 
	{
		int value;
		Node next;
		Node(int v)
		{
			value = v;
			next = null;
		}
	}

	int getIntersectionNode()
	{
		int c1 = getCount(LTopNode);
		int c2 = getCount(RTopNode);
		int v;

		if (c1 > c2) 
		{
			v = c1 - c2;
			return _getIntesectionNode(v, LTopNode, RTopNode);
		} 
		else 
		{
			v = c2 - c1;
			return _getIntesectionNode(v, RTopNode, LTopNode);
		}
	}

	int _getIntesectionNode(int x, Node node1, Node node2) 
	{
		int i;
		Node PresentNode = node1;
		Node NextNode = node2;
		for (i = 0; i < x; i++)
		{
			if (PresentNode == null) 
			{
				return -1;
			}
			PresentNode = PresentNode.next;
		}
		while (PresentNode != null && NextNode != null)
		{
			if (PresentNode.value == NextNode.value)
			{
				return PresentNode.value;
			}
			PresentNode = PresentNode.next;
			NextNode = NextNode.next;
		}

		return -1;
	}

	int getCount(Node node) 
	{
		Node current = node;
		int count = 0;

		while (current != null)
		{
			count++;
			current = current.next;
		}

		return count;
	}

	public static void main(String[] args)
	{
		MergeNode list = new MergeNode();

		MergeNode.LTopNode = new Node(45);
		MergeNode.LTopNode.next = new Node(53);
		MergeNode.LTopNode.next.next = new Node(57);
		MergeNode.LTopNode.next.next.next = new Node(57);
		MergeNode.LTopNode.next.next.next.next = new Node(70);
		
		
		MergeNode.RTopNode = new Node(55);
		MergeNode.RTopNode.next = new Node(57);
		MergeNode.RTopNode.next.next = new Node(70);

		System.out.println("Node at Intersection of 2 Singly Linked Lists: " + list.getIntersectionNode());

	}
}