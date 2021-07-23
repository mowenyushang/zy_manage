package com.example.zy_manage.Entity;

import java.util.ArrayList;

public class JsonEntity {
    private String success;
    private String name;
    private String message;
    private ArrayList<ShopEntity> result;

    @Override
    public String toString() {
        return "JsonEntity{" +
                "success='" + success + '\'' +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public ArrayList<ShopEntity> getResult() {
        return result;
    }

    public void setResult(ArrayList<ShopEntity> result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
