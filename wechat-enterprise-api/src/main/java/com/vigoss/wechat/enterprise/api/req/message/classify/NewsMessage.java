package com.vigoss.wechat.enterprise.api.req.message.classify;

import java.util.LinkedList;

/**
 * @Author:czq
 * @Description:
 * @Date: 14:15 2018/3/5
 * @Modified By:
 */
public class NewsMessage extends Message {

    private final NewsContent news;

    public NewsMessage(NewsContent news) {
        super(MessageType.NEWS.getType());
        this.news = news;
    }

    public NewsContent getNews() {
        return news;
    }

    public static class NewsContent {

        private static final transient int MAX_ARTICLE_COUNT = 8;

        private LinkedList<Article> articles;

        public NewsContent() {
            this.articles = new LinkedList<>();
        }

        public LinkedList<Article> getArticles() {
            return articles;
        }

        public NewsContent addArticle(String title, String description, String url, String picurl, String btntxt) {
            return addArticle(new Article(title, description, url, picurl, btntxt));
        }

        public NewsContent addArticle(Article... articles) {
            int num = MAX_ARTICLE_COUNT - articles.length;
            for (int i = 0;  this.articles.size() < MAX_ARTICLE_COUNT && i < articles.length; i++) {
                this.articles.add(articles[i]);
            }
            return this;
        }


        public static class Article {

            /**
             * title : 中秋节礼品领取
             * description : 今年中秋节公司有豪礼相送
             * url : URL
             * picurl : http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png
             * btntxt : 更多
             */

            private String title;
            private String description;
            private String url;
            private String picurl;
            private String btntxt;

            public Article() {
            }

            public Article(String title, String description, String url, String picurl, String btntxt) {
                this.title = title;
                this.description = description;
                this.url = url;
                this.picurl = picurl;
                this.btntxt = btntxt;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public String getBtntxt() {
                return btntxt;
            }

            public void setBtntxt(String btntxt) {
                this.btntxt = btntxt;
            }
        }
    }
}
