/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.sol;

import com.nvea.flip.Warehouse;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public interface Operation {

  void action(Warehouse w);

  void onCatch(Warehouse w);

  void undoAction(Warehouse w);

  int increment(int itemCounter);

}
