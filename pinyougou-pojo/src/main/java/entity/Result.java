package entity;

import java.io.Serializable;

/**
 * Created by 阿威 on 2018/9/4.
 */
public class Result implements Serializable{


    private boolean success;
    private String message;
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
}
