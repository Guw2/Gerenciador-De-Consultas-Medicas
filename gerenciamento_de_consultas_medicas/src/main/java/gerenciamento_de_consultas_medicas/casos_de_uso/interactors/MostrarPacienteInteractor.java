package gerenciamento_de_consultas_medicas.casos_de_uso.interactors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import gerenciamento_de_consultas_medicas.casos_de_uso.output.MostrarPacienteOutputPort;
import gerenciamento_de_consultas_medicas.dtos.PacienteDTO;

public class MostrarPacienteInteractor implements MostrarPacienteOutputPort {

	@Override
	public void mostrar(PacienteDTO pacienteDto) {
		System.out.printf(
				"""
				-=-=-=-=-=-=-=-=-=-=- Paciente -=-=-=-=-=-=-=-=-=-=-
				 - Id: %d
				 - Nome: %s
				 - Idade: %d
				 - Cpf: %s
				 - Telefone: %s
				-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-
				""",
				pacienteDto.getId(),
				pacienteDto.getNome(),
				calcularIdade(pacienteDto.getData_de_nascimento()),
				formatarCpf(pacienteDto.getCpf()),
				pacienteDto.getTelefone());
	}
	
	private final String formatarCpf(Long cpf) {
		char[] arrCpfFormatado = new char[14];
		char[] arrCpfOriginal = cpf.toString().toCharArray();
		
		int c = 0;
		
		for(int i = 0; i < arrCpfFormatado.length; i++) {
			if(i==3 || i==7) {
				arrCpfFormatado[i] = '.';
			}else if(i==11) {
				arrCpfFormatado[i] = '-';
			}
			else {
				arrCpfFormatado[i] = arrCpfOriginal[c];
				c++;
			}
		}
		
		String cpfFormatado = String.copyValueOf(arrCpfFormatado);
		
		return cpfFormatado;
	}
	
	private final Integer calcularIdade(LocalDate data_de_nascimento) {
		return (int) ChronoUnit.YEARS.between(data_de_nascimento, LocalDate.now());
	}

}
