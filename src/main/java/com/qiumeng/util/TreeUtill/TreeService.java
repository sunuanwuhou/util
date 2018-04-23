package com.qiumeng.util.TreeUtill;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**树形结构服务类实现类
 * @author qiumeng
 * @Package TreeUtill
 * @Description:
 * @date 2018 2018/4/19 18:24
 */
public abstract class TreeService<T extends BaseTreeObj<T>> implements TreeInterface{

    @Override
    public List getChildTreeObjects(List list, ID parentId) {
        List<T> returnList = new ArrayList<T>();
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
            T res= (T) iterator.next();
            //判断第一个对象是否为第一个节点
            if(res.getParentId().equals(parentId)){
                //相等--说明第一个节点为父节点--递归下面的子节点
                recursionFn(list, res);
                returnList.add(res);
            }
        }
        return returnList;
    }

    @Override
    public void recursionFn(List list, BaseTreeObj o) {
        List<T> childsList=getChildList(list, o);
        //设置他的子集对象集
        o.setChildsList(childsList);
        // 迭代--这些子集的对象--时候还有下一级的子级对象
        for (T nextChild : childsList) {
            //下一个对象，与所有的资源集进行判断
            if(hasChild(list, nextChild)){
                //有下一个子节点,递归
                Iterator<T> it = childsList.iterator();
                while (it.hasNext()) {
                    T node = it.next();
                    //所有的对象--跟当前这个childsList 的对象子节点
                    recursionFn(list, node);
                }
            }
        }
    }

    @Override
    public List getChildList(List list, BaseTreeObj o) {
        List<T> childsList=new ArrayList<T>();
        Iterator<T> it=list.iterator();
        while(it.hasNext()){
            T child=it.next();
            //判断集合父ID是否等于上一级ID
            if(((BaseTreeObj<T>) child).getParentId().equals(((BaseTreeObj<T>) o).getId())){
                childsList.add(child);
            }
        }
        return childsList;
    }

    @Override
    public boolean hasChild(List list, BaseTreeObj o) {
        return getChildList(list,o).size() > 0 ? true : false;
    }

}
