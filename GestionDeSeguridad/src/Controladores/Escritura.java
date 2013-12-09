package Controladores;

import Estructuras.Activo;
import Estructuras.Control;
import Estructuras.PlanDeSoporte;
import Estructuras.Politica;
import Estructuras.Proceso;
import Estructuras.Riesgo;
import Estructuras.Rol;
import Estructuras.Tarea;
import Modelos.EntityDB;
import Modelos.LectorEscritorDeArbol;
import Modelos.LectorEscritorDeEntidades;
import Modelos.LectorEscritorDeMementos;
import Modelos.LectorEscritorDePrivilegios;
import Modelos.LectorEscritorValuadorDeRol;
import Modelos.LogsRegister;
import Modelos.Reporter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Itzcoatl90
 */
public class Escritura {
    LectorEscritorValuadorDeRol rol;
    LectorEscritorDeEntidades enti;
    LectorEscritorDeArbol arbol;
    LogsRegister logger;
    LectorEscritorDeMementos memento;
    LectorEscritorDePrivilegios privilegio;
    Reporter reportero;
    public Escritura(){
        rol = new LectorEscritorValuadorDeRol();
        logger = new LogsRegister();
    }
    public boolean autenticar(String login, String password){
        boolean logeo = rol.autenticar(login,password);
        logger.logLoggin(login, password, logeo);
        return logeo;
    }
    
    public void leerDatos(){
        /*enti = new LectorEscritorDeEntidades();
        arbol = new LectorEscritorDeArbol();
        memento = new LectorEscritorDeMementos();
        privilegio = new LectorEscritorDePrivilegios();
        reportero = new Reporter();
        rol.leerRoles();
        enti.leerEntidadesDirectas();
        enti.leerEntidadesIndirectas();
        arbol.leerArbol();*/
        temporal();
    }
    
    public void escribirMemento(){
        //ESTE MÉTODO ES UN "TODO", NO SE IMPLEMENTARÁ REALMENTE
    }
    
    public void guardarDatos(){
        /*
         * Este después le pongo atención (itzco)
         */
    }
    
    public void temporal(){
        Politica mision = new Politica();
        mision.setNombre("Mision de seguridad");
        mision.setDescripcion("Proveer a nuestros clientes de los servicios del compilador para el pseudo-lenguaje de programación "
                + "LaTeX, así como diversos tipos de templates, junto con espacio de almacenamiento para sus documentos científicos "
                + "ofreciéndole al mismo un alto grado de confidencialidad,  integridad, disponibilidad y rápido acceso para sus "
                + "documentos desde cualquier parte del mundo en donde existan servicios de Internet.");
        long fecha1 = new Long("1387584000000");//  20/Dic/2013
        long fecha2 = new Long("1386633600000");//  9/Dic/2013
        //86400000--> cantidad de milisegundos en un día
        long fecha3 = new Long("1386633600000");
        fecha3 += 86400000*3;
        long fecha4 = new Long("1386633600000");
        fecha4 += 86400000*7;
        long fecha5 = new Long("1386633600000");
        fecha5 += 86400000*10;
        long fecha6 = new Long("1386633600000");
        fecha6 += 86400000*15;
        long fecha7 = new Long("1386633600000");
        fecha7 += 86400000*18;
        mision.setProximoMonitoreo(new Date(fecha4));
        mision.setTiempoDeMonitoreo(new Time(86400000*150));//Cada 150 días
        ArrayList act = new ArrayList();
        act.add("Servidor");
        act.add("Workstation 1");
        act.add("Workstation 2");
        mision.setActivosAsociados(act);
        ArrayList cont = new ArrayList();
        cont.add("Lista blanca de aplicacion");
        cont.add("Antivirus AVIRA");
        cont.add("Cifrado");
        mision.setControlesAsociados(cont);
        mision.setResponsable("Director de TI");
        ArrayList hija = new ArrayList();
        mision.setEstado("Vigente");
        Politica aplicacion = new Politica();
        aplicacion.setNombre("Politicas para aplicacion");
        aplicacion.setDescripcion("Las aplicaciones deberán ser seguras.");
        aplicacion.setProximoMonitoreo(new Date(fecha6));
        aplicacion.setTiempoDeMonitoreo(new Time(86400000*80));//Cada 80 días
        ArrayList act2 = new ArrayList();
        act2.add("Workstation 1");
        act2.add("Workstation 2");
        aplicacion.setActivosAsociados(act2);
        ArrayList cont2 = new ArrayList();
        cont2.add("Lista blanca de aplicacion");
        cont2.add("Antivirus AVIRA");
        aplicacion.setControlesAsociados(cont2);
        aplicacion.setPadre(mision);
        aplicacion.setResponsable("Director Operativo");
        ArrayList hija2 = new ArrayList();
        aplicacion.setHijas(hija2);
        aplicacion.setEstado("Evaluación");
        Politica servidores = new Politica();
        servidores.setNombre("Politicas para servidores");
        servidores.setDescripcion("Los servidores deberán ofrecer cierto grado de confidencialidad.");
        servidores.setProximoMonitoreo(new Date(fecha1));
        servidores.setTiempoDeMonitoreo(new Time(86400000*50));//Cada 50 días
        ArrayList act3 = new ArrayList();
        act3.add("Servidor");
        servidores.setActivosAsociados(act3);
        ArrayList cont3 = new ArrayList();
        cont3.add("Cifrado");
        servidores.setControlesAsociados(cont3);
        servidores.setPadre(mision);
        servidores.setResponsable("Subdirector de auditoría");
        ArrayList hija3 = new ArrayList();
        servidores.setEstado("Vigente");
        Politica archivos = new Politica();
        archivos.setNombre("Politica para archivo en servidor");
        archivos.setDescripcion("Todos los archivos en el servidor deberán ser cifrados.");
        archivos.setProximoMonitoreo(new Date(fecha3));
        archivos.setTiempoDeMonitoreo(new Time(86400000*45));//Cada 45 días
        ArrayList act4 = new ArrayList();
        act4.add("Servidor");
        archivos.setActivosAsociados(act4);
        ArrayList cont4 = new ArrayList();
        cont4.add("Cifrado");
        archivos.setControlesAsociados(cont4);
        archivos.setPadre(servidores);
        archivos.setResponsable("Subdirector de auditoría");
        ArrayList hija4 = new ArrayList();
        archivos.setEstado("Vigente");
        hija3.add(archivos);
        servidores.setHijas(hija3);
        Proceso cifrado = new Proceso();
        cifrado.setNombre("Proceso de cifrado de archivos");
        cifrado.setDescripcion("Todo archivo en servidor se cifrará con el algoritmo Asimétrico todo el tiempo mientras "
                + "este se encuentre en el servidor.");
        cifrado.setProximoMonitoreo(new Date(fecha2));
        cifrado.setTiempoDeMonitoreo(new Time(86400000*73));//Cada 73 días
        ArrayList act5 = new ArrayList();
        act5.add("Servidor");
        cifrado.setActivosAsociados(act5);
        ArrayList cont5 = new ArrayList();
        cont5.add("Cifrado");
        cifrado.setControlesAsociados(cont5);
        cifrado.setPadre(archivos);
        cifrado.setResponsable("Subdirector de auditoría");
        cifrado.setEstado("Vigente");
        hija4.add(cifrado);
        archivos.setHijas(hija4);
        hija.add(aplicacion);
        hija.add(servidores);
        mision.setHijas(hija);
        EntityDB.getInstance().setRoot(mision);
        Activo servidor = new Activo();
        servidor.setNombre("Servidor");
        servidor.setProximoMonitoreo(new Date(fecha5));
        servidor.setTiempoDeMonitoreo(new Time(86400000*20));//Cada 20 días
        servidor.setCostoInterrupcion("10000");
        servidor.setCostoModificacion("100000");
        servidor.setCostoRevelacion("Reputación");
        ArrayList ries = new ArrayList();
        ries.add("Hackers");
        servidor.setRiesgos(ries);
        EntityDB.getInstance().agregarActivo(servidor);
        Activo w1 = new Activo();
        w1.setNombre("Workstation 1");
        w1.setProximoMonitoreo(new Date(fecha7));
        w1.setTiempoDeMonitoreo(new Time(86400000*37));//Cada 37 días
        w1.setCostoInterrupcion("500");
        w1.setCostoModificacion("1000");
        w1.setCostoRevelacion("1000");
        ArrayList ries2 = new ArrayList();
        ries2.add("Virus");
        ries2.add("Malware");
        w1.setRiesgos(ries2);
        EntityDB.getInstance().agregarActivo(w1);
        Activo w2 = new Activo();
        w2.setNombre("Workstation 2");
        w2.setProximoMonitoreo(new Date(fecha6));
        w2.setTiempoDeMonitoreo(new Time(86400000*39));//Cada 39 días
        w2.setCostoInterrupcion("500");
        w2.setCostoModificacion("1000");
        w2.setCostoRevelacion("1000");
        ArrayList ries3 = new ArrayList();
        ries3.add("Virus");
        ries3.add("Malware");
        w2.setRiesgos(ries3);
        EntityDB.getInstance().agregarActivo(w2);
        Riesgo hackers = new Riesgo();
        hackers.setActivo("Servidor");
        hackers.setAmenaza("Hackers");
        hackers.setImpacto(5);
        hackers.setOcurrencia(3);
        hackers.setRiesgo(8);
        hackers.setTratamiento("Mitigarlo");
        hackers.setResultado("Interrupcion");
        hackers.setTiempoDeMonitoreo(new Time(fecha2));
        hackers.setProximoMonitoreo(new Date(86400000*35));//Cada 35 días
        Riesgo virus = new Riesgo();
        virus.setActivo("Workstation 1");
        virus.setAmenaza("Virus");
        virus.setImpacto(3);
        virus.setOcurrencia(1);
        virus.setRiesgo(4);
        virus.setTratamiento("Mitigarlo");
        virus.setResultado("Interrupcion");
        virus.setTiempoDeMonitoreo(new Time(fecha1));
        virus.setProximoMonitoreo(new Date(86400000*23));//Cada 23 días
        Riesgo malware = new Riesgo();
        malware.setActivo("Workstation 1");
        malware.setAmenaza("Malware");
        malware.setImpacto(2);
        malware.setOcurrencia(1);
        malware.setRiesgo(3);
        malware.setTratamiento("Aceptarlo");
        malware.setResultado("Modificacion");
        malware.setTiempoDeMonitoreo(new Time(fecha7));
        malware.setProximoMonitoreo(new Date(86400000*15));//Cada 15 días
        Riesgo virus2 = new Riesgo();
        virus2.setActivo("Workstation 2");
        virus2.setAmenaza("Virus");
        virus2.setImpacto(3);
        virus2.setOcurrencia(1);
        virus2.setRiesgo(4);
        virus2.setTratamiento("Mitigarlo");
        virus2.setResultado("Interrupcion");
        virus2.setTiempoDeMonitoreo(new Time(fecha2+86400000*2));
        virus2.setProximoMonitoreo(new Date(86400000*15));//Cada 15 días
        Riesgo malware2 = new Riesgo();
        malware2.setActivo("Workstation 2");
        malware2.setAmenaza("Malware");
        malware2.setImpacto(2);
        malware2.setOcurrencia(1);
        malware2.setRiesgo(3);
        malware2.setTratamiento("Aceptarlo");
        malware2.setResultado("Modificacion");
        malware2.setTiempoDeMonitoreo(new Time(fecha3+86400000*3));
        malware2.setProximoMonitoreo(new Date(86400000*15));//Cada 15 días
        EntityDB.getInstance().agregarRiesgo(hackers);
        EntityDB.getInstance().agregarRiesgo(virus);
        EntityDB.getInstance().agregarRiesgo(virus2);
        EntityDB.getInstance().agregarRiesgo(malware);
        EntityDB.getInstance().agregarRiesgo(malware2);
        Control lblanca = new Control();
        lblanca.setNombre("Lista blanca de aplicacion");
        lblanca.setProximoMonitoreo(new Date(fecha5+86400000*2));
        lblanca.setTiempoDeMonitoreo(new Time(86400000*14));//Cada 14 días
        ArrayList tar = new ArrayList();
        tar.add(new Tarea("Lista blanca Actualizar","Se debe actualizar la base de datos de aplicaciones permitidas y revisar integridad de lista"));
        lblanca.setTareasARealizar(tar);
        ArrayList riesgos = new ArrayList();
        riesgos.add("Malware");
        lblanca.setRiesgosAsociados(riesgos);
        Control avirus = new Control();
        avirus.setNombre("Antivirus AVIRA");
        avirus.setProximoMonitoreo(new Date(fecha1+86400000*1));
        avirus.setTiempoDeMonitoreo(new Time(86400000*12));//Cada 12 días
        ArrayList tar2 = new ArrayList();
        tar2.add(new Tarea("Actualizar base de datos de virus","Se debe actualizar la base de datos de virus"));
        tar2.add(new Tarea("Analizar equipos","Se debe hacer un escaneo de virus en todo los equipos"));
        avirus.setTareasARealizar(tar2);
        ArrayList riesgos2 = new ArrayList();
        riesgos2.add("Virus");
        avirus.setRiesgosAsociados(riesgos2);
        Control cifrad = new Control();
        cifrad.setNombre("Cifrado");
        cifrad.setProximoMonitoreo(new Date(fecha2+86400000*3));
        cifrad.setTiempoDeMonitoreo(new Time(86400000*17));//Cada 17 días
        ArrayList tar3 = new ArrayList();
        tar3.add(new Tarea("Revisar algoritmo","Verificar que el algoritmo utilizado siga siendo fuerte y no roto"));
        cifrad.setTareasARealizar(tar3);
        ArrayList riesgos3 = new ArrayList();
        riesgos3.add("Hackers");
        cifrad.setRiesgosAsociados(riesgos3);
        EntityDB.getInstance().agregarControl(cifrad);
        EntityDB.getInstance().agregarControl(lblanca);
        EntityDB.getInstance().agregarControl(avirus);
        PlanDeSoporte sop = new PlanDeSoporte();
        sop.setNombre("Plan de Contingencia");
        sop.setDescripcion("Es el plan de contingencia para los servicios digitales");
        sop.setProximoMonitoreo(new Date(fecha6+86400000));
        sop.setTiempoDeMonitoreo(new Time(86400000*80));//Cada 80 días
        ArrayList tareas = new ArrayList();
        tareas.add(new Tarea("Revision","Revisar origen del problema"));
        tareas.add(new Tarea("Aislamiento","Aislarlo"));
        tareas.add(new Tarea("Respaldo","Cambiar a energias alternativas y respaldos de recursos"));
        tareas.add(new Tarea("Levantar","Prender servicios críticos de respaldo"));
        sop.setTareasARealizar(tareas);
        ArrayList pol = new ArrayList();
        pol.add("Politicas para aplicacion");
        pol.add("Politicas para servidores");
        pol.add("Politica para archivo en servidor");
        pol.add("Proceso de cifrado de archivos");
        pol.add("Mision de seguridad");
        sop.setPoliticasQueSoporta(pol);
        EntityDB.getInstance().agregarPlanDeSoporte(sop);
        Rol directorTI = new Rol();
        directorTI.setNombre("Director de TI");
        ArrayList user = new ArrayList();
        user.add("itzcoatl90");
        directorTI.setUsuarios(user);
        HashMap privDIRTI = new HashMap();
        boolean[] priact1 = {true,true,true,true,true,true,true,true,true,true,true};
        privDIRTI.put(1, priact1);
        boolean[] pricont1 = {true,true,true,true,true,true,true,true,true,true};
        privDIRTI.put(2, pricont1);
        boolean[] pyp1 = {true,false,false,false,false,false,false,false,false,false,true,true,true,true,true,true};
        privDIRTI.put(3, pyp1);
        boolean[] psop1 = {true,true,true,true,true,true,true,true,true,true,true};
        privDIRTI.put(4, psop1);
        boolean[] priries1 = {true,true,true,true,true,true,true,true,true,true,true,true};
        privDIRTI.put(5, priries1);
        boolean[] prirol1 = {true,true,true,true,true,true,true,true,true};
        privDIRTI.put(6, prirol1);
        directorTI.setPrivilegios(privDIRTI);
        EntityDB.getInstance().agregarRol(directorTI);
        Rol evalArq = new Rol();
        evalArq.setNombre("Director Operativo");
        ArrayList user2 = new ArrayList();
        user2.add("neogiovas");
        user2.add("danielZam");
        evalArq.setUsuarios(user2);
        HashMap privEVAR = new HashMap();
        boolean[] priact2 = {true,true,true,true,true,true,true,true,true,true,true};
        privEVAR.put(1, priact2);
        boolean[] pricont2 = {true,true,false,true,false,true,false,true,false,true};
        privEVAR.put(2, pricont2);
        boolean[] pyp2 = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
        privEVAR.put(3, pyp2);
        boolean[] psop2 = {false,false,false,true,true,true,true,true,true,true,true};
        privEVAR.put(4, psop2);
        boolean[] priries2 = {true,true,true,true,true,true,true,true,true,true,true,true};
        privEVAR.put(5, priries2);
        boolean[] prirol2 = {true,true,true,true,true,true,true,true,true};
        privEVAR.put(6, prirol2);
        evalArq.setPrivilegios(privEVAR);
        EntityDB.getInstance().agregarRol(evalArq);
        Rol audInt = new Rol();
        audInt.setNombre("Subdirector de auditoría");
        ArrayList user3 = new ArrayList();
        user3.add("jortegam");
        user3.add("msotelo");
        audInt.setUsuarios(user3);
        HashMap privAUDIN = new HashMap();
        boolean[] priact3 = {false,false,false,true,true,true,true,true,true,true,true};
        privAUDIN.put(1, priact3);
        boolean[] pricont3 = {true,false,true,false,true,false,true,false,true,false};
        privAUDIN.put(2, pricont3);
        boolean[] pyp3 = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
        privAUDIN.put(3, pyp3);
        boolean[] psop3 = {true,true,true,true,true,true,true,true,true,true,true};
        privAUDIN.put(4, psop3);
        boolean[] priries3 = {true,true,true,true,true,true,true,true,true,true,true,true};
        privAUDIN.put(5, priries3);
        boolean[] prirol3 = {true,true,true,true,true,true,true,true,true};
        privAUDIN.put(6, prirol3);
        audInt.setPrivilegios(privAUDIN);
        EntityDB.getInstance().agregarRol(audInt);
        EntityDB.getInstance().setPersona("Director de TI", "Itzcoatl Salazar", "itzcoatl90", "password");
    }
    
}
