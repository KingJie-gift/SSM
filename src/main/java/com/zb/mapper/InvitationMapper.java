package com.zb.mapper;

import com.zb.entity.Invitation;

import java.util.List;
import java.util.Map;

public interface InvitationMapper {
    /**
     * 分页按照条件查询
     * map
     *  para  name
     *  start
     *  row
     */
    public Integer byLimitInvitation(Map<String,Object> map);

    public List<Invitation> byLimitList(Map<String,Object> map);
}
