/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Model {
  Warehouse w;
  private Article currentArticle;
  private String message;
  private Article selection;

  public Model(Warehouse w, Article currentArticle) {
    this.w = w;
    this.currentArticle = currentArticle;
  }

  public Warehouse getWarehouse() {
    return w;
  }

  public Article getCurrentArticle() {
    return currentArticle;
  }

  public void setCurrentArticle(Article currentArticle) {
    this.currentArticle = currentArticle;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public Article getSelection() {
    return selection;
  }

  public void setSelection(Article selection) {
    this.selection = selection;
  }

}
