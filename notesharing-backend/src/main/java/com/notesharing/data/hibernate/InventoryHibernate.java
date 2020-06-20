package com.notesharing.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Inventory;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class InventoryHibernate implements InventoryDAO{

private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Integer createInventory(Inventory inventory) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(inventory);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, InventoryHibernate.class);
		} finally {
			s.close();
		}
		return inventory.getId();
		
	}

	@Override
	public Inventory getInventory(Inventory inventory) {
		Session s = hu.getSession();
		inventory = s.get(Inventory.class, inventory.getId());
		s.close();
		return inventory;
	}

	@Override
	public Inventory getInventoryById(Integer id) {
		Session s = hu.getSession();
		Inventory inventory = s.get(Inventory.class, id);
		s.close();
		return inventory;
		
	}

	@Override
	public Set<Inventory> getInventory() {
		Session s = hu.getSession();
		String query = "FROM Inventory";
		Query<Inventory> q = s.createQuery(query, Inventory.class);
		List<Inventory> inventoryList = q.getResultList();
		Set<Inventory> inventorySet = new HashSet<Inventory>();
		inventorySet.addAll(inventoryList);
		s.close();
		return inventorySet;
	}

	@Override
	public void updateInventory(Inventory inventory) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(inventory);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, InventoryHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteInventory(Inventory inventory) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(inventory);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, InventoryHibernate.class);
		} finally {
			s.close();
		}
	}

}
