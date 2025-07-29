package gerenciamento_de_consultas_medicas.adapters.db;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.MedicoRepository;
import gerenciamento_de_consultas_medicas.entities.Medico;

public class InMemoryMedicoRepository implements MedicoRepository{

	private static Long ID_NOW = 1L;
	private HashMap<Long, Medico> medicos = new HashMap<Long, Medico>();
	
	@Override
	public void save(Medico medico) {
		
		if(
				medico.getId() == null ||
				medico.getId() >= ID_NOW ||
				medico.getId() < 0) {
			
			medico.setId(ID_NOW);
			medicos.put(ID_NOW, medico);
			ID_NOW++;		
		} else {
			medicos.put(medico.getId(), medico);
		}
		
	}

	@Override
	public Optional<Medico> findById(Long id) {
		return Optional.ofNullable(medicos.get(id));
	}

	@Override
	public List<Medico> findAll() {
		return medicos.values().stream().toList();
	}

}
