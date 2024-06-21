package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO {

	public static void insere(Usuario user) throws SQLException{ 

        String sql="INSERT INTO usuarios(nome,email,senha) VALUES (?,?,?) "; 
        Connection conn= null; 
        PreparedStatement pstm=null; 

        try{ 
            //criar uma conexão com o BD 
            conn= ConnectionFactory.createConnection(); 

            //Preparando a query 
            pstm= (PreparedStatement) conn.prepareStatement(sql); 

           // indicar as substitui��es na query- noem, email e senha do usu�rio 
            pstm.setString(1,user.getNome()); 
            pstm.setString(2, user.getEmail()); 
            pstm.setString(3,user.getSenha()); 

            //Executando a query 
             pstm.execute(); 

	        } catch(Exception e) {
	            e.printStackTrace(); 
	        } finally { 
	            if(pstm!=null)pstm.close(); 
	            if(conn!=null)conn.close(); 
	        }     

    }//fim insere 
	
	public static boolean existeEmail(String email) throws SQLException, ClassNotFoundException{
		String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement pstm = conn.prepareCall(sql)){
			pstm.setString(1, email);
			try(ResultSet rs = pstm.executeQuery()){
				if(rs.next()) {
					return rs.getInt(1)>0;
				}
			}
		}
		return false;
				
	}
	
	public static Usuario autenticar(String email, String senha) throws SQLException, ClassNotFoundException {
	    String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
	    try (Connection conn = ConnectionFactory.createConnection();
	         PreparedStatement pstm = conn.prepareStatement(sql)) {
	        pstm.setString(1, email);
	        pstm.setString(2, senha);
	        try (ResultSet rs = pstm.executeQuery()) {
	            if (rs.next()) {
	                return new Usuario(rs.getInt("id_usuario"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
	            }
	        }
	    }
	    return null;
	}

    public static void removeById(int id){ 
    	String sql = "DELETE FROM usuarios WHERE id = ?"; 
    	Connection conn = null; 
    	PreparedStatement pstm = null; 

    	try { 
	    	conn = ConnectionFactory.createConnection(); 
	    	pstm = conn.prepareStatement(sql);
	    	pstm.setInt(1, id); 
	    	pstm.execute(); 

    	} catch (Exception e) { 
    	// TODO Auto-generated catch block 
    		e.printStackTrace(); 
    	}
    	
    	finally{ 
    		
	    	try{ 
		    	if(pstm != null){ 
		    		pstm.close(); 
		    	} 
	 
		    	if(conn != null){ 
		    		conn.close(); 
		    	} 
	
	    	}catch(Exception e){ 
	    		e.printStackTrace(); 
	    	} 
    	} 
}//fimremove 

     
    public static ArrayList<Usuario> listarBD(){ 
    	  
    	 String sql = "SELECT * FROM usuarios";     	  
    	 ArrayList<Usuario> lista = new ArrayList<Usuario>();     	  
    	 Connection conn = null; 
    	 PreparedStatement pstm = null; 

    	 //Classe que vai recuperar os dados do banco de dados 
    	 ResultSet rset = null;     	  

    	 try { 
	    	 conn = ConnectionFactory.createConnection();    	  
	    	 pstm = conn.prepareStatement(sql); 
	    	 rset = pstm.executeQuery(); 

    	 //Enquanto existir dados no banco de dados, fa�a 
    	 while(rset.next()){ 
	    	 Usuario user = new Usuario();    	  
	
	    	 //Recupera o id do banco e atribui ele ao objeto 
	    	 user.setId(rset.getInt("id")); 
	
	    	 //Recupera o nome do banco e atribui ele ao objeto 
	    	 user.setNome(rset.getString("nome")); 
	
	    	 //Recupera a email do banco e atribui ele ao objeto 
	    	 user.setEmail(rset.getNString("email")); 
	    	  
	    	 //Recupera a senha do banco e atribui ela ao objeto 
	    	 user.setSenha(rset.getNString("senha")); 
	   	  
	    	 //Adiciono o contato recuperado, a lista de contatos 
	    	 lista.add(user); 
    	 } 
    	 
    	 } catch (Exception e) { 
    		 e.printStackTrace(); 
    	 }
    	 
    	finally{ 

    	try{  
		    if(rset != null){ 		    	  		
		    	rset.close(); 		
		    } 

	    	if(pstm != null){ 
	    		 pstm.close(); 
	    	}     	  
	
	    	if(conn != null){ 
	    		 conn.close(); 
	    	} 
	    	  
	    	}catch(Exception e){ 
	    		 e.printStackTrace(); 
	    	} 

    	 } 
    	 return lista; 

  } 

    public static void update(Usuario user){ 

		 String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ?" + 
		 " WHERE id = ?"; 	
		 Connection conn = null; 	
		 PreparedStatement pstm = null; 

		 try { 
		
		 //Cria uma conexão com o banco 
		 conn = ConnectionFactory.createConnection(); 
		
		 //Cria um PreparedStatment, classe usada para executar a query 
		 pstm = conn.prepareStatement(sql); 
		
		 //Adiciona o valor do primeiro par�metro da sql 
		 pstm.setString(1, user.getNome()); 
		
		 //Adicionar o valor do segundo par�metro da sql 
		 pstm.setString(2, user.getEmail()); 
		
		 //Adiciona o valor do terceiro par�metro da sql 
		 pstm.setString(3, user.getSenha()); 
		 pstm.setLong(4, user.getId()); 
		
		 //Executa a sql para inser��o dos dados 
		 pstm.execute(); 
		
		 } catch (Exception e) { 
			 e.printStackTrace(); 
		 }
		 
		 finally{ 
	
		 //Fecha as conex�es 
		 try{ 		
			 if(pstm != null){ 		
				 pstm.close(); 		
			 } 
		
			 if(conn != null){ 			
				 conn.close(); 			
			 } 
		
		 }catch(Exception e){ 		
			 e.printStackTrace(); 		
		 } 
		
		} 

    } 
}
