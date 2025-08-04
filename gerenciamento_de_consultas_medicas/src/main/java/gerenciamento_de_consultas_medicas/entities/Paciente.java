package gerenciamento_de_consultas_medicas.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Paciente {
	
	private Long id;
	private String nome;
	private Long cpf;
	private LocalDate data_de_nascimento;
	private String telefone;
	
	public Paciente() {}
	
	public Paciente(Long id, String nome, Long cpf, LocalDate data_de_nascimento, String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.data_de_nascimento = data_de_nascimento;
		this.telefone = telefone;
	}

	
	public Boolean eMaiorDeIdade() {
		return ChronoUnit.YEARS.between(data_de_nascimento, LocalDate.now()) >= 18;
	}
	
	public Boolean validarCpf() {
		if(cpf < 0) {
			return false;
		}
		
		return getCpf().toString().length() == 11;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData_De_nascimento() {
		return data_de_nascimento;
	}

	public void setData_De_nascimento(LocalDate data_De_nascimento) {
		this.data_de_nascimento = data_De_nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", data_De_nascimento=" + data_de_nascimento
				+ ", telefone=" + telefone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, data_de_nascimento, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(data_de_nascimento, other.data_de_nascimento)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
	
}
