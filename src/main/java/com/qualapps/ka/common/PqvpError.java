package com.qualapps.ka.common;

public class PqvpError {
    public PqvpError() {
    }

    private String message;
    private String code;
    private String type;

    /**
     * Code getter
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Code setter
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Type setter
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Type getter
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * message setter
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * message getter
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


}
