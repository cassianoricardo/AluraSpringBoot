package br.com.alura.listaVip.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.listaVip.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{
	
	
	List<Convidado> findByNome(String nome);


}
