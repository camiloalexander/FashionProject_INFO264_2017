
package Controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    Calendar fecha = new GregorianCalendar();
    int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int hora = fecha.get(Calendar.HOUR_OF_DAY);
    int minuto = fecha.get(Calendar.MINUTE);
    int segundo = fecha.get(Calendar.SECOND);
    String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public String obtenerFecha(){
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        String fechaConcatenada = Integer.toString(año) +"-"+ Integer.toString(mes+1) +"-"+ Integer.toString(dia);
        //System.out.println("Fecha Actual: "+ dia + "/" + (mes+1) + "/" + año);
        //System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);
        return fechaConcatenada;
    }
    public String fechaParaMostrar(){
        String fechaConcatenada = Integer.toString(dia) +"-"+ meses[mes] +"-"+ Integer.toString(año);
        return fechaConcatenada;
    }
}
