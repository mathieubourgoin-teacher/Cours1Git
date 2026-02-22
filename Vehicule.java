package exercice4;

import java.text.DecimalFormat;

/**
 * CoursPOO1 - FormatifS11 - Vehicule
 *
 * @author Julien.Brunet màj Jocelyn
 * @since 2025
 */
public class Vehicule {

    public static final int MIN_PASSAGERS = 2;
    public static final int MAX_PASSAGERS = 8;
    public static final double TAXE = 0.15;
    public static final double RABAIS_PAR_DEFAUT = 0;

    private double prixVente = 0;
    private double rabais = RABAIS_PAR_DEFAUT;
    private String modele = "";
    private int nombrePassagers = 0;

    /**
     * Constructeur
     *
     * @param prixVente
     * @param modele
     * @param nombrePassager
     */
    public Vehicule(double prixVente, String modele, int nombrePassager) {
        this.modele = modele;
        this.prixVente = prixVente;
        //pour beneficier de la validation...
        setNombrePassagers(nombrePassager);
    }

    public double getRabais() {
        return rabais;
    }

    public void setRabais(double rabais) {
        this.rabais = rabais;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public String getModele() {
        return modele;
    }

    private void setModele(String modele) {
        this.modele = modele;
    }

    public int getNombrePassagers() {
        return nombrePassagers;
    }

    private void setNombrePassagers(int nombrePassagers) {
        if (Vehicule.isNombrePassagersValid(nombrePassagers)) {
            this.nombrePassagers = nombrePassagers;
        } else {
            System.out.println("Le nombre (" + nombrePassagers + ") de passagers est invalide, valeur par defaut: " + MIN_PASSAGERS);
            this.nombrePassagers = MIN_PASSAGERS;
        }
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.00$");
        return "Vehicule de marque VW : (" +
                "prixVente = " + prixVente +
                ", rabais = " + rabais +
                ", modele = '" + modele + '\'' +
                ", nombrePassagers = " + nombrePassagers +
                ") Prix taxes comprises : " + format.format(calculerPrixFinal());
    }

    public double calculerPrixFinal() {
        return (prixVente - prixVente * rabais) * (1 + TAXE);
    }

    private static boolean isNombrePassagersValid(int nombrePassagers) {
        return nombrePassagers >= MIN_PASSAGERS && nombrePassagers <= MAX_PASSAGERS;
    }
}
