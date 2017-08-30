package org.sha.ursip.model;

/**
 * Created by first on 28.08.17.
 */
public class ArticleLink {
    private long article1Id;
    private long article2Id;

    public ArticleLink(){}

    public ArticleLink(long article1Id, long article2Id) {
        this.article1Id = article1Id;
        this.article2Id = article2Id;
    }

    public long getArticle1Id() {
        return article1Id;
    }

    public void setArticle1Id(long article1Id) {
        this.article1Id = article1Id;
    }

    public long getArticle2Id() {
        return article2Id;
    }

    public void setArticle2Id(long article2Id) {
        this.article2Id = article2Id;
    }
}
