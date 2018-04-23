package com.qiumeng.util.TreeUtill;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

/**树形结构服务类
 * @author qiumeng
 * @Package TreeUtill
 * @Description:
 * @date 2018 2018/4/19 18:20
 */
public interface TreeInterface<T extends  BaseTreeObj<T>> {
    /**
     * 获取指点节点下所有的归档
     * @param list
     * @param parentId
     * @return
     */
     List<T> getChildTreeObjects(List<T> list, ID parentId);
    /**
     * 递归列表
     * @param list
     * @param t
     */
     void recursionFn(List<T> list,T t);
    /**
     * 获得指定节点下的所有子节点
     * @param list
     * @param t
     * @return
     */
     List<T> getChildList(List<T> list,T t);
    /**
     * 判断是否还有下一个子节点
     * @param list
     * @param t
     * @return
     */
     boolean hasChild(List<T> list, T t);
}
