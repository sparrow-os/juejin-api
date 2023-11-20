package com.sparrow.tag.service;

import com.sparrow.tag.dao.TagDao;
import com.sparrow.tag.po.Tag;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TagService {
    @Inject
    private TagDao tagDao;

    public List<Tag> queryByLastId(Long lastId) {
        return this.tagDao.queryByLastId(lastId);
    }

    public List<Tag> queryByName(String tagName) {
        return this.tagDao.queryByName(tagName);
    }
}
