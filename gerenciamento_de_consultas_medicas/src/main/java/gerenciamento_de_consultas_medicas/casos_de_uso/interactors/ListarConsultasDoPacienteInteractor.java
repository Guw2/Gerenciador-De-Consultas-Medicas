package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import java.util.List;

import gerenciamento_de_consultas_medicas.casos_de_uso.output.ListarConsultasDoPacienteOutputPort;
import gerenciamento_de_consultas_medicas.casos_de_uso.repositories.ConsultaRepository;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;
import gerenciamento_de_consultas_medicas.entities.Consulta;

public class ListarConsultasDoPacienteInteractor implements ListarConsultasDoPacienteOutputPort {

	private final ConsultaRepository repo;
	
	public ListarConsultasDoPacienteInteractor(ConsultaRepository repo) {
		this.repo = repo;
	}

	@Override
	public void listar(PacienteDTO pacienteDto, Boolean mais_info) {
		List<Consulta> consultas = 
				
				repo.findAll().stream()
				.filter(x -> x.getPaciente().getCpf().equals(pacienteDto.getCpf())).toList();
		
		if(!mais_info) {
			consultas.forEach(x -> System.out.printf("%s | Dr(a). %s\n", x.getData(), x.getMedico().getNome()));			
		}else {
			consultas.forEach(x -> System.out.printf(
					"""
					-=-=-=-=-=-=-=-=-=-=- Consulta -=-=-=-=-=-=-=-=-=-=-
					 - Id: %d
					 - Data da Consulta: %s
					 - Paciente: %s
					 - Médico: Dr(a). %s - %s
					 - Status: %s
					-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-
					""", 
					x.getId(), 
					x.getData(), 
					x.getPaciente().getNome(), 
					x.getMedico().getNome(),
					x.getMedico().getEspecialidade().name(),
					x.getStatus().name()
			));
		}
	}
	
}
