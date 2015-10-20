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

public class Main {
  public static void main(String[] args) {
    Warehouse w = new Warehouse(8, 8);
    Model m = new Model(w, Article.getRandom());
    Controller c = new Controller(m);
    for (int i = 0; i < 200; i++) {
      try {
        w.store((int) (Math.random() * 8.0), (int) (Math.random() * 8.0), Article.getRandom());
      } catch (Exception e) {
        // TODO Auto-generated catch block
      }
    }

    MyFrame frame = new MyFrame(c);
    frame.setVisible(true);
    frame.setSize(200, 240);
  }
}