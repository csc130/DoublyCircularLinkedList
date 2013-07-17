public class DCLL<T> implements DCLLInterface<T> {

	Node<T> list, location, previous;

	public DCLL() {
		list = null;
		location = null;
		previous = null;
	}

	@Override
	// insert at the end
	public void insert(T data) {
		// TODO Auto-generated method stub
		// is empty
		Node<T> newNode = new Node<T>(data);
		if (isEmpty()) {
			list = newNode;
			list.setFront(list);
			list.setBack(list);
		} else {
			newNode.setBack(list);
			newNode.setFront(list.getFront());
			newNode.getFront().setBack(newNode);
			list.setFront(newNode);
			list = newNode;
		}
	}

	@Override
	public void remove(T data) throws DCLLException {
		// TODO Auto-generated method stub
		if (contains(data)) {
			// check only single
			if (list.getFront() == list) {
				list = null;
				return;
			}
			// remove at list
			if (location == list) {
				list = location.getBack();
			}
			location.getBack().setFront(location.getFront());
			location.getFront().setBack(location.getBack());
		} else {
			throw (new DCLLException(data + " does not exist"));
		}
	}

	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		boolean found = false;
		location = list;

		if (!isEmpty()) {
			do {
				location = location.getFront();
				if (location.getData().equals(data)) {
					found = true;
					break;
				}
			} while (location != list);
		}
		return found;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (list == null) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub

		return 0;
	}

	public String toString() {
		String output = "";
		previous = list;
		if (!isEmpty()) {
			do {
				previous = previous.getFront();
				output += previous.getData() + "\n";
			} while (previous != list);
		}
		return output;

	}
}
