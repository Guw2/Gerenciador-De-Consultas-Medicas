package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import gerenciamento_de_consultas_medicas.casos_de_uso.input.CadastrarPacienteInputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.PacienteRepository;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;
import gerenciamento_de_consultas_medicas.entities.Paciente;

public class CadastrarPacienteInteractor implements CadastrarPacienteInputPort {

	private final PacienteRepository repo;
	
	public CadastrarPacienteInteractor(PacienteRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void cadastrar(PacienteDTO pacienteDto) {
		Paciente paciente = dtoToEntity(pacienteDto);
		repo.save(paciente);
	}
	
	
	private final Paciente dtoToEntity(PacienteDTO pacienteDto) {
		Paciente paciente = new Paciente();
		
		paciente.setId(pacienteDto.getId());
		paciente.setNome(pacienteDto.getNome());
		paciente.setCpf(pacienteDto.getCpf());
		paciente.setData_De_nascimento(pacienteDto.getData_de_nascimento());
		paciente.setTelefone(pacienteDto.getTelefone());
		
		return paciente;
	}
}
