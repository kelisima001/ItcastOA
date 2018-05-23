package cn.itcast.oa.service.impl;

import org.springframework.stereotype.Service;

import cn.itcast.oa.base.impl.BaseDaoImpl;
import cn.itcast.oa.domain.Product;
import cn.itcast.oa.service.ProductService;

@Service
public class ProductServiceImpl extends BaseDaoImpl<Product> implements ProductService {

}
