package gerenciamento_de_consultas_medicas.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Consulta {
	
	private Long id;
	private LocalDate data;
	private Medico medico;
	private Paciente paciente;
	private ConsultaStatus status;
	
	public Consulta() {}

	public Consulta(Long id, LocalDate data, Medico medico, Paciente paciente, ConsultaStatus status) {
		this.id = id;
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		this.status = status;
	}
	
	public void cancelar() {
		setStatus(ConsultaStatus.CANCELADO);
	}
	
	public void confirmar() {
		setStatus(ConsultaStatus.CONFIRMADO);
	}
	
	public Boolean eConsultaFutura() {
		return getStatus() == ConsultaStatus.CONFIRMADO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ConsultaStatus getStatus() {
		return status;
	}

	public void setStatus(ConsultaStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", data=" + data + ", medico=" + medico + ", paciente="
				+ paciente + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, medico, paciente, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id) && Objects.equals(medico, other.medico)
				&& Objects.equals(paciente, other.paciente) && status == other.status;
	}
	
}
