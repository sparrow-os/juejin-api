package com.sparrow.cms.controller;

import com.sparrow.cms.protocol.vo.MenuVO;
import com.sparrow.cms.protocol.vo.WebsiteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("content")
@Api(value = "内容管理系统",tags = "内容管理系统")
public class ContentController {
    @ApiOperation(value = "菜单列表")
    @GetMapping("menu")
    public List<MenuVO> menus() {
        List<MenuVO> menus = new ArrayList<>();
        String[] menuNames = new String[]{"首页", "圈子", "商城", "消息", "问答"};
        for (int i = 0; i < menuNames.length; i++) {
            MenuVO menu = new MenuVO();
            menu.setId(i);
            menu.setName(menuNames[i]);
            menu.setIcon("http://img.sparrowzoo.net/" + i + ".jpg");
            menu.setDesc(menuNames[i]);
            menus.add(menu);
        }
        return menus;
    }

    @ApiOperation("网站相关配置")
    @GetMapping("config")
    public WebsiteVO getConfig() {
        WebsiteVO website = new WebsiteVO();
        website.setTitle("让天下没有难学的技术");
        website.setKeywords("学技术 JAVA");
        website.setDescription("学技术");
        website.setLogo("logo");
        website.setBanner("banner");
        website.setVideoBanner("video banner");
        website.setIcp("京 ICP 12345");
        website.setContact("13581527222");
        return website;
    }
}
