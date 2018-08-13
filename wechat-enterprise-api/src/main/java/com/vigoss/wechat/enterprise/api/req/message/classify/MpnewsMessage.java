package com.vigoss.wechat.enterprise.api.req.message.classify;

import java.util.LinkedList;

/**
 * @Author:czq
 * @Description:
 * @Date: 16:25 2018/3/5
 * @Modified By:
 */
public class MpnewsMessage extends Message {
    private final MpnewsContent mpnews;

    public MpnewsMessage(MpnewsContent mpnews) {
        super(MessageType.MPNEWS.getType());
        this.mpnews = mpnews;
    }

    public MpnewsContent getMpnews() {
        return mpnews;
    }

    public static class MpnewsContent {

        private static final transient int MAX_ARTICLE_COUNT = 8;

        private LinkedList<Article> articles;

        public MpnewsContent() {
            this.articles = new LinkedList<>();
        }

        public LinkedList<Article> getArticles() {
            return articles;
        }

        public MpnewsContent addArticle(String title, String thumb_media_id, String author, String content_source_url, String content, String digest) {
            return addArticle(new Article(title, thumb_media_id, author, content_source_url, content, digest));
        }

        public MpnewsContent addArticle(Article... articles) {
            int num = MAX_ARTICLE_COUNT - articles.length;
            for (int i = 0; this.articles.size() < MAX_ARTICLE_COUNT && i < articles.length; i++) {
                this.articles.add(articles[i]);
            }
            return this;
        }


        public static class Article {

            /**
             * title : Title
             * thumb_media_id : MEDIA_ID
             * author : Author
             * content_source_url : URL
             * content : Content
             * digest : Digest description
             */

            private String title;
            private String thumb_media_id;
            private String author;
            private String content_source_url;
            private String content;
            private String digest;

            public Article() {
            }

            public Article(String title, String thumb_media_id, String author, String content_source_url, String content, String digest) {
                this.title = title;
                this.thumb_media_id = thumb_media_id;
                this.author = author;
                this.content_source_url = content_source_url;
                this.content = content;
                this.digest = digest;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb_media_id() {
                return thumb_media_id;
            }

            public void setThumb_media_id(String thumb_media_id) {
                this.thumb_media_id = thumb_media_id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getContent_source_url() {
                return content_source_url;
            }

            public void setContent_source_url(String content_source_url) {
                this.content_source_url = content_source_url;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getDigest() {
                return digest;
            }

            public void setDigest(String digest) {
                this.digest = digest;
            }
        }
    }
}
