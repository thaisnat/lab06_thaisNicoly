package lab06;

import java.util.ArrayList;

/**
 * 
 * @author thaisnat
 *
 */
public abstract class Usuario {
	
	// atributos
	private String nomeUsuario , login;
	private ArrayList<Jogo> listaJogos;
	private double dinheiro;
	private int x2p;
	
	/**
	 * Construtor da classe Usuario
	 * Super Classe 
	 * @param nomeUsuario
	 * @param login
	 * @param dinheiro
	 */
	public Usuario(String nomeUsuario, String login, double dinheiro) throws Exception{
		
		TestesUsuario.testandoNome(nomeUsuario);
		TestesUsuario.testandoLogin(login);
		TestesUsuario.testandoDinheiro(dinheiro);
		
		this.nomeUsuario = nomeUsuario;
		this.login = login;
		this.dinheiro = dinheiro;
		this.listaJogos = new ArrayList<>();	
	}
	
	
	
	/**
	 * Metodo que verifica se o usuario tem o jogo
	 * se nao tiver ele o adiciona
	 * @param nomeJogo
	 * @return
	 */
	public boolean compraJogo(Jogo jogoRecebido){
		if(dinheiro >= calculaDesconto(jogoRecebido.getPreco())){
			if (listaJogos.contains(jogoRecebido)) {
				return false;
			} else {
				this.setDinheiro(this.getDinheiro() - this.calculaDesconto(jogoRecebido.getPreco()));
				return listaJogos.add(jogoRecebido);
			}
		}
		return false;
	}
	
	/**
	 * Metodo abstrato que sera utilizado no metodo compraJogo
	 * o mesmo esta nas classes Noob e Veterano 
	 * de onde sera utilizado
	 * @param preco
	 * @return
	 */
	abstract double calculaDesconto(double preco);
	

	/**
	 * Metodo que adiciona dinheiro para o usuario
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public boolean adicionaDinheiro(double valor) throws Exception {
		if (valor > 0) {
			this.setDinheiro(this.getDinheiro() + valor);
			return true;
		} else {
			throw new Exception("Valor nao pode ser menor ou igual a zero");
		}
	}
	
	/**
	 * Metodo que calcula o valor atual do x2p
	 * @param valor
	 * @return
	 */
	public int calculaX2p(Jogo jogoRecebido){
		int somaX2p;
		somaX2p = getX2p() + (int)jogoRecebido.getPreco() * bonificacaoJogo();
		this.setX2p(somaX2p);
		return getX2p();
	}
	
	abstract int bonificacaoJogo();
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou){
		
	}
	
	
	/**
	 * Metodos Get e Set
	 * HashCode
	 * Equals
	 * toString 
	 */
	
	/**
	 * Getters
	 * @return
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public String getLogin() {
		return login;
	}
	public double getDinheiro() {
		return dinheiro;
	}
	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}
	public int getX2p() {
		return x2p;
	}
	
	/**
	 * Setters
	 * @param nomeUsuario
	 * @param login
	 * @param dinheiro
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	public void setListaJogos(ArrayList<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	
}
