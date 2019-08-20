package ui;

import java.util.List;

import dao.ProductDao;
import model.Product;

public class SelectProductUi extends AbstractUi {
	private ProductDao productDao;
		
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	protected void showProductList(List<Product> productList) {
		System.out.println("-----------------------");
		System.out.println("Code    이름");
		for(Product product: productList) {
			System.out.printf("%d %s\n",
					product.getCode(),product.getName());
		}
	}


	@Override
	public void show() {
		showProductList(productDao.getProductList());
		System.out.println("Enter를 누르세요.");
		this.getInputedString();

	}

}
