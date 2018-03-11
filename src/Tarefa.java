import java.util.Date;

public class Tarefa {

    private String nome;

    private String descricao;

    private String local;

    private Date dataInicio;

    private Date dataTermino;

    public Tarefa(String nome, String descricao, String local, Date dataInicio, Date dataTermino) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Tarefa() {
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
