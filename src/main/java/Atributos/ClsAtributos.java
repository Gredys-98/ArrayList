
package Atributos;

import java.text.NumberFormat;
import java.util.*;


public class ClsAtributos {
    
    Scanner teclado = new Scanner(System.in);
    public static NumberFormat formatoCantidad = NumberFormat.getCurrencyInstance(new Locale("es","GT"));
    List<ClsDatos> lista = new ArrayList<>();
    
    
    public ClsDatos IngresoInformacion (){
        
        ClsDatos Dato = new ClsDatos();
  
        System.out.println("Ingrese nombre del vendedor");
        Dato.setNombre(teclado.nextLine());
        
        System.out.println("Ingrese la venta de Enero");
        Dato.setVenero(teclado.nextInt());
                
        System.out.println("Ingrese la venta de Febrero");
        Dato.setVfebrero(teclado.nextInt());
        
        System.out.println("Ingrese la venta de Marzo");
        Dato.setVmarzo(teclado.nextInt());
        teclado.nextLine();
        
        lista.add(Dato);
        return Dato;
    }
   
    public static String cambiarFormato(double cantidad){
        return formatoCantidad.format(cantidad);
    }
    
    public void CargarInfo(){
        
        for(ClsDatos ele: lista){
            
            System.out.println(ele.getNombre() + "       " + cambiarFormato(ele.getVenero()) +"     "+ cambiarFormato(ele.getVfebrero()) +"     "+ cambiarFormato(ele.getVmarzo()));
        }
    }
   
    public void Sumar(){
        
       double totalEnero = 0;
       double totalFebrero = 0;
       double totalMarzo = 0;
       
       for( ClsDatos ele: lista){
           totalEnero += ele.getVenero();
           totalFebrero += ele.getVfebrero();
           totalMarzo += ele.getVmarzo();
       }
       double GranTotal = totalEnero+totalFebrero+totalMarzo;
        System.out.println("Venta total hasta la fecha: "+ GranTotal);
        System.out.println("Venta total de Enero: " + totalEnero);
        System.out.println("Venta total de Febrero: " + totalFebrero);
        System.out.println("Venta total de Marzo: " + totalMarzo);
      
    }
 
    public void CargarTotal(){
         for(ClsDatos datos : lista){  
        
        datos.setTotal(datos.Venero + datos.Vfebrero + datos.Vmarzo);
        }
    }
    public void VentaMAyor(){
        
        CargarTotal();
        if(lista.get(0).getTotal() > lista.get(1).getTotal() && lista.get(0).getTotal()> lista.get(2).getTotal()){
            System.out.println(lista.get(0).getNombre() +"  "+ lista.get(0).getTotal());
        }else if(lista.get(1).getTotal() > lista.get(0).getTotal() && lista.get(1).getTotal()> lista.get(2).getTotal()){
            System.out.println(lista.get(1).getNombre() +"  "+ lista.get(1).getTotal());
        }else{
            System.out.println(lista.get(2).getNombre() +"  "+ lista.get(2).getTotal());
        }
    }     
    public void QuienVendioMenos(){
        CargarTotal();
        if(lista.get(0).getTotal() < lista.get(1).getTotal() && lista.get(0).getTotal()< lista.get(2).getTotal()){
            System.out.println(lista.get(0).getNombre() +"  "+ lista.get(0).getTotal());
        }else if(lista.get(1).getTotal() < lista.get(0).getTotal() && lista.get(1).getTotal() < lista.get(2).getTotal()){
            System.out.println(lista.get(1).getNombre() +"  "+ lista.get(1).getTotal());
        }else{
            System.out.println(lista.get(2).getNombre() +"  "+ lista.get(2).getTotal());
        }
    }
    
    public void Busqueda_Cantidad(){
     double valor=0;
     int indice =0;
     System.out.println("Ingrese el Valor que desea Buscar");
     valor= teclado.nextDouble();
     indice= lista.indexOf(valor);
     if(indice!=-1){
     System.out.println("El dato se encuentra en el indice "+indice);
 
     }else{
              System.out.println("El dato nose encuentra en el rango");
     }
    }
    public void editar_registro(){
     ClsDatos Dato = new ClsDatos();
     double valor;
     int indice;
     System.out.println("cual es el valor que deseas modificar");
     
     valor = teclado.nextDouble();
     indice = lista.indexOf(valor);
     if(indice !=-1){
     System.out.println("ingresa el nuevo valor que deseas");
     valor=teclado.nextDouble();
     lista.set(indice, Dato);
     
     }else {
     System.out.println("El dato nose encuentra en el rango");
     }
     
     }
   
    public void Menu(){
         Scanner t = new Scanner(System.in);
            String opc =" ";
            
            do{
            System.out.println("1- Ingreso de Informacion");
            System.out.println("2- Desplegar toda la informacion");
            System.out.println("3- Quien vendio menos (3 meses)");
            System.out.println("4- Quien Vendio Mas(3 meses)");
            System.out.println("5- Editar registro");
            System.out.println("6- Busqueda por cantidad");
            System.out.println("7- Totales por mes");
            System.out.println("8- Salir del programa ;)");
            opc = t.nextLine();
            
            switch(opc){
                case"1": IngresoInformacion();
                break;
                case"2": CargarInfo();
                break;
                case"3": QuienVendioMenos();
                break;
                case"4": VentaMAyor();
                break;
                case"5": editar_registro();
                break;
                case"6": Busqueda_Cantidad();
                break;
                case"7": Sumar();
                break;
                
                
                
            }
        }while(!opc.equals("8"));
            
    }
}
