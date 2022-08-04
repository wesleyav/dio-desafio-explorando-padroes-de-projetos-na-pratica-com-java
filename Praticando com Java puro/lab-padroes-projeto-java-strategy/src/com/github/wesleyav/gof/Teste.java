package com.github.wesleyav.gof;

public class Teste {

	public static void main(String[] args) {

//		Testes relaciondos ao Design Pattern Singleton

		Comportamento normal = new ComportamentoNormal();
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento agressivo = new ComportamentoAgressivo();

		Robo robo = new Robo();
		robo.setComportamento(normal);
		robo.mover();
		robo.mover();

		robo.setComportamento(defensivo);
		robo.mover();
		robo.mover();

		robo.setComportamento(agressivo);
		robo.mover();
		robo.mover();
		robo.mover();

	}

}
