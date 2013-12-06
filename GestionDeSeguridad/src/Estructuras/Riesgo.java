package Estructuras;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Itzcoatl90
 */
public class Riesgo {
    private String amenaza;//1
    private int ocurrencia;//2
    private int impacto;//3
    private int riesgo;//4
    private String tratamiento;//5
    private String resultado;//6
    private Time tiempoDeMonitoreo;//7
    private Date proximoMonitoreo;//8
    private String activo;//9

    public String getAmenaza() {
        return amenaza;
    }

    public void setAmenaza(String amenaza) {
        this.amenaza = amenaza;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
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

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }
    
    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Time getTiempoDeMonitoreo() {
        return tiempoDeMonitoreo;
    }

    public void setTiempoDeMonitoreo(Time tiempoDeMonitoreo) {
        this.tiempoDeMonitoreo = tiempoDeMonitoreo;
    }
    
    public Date getProximoMonitoreo() {
        return proximoMonitoreo;
    }

    public void setProximoMonitoreo(Date proximoMonitoreo) {
        this.proximoMonitoreo = proximoMonitoreo;
    }
    
}
