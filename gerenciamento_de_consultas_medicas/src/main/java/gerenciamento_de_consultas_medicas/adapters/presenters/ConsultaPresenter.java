package gerenciamento_de_consultas_medicas.adapters.presenters;

import gerenciamento_de_consultas_medicas.casos_de_uso.output.ListarConsultasDoPacienteOutputPort;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public class ConsultaPresenter {

	private final ListarConsultasDoPacienteOutputPort output;

	public ConsultaPresenter(ListarConsultasDoPacienteOutputPort output) {
		this.output = output;
	}
	
	public void listar(PacienteDTO pacienteDto, Boolean mais_info) {
		output.listar(pacienteDto, mais_info);
	}
	
}
