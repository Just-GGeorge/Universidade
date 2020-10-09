package universidade.persistencia.arquivo;
import universidade.entidades.Professor;
import universidade.persistencia.ProfessorDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProfessorDAOImplArq implements ProfessorDAO {
	private final String filename = "professor.dat";
    private List<Professor> professores = new ArrayList<Professor>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(professores);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProfessorDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfessorDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadArquivo(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            professores = (List<Professor>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //if(str1.equals(str2))
    public void inserir(Professor professor) {
        loadArquivo();
        boolean existe = false;
        String str = professor.getIdentificacaoCPF();
        for (Professor d : professores) {
            String str1 = d.getIdentificacaoCPF();
            if(str1.equals(str)){
                existe = true;
                break;
            }
        }
        if(existe == false){
        	professores.add(professor);
            salvarArquivo();
            System.out.println("Professor cadastrado com Sucesso!");
        }if(existe == true){
            System.out.println("Professor já cadastrado!");
        }
    }
    // if(str1.equals(str2))
    
    public void editar(Professor professor) {
        loadArquivo();
        for (int i = 0; i < professores.size(); i++) {
        	Professor c = professores.get(i);
            String str = professor.getIdentificacaoCPF();

            String str1 = c.getIdentificacaoCPF();
            if(str1.equals(str)){
            	professores.set(i, professor);
                salvarArquivo();
                System.out.println("editador irmao");
                break;
            }
        }
    }

    
    public boolean remover(String identificacao) {
        loadArquivo();

        for (int i = 0; i < professores.size(); i++) {
        	Professor c = professores.get(i);
            if(c.getIdentificacaoCPF().equals(identificacao)){
            	professores.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    
    public Professor getById(String id) {
        loadArquivo();
        for (Professor c : professores) {
        	if(c.getIdentificacaoCPF().equals(id)){
                return c;
            }
        }
        
        return null;
    }

    @Override
    public List<Professor> listar() {
        loadArquivo();
        return professores;
    }

	@Override
	public Professor getbyId(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}


	
    
}



