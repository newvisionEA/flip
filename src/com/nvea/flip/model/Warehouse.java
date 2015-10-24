
package com.nvea.flip.model;

public class Warehouse {
  private Article[][] matrix;

  public Warehouse(int x, int y) {
    this.matrix = new Article[x][y];
  }

  public void show() {
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        System.out.print((matrix[y][x] != null ? matrix[y][x].toString() : "____") + " ");
      }
      System.out.println();
    }
  }

  public void store(int x, int y, Article random) {
    if (matrix[y][x] != null) {
      throw new RuntimeException("Location occupied");
    }

    matrix[y][x] = random;
    if (!checkMatrix()) {
      matrix[y][x] = null;
      throw new RuntimeException("Can't store that");
    }
  }

  private boolean checkMatrix() {
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        // freezing        
        if (!checkFreezing(y, x)) {
          return false;
        }

        if (!checkFlamable(y, x)) {
          return false;
        }

        if (!checkLiquid(y, x)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean checkLiquid(int y, int x) {
    if (matrix[y][x] != null && matrix[y][x].hasType(ArticleType.LIQUID)) {
      for (int i = y + 1; i < getHeight(); i++) {
        try {
          if (matrix[i][x] != null && matrix[i][x].hasType(ArticleType.PERMEABLE)) {
            return false;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          // 
        }
      }

    }
    return true;
  }

  private boolean checkFlamable(int y, int x) {
    if (matrix[y][x] != null && matrix[y][x].hasType(ArticleType.INFLAMABLE)) {
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (i != 0 || j != 0) {
            try {
              if (matrix[y + i][x + j] != null && //
                matrix[y + i][x + j].hasType(ArticleType.INFLAMABLE)) {
                return false;
              }
            } catch (ArrayIndexOutOfBoundsException e) {
              // skip
            }
          }
        }
      }
    }
    return true;
  }

  private boolean checkFreezing(int y, int x) {
    if (matrix[y][x] != null && matrix[y][x].hasType(ArticleType.FREEZING)) {
      if (y < matrix.length * 3 / 4) {
        return false;
      }
    }
    return true;
  }

  public int getHeight() {
    return matrix.length;
  }

  public int getWidth() {
    return matrix[0].length;
  }

  public Article getArticleAt(int x, int y) {
    return matrix[y][x];
  }

  public void removeArticleAt(int x, int y) {
    matrix[y][x] = null;
  }

  public int getFree() {
    int count = 0;
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        if (matrix[y][x] == null) {
          count++;
        }
      }
    }
    return count;
  }

  @Override
  public Object clone() {
    Warehouse clone = new Warehouse(this.getWidth(), this.getHeight());
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        clone.matrix[y][x] = matrix[y][x];
      }
    }

    return clone;
  }

  @Override
  public boolean equals(Object obj) {
    Warehouse that = (Warehouse) obj;

    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        if (that.matrix[y][x] == null) {
          if (this.matrix[y][x] != null) {
            return false;
          }
        } else if (!that.matrix[y][x].equals(this.matrix[y][x])) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public String toString() {
    String result = "";
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[0].length; x++) {
        result += ((matrix[y][x] != null ? matrix[y][x].toString() : "____") + " ");
      }
      result += "\n\r";
    }
    return result;
  }
}
