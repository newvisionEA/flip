
package com.nvea.flip.model;

import java.awt.Color;
import java.awt.Graphics;

public class Article {
  private ArticleType[] articleTypes;

  public Article(ArticleType[] articleTypes) {
    super();
    this.articleTypes = articleTypes;
    if (articleTypes.length == 0) {
      throw new RuntimeException("Invalid article type");
    }
  }

  public ArticleType[] getArticleTypes() {
    return articleTypes;
  }

  @Override
  public String toString() {
    String result = "";

    for (ArticleType articleType : articleTypes) {
      result += articleType.getShortcut();
    }

    for (int i = result.length(); i < ArticleType.values().length; i++) {
      result += " ";
    }

    return result;
  }

  public boolean hasType(ArticleType type) {
    for (ArticleType t : articleTypes) {
      if (type == t) {
        return true;
      }
    }
    return false;
  }

  public static Article getRandom() {
    double rand = Math.random();

    if (rand >= 0 && rand < 0.1) {
      return new Article(new ArticleType[] { ArticleType.FREEZING });
    } else if (rand >= 0.1 && rand < 0.2) {
      return new Article(new ArticleType[] { ArticleType.INFLAMABLE });
    } else if (rand >= 0.2 && rand < 0.3) {
      return new Article(new ArticleType[] { ArticleType.LIQUID });
    } else if (rand >= 0.3 && rand < 0.4) {
      return new Article(new ArticleType[] { ArticleType.PERMEABLE });
    } else if (rand >= 0.4 && rand < 0.5) {
      return new Article(new ArticleType[] { ArticleType.PERMEABLE, ArticleType.FREEZING });
    } else if (rand >= 0.5 && rand < 0.6) {
      return new Article(new ArticleType[] { ArticleType.LIQUID, ArticleType.FREEZING });
    } else if (rand >= 0.6 && rand < 0.7) {
      return new Article(new ArticleType[] { ArticleType.LIQUID, ArticleType.INFLAMABLE });
    } else if (rand >= 0.7 && rand < 0.8) {
      return new Article(new ArticleType[] { ArticleType.INFLAMABLE, ArticleType.FREEZING });
    } else if (rand >= 0.8 && rand < 0.9) {
      return new Article(new ArticleType[] { ArticleType.PERMEABLE, ArticleType.INFLAMABLE });
    } else if (rand >= 0.9 && rand < 0.95) {
      return new Article(new ArticleType[] { ArticleType.LIQUID, ArticleType.INFLAMABLE, ArticleType.FREEZING });
    } else {
      return new Article(new ArticleType[] { ArticleType.PERMEABLE, ArticleType.INFLAMABLE, ArticleType.FREEZING });
    }

  }

  public void draw(Graphics g, int x, int y) {
    g.setColor(Color.LIGHT_GRAY);
    g.drawRect(x, y - 30, 30, 30);

    if (this.hasType(ArticleType.FREEZING)) {
      g.setColor(Color.WHITE);
      g.drawString("F", x + 5, y - 5);
    }
    if (this.hasType(ArticleType.INFLAMABLE)) {
      g.setColor(Color.RED);
      g.drawString("I", x + 5, y - 15);
    }
    if (this.hasType(ArticleType.LIQUID)) {
      g.setColor(Color.CYAN);
      g.drawString("L", x + 15, y - 5);
    }
    if (this.hasType(ArticleType.PERMEABLE)) {
      g.setColor(Color.YELLOW);
      g.drawString("P", x + 15, y - 15);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    Article that = (Article) obj;

    for (ArticleType type : ArticleType.values()) {
      if (that.hasType(type) && !this.hasType(type)) {
        return false;
      }
    }

    return true;
  }
}
