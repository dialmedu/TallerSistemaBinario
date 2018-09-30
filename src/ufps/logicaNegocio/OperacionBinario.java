package ufps.logicaNegocio;

public interface OperacionBinario {

    public Binario[] getMas_SeRepite();

    public Binario getSumaTotal();

    public Binario getResta(int indiceBinario1, int indiceBinario2);

    public Binario getMultiplica(int indiceBInario1, int indiceBinario2);

    public long getDecimal(int indice_Del_Binario);

    public Binario getSuma(int indiceBinario1, int indiceBinario2);

    public String getHexaDecimal(int indice_Del_Binario);

    public Binario getMenor();

    public Binario getMayor();
}
