package com.sparrow.tag.assembler;

import com.sparrow.tag.po.Tag;
import com.sparrow.tag.protocol.vo.SimpleTagVO;
import com.sparrow.utility.CollectionsUtility;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class TagAssembler {
    public List<SimpleTagVO> assembleTagList(List<Tag> tags) {
        if (CollectionsUtility.isNullOrEmpty(tags)) {
            return null;
        }
        List<SimpleTagVO> simpleTags = new ArrayList<>(tags.size());
        for (Tag tag : tags) {
            SimpleTagVO simpleTag = new SimpleTagVO();
            simpleTag.setTagId(tag.getId());
            simpleTag.setTagName(tag.getTagName());
            simpleTags.add(simpleTag);
        }
        return simpleTags;
    }
}
