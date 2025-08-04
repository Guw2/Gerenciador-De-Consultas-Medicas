package gerenciamento_de_consultas_medicas.mappers;

import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;
import gerenciamento_de_consultas_medicas.entities.Paciente;

public class PacienteMapper {
	
	public void map(Paciente paciente, PacienteDTO pacienteDto) {
		paciente.setId(pacienteDto.getId());
		paciente.setNome(pacienteDto.getNome());
		paciente.setCpf(pacienteDto.getCpf());
		paciente.setData_De_nascimento(pacienteDto.getData_de_nascimento());
		paciente.setTelefone(pacienteDto.getTelefone());
	}

}
