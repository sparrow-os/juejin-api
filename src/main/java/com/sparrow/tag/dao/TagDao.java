package com.sparrow.tag.dao;

import com.sparrow.tag.po.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> queryByLastId(Long lastId);

    List<Tag> queryByName(String tagName);
}
