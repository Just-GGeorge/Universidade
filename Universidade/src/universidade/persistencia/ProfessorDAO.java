package universidade.persistencia;
import java.util.List;

import universidade.entidades.Professor;

public interface ProfessorDAO {

	public void inserir(Professor professor);
	
	public void editar (Professor professor);
	
	public boolean remover(String cpf);
	
	public Professor getbyId (String cpf);
	
	public List<Professor> listar();
	
	
}
