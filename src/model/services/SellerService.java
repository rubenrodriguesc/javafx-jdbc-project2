package model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public class SellerService {

	public List<Seller> findAll() {
		List<Seller> list = new ArrayList<>();

		Department dp1 = new Department(1, "Books");
		Department dp2 = new Department(2, "Musics");

		list.add(new Seller(1, "Bob Brown", "bob@gmail.com", new Date(), 2000.0, dp1));
		list.add(new Seller(2, "Alex Grey", "alex@gmail.com", new Date(), 3500.0, dp2));
		list.add(new Seller(3, "Maria Green", "maria@gmail.com", new Date(), 2000.0, dp1));
		list.add(new Seller(4, "Donal Bluew", "donald@gmail.com", new Date(), 3580.0, dp2));

		return list;
	}

}
