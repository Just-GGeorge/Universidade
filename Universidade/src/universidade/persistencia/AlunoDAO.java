package universidade.persistencia;

import java.util.List;

import universidade.entidades.Aluno;

public interface AlunoDAO {

	public void inserir(Aluno aluno);
	
	public void editar (Aluno aluno);
	
	public boolean remover(int rga);
	
	public Aluno getbyId (int rga);
	
	public List<Aluno> listar();
	
}
