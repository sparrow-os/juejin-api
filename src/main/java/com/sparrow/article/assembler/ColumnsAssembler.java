package com.sparrow.article.assembler;

import com.sparrow.article.po.Columns;
import com.sparrow.article.protocol.vo.ColumnVO;
import com.sparrow.utility.CollectionsUtility;
import org.springframework.beans.BeanUtils;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ColumnsAssembler {
    public List<ColumnVO> assemblerColumns(List<Columns> columnsList) {
        if (CollectionsUtility.isNullOrEmpty(columnsList)) {
            return null;
        }
        List<ColumnVO> columnList = new ArrayList<>(columnsList.size());

        for (Columns columns : columnsList) {
            ColumnVO columnvo = new ColumnVO();
            BeanUtils.copyProperties(columns, columnvo);
            columnList.add(columnvo);
        }
        return columnList;
    }
}
