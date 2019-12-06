package life.majiang.community.exception;

public enum CustormizeErrorCode implements ICustormizeErrorCode {

    QUESTION_NOT_FOUND("你找的问题不在了，要不换个试试");

    public String message;

    CustormizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
