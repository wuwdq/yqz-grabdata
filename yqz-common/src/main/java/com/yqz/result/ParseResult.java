package com.yqz.result;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.yqz.request.Request;

/**
 * 解析网页之后的数据和链接
 *
 * @author td
 * @version $Id: ParseResult.java, v 0.1 2018年5月7日 下午2:30:38 td Exp $
 */
public class ParseResult<T> {

    private List<T>       dataList       = new ArrayList<T>();        // 存放解析后的数据
    private List<Request> childRequests = new LinkedList<Request>(); // 解析获得的子链接
    
    public List<T> getDataList() {
        return dataList;
    }
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
    public List<Request> getChildRequests() {
        return childRequests;
    }
    public void setChildRequests(List<Request> childRequests) {
        this.childRequests = childRequests;
    }

}
