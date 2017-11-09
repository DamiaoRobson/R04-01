package sorting.test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.variationsOfBubblesort.CombSort;
import sorting.variationsOfBubblesort.GnomeSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	// meus testes
	private Integer[] vetorNegativo;
	private Integer[] vetorInvertido;
	private Integer[] vetorInvertidoElemRepetido;
	private Integer[] vetorUmElemento;
	private Integer[] vetorDoisElmentos;
	private Integer[] vetorTresElementos;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		popularVetorNegativo(new Integer[] { 1, -10, 0, -1 });
		popularVetorInvertido(new Integer[] { 5, 4, 3, 2, 1, 0 });
		popularVetorInvertidoElemRepetido(new Integer[] { 5, 4, 4, 4, 4, 3, 3, 3, 2, 2, 1, 0, 0, 0, 0 });
		popularVetorUmElemento(new Integer[] { 5 });
		popularVetorDoisElmentos(new Integer[] { 5, 4 });
		popularVetorTresElemento(new Integer[] { 5, 4, 4 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a
	 * implementação do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		// this.implementation = new CombSort<>();
		this.implementation = new GnomeSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void popularVetorNegativo(Integer[] arrayPadrao) {
		this.vetorNegativo = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void popularVetorInvertido(Integer[] arrayPadrao) {
		this.vetorInvertido = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void popularVetorInvertidoElemRepetido(Integer[] arrayPadrao) {
		this.vetorInvertidoElemRepetido = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void popularVetorUmElemento(Integer[] arrayPadrao) {
		this.vetorUmElemento = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void popularVetorDoisElmentos(Integer[] arrayPadrao) {
		this.vetorDoisElmentos = arrayPadrao;
	}

	private void popularVetorTresElemento(Integer[] arrayPadrao) {
		this.vetorTresElementos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO
	 * APENAS UMA PARTE DO ARRAY.
	 */

	@Test
	public void testSort06() {
		genericTest(vetorNegativo);
	}

	@Test
	public void testSort07() {
		genericTest(vetorInvertido);
	}

	@Test
	public void testSort08() {
		genericTest(vetorInvertidoElemRepetido);
	}

	@Test
	public void testSort09() {
		Integer[] a = new Integer[10000];
		popularArray(a);
		genericTest(a);
	}

	@Test
	public void testSort10() {
		genericTest(vetorUmElemento);
	}

	@Test
	public void testSort11() {
		genericTest(vetorDoisElmentos);
	}

	@Test
	public void testSort12() {
		genericTest(vetorTresElementos);
	}

	private void popularArray(Integer[] array) {
		Random ran = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = ran.nextInt(array.length);
		}
	}
}