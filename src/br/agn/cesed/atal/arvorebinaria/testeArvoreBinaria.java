package br.agn.cesed.atal.arvorebinaria;

public class testeArvoreBinaria {

	public static void main(String[] args) {

		arvoreBinaria arvoreBinaria = new arvoreBinaria();

		System.out.println(arvoreBinaria.getQtdNode());

		Node root = new Node(1);

		arvoreBinaria.inserir(8);
		arvoreBinaria.inserir(10);
		arvoreBinaria.inserir(3);
		arvoreBinaria.inserir(14);
		arvoreBinaria.inserir(1);
		arvoreBinaria.inserir(6);
		arvoreBinaria.inserir(13);
		arvoreBinaria.inserir(32);

		arvoreBinaria.imprimirArvore();
		
		try {
			arvoreBinaria.remover(32);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		arvoreBinaria.imprimirArvore();
	}

}
