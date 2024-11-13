package subsistema2.cep;

// Classe Endereco (representa os dados do endereço)
public class Endereco {
    private String cidade;
    private String estado;

    public Endereco(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Cidade: " + cidade + ", Estado: " + estado;
    }
}

// Classe CepApi já segue o padrão Singleton
public class CepApi {

    private static CepApi instancia = new CepApi();

    private CepApi() {}

    public static CepApi getInstancia() {
        return instancia;
    }

    // Método para recuperar um objeto Endereco completo, ao invés de apenas uma String
    public Endereco recuperarEndereco(String cep) {
        // Aqui você pode adicionar uma lógica mais complexa, por exemplo, buscar em uma API externa
        return new Endereco("Tupã", "SP");
    }
}

// Facade que simplifica o uso do sistema
public class CepFacade {

    private CepApi cepApi;

    public CepFacade() {
        this.cepApi = CepApi.getInstancia(); // Usando o Singleton
    }

    // Método para obter cidade
    public String obterCidade(String cep) {
        Endereco endereco = cepApi.recuperarEndereco(cep);
        return endereco.getCidade();
    }

    // Método para obter estado
    public String obterEstado(String cep) {
        Endereco endereco = cepApi.recuperarEndereco(cep);
        return endereco.getEstado();
    }

    // Método para obter o endereço completo
    public Endereco obterEnderecoCompleto(String cep) {
        return cepApi.recuperarEndereco(cep);
    }
}

// Classe de exemplo para testar o sistema
public class Main {
    public static void main(String[] args) {
        // Usando a Facade para interagir com o sistema
        CepFacade cepFacade = new CepFacade();

        String cidade = cepFacade.obterCidade("12345-678");
        String estado = cepFacade.obterEstado("12345-678");

        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);

        // Obtendo o endereço completo
        Endereco endereco = cepFacade.obterEnderecoCompleto("12345-678");
        System.out.println(endereco);
    }
}
