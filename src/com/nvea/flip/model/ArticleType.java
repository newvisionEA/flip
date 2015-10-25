package com.nvea.flip.model;

import java.io.Serializable;

public enum ArticleType implements Serializable {
	INFLAMABLE("I"), FREEZING("F"), LIQUID("L"), PERMEABLE("P");
	private String shortcut;

	ArticleType(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getShortcut() {
		return shortcut;
	}

}
