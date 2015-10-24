/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.nvea.flip.model.Article;
import com.nvea.flip.model.ArticleType;
import com.nvea.flip.model.Warehouse;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class WarehouseTest {

	@Test
	public void testI() {
		Warehouse w = new Warehouse(4, 4);
		w.store(2, 2, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));
		try {
			w.store(3, 2, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));
			fail("Should throw exception");
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void testCloneAndEquals() {
		Warehouse w = new Warehouse(4, 4);

		w.store(0, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(1, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(2, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(3, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));

		w.store(0, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 1, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));

		Object clone = w.clone();
		assertEquals(clone, w);
	}

	@Test
	public void testEquals() {
		Warehouse w = new Warehouse(4, 4);

		w.store(0, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(1, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(2, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(3, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));

		w.store(0, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 1, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));

		Warehouse w1 = w;
		w = new Warehouse(4, 4);

		w.store(0, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(1, 3, new Article(new ArticleType[] { ArticleType.FREEZING }));
		w.store(2, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 2, new Article(new ArticleType[] { ArticleType.LIQUID }));

		w.store(0, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 1, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));

		assertEquals(w1, w);
	}
}
