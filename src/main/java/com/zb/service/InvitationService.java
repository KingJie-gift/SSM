package com.zb.service;

import com.zb.entity.Invitation;
import com.zb.util.Page;

import java.util.List;
import java.util.Map;

public interface InvitationService {
    /**
     * 分页按照条件查询
     * map
     *  para  name
     *  start
     *  row
     */
    public Integer byLimitInvitation(Map<String, Object> map);

    public List<Invitation> byLimitList(Map<String, Object> map);

    public Page<Invitation> getPage(Integer indexPage,Integer row , String title);
}
