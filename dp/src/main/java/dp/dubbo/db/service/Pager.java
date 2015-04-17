package dp.dubbo.db.service;

import java.io.Serializable;
import java.util.List;

/**
 * 专门分页
 * Created by evan on 2014/10/22.
 */
public class Pager<T> implements Serializable {

	/**
     * 记录数totalSize
     */
    private Long totalSize;
    /**
     * 查询结果
     */
    private List<T> resultList;

    /**
     * 获取totalSize
     *
     * @return the totalSize
     */
    public Long getTotalSize() {
        return totalSize;
    }

    /**
     * 给 totalSize 赋值
     *
     * @param totalSize totalSize
     */
    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    /**
     * 获取resultList
     *
     * @return the resultList
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * 给 resultList 赋值
     *
     * @param resultList resultList
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
