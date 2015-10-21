/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.sol;

import com.nvea.flip.Article;
import com.nvea.flip.Warehouse;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Store implements Operation {
  Article art;
  int targetX;
  int targetY;

  public Store(Article art, int targetX, int targetY) {
    super();
    this.art = art;
    this.targetX = targetX;
    this.targetY = targetY;
  }

  @Override
  public String toString() {
    return "Store " + art + " at " + targetX + ", " + targetY;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((art == null) ? 0 : art.hashCode());
    result = prime * result + targetX;
    result = prime * result + targetY;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Store other = (Store) obj;
    if (art == null) {
      if (other.art != null)
        return false;
    } else if (!art.equals(other.art))
      return false;
    if (targetX != other.targetX)
      return false;
    if (targetY != other.targetY)
      return false;
    return true;
  }

  public void action(Warehouse w) {
    w.store(targetX, targetY, art);
  }

  public void onCatch(Warehouse w) {
    //
  }

  public void undoAction(Warehouse w) {
    w.removeArticleAt(targetX, targetY);
  }

  public int increment(int itemCounter) {
    return itemCounter + 1;
  }

}
