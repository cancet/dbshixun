package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierMapper {
    List<Supplier> suppliers();
    Supplier getSupplier(int id);
    void addSupplier(Supplier supplier);
    void deleteSupplier(int id);
}
