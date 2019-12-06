package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;//向前按钮
    private Boolean showFirstPage;//第一页按钮
    private Boolean showNext;//向后按钮
    private Boolean showEndPage;//最后一页按钮

    private Integer page;//当前页
    private Integer totalPage;//总页数

    private List<Integer> pages = new ArrayList<>();//分页条显示的页数


    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;

        if (page<1){
            page = 1;
        }
        if (page>totalPage){
            page = totalPage;
        }
        this.page = page;
        pages.add(page);
        for (int i = 1; i<=3;i++){
            if (page - i>0){
                pages.add(0,page - i);
            }

            if (page + i <= totalPage){
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if(page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }

        //是否展示下一页
        if(page == totalPage){
            showNext = false;
        }else {
            showNext = true;
        }

        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if(pages.contains(totalPage)){
           showEndPage = false;
        }else {
            showEndPage = true;
        }
    }
}
