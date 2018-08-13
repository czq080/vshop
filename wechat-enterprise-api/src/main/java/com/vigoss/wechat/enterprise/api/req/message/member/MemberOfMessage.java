package com.vigoss.wechat.enterprise.api.req.message.member;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Collections;

/**
 * @Author:czq
 * @Description:
 * @Date: 9:44 2018/3/5
 * @Modified By:
 */
public class MemberOfMessage {
    @JSONField(unwrapped = true)
    private Member touser;
    @JSONField(unwrapped = true)
    private Member toparty;
    @JSONField(unwrapped = true)
    private Member totag;

    public static MemberStep newBuilder() {
        return new Builder();
    }

    public Member getTotag() {
        return totag;
    }

    public void setTotag(Member totag) {
        this.totag = totag;
    }

    public Member getToparty() {
        return toparty;
    }

    public void setToparty(Member toparty) {
        this.toparty = toparty;
    }

    public Member getTouser() {
        return touser;
    }

    public void setTouser(Member touser) {
        this.touser = touser;
    }

    public interface MemberStep {
        MemberStep withToUser(UserMember user);

        MemberStep withToParty(PartyMember party);

        MemberStep withToTag(TagMember tag);

        BuildStep withToAll();

        BuildStep noMoreMember();
    }

    public interface BuildStep {
        MemberOfMessage build();
    }

    public static class Builder implements MemberStep, BuildStep {
        private Member touser;
        private Member toparty;
        private Member totag;

        public MemberStep withToUser(UserMember user) {
            this.touser = user;
            return this;
        }

        @Override
        public MemberStep withToParty(PartyMember party) {
            this.toparty = party;
            return this;
        }

        @Override
        public MemberStep withToTag(TagMember tag) {
            this.totag = tag;
            return this;
        }

        @Override
        public BuildStep withToAll() {
            UserMember member = new UserMember(Collections.singletonList("@all"));
            this.touser = member;
            return this;
        }

        @Override
        public BuildStep noMoreMember() {
            return this;
        }

        @Override
        public MemberOfMessage build() {
            MemberOfMessage memberOfMessage = new MemberOfMessage();
            if (touser != null)
                memberOfMessage.setTouser(touser);
            if (toparty != null)
                memberOfMessage.setToparty(toparty);
            if (totag != null)
                memberOfMessage.setTotag(totag);
            return memberOfMessage;
        }
    }
}
