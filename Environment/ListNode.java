package Environment;

public class ListNode<K,V>
{
	K				key;
	V				value;
	int				scope;
	ListNode<K,V> 	next;

	public ListNode (K k, V v, int s, ListNode<K,V> n)
	{
		key = k;
		value = v;
		scope = s;
		next = n;
	}
	public ListNode (K k, V v, ListNode<K,V> n)
	{
		key = k;
		value = v;
		scope = 0;
		next = n;
	}
}
