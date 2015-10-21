/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.sol;

import java.util.ArrayList;

import com.nvea.flip.Article;
import com.nvea.flip.Warehouse;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Solution {

  ArrayList<Warehouse> path = new ArrayList<Warehouse>();
  private Article[] items;
  private Warehouse w;
  private ArrayList<Operation> ops;
  private int minSol = 10000;

  public Solution(Warehouse w, Article[] items) {
    this.w = w;
    this.items = items;
    this.ops = new ArrayList<Operation>();
  }

  public int find() {
    find(0, true);
    path.add((Warehouse) w.clone());
    return minSol;
  }

  private void find(int itemCounter, boolean recursive) {
    if (itemCounter == items.length) {
      System.out.println(ops);
      if (minSol > ops.size() - items.length) {
        minSol = ops.size() - items.length;
      }
      return;
    }

    Article art = items[itemCounter];
    int bagat = 0;
    for (int y = 0; y < w.getHeight(); y++) {
      for (int x = 0; x < w.getWidth(); x++) {
        if (w.getArticleAt(x, y) == null) {
          try {
            Operation op = new Store(art, x, y);
            w.store(x, y, art);
            ops.add(op);
            if (!path.contains(w)) {
              path.add(w);
              find(itemCounter + 1, true);
              path.remove(w);
            }
            ops.remove(op);
            w.removeArticleAt(x, y);
            bagat++;
          } catch (Exception e) {
            //
          }
        }
      }
    }

    if (bagat > 0) {
      return;
    }
    for (int y = 0; y < w.getHeight(); y++) {
      for (int x = 0; x < w.getWidth(); x++) {
        if (w.getArticleAt(x, y) != null) {
          Article artToMove = w.getArticleAt(x, y);
          for (int yy = 0; yy < w.getHeight(); yy++) {
            for (int xx = 0; xx < w.getWidth(); xx++) {
              if (w.getArticleAt(xx, yy) == null) {
                try {
                  Operation op = new Move(artToMove, x, y, xx, yy);
                  w.removeArticleAt(x, y);
                  w.store(xx, yy, artToMove);
                  ops.add(op);
                  find(itemCounter, false);
                  ops.remove(op);
                  w.removeArticleAt(xx, yy);
                  w.store(x, y, artToMove);
                } catch (Exception e) {
                  w.store(x, y, artToMove);
                }
              }
            }
          }
        }
      }
    }
  }
}
