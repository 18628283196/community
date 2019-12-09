package life.majiang.community.exception;

public enum CustormizeErrorCode implements ICustormizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不换个试试"),
    TAGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    ;

    public String message;
    private Integer code;


    CustormizeErrorCode( Integer code,String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public Integer getCode(){
        return code;
    }


}
