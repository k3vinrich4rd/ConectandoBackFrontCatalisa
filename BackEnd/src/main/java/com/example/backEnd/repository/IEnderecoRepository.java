package com.example.backEnd.repository;

import com.example.backEnd.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoModel, Long> {

}
