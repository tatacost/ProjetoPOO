package org.serratec.trabalho.poo.modelos;

public class Planos /**implements GerarRelatorio**/{
	private  String nomePlano;
	private  TipoPlano tipoPlano;
	private  double valorPlano;
	
	


	public Planos(String nomePlano, TipoPlano tipoPlano, double valorPlano) {
		super();
		this.nomePlano = nomePlano;
		this.tipoPlano = tipoPlano;
		this.valorPlano = valorPlano;
	}



	public String getNomePlano() {
		return nomePlano;
	}



	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}



	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}



	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}



	public double getValorPlano() {
		return valorPlano;
	}



	public void setValorPlano(double valorPlano) {
		this.valorPlano = valorPlano;
	}



	@Override
	public String toString() {
		return "Nome: " + nomePlano + " | Tipo de Plano: " + tipoPlano + " | Valor:" + valorPlano;
	}


	
	
	
//
//	@Override
//	public String gerarAluno() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public String gerarFuncionario() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
