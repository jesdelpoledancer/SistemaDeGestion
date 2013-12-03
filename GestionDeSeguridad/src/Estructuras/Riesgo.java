package Estructuras;

import java.sql.Time;

/**
 *
 * @author Itzcoatl90
 */
public class Riesgo {
    private String amenaza;
    private Activo activo;
    private int ocurrencia;
    private int impacto;
    private int tratamiento;
    private int resultado;
    private Time tiempoDeMonitoreo;

    public String getAmenaza() {
        return amenaza;
    }

    public void setAmenaza(String amenaza) {
        this.amenaza = amenaza;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public int getOcurrencia() {
        return ocurrencia;
    }

    public void setOcurrencia(int ocurrencia) {
        this.ocurrencia = ocurrencia;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public int getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(int tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Time getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Time tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }
    
}
