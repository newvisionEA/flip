package com.nvea.flip;

public enum ArticleType {
	FREEZING("F"), FLAMABLE("I"), LIQUID("L"), PERMEABLE("P");

	private String shortcut;

	ArticleType(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getShortcut() {
		return shortcut;
	}
}
