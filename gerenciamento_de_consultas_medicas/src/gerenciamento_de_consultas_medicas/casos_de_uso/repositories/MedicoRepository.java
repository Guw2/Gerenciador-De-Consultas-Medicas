package gerenciamento_de_consultas_medicas.casos_de_uso.repositories;

import java.util.List;
import java.util.Optional;

import gerenciamento_de_consultas_medicas.entities.Medico;

public interface MedicoRepository {
	
	void save(Medico medico);
	Optional<Medico> findById(Long id);
	List<Medico> findAll();
}
