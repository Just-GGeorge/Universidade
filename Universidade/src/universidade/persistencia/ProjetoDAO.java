package universidade.persistencia;
import java.util.List;

import universidade.entidades.Projeto;

public interface ProjetoDAO {
	
	public void inserir(Projeto projeto);
	
	public void editar (Projeto projeto);
	
	public boolean remover(int id);
	
	public Projeto getbyId (int id);
	
	public List<Projeto> listar();

}
