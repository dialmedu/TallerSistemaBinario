package ufps.logicaNegocio;

import java.util.Arrays;

public class Binario {

    private Boolean[] bins;

    public Binario() {
     
    }
    
    public Binario(String binario) {
        this.bins = valueOf(binario).bins;
    }
    
    

    @Override
    public String toString() {
        String result = "";
        if(bins != null && bins.length > 0){
            for (Boolean bin : bins) {
             result += bin ? "1" : "0";
            }
            return result; 
        }
        return result;
    }
    
    private static Binario valueOf(String binario){
        Binario result = new Binario();
        String[] numeros = binario.replaceAll(" ", "").split("");
        Boolean[] auxBins = new Boolean[numeros.length];
        int validos = 0;
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i].equalsIgnoreCase("1") || numeros[i].equalsIgnoreCase("0")){
               Boolean bin = numeros[i].equalsIgnoreCase("1");
               auxBins[i] = bin;
               validos++;
           }
        }
        result.bins = new Boolean[validos];
        int agregar = 0;
        for( int j = 0; j < auxBins.length ; j++){
            if(auxBins[j] != null){
                result.bins[agregar] = auxBins[j];
                agregar++;
            }
        }
        return result;
    }

   
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Binario other = (Binario) obj;
        return Arrays.deepEquals(this.bins, other.bins);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Arrays.deepHashCode(this.bins);
        return hash;
    }

    public Boolean[] getBins() {
        return bins;
    }
    
    public int[] integerValue(){
         int[] ints = new int[0];
        if(this.bins != null && this.bins.length > 0){
            ints = new int[this.bins.length];
            for( int i = 0; i < this.bins.length; i++){
                boolean bin = this.bins[i];
                ints[i] =  bin ? 1 : 0; 
            }
        }
        return ints;
    }

    public void setBins(Boolean[] bins) {
        this.bins = bins;
    }
    
    
    
}
