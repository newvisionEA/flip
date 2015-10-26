/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.sol;

import java.util.ArrayList;

import com.nvea.flip.model.Article;
import com.nvea.flip.model.Warehouse;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Solution2 {

	ArrayList<Warehouse> path = new ArrayList<Warehouse>();
	private Article[] items;
	private Warehouse w;
	private ArrayList<Operation> ops;
	private int minSol = 10000;
	private Warehouse minWh;

	public Solution2(Warehouse w, Article[] items) {
		this.w = w;
		this.items = items;
		this.ops = new ArrayList<Operation>();
	}

	public int find() {
		path.add((Warehouse) w.clone());
		find(0);
		return minSol;
	}

	private void find(int itemCounter) {
		if (itemCounter == items.length) {
			System.out.println(ops);
			if (minSol > ops.size() - items.length) {
				minSol = ops.size() - items.length;
				minWh = (Warehouse) w.clone();
			}
			System.out.println(minSol);
			return;
		}

		ArrayList<Operation> ops2 = getPossibleOperations(itemCounter);

		for (Operation op : ops2) {
			try {
				op.action(w);
				if (!ops.contains(op) && ops.size() < 3) {
					ops.add(op);
					if (!path.contains(w)) {
						path.add((Warehouse) w.clone());
						find(op.increment(itemCounter));
						path.remove(path.size() - 1);
					}
					ops.remove(op);
				}
				op.undoAction(w);
			} catch (Exception e) {
				op.onCatch(w);
			}
		}
	}

	private ArrayList<Operation> getPossibleOperations(int itemCounter) {
		ArrayList<Operation> result = new ArrayList<Operation>();
		for (int y = 0; y < w.getHeight(); y++) {
			for (int x = 0; x < w.getWidth(); x++) {
				if (w.getArticleAt(x, y) == null) {
					result.add(new Store(items[itemCounter], x, y));
				}
			}
		}

		for (int y = 0; y < w.getHeight(); y++) {
			for (int x = 0; x < w.getWidth(); x++) {
				if (w.getArticleAt(x, y) != null) {
					Article artToMove = w.getArticleAt(x, y);
					for (int yy = 0; yy < w.getHeight(); yy++) {
						for (int xx = 0; xx < w.getWidth(); xx++) {
							if (w.getArticleAt(xx, yy) == null) {
								result.add(new Move(artToMove, x, y, xx, yy));
							}
						}
					}
				}
			}
		}
		return result;
	}

	public Warehouse getMinWarehouse() {
		return minWh;
	}
}
