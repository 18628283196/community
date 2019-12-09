package life.majiang.community.exception;

public class CustomizeExceprion extends RuntimeException {
    private String message;
    private Integer code;
    public CustomizeExceprion(ICustormizeErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
}
