import com.feng.mapper.BlogMapper;
import com.feng.mapper.UserMapper;
import com.feng.pojo.Blog;
import com.feng.pojo.User;
import com.feng.util.IDUtil;
import com.feng.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

public class MyTest {
    @Test
    public  void  testgetUserListByMap()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userListByMap = userMapper.getUserListByMap();
        for (User user : userListByMap) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public  void  testgetUserListByPage()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",3);
        List<User> userList = userMapper.getUserListByPage(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public  void testAnnotation()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user  = userMapper.getUserListByAnnotation(1);

            System.out.println(user);

        sqlSession.close();
    }

    @Test
    public  void testaddblog()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        for (int i=0;i<10; i++)
        {
            Blog blog=new Blog(IDUtil.getId(),"mybatistitle"+i,"author"+i,new Date(),1);
            blogMapper.addBlog(blog);
        }

        sqlSession.close();
    }
    @Test
    public void  testgetBlogIf()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
        blog.setTitle("mybatistitle1");
        blog.setAuthor("author1");
        List<Blog> blogIf = blogMapper.getBlogIf(blog);
        for (Blog blog1 : blogIf) {
            System.out.println(blog1);
        }
        sqlSession.close();
    }
    @Test
    public void  testgetBlogwhere()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
      /*  blog.setTitle("mybatistitle1");*/
        blog.setAuthor("author1");
        List<Blog> blogIf = blogMapper.getBlogwhere(blog);
        for (Blog blog1 : blogIf) {
            System.out.println(blog1);
        }
        sqlSession.close();
    }
    @Test
    public void  testgetBlogchoose()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
       /* blog.setTitle("mybatistitle1");
        blog.setAuthor("author1");*/
        blog.setViews(1);
        List<Blog> blogIf = blogMapper.getBlogchoose(blog);
        for (Blog blog1 : blogIf) {
            System.out.println(blog1);
        }
        sqlSession.close();
    }
    @Test
    public void  testupodateBlogset()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
        blog.setId("ADA88E74EFA342248D89625A1E5B75D9");
      /*   blog.setTitle("mybatistitle11111111");*/
         blog.setAuthor("2222222222");
         int i = blogMapper.upodateBlogset(blog);

        sqlSession.close();
    }

    @Test
    public void  testgetBlogForeach()
    {
        SqlSession sqlSession = new MyBatisUtil().getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<String> ids = new ArrayList<String>();
        ids.add("author1");
        ids.add("author2");
        ids.add("author3");
        map.put("titles",ids);
        List<Blog> blogIf = blogMapper.getBlogForeach(map);
        for (Blog blog1 : blogIf) {
            System.out.println(blog1);
        }
        sqlSession.close();
    }
}
