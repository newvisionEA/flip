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

		return result;
	}
}
