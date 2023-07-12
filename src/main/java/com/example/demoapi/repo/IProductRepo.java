package com.example.demoapi.repo;
import com.example.demoapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "select * from product p join cart c on p.product_id = c.product_product_id\n" +
            "join user u on c.user_user_id = u.user_id\n" +
            "where user_id = 1",nativeQuery = true)
    Product findProductByUserId(@Param("id") Long userId);
//    @Query("SELECT Product FROM Product JOIN Cart on Product.productId = Cart.product.productId JOIN User on User.userId = Cart.user.userId WHERE User.userId = :id")
//    Product findProductByUserId(@Param("id") Long userId);
}
