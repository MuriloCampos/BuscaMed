package mysticlabs.projects.com.buscamed.Model;

import java.util.ArrayList;

/**
 * Created by Murilo on 15/01/2017.
 */

public class medico {
    private String nome;
    private String crm;
    private String endereco;
    private String email;
    private String telefone;
    private String especialidade;
    private String skype_username;
    private String horario_funcionamento;
    private ArrayList<String> convenios;

    /*public medico(String nome, String crm, String endereco, String email, String telefone, String skype_username, String horario_funcionamento, ArrayList<String> convenios, String especialidade){
        this.nome = nome;
        this.crm = crm;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.skype_username = skype_username;
        this.horario_funcionamento = horario_funcionamento;
        this.convenios = convenios;
        this.especialidade = especialidade;
    }*/

    public medico(){}

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSkype_username() {
        return skype_username;
    }

    public void setSkype_username(String skype_username) {
        this.skype_username = skype_username;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public ArrayList<String> getConvenios() {
        return convenios;
    }

    public void setConvenios(ArrayList<String> convenios) {
        this.convenios = convenios;
    }
}
