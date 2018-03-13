package com.qualapps.ka.common;

/**
 * The Common response object
 */
public class PqvpResponse {
    public PqvpResponse() {
    }
    private Object result;
    private PqvpError error;

    /**
     * REsult getter
     * @return result object
     */
    public Object getResult() {
        return result;
    }

    /**
     * Result setter
     * @param result
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * Error getter
     * @return PqvpError
     */
    public PqvpError getError() {
        return error;
    }

    /**
     * Return setter
     * @param error
     */
    public void setError(PqvpError error) {
        this.error = error;
    }


}
