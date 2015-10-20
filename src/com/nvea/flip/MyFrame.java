/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class MyFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private static final int OFFSET = 30;
  public static final int BLOCKSIZE = 40;
  private Controller c;

  public MyFrame(Controller c) {
    this.c = c;
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println(((e.getX() - BLOCKSIZE) / BLOCKSIZE));
        System.out.println(((e.getY() - OFFSET - BLOCKSIZE) / BLOCKSIZE));
        cellClicked(((e.getX() - BLOCKSIZE) / BLOCKSIZE), ((e.getY() - OFFSET - BLOCKSIZE) / BLOCKSIZE));
      }
    });
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  protected void cellClicked(int x, int y) {
    Model model = c.getModel();

    if (model.getWarehouse().getArticleAt(x, y) == null) {
      try {
        if (model.getSelection() != null) {
          model.getWarehouse().store(x, y, model.getSelection());
          model.setSelection(null);
        } else {
          model.getWarehouse().store(x, y, model.getCurrentArticle());
          model.setCurrentArticle(Article.getRandom());
        }
        model.setMessage("Success");
      } catch (Exception e) {
        model.setMessage(e.getMessage());
      }
    } else {
      if (model.getSelection() == null) {
        model.setSelection(model.getWarehouse().getArticleAt(x, y));
        model.getWarehouse().removeArticleAt(x, y);
      }
    }

    this.repaint();
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 640, 480);
    g.setColor(Color.WHITE);

    for (int y = 0; y <= c.getModel().getWarehouse().getHeight(); y++) {
      g.drawLine(BLOCKSIZE, OFFSET + (y + 1) * BLOCKSIZE, BLOCKSIZE * (c.getModel().getWarehouse().getWidth() + 1), OFFSET + (y + 1) * BLOCKSIZE);
    }

    for (int x = 0; x <= c.getModel().getWarehouse().getWidth(); x++) {
      g.drawLine(BLOCKSIZE * (x + 1), OFFSET + BLOCKSIZE, BLOCKSIZE * (x + 1), OFFSET + (c.getModel().getWarehouse().getHeight() + 1) * BLOCKSIZE);
    }

    for (int y = 0; y < c.getModel().getWarehouse().getHeight(); y++) {
      for (int x = 0; x < c.getModel().getWarehouse().getWidth(); x++) {
        if (c.getModel().getWarehouse().getArticleAt(x, y) != null) {
          g.drawString(c.getModel().getWarehouse().getArticleAt(x, y).toString(), 5 + BLOCKSIZE * (x + 1), -5 + OFFSET + (y + 2) * BLOCKSIZE);
        }
      }
    }

    g.setColor(Color.YELLOW);
    g.drawString(c.getModel().getCurrentArticle().toString(), 10, 40);

    g.setColor(Color.YELLOW);
    g.drawString(c.getModel().getSelection() != null ? c.getModel().getSelection().toString() : "", 40, 40);

    g.setColor(Color.RED);
    g.drawString(c.getModel().getMessage(), 100, 40);

  }
}
