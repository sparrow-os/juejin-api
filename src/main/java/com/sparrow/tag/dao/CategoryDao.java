package com.sparrow.tag.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.tag.po.Category;

import java.util.List;

public interface CategoryDao extends DaoSupport<Category, Long> {
    List<Category> allEnableList();
}
