package gerenciamento_de_consultas_medicas.adapters.db;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.PacienteRepository;
import gerenciamento_de_consultas_medicas.entities.Paciente;

public class InMemoryPacienteRepository implements PacienteRepository {

	private static Long ID_NOW = 1L;
	private HashMap<Long, Paciente> pacientes = new HashMap<Long, Paciente>();
	
	@Override
	public void save(Paciente paciente) {
		
		if(
				paciente.getId() == null ||
				paciente.getId() >= ID_NOW ||
				paciente.getId() < 0) {
			
			paciente.setId(ID_NOW);
			pacientes.put(ID_NOW, paciente);
			ID_NOW++;		
		} else {
			pacientes.put(paciente.getId(), paciente);
		}
		
	}

	@Override
	public Optional<Paciente> getById(Long id) {
		return Optional.ofNullable(pacientes.getOrDefault(id, null));
	}

	@Override
	public List<Paciente> findAll() {
		return pacientes.values().stream().toList();
	}

}
