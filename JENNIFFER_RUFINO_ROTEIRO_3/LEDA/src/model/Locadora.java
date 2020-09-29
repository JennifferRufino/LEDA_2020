package model;

import java.util.Arrays;
import java.util.Scanner;

public class Locadora {


    private Cliente[] clientes = new Cliente[10];
    private Fita[] fitas = new Fita[10];
    private int posicaoAtual = 0;
    private int posicaoAtualFita = 0;

    private int posicaoAtual() {
        return this.posicaoAtual;
    }

    //Métodos para cliente

    public Cliente getCliente(int i) {
        if(i >= posicaoAtual || i < 0) {
            throw new IndexOutOfBoundsException("Index:" + i + " de Tamanho:" + i);
        }
        return clientes[i];
    }
    public Aluguel getAluguel(int i, int j) {
        if(i >= posicaoAtual || i < 0) {
            throw new IndexOutOfBoundsException("Index:" + i + " de Tamanho:" + i);
        }
        return clientes[i].getAluguel(j);
    }
    public void adicionaCliente(Cliente cliente) {
        if(posicaoAtual == clientes.length) {
            cresceArray();
        }
        clientes[posicaoAtual++] = cliente;
    }

    private void cresceArray() {
        int newSize = clientes.length * 2;
        clientes = Arrays.copyOf(clientes, newSize);
    }

    public Cliente removeCliente (String nome) {
        Cliente cliente = null;
        for (int i = 0; i < posicaoAtual(); i++) {
            if (clientes[i] == null) {
                break;
            }
            if (clientes[i].getNome().equals(nome)) {
                cliente = clientes[i];
                for (int j = i; j < posicaoAtual(); j++) {
                    clientes[j] = clientes[j+1];
                }
                posicaoAtual--;
                System.out.println(Arrays.toString(ordenarClientesPeloNome()));
                return cliente;
            }
        }
        System.out.println(Arrays.toString(ordenarClientesPeloNome()));
        return cliente;
    }


    public Cliente[] ordenarClientesPeloNome () {
        clientes= Arrays.copyOf(clientes, posicaoAtual);
        int i, j;
        Cliente key, temp;
        for (i = 1; i < clientes.length; i++) {
            if(clientes[i] == null) {
                break;
            }
            key = clientes[i];
            j = i - 1;
            while (j >= 0 && key.compareTo(clientes[j]) < 0) {
                if(clientes[j] == null) {
                    break;
                }
                temp = clientes[j];
                clientes[j] = clientes[j + 1];
                clientes[j + 1] = temp;
                j--;
            }
        }
        return clientes;
    }

    public Cliente[] ordenarClientePeloNome(Cliente[] clientes){
        int i, j;
        Cliente key, temp;
        for (i = 1; i < clientes.length; i++) {
            if(clientes[i] == null) {
                break;
            }
            key = clientes[i];
            j = i - 1;
            while (j >= 0 && key.compareTo(clientes[j]) < 0) {
                if(clientes[j] == null) {
                    break;
                }
                temp = clientes[j];
                clientes[j] = clientes[j + 1];
                clientes[j + 1] = temp;
                j--;
            }
        }
        return clientes;
    }

    public String buscaLinearCliente(String nome) {
        Cliente[] list = this.clientes;

        int i;

        for(i = 0; i < list.length; i++){
            if(list[i] == null) {
                break;
            }
            if(nome.trim().equals(list[i].getNome())){
                return list[i].getNome();
            }
        }
        return null;
    }

    public Cliente buscaBinariaClientes (String nome) {
        Cliente[] clientes = (Cliente[]) ordenarClientesPeloNome();
        Integer comeco = 0;
        Integer end = posicaoAtual() - 1;
        Cliente cliente = null;
        while (comeco <= end) {
            Integer meio = (comeco + end)/2;
            if (clientes[meio].getNome().compareTo(nome) == 0) {
                cliente = clientes[meio];
                return cliente;
            } else if (clientes[meio].getNome().compareTo(nome) < 0) {
                comeco++;
            } else if (clientes[meio].getNome().compareTo(nome) > 0) {
                end--;
            }
        }
        return cliente;
    }


//Método para aluguéis
    public Aluguel[] ordenarAluguelPorValor(int indice){
        return this.clientes[indice].ordenarAluguelPorValor();
    }
    public int tamanhoAluguel(int i ) {
        return clientes[i].posicaoAtual();
    }

    //Métodos para fita


    public Fita getFita(int i) {
        if(i > posicaoAtual || i < 0) {
            throw new IndexOutOfBoundsException("Index:" + i + " de Tamanho:" + i);
        }
        return fitas[i];
    }

    public void adicionaFita(Fita fita) {
        if(posicaoAtualFita == fitas.length) {
            cresceFita();
        }
        fitas[posicaoAtualFita++] = fita;
    }

    private void cresceFita() {
        int newSize = fitas.length * 2;
        fitas = Arrays.copyOf(fitas, newSize);
    }

    public Fita[] ordenarFitasPeloTitulo () {
        int ordena = 1;
        int i;
        fitas = Arrays.copyOf(fitas, posicaoAtualFita);
        while (ordena < this.posicaoAtualFita) {
            Fita fita = fitas[ordena];
            if (fitas[ordena] == null) {
                break;
            }
            for (i = ordena; i > 0; i--) {
                if (fita.compareTo(fitas[i - 1]) < 0) {
                    fitas[i] = fitas[i - 1];
                } else {
                    break;
                }
            }
            fitas[i] = fita;
            ordena++;
        }
        return fitas;
    }

    public Fita[] ordenarFitasPeloTitulo (Fita[] fitas) {
        int i, j;
        Fita key, temp;
        for (i = 1; i < fitas.length; i++) {
            if(fitas[i] == null) {
                break;
            }
            key = fitas[i];
            j = i - 1;
            while (j >= 0 && key.compareTo(fitas[j]) < 0) {
                if(fitas[j] == null) {
                    break;
                }
                temp = fitas[j];
                fitas[j] = fitas[j + 1];
                fitas[j + 1] = temp;
                j--;
            }
        }
        return fitas;
    }

    public Fita[] ordenarFitasMergeSortPorValor(Fita[] fitas) {

        int length = fitas.length;
        if (length < 2) {
            return fitas;
        }
        int mid = length / 2;
        Fita [] esquerda = new Fita[mid];
        Fita [] direita = new Fita[length - mid];
        for (int i = 0; i < mid; i++){
            esquerda[i] = fitas[i];
        }
        for (int i = mid; i < length; i++) {
            direita[i - mid] = fitas[i];
        }
        ordenarFitasMergeSortPorValor(esquerda);
        ordenarFitasMergeSortPorValor(direita);

        mergeSort(fitas, esquerda, direita, mid, length - mid);
        return fitas;
    }

    public Fita[] ordenarFitasPeloValorQuick(Fita[] fitas, int left, int right) {
        Fita pivo = fitas[left];

        int i = left;
        int j = right;
        Fita aux;

        while(i < j){
            while(fitas[i].getValor() <= pivo.getValor() && i < j){
                i++;
            }
            while(fitas[j].getValor() > pivo.getValor()){
                j--;
            }

            if(i < j) {
                aux = fitas[i];
                fitas[i] = fitas[j];
                fitas[j] = aux;
            }
        }

        fitas[left] = fitas[j];
        fitas[j] = pivo;

        if(left < j - 1) {
            ordenarFitasPeloValorQuick(fitas, left, j - 1 );
        }
        if(j + 1 < right){
            ordenarFitasPeloValorQuick(fitas, j + 1, right);
        }
        return fitas;
    }
    private void mergeSort(Fita[] fita, Fita[] esquerda, Fita[] direita, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (esquerda[i].getValor() <= direita[i].getValor()) {
                fita[k++] = esquerda[i++];
            } else {
                fita[k++] = direita[j++];
            }
        }
        while (i < left) {
            fita[k++] = esquerda[i++];
        }
        while (j < right) {
            fita[k++] = direita[j++];
        }
    }

    public Fita buscaLinearFita(String titulo) {
        Fita[] list = this.fitas;

        int i;

        for(i = 0; i < list.length; i++){
            if(list[i] == null) {
                break;
            }
            if(titulo.trim().equals(list[i].getTitulo())){
                return list[i];
            }
        }
        return null;
    }

    public Fita buscaBinariaFita (String titulo) {
        Fita[] fitas = ordenarFitasPeloTitulo();
        System.out.println(Arrays.toString(fitas));
        int comeco = 0;
        int finall = posicaoAtualFita - 1;
        Fita fita = null;
        while (comeco <= finall) {
            int meio = (comeco + finall)/2;
            if (fitas[meio].getTitulo().compareTo(titulo) == 0) {
                fita = fitas[meio];
                return fita;
            } else if (fitas[meio].getTitulo().compareTo(titulo) < 0) {
                comeco++;
            } else if (fitas[meio].getTitulo().compareTo(titulo) > 0) {
                finall--;
            }
        }
        return fita;
    }

    private int posicaoAtualFita() {
        return this.posicaoAtualFita;
    }
    public Fita removeFita (String titulo) {
        Fita fita = null;
        for (int i = 0; i < posicaoAtualFita(); i++) {
            if (fitas[i] == null) {
                break;
            }
            if (fitas[i].getTitulo().equals(titulo)) {
                fita = fitas[i];
                for (int j = i; j < posicaoAtualFita(); j++) {
                    fitas[j] = fitas[j+1];
                }
                posicaoAtualFita--;
                System.out.println(Arrays.toString(ordenarFitasPeloTitulo()));
                return fita;
            }
        }
        System.out.println(Arrays.toString(ordenarFitasPeloTitulo()));
        return fita;
    }
}
