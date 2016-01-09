package com.iweb.panda.common.resp;

public class JsonpResult extends Result {

    private static final long serialVersionUID = -2942825547099827134L;
    private Result            result;
    private String            method;

    public JsonpResult(Result result, String method){
        this.result = result;
        this.method = method;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
