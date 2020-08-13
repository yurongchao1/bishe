package com.chao.bishe.enums;




public enum OrderStatusEnum  implements  CodeEnum{
    NEW(0, "新订单"),//相当于买家端的待上餐
    FINISHED(1, "完结"),//相当于买家端的待评价
    CANCEL(2, "已取消"),//同买家端的已取消
    COMMENT(3,"已评价"),//相当于买家端的已评价
    ;

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

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
