package com.qiumeng.util.TreeUtill;

import java.util.ArrayList;
import java.util.List;

/**树形基础结构
 * @author qiumeng
 * @Package TreeUtill
 * @Description:
 * @date 2018 2018/4/19 18:17
 */
public class BaseTreeObj<E> {
    /**
     * 节点id
     */
    private Integer id;
    /**
     * 父节点id
     */
    private Integer parentId;
    /**
     * 节点的子节点
     */
    private List<E> childsList=new ArrayList<E>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<E> getChildsList() {
        return childsList;
    }

    public void setChildsList(List<E> childsList) {
        this.childsList = childsList;
    }
}
