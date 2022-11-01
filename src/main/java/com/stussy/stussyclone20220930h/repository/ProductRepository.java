package com.stussy.stussyclone20220930h.repository;

import com.stussy.stussyclone20220930h.domain.CollectionsProduct;
import com.stussy.stussyclone20220930h.domain.Product;
import com.stussy.stussyclone20220930h.domain.PaymentProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
    public List<CollectionsProduct> getProductList(Map<String, Object> map) throws Exception;

    public Product getProduct(int pdtId) throws Exception;

    public PaymentProduct getPaymentProduct(int pdtDtlId) throws Exception;
}