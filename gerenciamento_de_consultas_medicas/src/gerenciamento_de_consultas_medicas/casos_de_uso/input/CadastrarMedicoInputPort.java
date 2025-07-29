package gerenciamento_de_consultas_medicas.casos_de_uso.input;

import gerenciamento_de_consultas_medicas.dtos.MedicoDTO;

public interface CadastrarMedicoInputPort {
	
	void cadastrar(MedicoDTO medicoDto);

}
