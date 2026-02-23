/*

__exercicio 4__

 partir da interface abaixo, implemente 
 uma classe “AdminService” que atenda
 todos os requisitos de “GenericUserService”.

public interface GenericUserService {
    void verificarUserStatus(User usuario); 
    void reativarUser(User usuario);
}

 */

public class AdminService implements GenericUserService{
    
    UsStatus stts;
    /*public enum Status{
        ATIVO,
        OFFLINE
    }

    public AdminService(){
        this.Status=ATIVO;
    }
    */    

    public AdminService(){
        this.stts=ATIVO;
    }

    @Override // indica que há reuso de mesma assinatura
    public void verificarUserStatus(User usuario){
        // a implementar
    }

    @Override 
    public void reativarUser(User usuario){
        // idem
    }
}
