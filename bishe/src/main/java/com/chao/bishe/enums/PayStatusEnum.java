package com.chao.bishe.enums;




public enum PayStatusEnum implements  CodeEnum{

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),

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

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
