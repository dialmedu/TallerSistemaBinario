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
        return null;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        Binario[][] maxBinario = new  Binario[this.binarios.length][];
        int maxRepeticiones = 0;
        for ( int j = 0; j <  this.binarios.length; j++){
               maxBinario[j][0] = this.binarios[j];
            for(int k = 0; k < this.binarios.length; k++){
                if( maxBinario[j][0].equals(this.binarios[k]) ){
                    maxBinario[j][k] = this.binarios[k]; 
                }
            }
            if(maxBinario[j].length > maxRepeticiones){
                maxRepeticiones = maxBinario[j].length;
            }
        }
        return maxBinario[maxRepeticiones];
    }
  
    public Binario getSumaTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return getResta(binario1.integerValue(),binario2.integerValue());    
    }

    @Override
    public Binario getMultiplica(int indiceBInario1, int indiceBinario2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getDecimal(int indice_Del_Binario) {
        //binario a decimal
        int  cifra, resultado=0, exp=0;
        int n;
         Scanner dato= new Scanner(System.in);
        n= dato.nextInt();
        do {
            cifra= n % 10;
            resultado= resultado+ cifra* (int)Math.pow(2,exp);
            exp++;
            n=n/10;
        } while (n>0);
        System.out.println("num decimal: "+resultado);
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
        int cadena[]= binario1.integerValue();
        int cdena[]=  binario2.integerValue();
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
            if(cadena[0] == "0"){
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
        //binario a hexa
       // Scanner dato= new Scanner(System.in);
        int n, cont=0, aux, acum=0;
        String resultado="";
        System.out.println("num: ");
        //n= dato.nextInt(); 
        //n= String.valueOf(indice_Del_Binario);
        n= 1001;
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
         resultado= " "+resultado; 
         //System.out.println("Resultado: "+resultado);
        return resultado+= "Resultado: "+resultado;
    }

    @Override
    public Binario getMenor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Binario getMayor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
