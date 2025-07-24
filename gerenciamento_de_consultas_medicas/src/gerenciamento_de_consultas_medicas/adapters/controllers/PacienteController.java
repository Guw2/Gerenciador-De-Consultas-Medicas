package gerenciamento_de_consultas_medicas.adapters.controllers;

import gerenciamento_de_consultas_medicas.casos_de_uso.input.CadastrarPacienteInputPort;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public class PacienteController {
	
	private final CadastrarPacienteInputPort cadastrarPacienteInputPort;

	public PacienteController(CadastrarPacienteInputPort cadastrarPacienteInputPort) {
		this.cadastrarPacienteInputPort = cadastrarPacienteInputPort;
	}
	
	public void cadastrar(PacienteDTO pacienteDto) {
		cadastrarPacienteInputPort.cadastrar(pacienteDto);
	}
	
}
