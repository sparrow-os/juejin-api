package com.sparrow.article.controller;

import com.sparrow.article.dao.ColumnDao;
import com.sparrow.article.po.Columns;
import com.sparrow.article.protocol.vo.ColumnVO;
import com.sparrow.article.service.ColumnsService;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("column")
@Api(value = "文章系统", tags = "文章系统")
public class ColumnController {
    @Inject
    private ColumnDao columnDao;

    @Inject
    private ColumnsService columnsService;

    @ApiOperation("我的专栏")
    @PostMapping("my")
    public List<ColumnVO> columnList() {
        return this.columnsService.myEnableList();
    }

    @ApiOperation("我的专栏-全部")
    @PostMapping("/all")
    public List<Columns> columnAll() {
        LoginUser loginUser = ThreadContext.getLoginToken();
        return this.columnDao.myAllList(loginUser.getUserId());
    }

    @ApiOperation("我的专栏-发布过的")
    @PostMapping("/published")
    public List<ColumnVO> published() {
        List<ColumnVO> columnList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ColumnVO columnVO = new ColumnVO();
            columnVO.setId(0L);
            columnVO.setName("专栏" + i);
            columnVO.setDesc("专栏描述");
            columnVO.setIcon("icon");
            columnList.add(columnVO);
        }
        return columnList;
    }

    @ApiOperation("我的专栏-待审核")
    @PostMapping("/auditing")
    public List<ColumnVO> auditing() {
        List<ColumnVO> columnList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ColumnVO columnVO = new ColumnVO();
            columnVO.setId(0L);
            columnVO.setName("专栏" + i);
            columnVO.setDesc("专栏描述");
            columnVO.setIcon("icon");
            columnList.add(columnVO);
        }
        return columnList;
    }

    @ApiOperation("我的专栏-拒绝过的")
    @PostMapping("/rejected")
    public List<ColumnVO> rejected() {
        List<ColumnVO> columnList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ColumnVO columnVO = new ColumnVO();
            columnVO.setId(0L);
            columnVO.setName("专栏" + i);
            columnVO.setDesc("专栏描述");
            columnVO.setIcon("icon");
            columnList.add(columnVO);
        }
        return columnList;
    }
}
