package Controladores.PestanasConPaneles;

import Controladores.Mediator;
import Controladores.Privilegios;
import Estructuras.Control;
import Estructuras.Riesgo;
import Estructuras.Tarea;
import Modelos.EntityDB;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Itzcoatl90
 */
public class Calendario implements Pestana {
    private JPanel calendario;
    private JPanel listaDePendientes;
    private Mediator m;
    private boolean init = true;
    Calendar calenda = Calendar.getInstance();
    Vector<ArrayList> vecDias = new Vector<ArrayList>(32);
    public Calendario(Mediator m){
        calendario = new JPanel();
        calendario.setSize(595,489);
        listaDePendientes = new JPanel();
        listaDePendientes.setSize(595,489); 
        listaDePendientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listaDePendientes.setLayout(new BoxLayout(listaDePendientes, BoxLayout.PAGE_AXIS));
        for(int i=0; i<=31;i++)
            vecDias.add(new ArrayList());
        this.m = m;               
    }
    
    @Override
    public void init(){
        if(init){
            init =false;
            prepararPanel();
        }
    }
    
    private void changePanel(JPanel panel){
        m.changePanel(1, panel);
    }
    
    @Override
    public void prepararPanel(){
        /*
         * En este método se busca en todas las entidades de EntityDB
         * los "tiempoDeMonitoreo". Se pone un señalizador en cada dia de la semana.
         * 
         * Puedes representar el calendario con imagenes o con panelsitos...
         * Si te sale otra idea de como representarlo está bien...
         * 
         * Tienes todo el panel para ti solo... Solo no cambies el tamaño del panel (595,489)
         * y si lo cambias me avisas para yo cambiar tu host de calendario.
         * 
         * EntityDB es un Singleton y la forma de llamarlo es por su método "getInstance()"
         * en vez de crear uno nuevo.
         * 
         * ej.
         * 
         * EntityDB entidad = EntityDB.getInstance();
         * 
         * Además... como tienes tu propio panel vas a tener que agregar los listeners de manera local...
         * 
         * dinámicamente checa como lo he hecho anteriormente...
         * 
         * 
         explicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicarButton();
            }
         });
         * 
         * "explicar" es un boton. "actionPerformed" es un evento de un componente GUI (una señal),
         * por ejemplo que den doble click o pasen el mouse sobre el componente...
         * 
         * El "evento" puede ser de mouse (mouseClicked, mouseEntered,...), puede ser de teclas (keyPressed, keyRelease),...
         * 
         * Puedes buscar estas acciones en internet o, en otro proyecto, poner un panel o boton o un componente GUI y (en netbeans)
         * en la interfaz darle click derecho, "events" y allí te sale una lista...
         * 
         * Si lo haces con imagenes puedes (cuando da click el usuario) sacar la 'x' y la 'y' para saber donde está (creo que es
         * algo como con el evento mouseclicked sacar click.X y click.Y... No recuerdo pero no es dificil, lo he hecho).
         * 
         * Si resuelves el problema de otra manera (no imagenes y no paneles) y no sabes como podemos hacerle para los listeners
         * me avisas para ver que podemos hacer...
         * 
         * Los listeners responden a una señal, en mi ejemplo delega el evento "actionPerformed" de mi boton "explicar" al método
         * "explicarButton();" que implementa lo que se debe de hacer...
         * 
         * Tu tienes muchos días (ya sean páneles o imagenes), de modo que a lo mejor puedes ir creando (cuando creas el calendario)
         * un ArrayList con apuntadores a cada componente nuevo que creas para ponerle diferentes métodos de respuesta a las señales.
         * 
         * De manera Dinámica sería lo mejor, pero si se te dificulta mucho puedes hacerlo de manera estática. Se ve medio feo eso
         * pero tenemos la certeza de que hay máximo 31 días en un mes.
         * 
         * 
         */
        //changePanel(calendario);
                
        int[] finDeMes = {31,28,31,30,31,30,31,31,30,31,30,31};                  
        int anio,mes,dia,dial;        
        Date fecha = new Date();
        Calendar cal = Calendar.getInstance();
        EntityDB entidadDB = EntityDB.getInstance();
        
        //System.out.println (fecha);
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        
        dateFormat.applyPattern("dd");
        dia = Integer.parseInt(dateFormat.format(fecha));        
        dateFormat.applyPattern("MM");
        mes = Integer.parseInt(dateFormat.format(fecha));
        dateFormat.applyPattern("yyyy");
        anio = Integer.parseInt(dateFormat.format(fecha));                
        calenda.set(Calendar.DAY_OF_MONTH,dia);
        calenda.set(Calendar.MONTH,mes-1);
        calenda.set(Calendar.YEAR,anio);
        
        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
           finDeMes[1]=29;
        
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH,mes-1);
	dial = cal.get(Calendar.DAY_OF_WEEK);
        
        //System.out.println("Fecha:: "+dial+" "+dia+"/"+mes+"/"+anio);
                       
        JPanel[] diasArray = new JPanel[38];        
        JLabel dias = new JLabel("Dom       Lun        Mar         Mie         Jue          Vie        Sab   ");
        int x,y,cont,desp;
        JLabel mesLabel = new JLabel("<html>D<br>I<br>C<br>I<br>E<br>M<br>B<br>R<br>E</html>");
        JLabel anioLabel = new JLabel(anio+"");
        JLabel anioSig = new JLabel();;
        JLabel anioAnt = new JLabel();
        JLabel mesSig = new JLabel(); 
        JLabel mesAnt  = new JLabel();
        mesLabel.setBounds(0,80, 20, 300);
        anioLabel.setBounds(480,10, 100, 30);
        anioSig.setBounds(563,6,35,35);
        anioSig.setText(">");
        anioAnt.setBounds(450,6,35,35);
        anioAnt.setText("<");
        mesSig.setBounds(565,42,35,35);
        mesSig.setText(">");
        mesAnt.setBounds(10,42,35,35);
        mesAnt.setText("<");
        anioSig.setFont(new Font("Lucida Grande", 1, 35));
        anioAnt.setFont(new Font("Lucida Grande", 1, 35));
        mesSig.setFont(new Font("Lucida Grande", 1, 20));
        mesAnt.setFont(new Font("Lucida Grande", 1, 20));
        anioSig.setName("anioSig");
        anioAnt.setName("anioAnt");
        mesSig.setName("mesSig");
        mesAnt.setName("mesAnt");
        
        mesLabel.setFont(new Font("Lucida Grande", 1, 20));
        anioLabel.setFont(new Font("Lucida Grande", 1, 30));
        
        anioSig.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                
                metodosDeRespuesta(invoca);
            }
        });
        anioAnt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                        
                metodosDeRespuesta(invoca);
            }
        });
        mesSig.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                        
                metodosDeRespuesta(invoca);
            }
        });
        mesAnt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                        
                metodosDeRespuesta(invoca);
            }
        });
        
        calendario.add(mesLabel);
        calendario.add(anioLabel);
        calendario.add(anioSig);
        calendario.add(anioAnt);
        calendario.add(mesSig);
        calendario.add(mesAnt);
        //calendario.setLayout(new GridLayout(6,7));
        calendario.setLayout(null);
        dias.setBounds(70, 50, 680, 20);
        dias.setFont(new Font("Lucida Grande", 1, 15));
        //dias.setnew java.awt.Color(102, 153, 255)
        calendario.add(dias);
        y=70;
        x=0;
        desp=70;
        cont=0;
        for(int i =0; i<diasArray.length;i++,x++){            
                diasArray[i] = new JPanel();
                diasArray[i].setName(""+(i+1)+"");
                diasArray[i].setBounds(x*70+desp,y, 70, 70);                
                if(i >= (dial-1) && cont<finDeMes[mes-1]){
                    cont++;
                    diasArray[i].setBorder(javax.swing.BorderFactory.createTitledBorder(null, ""+cont+"", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 20), new java.awt.Color(102, 153, 255))); // NOI18N            
                    if(cont==dia)
                    diasArray[i].setBackground(new java.awt.Color(102, 102, 102));
                    //diasArray[i].addMouseListener(new accionesRatonCalendario());                    

                    generaListaControles(entidadDB,cont,fecha,this.vecDias,diasArray,i);
                    generaListaRiesgo(entidadDB,cont,fecha,vecDias,diasArray,i);
                    generaListaPlan(entidadDB,cont,fecha,vecDias,diasArray,i);
                    generaListaActivo(entidadDB,cont,fecha,vecDias,diasArray,i);
                                            
                }  
                calendario.add(diasArray[i]);   

                if (x==6){
                    y+=70;
                    x=-1;
                }
        }
        
        insertaEventosCalendario(diasArray);
        
        calendario.setVisible(true);         
        changePanel(calendario);
    }
    
    public void metodosDeRespuesta(Component componente){        
        /*
         * Este método representa varios, en realidad son la respuesta a los eventos de allá arriba.
         * 
         * Lo que van a hacer es, de cada uno sacar el date (tal vez puede ser un solo método ahora que lo pienso
         * que lo que cambie sea el parámetro)... Gestiona tu como te acomodes...
         * 
         * Ahora sí, perdon... Del día en cuestión sacar el date y buscar en las listas de entidades o en una local que tengas
         * (a lo mejor cada componente si lo hiciste con paneles por ejemplo tiene su lista de pendientes)...
         * 
         * Lo que queremos es que en listaDePendientes se vean... jajaja .... la lista de pendientes de ese día.
         * 
         * toma en cuenta que también han de tener listeners estos... puesto que si le das click mandarás llamar a una
         * funcion que muestra perfiles. Esta lista (y sus listeners) los puedes crear onthefly (osease cada que se le da
         * click a un día).
         * 
         * IDEAS:
         *  
         * Puedes hacerlo con imágenes también, o puedes hacerlo con algun otro componente que sea de lista (creo que 
         * "list" te podría servir).
         * 
         * Al terminar todo este show cambia el panel desde el mediator...
         * 
         * 
         * NOTA: PARA CADA DÍA TENDRAS QUE ITERAR SOBRE LAS ENTIDADES... NO LAS AGREGUES SI NO TIENE PRIVILEGIOS!!!
         * 
         * Para saber si tiene o no privilegios, usa el singleton privilegios e invoca el método ver() con el rol (del
         * singleton persona y el objeto en cuestion como parámetro).
         * 
         * ej.
         * 
         * if(Privilegios.getInstance().ver(EntityDB.getInstance().getPersona().getRol(),objetoEnCuestion)){//Este objeto en cuestion es tuyo
         *    //Mostrar en lista
         * }
         * 
         * NOTA: TAMBIEN INCLUYE UN BOTON QUE TE REGRESE AL CALENDARIO (ya no necesitas recalcularlo)
         * En el listener de este boton puedes mandar directamente un m.changePanel(1, calendario);
         * puesto que ya está inicializado todo.
         * 
         */
        /*
         Iterator iteradorInt = tempL.iterator();                                
                                while(iteradorInt.hasNext()){
                                    Tarea tareaT = (Tarea)iteradorInt.next();
                                    System.out.println("Nombre: "+tareaT.getNombre()+"\nDesc: "+tareaT.getDescripcion());
                                    //
                                    
                                    diasArray[i].addMouseListener(new MouseAdapter(){
                                        public void mouseClicked(MouseEvent ev){
                                            Component invoca = (Component) ev.getSource();        
                                            System.out.println("Accion del mouse: "+invoca);  
                                            metodosDeRespuesta(Integer.parseInt(invoca.getName()));
                                        }
                                    });
                                }
         */
        
        if(componente.getName().equals("botonOk")){
            listaDePendientes.setVisible(false);
            listaDePendientes.removeAll();
            m.changePanel(1, calendario);
            
        } 
        
        if(componente.getName().substring(0, 5).equals("check")){
            
            String compo = componente.getName().substring(5,7);
            //compo = ;
            int i=1;
            ArrayList tempoLista = vecDias.elementAt(Integer.parseInt(compo));
            Iterator itera = tempoLista.iterator();        
            while(itera.hasNext()){
                ListaTareas lisTar = (ListaTareas)itera.next();
                JLabel tempLabelL = new JLabel();
                tempLabelL.setName(lisTar.nombre);
                tempLabelL.setText("<html><a href="+">"+lisTar.nombre+"</a></html>");
                tempLabelL.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent ev){
                        Component invoca = (Component) ev.getSource();
                        String cadena = invoca.getName();
                        String objeto = cadena.substring(3,cadena.length());
                        System.out.println(objeto);
                        if(cadena.substring(0,1).equals("C"))
                            m.mostrarPerfil((Estructuras.Control)EntityDB.getInstance().encuentraControl(objeto)); 
                        if(cadena.substring(0,1).equals("R"))
                            m.mostrarPerfil((Estructuras.Riesgo)EntityDB.getInstance().encuentraRiesgo(objeto)); 
                        if(cadena.substring(0,1).equals("A"))                            
                            m.mostrarPerfil((Estructuras.Activo)EntityDB.getInstance().encuentraActivos(objeto));
                        if(cadena.substring(0,1).equals("P"))
                            m.mostrarPerfil((Estructuras.PlanDeSoporte)EntityDB.getInstance().encuentraPlanDeSoporte(objeto));
                    }
                });
                listaDePendientes.add(tempLabelL);
                
                JButton botonListaPendientes = new JButton("OK");
                botonListaPendientes.setName("botonOk");
                botonListaPendientes.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent ev){
                    Component invoca = (Component) ev.getSource();
                    //System.out.println("Boton OK: "+invoca);  
                    metodosDeRespuesta(invoca);
                    }
                });
            
                listaDePendientes.add(botonListaPendientes);        
                //m.mostrarPerfil(EntityDB.getInstance().getControles().get(1));
                //listaDePendientes.setVisible(true);         
                changePanel(listaDePendientes);
            }
          }
            if(componente.getName().equals("anioSig")){            
               calenda.set(Calendar.YEAR,calenda.get(Calendar.YEAR)+1);            
               prepararPanel(calenda.getTime());                        
            }
            if(componente.getName().equals("anioAnt")){
               calenda.set(Calendar.YEAR,calenda.get(Calendar.YEAR)-1);            
               prepararPanel(calenda.getTime());                        
            }
        
        //changePanel(calendario);
        
    }
    
    
    public void generaListaControles(EntityDB entidadDB,int cont,Date fecha, Vector<ArrayList> vecDias, JPanel[] diasArray, int i){
        
        if(Privilegios.getInstance().ver(entidadDB.getPersona().getRol(),entidadDB.getControles())){//Este objeto en cuestion es tuyo
            ArrayList temp = entidadDB.getControles();           
            Iterator iterador = temp.iterator();
            while(iterador.hasNext()){
                Control controlT = (Control)iterador.next();
                String nombreT = controlT.getNombre();                                
                Date tempDate = controlT.getProximoMonitoreo();
                Time tempTime = controlT.getTiempoDeMonitoreo();
                SimpleDateFormat formatoFecha = new SimpleDateFormat();        
                formatoFecha.applyPattern("dd-MM-yyyy");
                String f1,f2;            
                f1 = formatoFecha.format(fecha);
                if (cont <=9 )
                    f1 = "0"+cont+f1.substring(2,10);
                else
                    f1 = cont+f1.substring(2,10);
                f2 = formatoFecha.format(tempDate);

                if(f1.equals(f2)){
                    if(vecDias.elementAt(cont-1) != null)
                            vecDias.elementAt(cont-1).add(new ListaTareas("C: "+controlT.getNombre()));
                    /*
                    ArrayList tempL = controlT.getTareasARealizar();                            
                    Iterator iterador2 = tempL.iterator();
                    int contaIte=0;
                    while(iterador2.hasNext()){
                        Tarea t1 = (Tarea)iterador2.next();
                        //vecDias.insertElementAt(tempL,cont-1);   
                        if(vecDias.elementAt(cont-1) != null)
                            vecDias.elementAt(cont-1).add(new ListaTareas("C: "+t1.getNombre()));
                        contaIte++;
                    } */
                }
            }                    
        }
    }
    
    public void generaListaRiesgo(EntityDB entidadDB,int cont,Date fecha, Vector<ArrayList> vecDias, JPanel[] diasArray, int i){
        
        if(Privilegios.getInstance().ver(entidadDB.getPersona().getRol(),entidadDB.getRiesgos())){//Este objeto en cuestion es tuyo
            ArrayList temp = entidadDB.getRiesgos();           
            Iterator iterador = temp.iterator();
            
            while(iterador.hasNext()){
                Riesgo riesgoT = (Riesgo)iterador.next();
                                                                                    
                Date tempDate = riesgoT.getProximoMonitoreo();
                Time tempTime = riesgoT.getTiempoDeMonitoreo();
                SimpleDateFormat formatoFecha = new SimpleDateFormat();        
                formatoFecha.applyPattern("dd-MM-yyyy");
                String f1,f2;
                f1 = formatoFecha.format(fecha);
                if (cont <=9 )
                    f1 = "0"+cont+f1.substring(2,10);
                else
                    f1 = cont+f1.substring(2,10);

                f2 = formatoFecha.format(tempDate);
                
                if(f1.equals(f2)){
                    if(vecDias.elementAt(cont-1)!=null)
                        vecDias.elementAt(cont-1).add(new ListaTareas("R: "+riesgoT.getAmenaza()));
                }

            }
        }
    }

    public void generaListaActivo(EntityDB entidadDB,int cont,Date fecha, Vector<ArrayList> vecDias, JPanel[] diasArray, int i){
        
        if(Privilegios.getInstance().ver(entidadDB.getPersona().getRol(),entidadDB.getActivos())){//Este objeto en cuestion es tuyo
            ArrayList temp = entidadDB.getActivos();           
            Iterator iterador = temp.iterator();
            
            while(iterador.hasNext()){
                Estructuras.Activo activoT = (Estructuras.Activo)iterador.next();
                
                Date tempDate = activoT.getProximoMonitoreo();
                Time tempTime = activoT.getTiempoDeMonitoreo();
                SimpleDateFormat formatoFecha = new SimpleDateFormat();        
                formatoFecha.applyPattern("dd-MM-yyyy");
                String f1,f2;
                f1 = formatoFecha.format(fecha);
                if (cont <=9 )
                  f1 = "0"+cont+f1.substring(2,10);
                else
                  f1 = cont+f1.substring(2,10);
                f2 = formatoFecha.format(tempDate);

                if(f1.equals(f2)){
                                    
                    if(vecDias.elementAt(cont-1)!=null)
                        vecDias.elementAt(cont-1).add(new ListaTareas("A: "+activoT.getNombre()));
                }
            }                    
        }
    }
    
    
    @Override
    public void mostrarPerfil(Object obj){
        m.mostrarPerfil(obj);
    }
     
    public void generaListaPlan(EntityDB entidadDB,int cont,Date fecha, Vector<ArrayList> vecDias, JPanel[] diasArray, int i){
        
        if(Privilegios.getInstance().ver(entidadDB.getPersona().getRol(),entidadDB.getPlanesDeSoporte())){//Este objeto en cuestion es tuyo
            ArrayList temp = entidadDB.getPlanesDeSoporte();           
            Iterator iterador = temp.iterator();
            while(iterador.hasNext()){
                Estructuras.PlanDeSoporte planT = (Estructuras.PlanDeSoporte)iterador.next();
                String nombreT = planT.getNombre();                                
                Date tempDate = planT.getProximoMonitoreo();
                Time tempTime = planT.getTiempoDeMonitoreo();
                SimpleDateFormat formatoFecha = new SimpleDateFormat();        
                formatoFecha.applyPattern("dd-MM-yyyy");
                String f1,f2;
                f1 = formatoFecha.format(fecha);
                if (cont <=9 )
                    f1 = "0"+cont+f1.substring(2,10);
                else
                    f1 = cont+f1.substring(2,10);
                f2 = formatoFecha.format(tempDate);
                
                if(f1.equals(f2)){

                    ArrayList tempL = planT.getTareasARealizar();                            
                    Iterator iterador2 = tempL.iterator();
                    int contaIte =0;
                    while(iterador2.hasNext()){
                        Tarea t1 = (Tarea)iterador2.next();
                        //vecDias.insertElementAt(tempL,cont-1);   
                        if(vecDias.elementAt(cont-1) != null)
                            vecDias.elementAt(cont-1).add(new ListaTareas("P: "+t1.getNombre()));
                        contaIte++;
                    }                                                                        
                }                            
            }                      
        }
    }
    
    public void insertaEventosCalendario(JPanel[] diasArray){
    
        for(int i =0; i<vecDias.size();i++){            
            if(!vecDias.elementAt(i).isEmpty()){
                try{                                                                        
                    BufferedImage check = ImageIO.read(new File("gCheck.png"));
                    JLabel labelCheck = new JLabel(new ImageIcon(check));
                    if(i<=9)
                        labelCheck.setName("check0"+i);
                    else
                        labelCheck.setName("check"+i);

                    labelCheck.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent ev){
                            Component invoca = (Component) ev.getSource();        
                            //System.out.println("Accion Check: "+invoca);  
                            metodosDeRespuesta(invoca);
                        }
                    });
                    //diasArray[i].add(new JLabel(new ImageIcon(check)));
                    diasArray[i].add(labelCheck);
                } catch (IOException ex) {
                    Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }         
    }
    
    public void prepararPanel(Date fecha){
              
        calendario.removeAll();
        int[] finDeMes = {31,28,31,30,31,30,31,31,30,31,30,31};                  
        int anio,mes,dia,dial;        
        //Date fecha = new Date();
        Calendar cal = Calendar.getInstance();
        EntityDB entidadDB = EntityDB.getInstance();
        
        //System.out.println (fecha);
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        
        dateFormat.applyPattern("dd");
        dia = Integer.parseInt(dateFormat.format(fecha));        
        dateFormat.applyPattern("MM");
        mes = Integer.parseInt(dateFormat.format(fecha));
        dateFormat.applyPattern("yyyy");
        anio = Integer.parseInt(dateFormat.format(fecha));                
        
        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
           finDeMes[1]=29;
        
        cal.set(Calendar.YEAR,anio);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH,mes-1);
	dial = cal.get(Calendar.DAY_OF_WEEK);
        
        //System.out.println("Fecha:: "+dial+" "+dia+"/"+mes+"/"+anio);
                       
        JPanel[] diasArray = new JPanel[38];        
        JLabel dias = new JLabel("Dom       Lun        Mar         Mie         Jue          Vie        Sab   ");
        int x,y,cont,desp;
        JLabel mesLabel = new JLabel("<html>D<br>I<br>C<br>I<br>E<br>M<br>B<br>R<br>E</html>");
        JLabel anioLabel = new JLabel(anio+"");
        JLabel anioSig = new JLabel();;
        JLabel anioAnt = new JLabel();
        JLabel mesSig = new JLabel(); 
        JLabel mesAnt  = new JLabel();
        mesLabel.setBounds(0,80, 20, 300);
        anioLabel.setBounds(480,10, 100, 30);
        anioSig.setBounds(563,6,35,35);
        anioSig.setText(">");
        anioAnt.setBounds(450,6,35,35);
        anioAnt.setText("<");
        mesSig.setBounds(565,42,35,35);
        mesSig.setText(">");
        mesAnt.setBounds(10,42,35,35);
        mesAnt.setText("<");
        anioSig.setFont(new Font("Lucida Grande", 1, 35));
        anioAnt.setFont(new Font("Lucida Grande", 1, 35));
        mesSig.setFont(new Font("Lucida Grande", 1, 20));
        mesAnt.setFont(new Font("Lucida Grande", 1, 20));
        anioSig.setName("anioSig");
        anioAnt.setName("anioAnt");
        mesSig.setName("mesSig");
        mesAnt.setName("mesAnt");
        
        mesLabel.setFont(new Font("Lucida Grande", 1, 20));
        anioLabel.setFont(new Font("Lucida Grande", 1, 30));
        
        anioSig.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                
                metodosDeRespuesta(invoca);
            }
        });
        anioAnt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                        
                metodosDeRespuesta(invoca);
            }
        });
        mesSig.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                        
                metodosDeRespuesta(invoca);
            }
        });
        mesAnt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                Component invoca = (Component) ev.getSource();                        
                metodosDeRespuesta(invoca);
            }
        });
        
        calendario.add(mesLabel);
        calendario.add(anioLabel);
        calendario.add(anioSig);
        calendario.add(anioAnt);
        calendario.add(mesSig);
        calendario.add(mesAnt);
        //calendario.setLayout(new GridLayout(6,7));
        calendario.setLayout(null);
        dias.setBounds(70, 50, 680, 20);
        dias.setFont(new Font("Lucida Grande", 1, 15));
        //dias.setnew java.awt.Color(102, 153, 255)
        calendario.add(dias);
        y=70;
        x=0;
        desp=70;
        cont=0;
        for(int i =0; i<diasArray.length;i++,x++){            
                diasArray[i] = new JPanel();
                diasArray[i].setName(""+(i+1)+"");
                diasArray[i].setBounds(x*70+desp,y, 70, 70);                
                if(i >= (dial-1) && cont<finDeMes[mes-1]){
                    cont++;
                    diasArray[i].setBorder(javax.swing.BorderFactory.createTitledBorder(null, ""+cont+"", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 20), new java.awt.Color(102, 153, 255))); // NOI18N            
                    if(cont==dia)
                    diasArray[i].setBackground(new java.awt.Color(102, 102, 102));
                    //diasArray[i].addMouseListener(new accionesRatonCalendario());                    

                    generaListaControles(entidadDB,cont,fecha,this.vecDias,diasArray,i);
                    generaListaRiesgo(entidadDB,cont,fecha,vecDias,diasArray,i);
                    generaListaPlan(entidadDB,cont,fecha,vecDias,diasArray,i);
                    generaListaActivo(entidadDB,cont,fecha,vecDias,diasArray,i);
                                            
                }  
                calendario.add(diasArray[i]);   

                if (x==6){
                    y+=70;
                    x=-1;
                }
        }
        
        insertaEventosCalendario(diasArray);
        calendario.setVisible(false);         
        calendario.setVisible(true);         
        m.changePanel(1, calendario);
    }

}

class ListaTareas{
    String nombre;
    
    ListaTareas(String a){
        nombre = a;
    }
    
    ListaTareas(){
        nombre = "";
    }
}