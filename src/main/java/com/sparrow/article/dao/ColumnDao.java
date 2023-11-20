package com.sparrow.article.dao;

import com.sparrow.article.po.Columns;

import java.util.List;

public interface ColumnDao {
    List<Columns> myEnableList(Long userId);

    List<Columns> myAllList(Long userId);
}
