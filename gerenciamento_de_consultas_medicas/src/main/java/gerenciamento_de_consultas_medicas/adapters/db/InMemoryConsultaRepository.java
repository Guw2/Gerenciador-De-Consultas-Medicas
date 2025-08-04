package gerenciamento_de_consultas_medicas.adapters.db;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.ConsultaRepository;
import gerenciamento_de_consultas_medicas.entities.Consulta;

public class InMemoryConsultaRepository implements ConsultaRepository{
	
	private static Long ID_NOW = 1L;
	private HashMap<Long, Consulta> consultas = new HashMap<Long, Consulta>();
	
	@Override
	public void save(Consulta consulta) {
		if(
				consulta.getId() == null ||
				consulta.getId() >= ID_NOW ||
				consulta.getId() < 0) {
			
			consulta.setId(ID_NOW);
			consultas.put(ID_NOW, consulta);
			ID_NOW++;			
		} else {
			consultas.put(consulta.getId(), consulta);
		}
	}

	@Override
	public Optional<Consulta> findById(Long id) {
		return Optional.ofNullable(consultas.getOrDefault(id, null));
	}

	@Override
	public List<Consulta> findAll() {
		return consultas.values().stream().toList();
	}

	@Override
	public void deleteById(Long id) {
		consultas.remove(id);
		
	}

}
