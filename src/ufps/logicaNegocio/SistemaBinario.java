package ufps.logicaNegocio;

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

    @Override
    public Binario getSumaTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Binario getResta(int indiceBinario1, int indiceBinario2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Binario getMultiplica(int indiceBInario1, int indiceBinario2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getDecimal(int indice_Del_Binario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Binario getSuma(int indiceBinario1, int indiceBinario2) {
        /**
         * example: 
         */
        return new Binario();
    }

    @Override
    public String getHexaDecimal(int indice_Del_Binario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
