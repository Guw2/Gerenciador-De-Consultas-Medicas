package gerenciamento_de_consultas_medicas.casos_de_uso.repositories;

import java.util.List;
import java.util.Optional;

import gerenciamento_de_consultas_medicas.entities.Consulta;

public interface ConsultaRepository {
	
	void save(Consulta consulta);
	Optional<Consulta> findById(Long id);
	void deleteById(Long id);
	List<Consulta> findAll();
}
