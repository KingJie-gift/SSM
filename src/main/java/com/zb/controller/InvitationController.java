package com.zb.controller;


import com.alibaba.fastjson.JSON;
import com.zb.entity.Invitation;
import com.zb.service.InvitationService;
import com.zb.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/invitation/")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @ResponseBody
    @RequestMapping("init")
    public String init(@RequestParam(value = "indexPage" , defaultValue = "1") Integer indexPage, @RequestParam(value = "title" , defaultValue = "") String title){
        Page<Invitation> page = invitationService.getPage(indexPage,2,title);
        return JSON.toJSONString(page);
    }

}
