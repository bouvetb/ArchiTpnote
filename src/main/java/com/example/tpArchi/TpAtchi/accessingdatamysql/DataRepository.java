package com.example.tpArchi.TpAtchi.accessingdatamysql;

import com.example.tpArchi.TpAtchi.Model.Garantie;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Garantie,Integer> {
}
