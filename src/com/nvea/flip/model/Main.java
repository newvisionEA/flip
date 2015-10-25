/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Main {
	public static void main(String[] args) throws FileNotFoundException,
	    IOException {
		Warehouse w = new Warehouse(8, 8);
		Model m = new Model(w, Article.getRandom());
		Controller c = new Controller(m);
		while (w.getFree() > 5) {
			try {
				w.store((int) (Math.random() * 8.0), (int) (Math.random() * 8.0),
				    Article.getRandom());
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}

		MyFrame frame = new MyFrame(c);
		frame.setVisible(true);
		frame.setSize(200, 240);
		Article[] arts = new Article[5];
		for (int i = 0; i < 5; i++) {
			arts[i] = Article.getRandom();
		}
		save(w, arts);
	}

	public static void save(Warehouse w, Article[] arts)
	    throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
		    "level.ser"));
		oos.writeObject(w);
		oos.writeObject(arts);
		oos.close();
	}
}
