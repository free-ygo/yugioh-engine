package com.github.freeygo.engine.cardscript;

/**
 * @author 戴志勇
 */
public class EventResponse {

    /**
     * 忽略事件正常执行
     */
    public static final int IGNORE = 1;
    /**
     * 退出执行体
     */
    public static final int EXIT = 2;
    /**
     * 返回响应结果
     */
    public static final int RETURN_RESULT = 3;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
