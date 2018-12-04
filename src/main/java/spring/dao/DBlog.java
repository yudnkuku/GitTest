package spring.dao;

import org.apache.ibatis.session.SqlSession;
import spring.entity.Blog;

import java.util.ArrayList;
import java.util.List;

public class DBlog extends DBase {

    public Blog selectBlog(int id) {
        Blog blog = null;
        SqlSession sqlSession = openSession();
        try {
            IBlogDao dao = sqlSession.getMapper(IBlogDao.class);
            blog = dao.selectBlogById(id);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return blog;
    }

    public Blog selectBlogByAll(int id, String name, int author_id) {
        Blog blog = null;
        SqlSession sqlSession = openSession();
        try {
            IBlogDao dao = sqlSession.getMapper(IBlogDao.class);
            blog = dao.selectBlogByAll(id, name, author_id);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return blog;
    }

    public List<Blog> selectBlogsByIds(List<Integer> idList) {
        List<Blog> blogs = new ArrayList<Blog>();
        SqlSession session = openSession();
        try {
            IBlogDao dao = session.getMapper(IBlogDao.class);
            blogs = dao.selectBlogsByIds(idList);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return blogs;
    }
}
