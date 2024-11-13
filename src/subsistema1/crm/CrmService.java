package subsistema1.crm;

// Classe Cliente (model)
public class Cliente {
    private String nome;
    private String cep;
    private String cidade;
    private String estado;

    // Construtor privado, para que seja criado através do Builder
    private Cliente(Builder builder) {
        this.nome = builder.nome;
        this.cep = builder.cep;
        this.cidade = builder.cidade;
        this.estado = builder.estado;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCep() { return cep; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }

    // Builder para facilitar a criação do Cliente
    public static class Builder {
        private String nome;
        private String cep;
        private String cidade;
        private String estado;

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setCep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder setCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder setEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Cliente build() {
            return new Cliente(this);
        }
    }
}

// CrmService com padrão Singleton e método de gravação de cliente
public class CrmService {

    // Instância única
    private static CrmService instance;

    // Construtor privado para evitar instâncias externas
    private CrmService() {}

    // Método para obter a instância única (Singleton)
    public static CrmService getInstance() {
        if (instance == null) {
            instance = new CrmService();
        }
        return instance;
    }

    // Método para gravar cliente
    public void gravarCliente(Cliente cliente) {
        System.out.println("Cliente salvo no sistema de CRM:");
        System.out.println(cliente.getNome());
        System.out.println(cliente.getCep());
        System.out.println(cliente.getCidade());
        System.out.println(cliente.getEstado());
    }
}

// Classe de exemplo para testar o sistema
public class Main {
    public static void main(String[] args) {
        // Usando o Builder para criar um cliente
        Cliente cliente = new Cliente.Builder()
            .setNome("João Silva")
            .setCep("12345-678")
            .setCidade("São Paulo")
            .setEstado("SP")
            .build();

        // Usando o Singleton para gravar o cliente
        CrmService crmService = CrmService.getInstance();
        crmService.gravarCliente(cliente);
    }
}
