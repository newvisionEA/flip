/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
