package com.huangkelly.springbootmall.rowmapper;

import com.huangkelly.springbootmall.constant.ProductCategory;
import com.huangkelly.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        //Enum與String之間的轉換
        String categoryStr = resultSet.getString("category");
        ProductCategory category =ProductCategory.valueOf(categoryStr);
        product.setCategory(category);
        //一行的寫法
//        product.setCategory(ProductCategory.valueOf(resultSet.getString("category"));

        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLast_modified_date(resultSet.getTimestamp("last_modified_date"));

        return product;
    }
}
