package com.huaxi.lambda;

import lombok.Data;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-17 15:09:32
 */
@Data
public class Room {
    private Integer high;
    private Integer width;
    private Integer length;

    public Room(int high, int width, int length) {
        this.high=high;
        this.width=width;
        this.length=length;
    }
}
