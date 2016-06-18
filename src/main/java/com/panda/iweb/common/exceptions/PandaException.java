package com.panda.iweb.common.exceptions;

import com.panda.iweb.common.enums.ErrorCode;

public class PandaException extends RuntimeException {

    private static final long serialVersionUID = 6621877917813053114L;

    protected ErrorCode       code;

    public PandaException(ErrorCode code){
        this.code = code;
    }

    public PandaException(Throwable cause, ErrorCode code){
        super(cause);
        this.code = code;
    }

    public PandaException(Throwable cause){
        super(cause);
    }

    @Override
    public String getMessage() {
        if (code != null) {
            return code.getMsg();
        } else {
            return null;
        }
    }

    public ErrorCode getErrorCode() {
        return this.code;
    }
}
