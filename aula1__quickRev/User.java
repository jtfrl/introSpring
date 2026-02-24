public class User{
    private String nome;
    private String senha; //útil utilizar protected
    private String email;
    private Integer idade;

    public User(){
        
    }

    public User(String n, String s, String e, Integer id){
        this.nome=n;
        this.email=e;
        this.senha=s;
        this.idade=id;   
    }


    public static void main(String... args){
        User usuario=new User("Alberto", "sajnvsavj55??", "alberto@gmail.com", 25);

        System.out.println("Bem vindo, "+usuario.nome+"! ");
    }

}