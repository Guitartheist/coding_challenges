import java.util.Iterator;

/*
Circular Array: Implement a CircularArray class that supports an array-like data structure which can be efficiently rotated. 
If possible, the class should use a generic type (also called a template), and should support iteration via the standard for 
(Obj o : circularArray) notation.
*/
public class CircularArray<T> implements Iterable<T> {
	private int head;
	private int cursor;
	private int size;
	private Object[] data;

	public CircularArray(T[] data) {
		this.head = 0;
		this.data = data;
	}

	public CircularArray(int size) {
		this.head = 0;
		this.size = size;
		this.data = new Object[size];
	}

	@SuppressWarnings("unchecked")
	public T get(int i) {
		return (T) data[(i + head) % size];
	}

	public void set(int i, Object o) {
		data[(i + head) % size] = o;
	}

	public void rotate(int i) {
		head += i;
		head %= size;
		if (head<0) {
			head = size+head;
		}
		cursor = 0;
	}
	
	public int length() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				if (cursor!=0 && (cursor+head)%size==head) {
					cursor = 0;
					return false;
				}
				return true;
			}

			@Override
			public T next() {
				if (hasNext()) {
					return get(cursor++);
				}
				return null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Remove not implemented.");
			}
		};
	}
}
