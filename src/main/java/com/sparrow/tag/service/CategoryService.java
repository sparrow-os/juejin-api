package com.sparrow.tag.service;

import com.sparrow.tag.dao.CategoryDao;
import com.sparrow.tag.po.Category;
import com.sparrow.tag.protocol.vo.CategoryVO;
import com.sparrow.utility.CollectionsUtility;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
public class CategoryService {

    @Inject
    private CategoryDao categoryDao;

    public Boolean exist(Long categoryId) {
        return this.categoryDao.exist(categoryId);
    }

    public List<CategoryVO> categoryTree() {
        List<CategoryVO> categoryVOS = new ArrayList<>();
        CategoryVO root = CategoryVO.root();
        categoryVOS.add(root);

        List<Category> categories = this.categoryDao.allEnableList();
        Map<Long, List<CategoryVO>> treeNodes = new HashMap<>();
        for (Category category : categories) {
            if (!treeNodes.containsKey(category.getParentId())) {
                treeNodes.put(category.getParentId(), new ArrayList<>());
            }
            treeNodes.get(category.getParentId()).add(this.assemblerCategoryVo(category));
        }

        this.buildTree(categoryVOS, treeNodes);
        return categoryVOS;
    }

    public CategoryVO assemblerCategoryVo(Category category) {
        CategoryVO categoryVO = new CategoryVO();
        BeanUtils.copyProperties(category, categoryVO);
        return categoryVO;
    }

    public void buildTree(List<CategoryVO> parentNode, Map<Long, List<CategoryVO>> treeNodes) {
        List<CategoryVO> parentNodeList = new ArrayList<>();
        for (CategoryVO category : parentNode) {
            List<CategoryVO> children = treeNodes.get(category.getId());
            if (CollectionsUtility.isNullOrEmpty(children)) {
                continue;
            }
            category.setChildren(children);
            parentNodeList.addAll(children);
        }
        if (CollectionsUtility.isNullOrEmpty(parentNodeList)) {
            return;
        }
        buildTree(parentNodeList, treeNodes);
    }
}
