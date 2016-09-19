package com.jlopes.library;

public abstract class Utility {
	protected boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isDataEmpty(String... params) {
		for (String value : params) {
			if (value.equals("")) {
				return true;
			}
		}
		return false;
	}

}
