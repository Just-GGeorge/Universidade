package universidade.persistencia;
import java.util.List;

import universidade.entidades.Disciplina;


public interface DisciplinaDAO {
	
	public void inserir (Disciplina disciplina);
	
	public void editar (Disciplina disciplina);
	
	public boolean remover (int identificacao);
	
	public Disciplina getbyId (int identificacao);
	
	public List<Disciplina> listar();

}
