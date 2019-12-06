package life.majiang.community.exception;

public class CustomizeExceprion extends RuntimeException {
    private String message;

    public CustomizeExceprion(ICustormizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
