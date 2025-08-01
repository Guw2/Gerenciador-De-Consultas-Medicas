package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import gerenciamento_de_consultas_medicas.casos_de_uso.output.MostrarMedicoOutputPort;
import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;

public class MostrarMedicoInteractor implements MostrarMedicoOutputPort{

	@Override
	public void mostrar(MedicoDTO medicoDto) {
		
		System.out.printf(
				"""
				-=-=-=-=-=-=-=-=-=-=- Médico -=-=-=-=-=-=-=-=-=-=-
				 - Id: %d
				 - Nome: %s
				 - CRM: %s
				 - Especialidade: %s
				-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-
				""", 
				medicoDto.getId(), 
				medicoDto.getNome(), 
				medicoDto.getCrm(), 
				medicoDto.getEspecialidade().name());
		
	}

}
