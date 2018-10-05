package com.mckesson.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author jhovis
 * 
 *         Alternates in order between the iterators received in the constructor
 *
 * @param <T>
 */
public class AlternatingIterator<T> implements Iterator<T> {
	private List<Iterator<T>> hasNextIterators = new ArrayList<Iterator<T>>();
	private List<Iterator<T>> nextIterators = new ArrayList<Iterator<T>>();
	private ListIterator<Iterator<T>> hasNextIteratorsIter = null;
	private ListIterator<Iterator<T>> nextIteratorsIter = null;

	/**
	 * Create an instance of an alternating iterator
	 * 
	 * @param iterators
	 */
	@SafeVarargs
	public AlternatingIterator(Iterator<T>... iterators) {
		// The iterators that are passed in can not be used directly as the references
		// will be modified the
		// hasNext and Next methods so copies need to be made so we don't unexpectedly
		// move an iterator
		for (Iterator<T> iterator : iterators) {
			if (iterator != null) {
				List<T> list = new ArrayList<T>();
				iterator.forEachRemaining(value -> {
					list.add(value);
				});

				hasNextIterators.add(list.listIterator());
				nextIterators.add(list.listIterator());
			}
		}

		hasNextIteratorsIter = hasNextIterators.listIterator();
		nextIteratorsIter = nextIterators.listIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		boolean hasNextIteratorsIterHasNext = hasNextIteratorsIter.hasNext();
		boolean innerHasNext = false;

		// loop until all the has next iterators and the item iterators have been
		// exhausted
		while (hasNextIteratorsIterHasNext || innerHasNext) {
			Iterator<T> innerIter = hasNextIteratorsIter.next();
			innerHasNext = innerIter.hasNext();
			if (innerHasNext) {
				// if the end of the has next iterators is reached then reset it
				// to the beginning as the last iterator value is being retrieved
				if (!hasNextIteratorsIter.hasNext()) {
					hasNextIteratorsIter = hasNextIterators.listIterator();
				}

				innerIter.next();
				return innerHasNext;
			} else {
				hasNextIteratorsIterHasNext = hasNextIteratorsIter.hasNext();
			}
		}

		return false;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	public T next() {
		boolean nextIteratorsIterHasNext = nextIteratorsIter.hasNext();
		boolean innerHasNext = false;

		// loop until all the next iterators and the item iterators have been exhausted
		while (nextIteratorsIterHasNext || innerHasNext) {
			Iterator<T> innertIter = nextIteratorsIter.next();
			innerHasNext = innertIter.hasNext();
			if (innerHasNext) {
				// if the end of the next iterators is reached then reset it
				// to the beginning as the last iterator value is being retrieved
				if (!nextIteratorsIter.hasNext()) {
					nextIteratorsIter = nextIterators.listIterator();
				}

				return innertIter.next();
			} else {
				nextIteratorsIterHasNext = nextIteratorsIter.hasNext();
			}
		}

		throw new NoSuchElementException("Out Of Bounds - No Element Found");
	}
}