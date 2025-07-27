package gerenciamento_de_consultas_medicas.adapters.db;

import java.util.HashMap;
import java.util.List;

import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.ConsultaRepository;
import gerenciamento_de_consultas_medicas.entities.Consulta;

public class InMemoryConsultaRepository implements ConsultaRepository{
	
	private static Long ID_NOW = 1L;
	private HashMap<Long, Consulta> consultas = new HashMap<Long, Consulta>();
	
	@Override
	public void save(Consulta consulta) {
		consulta.setId(ID_NOW);
		consultas.put(ID_NOW, consulta);
		ID_NOW++;
	}

	@Override
	public Consulta getById(Long id) {
		return consultas.get(id);
	}

	@Override
	public List<Consulta> getAll() {
		return consultas.values().stream().toList();
	}

}
