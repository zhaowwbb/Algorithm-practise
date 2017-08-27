package com.rick.algorithms.sorting;

public class NaturalComparator implements Comparator {

	public static final NaturalComparator instance = new NaturalComparator();
	
	private NaturalComparator() {

	}

	public int compare(Object left, Object right) throws ClassCastException {
		assert left != null : "left can't be null";
		assert right != null : "right can't be null";
		return ((Comparable)left).compareTo(right);
	}

}
