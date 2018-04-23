//package net.proselyte.bookmanager.dao;
//
//import net.proselyte.bookmanager.model.Book;
//import net.proselyte.bookmanager.model.ViewAllBook;
//import org.hibernate.*;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.mapping.Map;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class ViewAllBooksDaoImpl extends BookDaoImpl {
//
//    private static SessionFactory factory;
//
//    //@Override
//    /*public List<ViewAllBook> listBooks( ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        List<ViewAllBook> resultList = new ArrayList<ViewAllBook>();
//
//        try {
//            tx = session.beginTransaction();
//            String sql = "SELECT * FROM view_allbooks";
//            SQLQuery query = session.createSQLQuery(sql);
//            query.addEntity(ViewAllBook.class);
//            List books = query.list();
//            for(Object book:  books){
//               resultList.add((ViewAllBook) book);
//            }
//
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return resultList;
//    }*/
//}
