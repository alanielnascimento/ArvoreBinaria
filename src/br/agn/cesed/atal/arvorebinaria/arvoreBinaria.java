package br.agn.cesed.atal.arvorebinaria;

public class arvoreBinaria {
	
	private Node raiz; //ROOT = RAIZ

	public boolean isEmpty() {
		if (raiz == null) {
			return true;
		}
		return false;
	}

	public int getAltura() {
		return getAltura(this.raiz);
	}

	private int getAltura(Node root) {
		if (root == null) {
			return 0;
		}
		int altEsq = getAltura(root.getNoEsquerda());
		int altDir = getAltura(root.getNoDireita());
		if (altEsq > altDir) {
			return altEsq + 1;
		} else {
			return altDir + 1;
		}
	}

	public int getQtdNode() {
		return getQtdNode(raiz);
	}

	private int getQtdNode(Node root) {
		if (root == null) {
			return 0;
		}
		int qtdNodeEsq = getQtdNode(root.getNoEsquerda());
		int qtdNodeDireita = getQtdNode(root.getNoDireita());
		return qtdNodeEsq + qtdNodeDireita + 1;
	}

	public void imprimirArvore() {
		if (this.raiz == null)
			System.out.println("Árvore vazia");
		else
			imprimirArvore(this.raiz);
	}

	private void imprimirArvore(Node nodo) {
		if (nodo.getNoEsquerda() != null) {
			imprimirArvore(nodo.getNoEsquerda());
		}
		if (nodo.getNoDireita() != null) {
			imprimirArvore(nodo.getNoDireita());
		}
		System.out.println("Nó: " + nodo.getValor());
	}

	public void inserir(int valor) {
		inserir(this.raiz, valor);
	}

	public void inserir(Node node, int valor) {
		if (this.raiz == null) {
			this.raiz = new Node(valor);
		} else {
			if (valor <= node.getValor()) {
				if (node.getNoEsquerda() != null) {
					inserir(node.getNoEsquerda(), valor);
				} else {
					// Se nodo esquerdo vazio insere o novo no aqui
					node.setNoEsquerda(new Node(valor));
				}
				// Verifica se o valor a ser inserido é maior que o no corrente
				// da árvore, se sim vai para subarvore direita
			} else if (valor > node.getValor()) {
				// Se tiver elemento no no direito continua a busca
				if (node.getNoDireita() != null) {
					inserir(node.getNoDireita(), valor);
				} else {
					// Se nodo direito vazio insere o novo no aqui
					node.setNoDireita(new Node(valor));
				}
			}
		}
	}

	public Node remover(int valor) throws Exception {
		return remover(this.raiz, valor);
	}

	private Node remover(Node node, int valor) throws Exception {
		if (this.raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			if (valor < node.getValor()) {
				node.setNoEsquerda(remover(node.getNoEsquerda(), valor));
			} else if (valor > node.getValor()) {
				node.setNoDireita(remover(node.getNoDireita(), valor));
			} else if (node.getNoEsquerda() != null && node.getNoDireita() != null) {
				/* 2 filhos */
				System.out.println("  Removeu No " + node.getValor());
				node.setValor(encontraMinimo(node.getNoDireita()).getValor());
				node.setNoDireita(removeMinimo(node.getNoDireita()));
			} else {
				System.out.println("  Removeu No " + node.getValor());
				node = (node.getNoEsquerda() != null) ? node.getNoEsquerda() : node.getNoDireita();
			}
			return node;
		}
	}

	private Node removeMinimo(Node node) {
		if (node == null) {
			System.out.println("  ERRO ");
		} else if (node.getNoEsquerda() != null) {
			node.setNoEsquerda(removeMinimo(node.getNoEsquerda()));
			return node;
		} else {
			return node.getNoDireita();
		}
		return null;
	}

	private Node encontraMinimo(Node node) {
		if (node != null) {
			while (node.getNoEsquerda() != null) {
				node = node.getNoEsquerda();
			}
		}
		return node;
	}

}
