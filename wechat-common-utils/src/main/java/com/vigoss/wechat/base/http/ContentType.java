package com.vigoss.wechat.base.http;

import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.util.StringUtil;
import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.util.StringUtil;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

public final class ContentType implements Serializable {

    private static final long serialVersionUID = 1544245878894784980L;

    private final MimeType mimeType;
    private final Charset charset;
    private final String boundary;
    private static final Charset DEFAULT_CHARSET = Consts.UTF_8;

    public static final ContentType APPLICATION_JSON;
    public static final ContentType APPLICATION_FORM_URLENCODED;
    public static final ContentType MULTIPART_FORM_DATA;
    public static final ContentType DEFAULT_BINARY;
    public static final ContentType DEFAULT_TEXT;

    static {
        APPLICATION_JSON = new ContentType(MimeType.APPLICATION_JSON);
        APPLICATION_FORM_URLENCODED = new ContentType(MimeType.APPLICATION_FORM_URLENCODED);
        MULTIPART_FORM_DATA = new ContentType(MimeType.MULTIPART_FORM_DATA);
        DEFAULT_BINARY = new ContentType(MimeType.APPLICATION_OCTET_STREAM);
        DEFAULT_TEXT = new ContentType(MimeType.TEXT_PLAIN);
    }

    ContentType(final MimeType mimeType) {
        this(mimeType, DEFAULT_CHARSET, null);
    }

    ContentType(final MimeType mimeType, final String boundary) {
        this(mimeType, DEFAULT_CHARSET, boundary);
    }

    ContentType(final MimeType mimeType, final Charset charset) {
        this(mimeType, charset, null);
    }

    ContentType(final MimeType mimeType, final Charset charset, final String boundary) {
        this.mimeType = mimeType;
        this.charset = charset;
        this.boundary = boundary;
    }

    public MimeType getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(this.mimeType.toString());
        if (this.charset != null) {
            buf.append("; charset=");
            buf.append(this.charset.name());
        }
        if (!StringUtil.isBlank(this.boundary)) {
            buf.append("; boundary=").append(this.boundary);
        }
        return buf.toString();
    }

    public static String toString(List<ContentType> contentTypes) {
        if (contentTypes == null || contentTypes.isEmpty()) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        for (ContentType contentType : contentTypes) {
            buf.append(contentType.toString()).append(",");
        }
        return buf.delete(buf.length() - 1, buf.length()).toString();
    }

    private static boolean valid(final String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '"' || ch == ',' || ch == ';') {
                return false;
            }
        }
        return true;
    }

    public static ContentType create(final MimeType mimeType, final Charset charset) {
        if (mimeType == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        return new ContentType(mimeType, charset);
    }

    public static ContentType create(final String mimeType) {
        return create(MimeType.valueOf(mimeType), (Charset) null);
    }

    public static ContentType create(final String mimeType, final Charset charset) {
        if (mimeType == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        String type = mimeType.trim().toLowerCase(Locale.US);
        if (type.length() == 0) {
            throw new IllegalArgumentException("MIME type may not be empty");
        }
        if (!valid(type)) {
            throw new IllegalArgumentException("MIME type may not contain reserved characters");
        }
        return new ContentType(MimeType.valueOf(type), charset);
    }

    public static ContentType create(final String mimeType, final String boundary) {
        if (mimeType == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        String type = mimeType.trim().toLowerCase(Locale.US);
        if (type.length() == 0) {
            throw new IllegalArgumentException("MIME type may not be empty");
        }
        if (!valid(type)) {
            throw new IllegalArgumentException("MIME type may not contain reserved characters");
        }
        return new ContentType(MimeType.valueOf(type), boundary);
    }
}