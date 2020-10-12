package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.Addevent;
import com.pojo.Booking;
import com.pojo.Colntactus;
import com.pojo.Feedback;
import com.pojo.Registration;
import com.pojo.Role;

public class BLManager 
{
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public Role serachbyrole(String role) 
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Role.class);
		cr.add(Restrictions.eq("rolename", role));
		Role r = (Role) cr.uniqueResult();
		return r;
	}

	public void saveregister(Registration r) 
	{
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(r);
		t.commit();
		s.close();
	}

	public boolean validep(String email, String pass) 
	{
		Registration reg = searchByEmalpass(email,pass);
		if (reg != null && reg.getEmail().equals(email)&& reg.getPassword().equals(pass)){
			return true;
		} else {
			return false;
		}
	}

	private Registration searchByEmalpass(String email, String pass) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Registration.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", pass));
		Registration r = (Registration) cr.uniqueResult();
		return r;
	}

	public Registration searchByEmailId(String email) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Registration.class);
		cr.add(Restrictions.eq("email", email));
		Registration r = (Registration) cr.uniqueResult();
		s.close();
		return r;
	}

	public void saveevent(Addevent a) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();
	}
	
	public List<Addevent> seracheventlist()
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Addevent.class);
		List<Addevent> e=cr.list();
		return e;
	}

	public Addevent serachbyeventid(int id) 
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Addevent.class);
		cr.add(Restrictions.eq("eid", id));
		Addevent r = (Addevent) cr.uniqueResult();
		s.close();
		return r;
	}

	public void deleteevent(Addevent ad) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.delete(ad);
		t.commit();
		s.close();
	}

	public void updateevent(Addevent ad) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(ad);
		t.commit();
		s.close();
	}

	public boolean ValidPassword(String oldPass, String email) 
	{
		Registration reg = searchByEmalpass(email,oldPass);
		if (reg != null && reg.getEmail().equals(email)&& reg.getPassword().equals(oldPass)){
			return true;
		} else {
			return false;
		}
	}

	public void updateRegistration(Registration reg) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(reg);
		t.commit();
		s.close();
	}
	
	public List<Booking> serachbookinglist()
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Booking.class);
		List<Booking> e=cr.list();
		return e;
	}
	
	public List<Booking> serachbookinglistuser(String email)
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Booking.class,"book");
		cr.createAlias("book.registration","reg");
		cr.add(Restrictions.eq("reg.email", email));
		List<Booking> e=cr.list();
		return e;
	}
	
	public List<Feedback> serachfeedbacklist()
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Feedback.class);
		List<Feedback> e=cr.list();
		return e;
	}

	public List<Addevent> serachbyeventname(String etype)
	{
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Addevent.class);
		cr.add(Restrictions.eq("eventtype", etype));
		List<Addevent> e=cr.list();
		return e;
	}

	public Addevent serachbyeventid1(Integer eid) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Addevent.class);
		cr.add(Restrictions.eq("eid",eid));
		Addevent e=(Addevent)cr.uniqueResult();
		return e;
	}

	public void bookingconfirm(Booking book) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(book);
		t.commit();
		s.close();
	}

	public Booking serchbookid(int id) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Booking.class);
		cr.add(Restrictions.eq("bid",id));
		Booking e=(Booking)cr.uniqueResult();
		return e;
	}

	public void savecontact(Colntactus c) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
	}

}
