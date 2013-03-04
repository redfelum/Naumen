package model;

import entity.Article;
import entity.Chapter;
import helpers.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ArticleModel {

    public Article getArticle(int id) {
        Session session = HibernateUtil.getSession();
        Article article = (Article) session.get(Article.class, id);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return article;
    }

    public void createArticle(Article article) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(article);
        tx.commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public List<Article> searchArticle(String text) {
        Session session = HibernateUtil.getSession();
        List<Article> aList = null;

        Query q = session.getNamedQuery("Article.search").setParameter("body", "%" + text + "%");
        aList = (List<Article>) q.list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return aList;
    }

    public List<Article> getArticleListOfChapter(int id){
        Session session = HibernateUtil.getSession();
        List<Article> aList = null;

        Query q = session.getNamedQuery("Article.findByChapterId").setParameter("chapter_id",id);
        aList = (List<Article>) q.list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return aList;
    }

    public void deleteArticle(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.get(Article.class, id));
        tx.commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
