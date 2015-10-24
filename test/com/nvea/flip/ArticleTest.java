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

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class ArticleTest {

	@Test
	public void testArticleConstructor() {
		try {
			new Article(new ArticleType[0]);
			fail("The code should throw an exception here");
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void testToString() {
		Article article = new Article(new ArticleType[] { ArticleType.INFLAMABLE });
		assertEquals("I___", article.toString());
	}

	@Test
	public void testEquals() {
		Article a1 = new Article(new ArticleType[] { ArticleType.PERMEABLE });
		Article a2 = new Article(new ArticleType[] { ArticleType.INFLAMABLE });
		assertEquals(a1, a2);

		a1 = new Article(new ArticleType[] { ArticleType.PERMEABLE,
		    ArticleType.INFLAMABLE });
		a2 = new Article(new ArticleType[] { ArticleType.INFLAMABLE,
		    ArticleType.PERMEABLE });
		assertEquals(a1, a2);

	}
}
