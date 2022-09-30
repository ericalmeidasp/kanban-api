package com.ada.dynamo.repository;

import com.ada.dynamo.model.Tarefa;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBPagingAndSortingRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@EnableScan
public interface TarefaRepository extends DynamoDBPagingAndSortingRepository<Tarefa, UUID> {
    List<Tarefa> findAll();

    @EnableScanCount
    List<Tarefa> findByTituloContains(String titulo, Pageable pageable);
}
