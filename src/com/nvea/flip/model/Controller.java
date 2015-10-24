/*
 * Copyright (c) 2015 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.nvea.flip.model;


/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class Controller {
  Model m;

  public Controller(Model m) {
    this.m = m;
  }

  public Model getModel() {
    return m;
  }

}
