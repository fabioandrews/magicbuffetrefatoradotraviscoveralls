/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;


import InterfaceDAO.InterfacePessoaDAO;
import controler.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel e Andreza
 */
public class PessoaDAO extends ConectionDAO implements InterfacePessoaDAO {

    private Mensagens mensagem = new Mensagens();
    
    @Override
    public boolean criar(Object object) {

        String SQL;
        SQL = "INSERT INTO pessoa (cpf,gerente_Login,pnome,rg,rua,numero,bairro,cep,tipoPessoa,telefone,cidade)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        conectar(SQL);
        try {
            Pessoa pessoa = (Pessoa) object;
            pstm.setString(1, pessoa.getCpf());
            pstm.setString(2, pessoa.getGerenteLogin());
            pstm.setString(3, pessoa.getPnome());
            pstm.setInt(4, pessoa.getRg());
            pstm.setString(5, pessoa.getRua());
            pstm.setInt(6, pessoa.getNumero());
            pstm.setString(7, pessoa.getBairro());
            pstm.setString(8, pessoa.getCep());
            pstm.setString(9, pessoa.getTipoPessoa());
            pstm.setString(10, pessoa.getTelefone());
            pstm.setString(11, pessoa.getCidade());
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Object buscar(String...args) {

        String buscarPessoa = "SELECT * FROM pessoa WHERE cpf = '" + args[0] +
                "' AND TipoPessoa = '" + args[1] + "'"; //busca apenas uma pessoa pelo CPF
        ResultSet result;
        Pessoa pessoaResultadoDaBusca = new Pessoa();
        conectar(buscarPessoa);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                pessoaResultadoDaBusca = criarObjetoPessoaAPartirDeResultadosDeBusca(result);

            }
        } catch (SQLException ex) {
            //System.err.println("CPF De Pessoa nao confere com dados do banco");
        	System.out.println(ex.getMessage());
        }
        fechar();
        return pessoaResultadoDaBusca;
    }

	private Pessoa criarObjetoPessoaAPartirDeResultadosDeBusca(ResultSet result
			) throws SQLException {
		Pessoa pessoaResultadoDaBusca = new Pessoa();
		pessoaResultadoDaBusca.setCpf(result.getString("CPF"));
		pessoaResultadoDaBusca.setRg(result.getInt("RG"));
		pessoaResultadoDaBusca.setGerenteLogin(result.getString("Gerente_login"));
		pessoaResultadoDaBusca.setCep(result.getString("CEP"));
		pessoaResultadoDaBusca.setRua(result.getString("Rua"));
		pessoaResultadoDaBusca.setBairro(result.getString("Bairro"));
		pessoaResultadoDaBusca.setTelefone(result.getString("Telefone"));
		pessoaResultadoDaBusca.setNumero(result.getInt("Numero"));
		pessoaResultadoDaBusca.setPnome(result.getString("PNome"));
		pessoaResultadoDaBusca.setTipoPessoa(result.getString("TipoPessoa"));
		pessoaResultadoDaBusca.setCidade(result.getString("cidade"));
		return pessoaResultadoDaBusca;
	}

    //Atualiza uma determinada pessoa
    @Override
    public boolean atualizar(Object object) {

        String atualizar = "UPDATE pessoa SET "
                + "gerente_Login = ?,"
                + "pnome = ?,"
                + "RG = ?,"
                + "Rua = ?,"
                + "Numero = ?,"
                + "Bairro = ?,"
                + "CEP = ?,"
                + "TipoPessoa = ?,"
                + "Telefone = ?,"
                + "Cidade = ? "
                + "WHERE CPF = ?";

        conectar(atualizar);
        try {
            Pessoa pessoa = (Pessoa) object;
            pstm.setString(1, pessoa.getGerenteLogin());
            pstm.setString(2, pessoa.getPnome());
            pstm.setInt(3, pessoa.getRg());
            pstm.setString(4, pessoa.getRua());
            pstm.setInt(5, pessoa.getNumero());
            pstm.setString(6, pessoa.getBairro());
            pstm.setString(7, pessoa.getCep());
            pstm.setString(8, pessoa.getTipoPessoa());
            pstm.setString(9, pessoa.getTelefone());
            pstm.setString(10, pessoa.getCidade());
            pstm.setString(11, pessoa.getCpf());

            pstm.executeUpdate();

            System.out.println("Pessoa atualizada");
            fechar();
            return true;

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            return false;
        }
    }

    //REMOVE UMA PESSOA DO BANCO DE DADOS
    @Override
    public boolean remover(Object object) {

        String sql = "DELETE FROM pessoa WHERE CPF = ?";
        conectar(sql);

        try {
            Pessoa pessoa = (Pessoa) object;
            pstm.setString(1, pessoa.getCpf());
            pstm.execute();
            pstm.close();
            System.out.println("Pessoa removida com sucesso");
            return true;
        } catch (SQLException ex) {
            mensagem.imprimeErro("Erro ao Remover Pessoas", ex.getMessage());
            return false;
        }
    }

    
    public ArrayList<Pessoa> buscarPessoas(String tipo) {

            String sql = "SELECT * FROM pessoa WHERE TipoPessoa = '"+ tipo + "'";
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet resultSetResultadoBusca;
        conectar(sql);
        
        try {
            resultSetResultadoBusca = pstm.executeQuery();
            while (resultSetResultadoBusca.next()) {
                Pessoa pessoaResultadoDaBusca = this.criarObjetoPessoaAPartirDeResultadosDeBusca(resultSetResultadoBusca);

                pessoas.add(pessoaResultadoDaBusca);
            }
            return pessoas;

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        return null;

    }
    
    
    public ArrayList<Pessoa> buscarPessoaNome(String nome) {

        String sql = "SELECT * FROM pessoa WHERE pnome LIKE '" + nome + "'";
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ResultSet result;

        try {
            conectar(sql);
            result = pstm.executeQuery();
            while (result.next()) {
                Pessoa pessoa = this.criarObjetoPessoaAPartirDeResultadosDeBusca(result);
                pessoas.add(pessoa);
            }
            return pessoas;

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        return null;

    }

   
}