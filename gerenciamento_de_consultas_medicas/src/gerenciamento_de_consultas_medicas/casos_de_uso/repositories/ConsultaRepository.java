package gerenciamento_de_consultas_medicas.casos_de_uso.repositories;

import java.util.List;

import gerenciamento_de_consultas_medicas.entities.Consulta;

public interface ConsultaRepository {
	
	void save(Consulta consulta);
	Consulta getById(Long id);
	List<Consulta> getAll();
}
