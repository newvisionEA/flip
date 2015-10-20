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

}
