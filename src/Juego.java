import java.util.ArrayList;
import java.util.Scanner;


public class Juego {
    private Ambiente ambiente;
    ArrayList<Pato> coleccion;

    public Juego(){
        this.ambiente=new Ambiente();
        coleccion = new ArrayList<Pato>(20);
    }


    public void jugar(int inicio){

        Ambiente ambiente =new Ambiente();
        boolean fin =false;
        int respuesta;
        primerosPatos(inicio);
        int suelo,medio,vueltas;
        dibujarColeccionPatos();

        while(!fin){

            respuesta=tratarMenu();
            if(respuesta==0){
                fin=true;
            }else if (respuesta==1){
                reproducir();
                dibujarColeccionPatos();
                eliminar10Peores();
                dibujarColeccionPatos();
            }else if(respuesta==2){
                System.out.println("Pon el numero del pato que quieres ver");
                int patoVer = tratarVerPato();
                dibujarPatoIndicidual(coleccion.get(patoVer));

            }else if(respuesta==3){
                this.ambiente.imprimir_ambiente();
            }
            else if(respuesta==4){
                this.ambiente.imprimir_ambiente();
                System.out.println("Pon el nuevo medio");

                medio=tratarModAmbiente();
                System.out.println("Pon el nuevo suelo");
                suelo=tratarModAmbiente();
                this.ambiente.setMedioSuelo(medio,suelo);
            }else if (respuesta==5){
                System.out.println("Pon el número de generaciones que quieres forzar");
                vueltas=tratarModAmbiente();
                for (int i=0;i<vueltas;i++){
                    System.out.println("Vuelta: "+i);
                    reproducir();
                    dibujarColeccionPatos();
                    eliminar10Peores();
                    dibujarColeccionPatos();
                }
            }else if (respuesta==6){
                coleccion.clear();
                coleccion.add(new Pato("Argentino"));
                primerosPatos(inicio);

                coleccion.remove(5);

                dibujarColeccionPatos();

            }else if (respuesta ==7){
                coleccion.clear();
                primerosPatos(inicio);
            }



        }


    }
    public void dibujarPatoIndicidual(Pato pato){
        System.out.println();
        System.out.println("🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆");

        System.out.println();
        System.out.println("Nombre: "+ pato.getNombre());
        System.out.println("Descripcion: "+ pato.getDescripcion());
        dibujar1(pato);System.out.println();
        dibujar2(pato);System.out.println();
        dibujar3(pato);System.out.println();
        dibujar4(pato);System.out.println();
        dibujar5(pato);System.out.println();
        dibujar6(pato);System.out.println();
        dibujar7(pato);System.out.println();
        pato.imprimir();
        System.out.println("Fitness: "+fitness(pato));
        if (fitness(pato)==40){
            System.out.println("Este pato ya esa adaptado");
        }
        System.out.println("Reproductibilidad: "+reproductividad(pato));
        System.out.println();

        System.out.println("🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆🦆");
        System.out.println();
    }
    public void reproducir( ){
        int i =0;
        for (i=0;i<5;i++){
            coleccion.add(new Pato(coleccion.get(i+0),coleccion.get(i+1)));
            coleccion.add(new Pato(coleccion.get(i+0),coleccion.get(i+1)));
        }




    }
    public int tratarVerPato(){
        int respuesta=-1;
        Scanner pato = new Scanner(System.in);
        respuesta =pato.nextInt();

        return respuesta;
    }
    public int tratarModAmbiente(){
        int respuesta=-1;
        Scanner pato = new Scanner(System.in);

        respuesta =pato.nextInt();



        return respuesta;
    }
    public void imprimirMenu(){
        System.out.println("Que quieres hacer?");
        System.out.println("0: Salir");
        System.out.println("1: Seguir");
        System.out.println("2: Informacion de un pato");
        System.out.println("3: Informacion el ambiente");
        System.out.println("4: Modificar el ambiente");
        System.out.println("5: Forzar numero de generaciones");
        System.out.println("6: Reiniciar");
        System.out.println("7: Activar el modo Argentino");

    }
    public int tratarMenu(){
        int respuesta;
        Scanner sc = new Scanner(System.in);
        imprimirMenu();
        respuesta =sc.nextInt();



        return respuesta;
    }
    public void imprimirColeccionPatos( ){
        for ( Pato pato:coleccion         ) {
            pato.imprimir();
        }

    }
    public void dibujarColeccionPatos( ){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                 PATO SOBRE UNA PATA                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        for (int i =0;i<coleccion.size()/5;i++){
            dibujar1(coleccion.get(i*5+0));
            dibujar1(coleccion.get(i*5+1));
            dibujar1(coleccion.get(i*5+2));
            dibujar1(coleccion.get(i*5+3));
            dibujar1(coleccion.get(i*5+4));
            System.out.println();
            dibujar2(coleccion.get(i*5+0));
            dibujar2(coleccion.get(i*5+1));
            dibujar2(coleccion.get(i*5+2));
            dibujar2(coleccion.get(i*5+3));
            dibujar2(coleccion.get(i*5+4));
            System.out.println();
            dibujar3(coleccion.get(i*5+0));
            dibujar3(coleccion.get(i*5+1));
            dibujar3(coleccion.get(i*5+2));
            dibujar3(coleccion.get(i*5+3));
            dibujar3(coleccion.get(i*5+4));
            System.out.println();
            dibujar4(coleccion.get(i*5+0));
            dibujar4(coleccion.get(i*5+1));
            dibujar4(coleccion.get(i*5+2));
            dibujar4(coleccion.get(i*5+3));
            dibujar4(coleccion.get(i*5+4));
            System.out.println();
            dibujar5(coleccion.get(i*5+0));
            dibujar5(coleccion.get(i*5+1));
            dibujar5(coleccion.get(i*5+2));
            dibujar5(coleccion.get(i*5+3));
            dibujar5(coleccion.get(i*5+4));
            System.out.println();
            dibujar6(coleccion.get(i*5+0));
            dibujar6(coleccion.get(i*5+1));
            dibujar6(coleccion.get(i*5+2));
            dibujar6(coleccion.get(i*5+3));
            dibujar6(coleccion.get(i*5+4));
            System.out.println();
            dibujar7(coleccion.get(i*5+0));
            dibujar7(coleccion.get(i*5+1));
            dibujar7(coleccion.get(i*5+2));
            dibujar7(coleccion.get(i*5+3));
            dibujar7(coleccion.get(i*5+4));
            System.out.println();
            System.out.println();
            System.out.println("            "+(i*5+0)+"           "+"            "+(i*5+1)+"           "+"            "+(i*5+2)+"           "+"            "+(i*5+3)+"           "+"            "+(i*5+4));
            System.out.println();
            System.out.println();

        }
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                  COLECCION DE PATOS                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");


    }
    public void dibujar1(Pato pato){
        if (pato.getPico()==10){
            System.out.print("           ╔╗           ");
        }else{
            System.out.print("                        ");
        }


    }
    public void dibujar2(Pato pato){
        if (pato.getPico()==10){
            System.out.print("           ╩╩           ");
        }else{
            System.out.print("                        ");
        }

    }
    public void dibujar3(Pato pato){
        System.out.print("          ▄██▄▄");
        String pico ="▄";
        int contador =0;
        for (int i =0;i<9;i++){
            if(!(contador< pato.getPico())){
                pico =" ";
            }
            contador++;
            System.out.print(pico);
        }


    }
    public void dibujar4(Pato pato){
        System.out.print(" ▄▄█████▄ ██▀           ");
    }
    public void dibujar5(Pato pato){
        System.out.print("▀██");
        String borde="";

        if (pato.getAla()==0){
            System.out.print("█████");
        }else{
            if (pato.getAla()>0){
                borde="║";
                if (pato.getAla()>=9){
                    borde="╬";
                }

            }else{
                borde="<";
                if (Math.abs(pato.getAla()) >=9){
                    borde="«";
                }

            }
            if (Math.abs(pato.getAla()) ==10){
                System.out.print(borde+borde+borde+borde+borde);
            }else{
                int cero, uno, dos,aux;
                aux =Math.abs(pato.getAla())-1;
                if (aux==8){
                    aux--;
                }
                cero =aux%2;
                aux=aux/2;
                uno =aux%2;
                aux=aux/2;
                dos=aux;



                System.out.print(borde+dos+""+uno+""+cero+""+borde);
            }
        }



        System.out.print("██▄██▄          ");


    }
    public void dibujar6(Pato pato){

        System.out.print("  ");
        String borde="";

        if (pato.getPata()==0){
            System.out.print("▀██████████▀");
        }else{
            String principio="▀";
            String fin="▀";
            String medio="█";

            String dos="█";
            String tres="█";
            String cuatro="█";
            String cinco="█";
            String seis="█";
            String siete="█";
            String ocho="█";
            String nueve="█";
            if (pato.getPata()<0){
                if(Math.abs(pato.getPata())==10){
                    System.out.print("╚╩╩╩╩╬╩╩╩╩╩╝");
                }else {
                    principio="╚";
                    fin="╝";
                    medio="╦";
                    if(Math.abs(pato.getPata())>1) dos="═";
                    if(Math.abs(pato.getPata())>2) tres="═";
                    if(Math.abs(pato.getPata())>3) cuatro="═";
                    if(Math.abs(pato.getPata())>4) cinco="═";
                    if(Math.abs(pato.getPata())>5) seis="═";
                    if(Math.abs(pato.getPata())>6) siete="═";
                    if(Math.abs(pato.getPata())>7) ocho="═";
                    if(Math.abs(pato.getPata())>8) nueve="═";

                }
            }else{
                if(Math.abs(pato.getPata())==10){
                    System.out.print("└┴┴┴┴┼┴┴┴┴┴┘");
                }else {
                    principio="└";
                    fin="┘";
                    medio="┬";
                    if(Math.abs(pato.getPata())>1) dos="~";
                    if(Math.abs(pato.getPata())>2) tres="~";
                    if(Math.abs(pato.getPata())>3) cuatro="~";
                    if(Math.abs(pato.getPata())>4) cinco="~";
                    if(Math.abs(pato.getPata())>5) seis="~";
                    if(Math.abs(pato.getPata())>6) siete="~";
                    if(Math.abs(pato.getPata())>7) ocho="~";
                    if(Math.abs(pato.getPata())>8) nueve="~";

                }



            }if(Math.abs(pato.getPata())!=10){
                System.out.print(principio+tres+cinco+siete+nueve+medio+nueve+ocho+seis+cuatro+dos+fin);
            }

        }



        System.out.print("          ");



    }
    public void dibujar7(Pato pato){
        System.out.print("       █▄▄              ");

    }



    public void primerosPatos( int inicio){
        if (inicio>10){
            for (int i = 0; i < 10&&i > -10; i++) {
                coleccion.add(new Pato());
            }
        }else{
            for (int i = 0; i < 10; i++) {
                coleccion.add(new Pato(inicio));
            }

        }

    }
    public void eliminar10Peores( ){
        while(coleccion.size()>11){
            int patoMenor=0;
            int menorReproductividad= reproductividad(coleccion.get(0));
            for (int i =0;i<coleccion.size();i++){
                if (reproductividad(coleccion.get(i))<menorReproductividad){
                    patoMenor=i;
                    menorReproductividad=reproductividad(coleccion.get(i));

                }

            }


            coleccion.remove(patoMenor);

        }


        coleccion.remove(1);
    }

    public int fitness(Pato pato){
        int fitness;
        fitness=20-Math.abs(ambiente.getMedio()-pato.getAla())+20-Math.abs(ambiente.getSuelo()-pato.getPata());
        return fitness;

    }
    public int reproductividad(Pato pato){

        return pato.getPico() * 2 + 20 - Math.abs(ambiente.getMedio() - pato.getAla()) + 20 - Math.abs(ambiente.getSuelo() - pato.getPata());


    }



}
