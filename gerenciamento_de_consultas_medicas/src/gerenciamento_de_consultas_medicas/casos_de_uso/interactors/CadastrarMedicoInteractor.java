package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import gerenciamento_de_consultas_medicas.casos_de_uso.input.CadastrarMedicoInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.MedicoRepository;
import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;
import gerenciamento_de_consultas_medicas.entities.Medico;
import gerenciamento_de_consultas_medicas.mappers.MedicoMapper;

public class CadastrarMedicoInteractor implements CadastrarMedicoInputPort{

	private final MedicoRepository repo;
	private final MedicoMapper mapper = new MedicoMapper();
	
	public CadastrarMedicoInteractor(MedicoRepository repo) {
		this.repo = repo;
	}

	@Override
	public void cadastrar(MedicoDTO medicoDto) {
		Medico medico = new Medico();
		
		mapper.map(medico, medicoDto);
		
		repo.save(medico);
	}

}
