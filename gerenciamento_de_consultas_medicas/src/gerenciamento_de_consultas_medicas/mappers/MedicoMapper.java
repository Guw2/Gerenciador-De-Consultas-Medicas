package gerenciamento_de_consultas_medicas.mappers;

import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;
import gerenciamento_de_consultas_medicas.entities.Medico;

public class MedicoMapper {
	
	public void map(Medico medico, MedicoDTO medicoDto) {
		medico.setId(medicoDto.getId());
		medico.setNome(medicoDto.getNome());
		medico.setEspecialidade(medicoDto.getEspecialidade());
		medico.setCrm(medicoDto.getCrm());
	}
	
}
