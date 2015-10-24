/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.sol;

import com.nvea.flip.model.Article;
import com.nvea.flip.model.Warehouse;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Move implements Operation {
  Article art;
  int sourceX;
  int sourceY;
  int targetX;
  int targetY;

  public Move(Article art, int sourceX, int sourceY, int targetX, int targetY) {
    super();
    this.art = art;
    this.sourceX = sourceX;
    this.sourceY = sourceY;
    this.targetX = targetX;
    this.targetY = targetY;
  }

  @Override
  public String toString() {
    return "Move " + art + " from " + sourceX + ", " + sourceY + " to " + targetX + ", " + targetY;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((art == null) ? 0 : art.hashCode());
    result = prime * result + sourceX;
    result = prime * result + sourceY;
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
    Move other = (Move) obj;
    if (art == null) {
      if (other.art != null)
        return false;
    } else if (!art.equals(other.art))
      return false;
    if (sourceX != other.sourceX)
      return false;
    if (sourceY != other.sourceY)
      return false;
    if (targetX != other.targetX)
      return false;
    if (targetY != other.targetY)
      return false;
    return true;
  }

  public void action(Warehouse w) {
    w.removeArticleAt(sourceX, sourceY);
    w.store(targetX, targetY, art);
  }

  public void onCatch(Warehouse w) {
    w.store(sourceX, sourceY, art);
  }

  public void undoAction(Warehouse w) {
    w.removeArticleAt(targetX, targetY);
    w.store(sourceX, sourceY, art);

  }

  public int increment(int itemCounter) {
    return itemCounter;
  }

}
