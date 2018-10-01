package ufps.logicaNegocio;

import java.util.*;

public class SistemaBinario implements OperacionBinario {

    private int i;
    private Binario binarios[];

    public SistemaBinario() {
    }

    
    public void set(Binario nuevo, int i) {
    }

    public Binario get(int pos) {
        if(this.binarios != null && this.binarios.length < pos){
            return this.binarios[pos];
        }
        return new Binario("");
    }

    @Override
    public String toString() {
        return "SistemaBinario{" + "binarios=" + Arrays.toString(binarios) + '}';
    }

    public void add(Binario nuevo) {
        if(this.binarios == null){
            this.binarios = new Binario[1];
            this.binarios[0] = nuevo;
        }else{
            int dimension = this.binarios.length;
            Binario[] aux = this.binarios.clone();
            this.binarios = new Binario[dimension + 1];
            System.arraycopy(aux, 0, this.binarios, 0, aux.length);
            this.binarios[dimension] = nuevo;
        }
    }

    @Override
    public Binario[] getMas_SeRepite() {
        Binario[][] maxBinario = new  Binario[this.binarios.length][this.binarios.length];
        int maxRepeticiones = 0;
        int indiceMaxRepeticiones = 0;
        for ( int j = 0; j <  this.binarios.length; j++){
            maxBinario[j][0] = this.binarios[j];
            for(int k = 0; k < this.binarios.length; k++){
                if( maxBinario[j][0].equals(this.binarios[k]) ){
                    Binario[][] auxMaxBinario = maxBinario;
                    maxBinario = new Binario[this.binarios.length][k];
                    System.arraycopy(auxMaxBinario, 0,maxBinario , 0, maxBinario.length);
                    maxBinario[j][k] = this.binarios[k]; 
                }
            }
            int countRepeticiones = 0;
            for(Binario bin : maxBinario[j] ){
                if(bin != null){
                    countRepeticiones++;
                }
            }
            if(countRepeticiones > maxRepeticiones){
                maxRepeticiones = countRepeticiones;
                indiceMaxRepeticiones = j;
            }
        }
        return maxBinario[indiceMaxRepeticiones];
    }
  
    @Override
    public Binario getSumaTotal() {
        Binario resultado = new Binario("0");
        for( Binario sumando : this.getBinarios()){
            resultado = this.getSuma(resultado, sumando);
        }
        return resultado;
    }

    @Override
    public Binario getResta(int indiceBinario1, int indiceBinario2) {
        Binario binario1 = this.getBinario(indiceBinario1);
        Binario binario2 = this.getBinario(indiceBinario2);       
        return getResta(binario1,binario2);
    }
    
     public Binario getResta(String valor1, String valor2) {
        Binario binario1 = new Binario(valor2);
        Binario binario2 = new Binario(valor2);
        return getResta(binario1, binario2);
    }
    
    public Binario getResta(Binario binario1, Binario binario2) {
        return getResta(binario1.getInt(),binario2.getInt());    
    }

    @Override
    public Binario getMultiplica(int indiceBinario1, int indiceBinario2) {
         Binario binario1 = this.getBinario(indiceBinario1);
         Binario binario2 = this.getBinario(indiceBinario2);
        return getMultiplica(binario1, binario2);
    }
    
    private Binario getMultiplica(Binario binario1, Binario binario2) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Binario[] productos = new Binario[binario1.getBins().length];
       int countProductos = 0;
       // multiplico los factores
       for( int multiplicador : binario1.getInt()){
           String producto = "";
           int[] multiplicando = binario2.getInt();
           for(int j = multiplicando.length-1; j >= 0;  j--){
               producto = String.valueOf( multiplicador * multiplicando[j]) + producto;
           }
           for(int j = 0; j < countProductos; j++ ){
               producto += "0";
           }
           productos[countProductos] = new Binario(producto);
           countProductos++;
       }
       // sumo los productos
       Binario resultado = new Binario("0");
       for(Binario producto : productos){
           resultado = this.getSuma(resultado, producto);
       }
       return resultado;
    }
    

    @Override
    public long getDecimal(int indice_Del_Binario) {
        //binario a decimal
        Binario binario = this.getBinario(indice_Del_Binario);
        return getDecimal(binario);
    }
    
    private long getDecimal(Binario binario) {
        //binario a decimal
        int  n,cifra, resultado=0, exp=0;
        if(null == binario ){
            return 0;
        }
        n = binario.getIntegerValue();
        do {
            cifra= n % 10;
            resultado= resultado+ cifra* (int)Math.pow(2,exp);
            exp++;
            n=n/10;
        } while (n>0);
        return resultado;
    }

    @Override
    public Binario getSuma(int indiceBinario1, int indiceBinario2) {
        Binario binario1 = this.getBinario(indiceBinario1);
        Binario binario2 = this.getBinario(indiceBinario2);
        return getSuma(binario1, binario2);
        
    }
    
    public Binario getSuma(String valor1, String valor2) {
        Binario binario1 = new Binario(valor2);
        Binario binario2 = new Binario(valor2);
        return getSuma(binario1, binario2);
    }
    
    private Binario getSuma(Binario binario1, Binario binario2){
        int cadena[]= binario1.getInt();
        int cdena[]=  binario2.getInt();
        return getSuma(cadena,cdena);
    }
    
    private Binario getSuma(int[] cadena, int[] cdena){
        int dim;
        String result = "";
        // DARLE AL MISMA DIMENSION
        if(cadena.length < cdena.length){
            cadena = this.redimBinario(cadena, cdena.length);
            dim = cdena.length;
        }else{
            cdena = this.redimBinario(cdena, cadena.length);
            dim =  cadena.length;
        }
        // PARA INICIAR LA SUMA
        int acarreo=0;
        for (int j=dim-1; j >= 0; j--) {
            int bin1 = suma(acarreo,cadena[j]);
            int bin2 = cdena[j];
            int suma = suma(bin1,bin2);
            result =  String.valueOf(suma) + result;

            // luego valido si llevo acarreo
            if( (acarreo == 1 && cadena[j] == 1) || ( bin1 == 1 && bin2 == 1)){
                acarreo = 1;
            }else{
                acarreo = 0;
            }
        }
        if(acarreo == 1){
            result = String.valueOf(acarreo) + result;
        }
        return new Binario(result);
    }
    
    private int suma( int bin1, int bin2 ){
        if( bin1 == 1 && bin2 == 1){
            return 0;
        }else
        {
            return bin1 + bin2;
        }
    }
    
    public Binario getResta(int[] cadena, int[] cdena){
        int dim;
        String result = "";
        // DARLE AL MISMA DIMENSION
        if(cadena.length < cdena.length){
            cadena = this.redimBinario(cadena, cdena.length);
            dim = cdena.length;
        }else{
            cdena = this.redimBinario(cdena, cadena.length);
            dim =  cadena.length;
        }
        // PARA INICIAR LA RESTA
        int acarreo=0;
        for (int j=dim-1; j >= 0; j--) {
            int bin1;
            if (acarreo == 1) {
                bin1= resta(cadena[j],acarreo);
                if(isAcarreoResta(cadena[j],acarreo)){
                    acarreo=1;
                }else{
                    acarreo = 0;
                }
            } else{
                bin1= cadena[j];
            }
            int bin2 = cdena[j];
            int resta = resta(bin1,bin2);
            result =  String.valueOf(resta) + result;

            // luego valido si llevo acarreo
            if(acarreo == 0 && isAcarreoResta(bin1,bin2)){
                acarreo = 1;
            }
        }
        if(acarreo == 1){
            result = String.valueOf(acarreo) + result;
        }
        return new Binario(result);
    }
     
    private boolean isAcarreoResta(int bin1, int bin2){
        return (bin1 == 0 && bin2 == 1);
    }
    
    public String formatBinResta(String valor){
        String[] cadena = valor.split("");
        if(cadena.length == 3){
            if("0".equals(cadena[0])){
                return valor.substring(1, valor.length());
            }
        }
        if(cadena.length > 3){
            String bin1 = cadena[0];
            String bin2 = cadena[1];
            int int1 = Integer.parseInt(bin1);
            int int2 = Integer.parseInt(bin2);
            valor = valor.substring(2, valor.length());
            return  resta(int1, int2) == 0 ? "-" + valor : valor;
        }
        return valor;
    }
     
    private int resta( int bin1, int bin2 ){
        if( bin1 == 0 && bin2 == 1){
            return 1;
        }else
        {
            return bin1 - bin2;
        }
    }
    
    private int[] redimBinario(int[] bins, int regex){
         if( regex > bins.length ){
            int[] aux = new int[bins.length];
             // para clonar los valores de bins a aux
            System.arraycopy(bins, 0, aux, 0, aux.length);
            bins = new int[regex];
            int j;
            for(j = 0; j < regex - aux.length; j++){
               bins[j] = 0;
            }
            for( int l = 0; l < aux.length; l++,j++){
               bins[j] = aux[l];
            }
         }
         return bins;
    }

    @Override
    public String getHexaDecimal(int indice_Del_Binario) {
        Binario binario = this.getBinario(indice_Del_Binario);
        return getHexaDecimal(binario);
    }
    
    public String getHexaDecimal(Binario binario) {
        int n, cont=0, aux, acum=0;
        String resultado="";
        
        if(null == binario){
            return "";
        }
        n= binario.getIntegerValue();
        while(n>0){
            acum=0;
            cont=0;
            while(cont<4){
                aux= n%10;
                if (aux ==1) {
                    switch(cont){
                        case 0:
                            acum=acum+1;
                            break;
                        case 1:
                            acum=acum+2;
                            break;    
                        case 2:
                            acum=acum+4;
                            break; 
                        case 3:
                            acum=acum+8;
                            break;
                        default:
                            break;    
                    }
                }
                
                n= n/10;
                cont++;
            }
            if (acum<=9) {
                resultado= acum+resultado;
            } else if(acum>9){
               if(acum==10){
                resultado= "A"+acum+resultado;
               } else if(acum==11){
                resultado= "B"+resultado;
               } else if(acum==12){
                resultado= "C"+resultado;
               } else if(acum==13){
                resultado= "D"+resultado;
               }else if(acum==14){
                resultado= "E"+resultado;
               } else if(acum==15){
                resultado= "F"+resultado;
               }
            }
        }
        return resultado;
    }

    @Override
    public Binario getMenor() {
        Binario menor = new Binario("");
        if( this.binarios != null && this.binarios.length > 0){
            menor = this.getBinario(0);
            for(Binario bin : this.binarios){
                if(this.getDecimal(bin) < this.getDecimal(menor)){
                    menor = bin;
                }
            }
        }
        return menor;
    }

    @Override
    public Binario getMayor() {
        Binario mayor = new Binario("");
        if( this.binarios != null && this.binarios.length > 0){
            mayor = this.getBinario(0);
            for(Binario bin : this.binarios){
                if(this.getDecimal(bin) > this.getDecimal(mayor)){
                    mayor = bin;
                }
            }
        }
        return mayor;
    }

    public int getI() {
        return i;
    }

    public Binario[] getBinarios() {
        return binarios;
    }
    
    private Binario getBinario(int i){
        if(this.binarios != null){
            if(this.binarios.length > 0){
                try{
                    return this.binarios[i];
                }catch(Exception ex){
                    ex.printStackTrace();
                } 
            }
        }
        return new Binario();
    }
}
