/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nvea.flip.model.Article;
import com.nvea.flip.model.ArticleType;
import com.nvea.flip.model.Warehouse;
import com.nvea.flip.sol.Solution2;
import com.nvea.flip.sol.Solution3;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class SolutionTest {
	@Test
	public void testSolution() {
		Warehouse w = new Warehouse(4, 4);

		w.store(0, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));
		w.store(1, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));
		w.store(3, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));

		Article[] items = new Article[] { new Article(
		    new ArticleType[] { ArticleType.FREEZING }) };
		Solution2 sol = new Solution2(w, items);
		assertEquals(1, sol.find());
	}

	@Test
	public void testSolution2() {
		Warehouse w = new Warehouse(4, 4);

		w.store(0, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));
		w.store(1, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));
		w.store(3, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));

		Article[] items = new Article[] {
		    new Article(new ArticleType[] { ArticleType.FREEZING }), //
		    new Article(new ArticleType[] { ArticleType.FREEZING }) };

		Solution2 sol = new Solution2(w, items);
		assertEquals(2, sol.find());
	}

	@Test
	public void testSolution3() {
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

		Article[] items = new Article[] { new Article(
		    new ArticleType[] { ArticleType.FREEZING }), //
		};

		Solution2 sol = new Solution2(w, items);
		assertEquals(2, sol.find());
	}

	@Test
	public void testSolution4() {
		Warehouse w = new Warehouse(4, 4);

		w.store(0, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 3, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 3, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 1, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 1, new Article(new ArticleType[] { ArticleType.INFLAMABLE }));

		w.store(0, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(1, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(2, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));
		w.store(3, 0, new Article(new ArticleType[] { ArticleType.LIQUID }));

		Article[] items = new Article[] {
		    new Article(new ArticleType[] { ArticleType.FREEZING }), //
		    new Article(new ArticleType[] { ArticleType.FREEZING }), //
		    new Article(new ArticleType[] { ArticleType.FREEZING }), //
		    new Article(new ArticleType[] { ArticleType.FREEZING }) };

		Solution3 sol = new Solution3(items, w);
		assertEquals(8, sol.find());
	}
}
