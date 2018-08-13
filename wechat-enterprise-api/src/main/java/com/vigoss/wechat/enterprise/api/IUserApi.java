package com.vigoss.wechat.enterprise.api;

import com.vigoss.wechat.enterprise.api.req.user.UserTicket;
import com.vigoss.wechat.enterprise.api.res.user.GetUserIdByCodeApiResult;
import com.vigoss.wechat.enterprise.api.res.user.ListUserApiResult;
import com.vigoss.wechat.enterprise.api.res.user.UserApiResult;
import com.vigoss.wechat.enterprise.api.res.user.UserDetailApiResult;

/**
 * @Author:czq
 * @Description:
 * @Date: 17:57 2018/3/3
 * @Modified By:
 */
public interface IUserApi {
    GetUserIdByCodeApiResult getUserIdByCode(String code);

    UserDetailApiResult getUserDetail(UserTicket userTicket);

    UserApiResult getUser(String userid);

    ListUserApiResult listUserDetail(int partyId, boolean fetchChild, boolean isdetail);
}
