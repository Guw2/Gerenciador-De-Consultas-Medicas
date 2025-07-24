package gerenciamento_de_consultas_medicas.adapters.db;

import java.util.HashMap;
import java.util.List;

import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.PacienteRepository;
import gerenciamento_de_consultas_medicas.entities.Paciente;

public class InMemoryPacienteRepository implements PacienteRepository {

	private HashMap<Long, Paciente> pacientes = new HashMap<Long, Paciente>();
	
	@Override
	public void save(Paciente paciente) {
		Long id = pacientes.keySet().size() + 1L;
		paciente.setId(id);
		pacientes.put(id, paciente);
	}

	@Override
	public Paciente getById(Long id) {
		return pacientes.getOrDefault(id, null);
	}

	@Override
	public List<Paciente> getAll() {
		return pacientes.values().stream().toList();
	}

}
