package com.example.dbshixun.service;

import com.example.dbshixun.mapper.SupplierMapper;
import com.example.dbshixun.pojo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    public List<Supplier> suppliers(){
        return supplierMapper.suppliers();
    }
    public Supplier getSupplier(int id){
        return supplierMapper.getSupplier(id);
    }
    public void addSupplier(Supplier supplier){
        supplierMapper.addSupplier(supplier);
    }
    public void deleteSupplier(int id){
        supplierMapper.deleteSupplier(id);
    }
}
