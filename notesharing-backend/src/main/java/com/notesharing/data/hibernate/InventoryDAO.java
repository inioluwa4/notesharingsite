package com.notesharing.data.hibernate;

import java.util.Set;

import com.notesharing.models.Inventory;

public interface InventoryDAO {

	public Integer createInventory(Inventory inventory);
	public Inventory getInventory(Inventory inventory);
	public Inventory getInventoryById(Integer id);
	public Set<Inventory> getInventory();
	public void updateInventory(Inventory inventory);
	public void deleteInventory(Inventory inventory);
}
