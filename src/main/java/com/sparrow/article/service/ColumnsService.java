package com.sparrow.article.service;

import com.sparrow.article.assembler.ColumnsAssembler;
import com.sparrow.article.dao.ColumnDao;
import com.sparrow.article.po.Columns;
import com.sparrow.article.protocol.vo.ColumnVO;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ColumnsService {
    @Inject
    private ColumnDao columnDao;
    @Inject
    private ColumnsAssembler columnsAssembler;

    public List<ColumnVO> myEnableList() {
        LoginUser loginUser = ThreadContext.getLoginToken();
        List<Columns> columns = this.columnDao.myEnableList(loginUser.getUserId());
        return this.columnsAssembler.assemblerColumns(columns);
    }

    public List<ColumnVO> myAllList() {
        LoginUser loginUser = ThreadContext.getLoginToken();
        List<Columns> columns = this.columnDao.myAllList(loginUser.getUserId());
        return this.columnsAssembler.assemblerColumns(columns);
    }
}
