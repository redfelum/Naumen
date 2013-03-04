package model;

import entity.Chapter;
import helpers.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ChapterModel {

    public Chapter getChapter(Integer id) {
        Session session = HibernateUtil.getSession();
        Chapter chapter=(Chapter) session.get(Chapter.class, id);
        if (session != null && session.isOpen()) {
            session.close();
        }
        return chapter;
    }


    public void createChapter(Chapter chapter) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(chapter);
        if (session != null && session.isOpen()) {
            session.close();
        }
        tx.commit();
    }

    public List<Chapter> getChapterList() {
        Session session = HibernateUtil.getSession();
        Query q = session.getNamedQuery("Chapter.findAll");
        List<Chapter> chapter= (List<Chapter>) q.list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return chapter;
    }

    public List<Chapter> getParentChapterList() {
        Session session = HibernateUtil.getSession();
        Query q = session.getNamedQuery("Chapter.findTop");
        List<Chapter> chapter= (List<Chapter>) q.list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return chapter;
    }

    public List<Chapter> getChapterList(int parent_id) {
        Session session = HibernateUtil.getSession();
        Query q = session.getNamedQuery("Chapter.findByParentId").setParameter("parentId", parent_id);
        List<Chapter> aList = (List<Chapter>) q.list();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return aList;
    }

    public void deleteChapter(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.get(Chapter.class, id));
        tx.commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
