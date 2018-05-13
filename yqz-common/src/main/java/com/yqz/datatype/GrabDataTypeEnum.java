package com.yqz.datatype;

/**
 * 数据类型枚举
 *
 * @author td
 * @version $Id: GrabDataTypeEnum.java, v 0.1 2018年5月7日 下午10:37:01 td Exp $
 */
public enum GrabDataTypeEnum {
    SUBJECT("subject", "电影"), 
    SUBJECT_DETAIL("subject_detail", "电影详情"), 
    SUBJECT_COMMENT("subject_comment", "电影评价");
    
    GrabDataTypeEnum(String type, String desc){
        this.type = type;
        this.desc = desc;
    }
    
    private String type;
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
