package com.example.demo.model.constant;

public enum ResponseCode {
    // 状态码
    FAIL(-1, "处理未完成，或者操作失败"),
    SUCCESS(200, "操作成功"),
    FORBIDDEN(403, "权限不足"),
    BAD_REQUEST(400, "请求无效，客户端错误"),
    SERVER_ERROR(500, "服务器错误");

    private int status;

    private String msg;

    ResponseCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
