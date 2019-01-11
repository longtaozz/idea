package com.zt.jinanzf.monitor.push.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zt.jinanzf.monitor.push.model.PushUser;

import java.util.List;

/**
 * 推送数据库操作
 */

public interface HWPushMapper extends BaseMapper<PushUser> {
    /**
     * 角色查询华为token
     * @param param
     * @return
     */
    List<String> getTokenByRole(Integer param);
}
