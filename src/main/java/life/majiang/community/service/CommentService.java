package life.majiang.community.service;

import life.majiang.community.exception.CustomizeExceprion;
import life.majiang.community.exception.CustormizeErrorCode;
import life.majiang.community.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0){
            throw  new CustomizeExceprion(CustormizeErrorCode.TAGET_PARAM_NOT_FOUND);
        }
    }
}
