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
        String cad2= String.valueOf(indiceBinario1);;
        String cad3= String.valueOf(indiceBinario2);
        int cadena[]= new int[20];
        int cdena[]= new int[20];
        int cdenamd[]= new int[20];
        int result[]= new int[20];
        int i, dim=0, dim2=0;
        //resta
        System.out.println("");
        int acarreo2=0;
        int result2[]= new int[20];
        for (i =dim-1; i >= 0; i--) {
            if (acarreo2==1) {
                cadena[i]= cadena[i]- acarreo2;
                if (cadena[i]==0) {
                    cadena[i]=0;
                } else{
                cadena[i]=1; }
            }
            result2[i+1]= cadena[i]- cdenamd[i];
            if (result2[i+1]== -1) {
                acarreo2=1;
                result2[i+1]=1;
            }else{
                if (result2[i+1]==1) {
                    acarreo2=0;
                    result2[i]=1;
                } else{
                    if (result2[i+1]== 0) {
                        acarreo2=0;
                        result2[i]=0;
                    }
                }
            }
        }
        String suma2="";
        if (acarreo2==1) 
            result2[0]=acarreo2;
        System.out.println("resta: ");
            for (int k = 0; k < dim+1; k++) {
                //suma2 += System.out.print(result2[k]+" ");
                suma2+= String.valueOf(result2[k]+" ");
            }
        return new Binario(suma2);    
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
        /** String cad2= new String();
        String cad3= new String();
        String cad2= String.valueOf(indiceBinario1);
        String cad3= String.valueOf(indiceBinario2); **/
        String cad2= this.getBinario(indiceBinario1).toString();
        String cad3= this.getBinario(indiceBinario2).toString();
        int cadena[]= this.getBinario(indiceBinario1).integerValue();
        int cdena[]=  this.getBinario(indiceBinario1).integerValue();
        int cdenamd[]= new int[20];
        String result= "";
        int i, dim = cadena.length, dim2 = cdena.length;
        
//        Scanner dato= new Scanner(System.in);
//        System.out.println("suma");
//        System.out.println("n1");
//       // cad2= dato.nextLine();
//         cad2= cad2;
//         
//        for (i = 0; i < cad2.length(); i++) {
//            //transforma la cadena en un int
//            if (cad2.charAt(i) == 48){ 
//                cadena[i]=0;
//            }
//        else{
//               cadena[i]=1;    }
//    }
        
//        dim= i;
//        System.out.println("n2");
//        //cad3= dato.nextLine();
//        cad3=cad3;
//        
//        for (i = 0; i < cad3.length(); i++) {
//            if (cad3.charAt(i) == 48) {
//                cdena[i]=0;
//            } else{
//               cdena[i]=1;    }
//    }
//        
////    dim2= i;
    // DARLE AL MISMA DIMENSION
    if(cadena.length < cdena.length){
        cadena = this.redimBinario(cadena, cdena.length);
        dim = cdena.length;
    }else{
        cdena = this.redimBinario(cdena, cadena.length);
        dim =  cadena.length;
    }
    
//    int j=0;
//        for (int k = 0; k < dim; k++) {
//            if (k<(dim-dim2)) {
//                cdenamd[k]=0;
//            }else{
//                cdenamd[k]=cdena[j];
//                j++;
//            }
//        }
//        System.out.println("numero 1:");
//        for (i = 0; i < dim; i++) {
//            System.out.print(cadena[i]+"  ");
//        }
//     System.out.println("");    
//    System.out.println("numero 2");
//        for (int l = 0; l < dim; l++) {
//            System.out.print(cdenamd[l]+"  ");
//        }
    //suma    
//    System.out.println(dim);

    

    int acarreo=0;
        for (i=dim-1; i >= 0; i--) {
//            if (acarreo==1) {
//                cadena[i]= cadena[i]+acarreo;
//                if (cadena[i]==2) {
////                    acarreo=1;
//                    cadena[i]=0;
//                }
//            }
            
            int bin1 = suma(acarreo,cadena[i]);
            int bin2 = cdena[i];
            int suma = suma(bin1,bin2);
            result =  String.valueOf(suma) + result;
           
            // luego valido si llevo acarreo
            if( (acarreo == 1 && cadena[i] == 1) || ( bin1 == 1 && bin2 == 1)){
                acarreo = 1;
            }else{
                acarreo = 0;
            }
            
            /*result[i+1]= cadena[i]+cdena[i];
                if (result[i+1] == 2) {
                    acarreo=1;
                    result[i+1]=0;
                }else{
                    acarreo=0;
                }   */
        }
        if(acarreo == 1){
            result = String.valueOf(acarreo) + result;
        }
//        
//        if (acarreo==1) 
//            result[0]= acarreo;
//        String suma="";
//             System.out.println("");
//             System.out.println("Suma:");
//            for (i= 0; i<dim+1; i++) {
//                //System.out.print(result[i]+" ");
//            suma+= String.valueOf(result[i]+" ");    
//            }
            
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
        if(this.binarios.length > 0){
            try{
                return this.binarios[i];
            }catch(Exception ex){
                ex.printStackTrace();
            } 
        }
        return null;
    }
}
