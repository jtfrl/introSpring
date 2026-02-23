//package aula1_spring;


/*Objetos instanciados dessa classe devem poder chamar um método 
que desativa um usuário (muda o valor do atributo “Ativo” do usuário alvo para false).
 */

public class Admin extends User {
    static Boolean ativo;

    public Admin(){
        // default
    }

    public Admin(Boolean acesso){
        this.ativo=acesso;
    }
    public static Boolean authUser(Admin user){
        Boolean mudancaStatus=false;
        if(Admin.ativo==true){
            Admin.ativo=false;
            mudancaStatus=true;
        }
        return mudancaStatus;
    }   
}
