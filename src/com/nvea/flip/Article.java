
package com.nvea.flip;

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

    if (rand >= 0 && rand < 0.25) {
      return new Article(new ArticleType[] { ArticleType.FREEZING });
    } else if (rand >= 0.25 && rand < 0.5) {
      return new Article(new ArticleType[] { ArticleType.INFLAMABLE });
    } else if (rand >= 0.5 && rand < 0.75) {
      return new Article(new ArticleType[] { ArticleType.LIQUID });
    } else {
      return new Article(new ArticleType[] { ArticleType.PERMEABLE });
    }

  }
}
