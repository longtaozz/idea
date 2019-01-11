package com.zt.jinanzf.common.conf;


public enum DBTypeEnum {
    zhatu("zhatu"), gateway("gateway");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
