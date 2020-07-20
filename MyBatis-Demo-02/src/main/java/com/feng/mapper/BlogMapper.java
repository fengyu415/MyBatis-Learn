package com.feng.mapper;

import com.feng.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

/*    @Insert(" insert into blog(id,title,author,create_time,views) values(#{id},#{title},#{author},#{createtime},#{views})")*/
    int addBlog(Blog blog);


    List<Blog> getBlogIf(Blog blog);
    List<Blog> getBlogwhere(Blog blog);
    List<Blog> getBlogchoose(Blog blog);

    List<Blog> getBlogForeach(Map map);

    int upodateBlogset(Blog blog);
}
