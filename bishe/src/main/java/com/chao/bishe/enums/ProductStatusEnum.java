package com.chao.bishe.enums;




public enum ProductStatusEnum implements  CodeEnum {
    UP(0, "已上架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
