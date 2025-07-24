package gerenciamento_de_consultas_medicas.casos_de_uso.repositories;

import java.util.List;

import gerenciamento_de_consultas_medicas.entities.Paciente;

public interface PacienteRepository {
	
	void save(Paciente paciente);
	Paciente getById(Long id);
	List<Paciente> getAll();
}
