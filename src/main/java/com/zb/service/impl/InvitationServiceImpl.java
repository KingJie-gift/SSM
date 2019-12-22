package com.zb.service.impl;

import com.zb.entity.Invitation;
import com.zb.mapper.InvitationMapper;
import com.zb.service.InvitationService;
import com.zb.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("invitationService")
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    private InvitationMapper invitationMapper;

    public Integer byLimitInvitation(Map<String, Object> map) {
        return invitationMapper.byLimitInvitation(map);
    }

    public List<Invitation> byLimitList(Map<String, Object> map) {
        return invitationMapper.byLimitList(map);
    }

    public Page<Invitation> getPage(Integer indexPage, Integer row, String title) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("start",(indexPage-1)*row);
        map.put("title",title);
        map.put("row",row);
        Page<Invitation> page = new Page<Invitation>();
        page.setRow(row);
        page.setIndexPage(indexPage);
        page.setSumCount(this.byLimitInvitation(map));
        page.setList(this.byLimitList(map));
        return page;
    }
}
