package br.com.estudos.rodrigo.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.rodrigo.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
