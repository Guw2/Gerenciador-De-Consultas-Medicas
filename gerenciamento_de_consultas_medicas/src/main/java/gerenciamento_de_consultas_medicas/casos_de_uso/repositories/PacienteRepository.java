package gerenciamento_de_consultas_medicas.casos_de_uso.repositories;

import java.util.List;
import java.util.Optional;

import gerenciamento_de_consultas_medicas.entities.Paciente;

public interface PacienteRepository {
	
	void save(Paciente paciente);
	Optional<Paciente> getById(Long id);
	List<Paciente> findAll();
}
