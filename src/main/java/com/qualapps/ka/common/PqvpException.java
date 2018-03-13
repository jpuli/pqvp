package com.qualapps.ka.common;

public class PqvpException extends Exception {

    private String propKey;
    private String type;
    private String[] params;

    public PqvpException(String type, String[] params) {
        super();
        this.type = type;
        this.params = params;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }


}
