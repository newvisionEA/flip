package com.nvea.flip.sol;

import com.nvea.flip.model.Article;
import com.nvea.flip.model.Warehouse;

public class Solution3 {
	private Article[] items;
	private Warehouse w;

	public Solution3(Article[] items, Warehouse w) {
		super();
		this.items = items;
		this.w = w;
	}

	public int find() {
		int counter = 0;
		Warehouse wh = w;
		for (Article art : items) {
			Solution2 sol2 = new Solution2(wh, new Article[] { art });
			counter += sol2.find();
			wh = sol2.getMinWarehouse();

		}
		return counter;
	}
}
