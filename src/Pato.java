import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pato {

    private int dominantePico;
    private int dominanteAla;
    private int dominantePata;
    private int pico;
    private int ala;
    private int pata;
    private String nombre;
    private String descripcion;

    public int getPico() {
        return pico;
    }

    public int getPata() {
        return pata;
    }

    public int getAla() {
        return ala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Pato(){
        this.nombre=nombreRandom();
        this.descripcion=descripcionRandom();
        this.dominantePico=(int)(Math.random()*2);
        this.dominanteAla=(int)(Math.random()*2);
        this.dominantePata=(int)(Math.random()*2);
        this.pico=(int)(Math.random()*11);
        //SenZuAliDad
        this.ala=(int)(Math.random()*21)-10;
        //Agua-Fuego

        this.pata=(int)(Math.random()*21)-10;
        //Tierra-Aire


    }
    public Pato(String argentino){
        this.nombre="Argentino supremo";
        this.descripcion="Argentino supremo, es DIOS";
        this.dominantePico=1;
        this.dominanteAla=1;
        this.dominantePata=1;
        this.pico=10;
        //SenZuAliDad
        this.ala=0;
        //Agua-Fuego

        this.pata=0;
        //Tierra-Aire


    }
    public Pato(int num){
        this.nombre=nombreRandom();
        this.descripcion=descripcionRandom();

        this.dominantePico=(int)(Math.random()*2);
        this.dominanteAla=(int)(Math.random()*2);
        this.dominantePata=(int)(Math.random()*2);
        this.pico=Math.abs(num);
        //SenZuAliDad
        this.ala=(int)num;
        //Agua-Fuego

        this.pata=num;
        //Tierra-Aire

    }


    public Pato(Pato padre, Pato madre){
        this.nombre=nombreRandom();
        this.descripcion=descripcionRandom();

        int auxD =(int)(Math.random()*2);//0 o 1
        int aux =(int)(Math.random()*100);
        int mutacion;
        this.dominantePico=Math.abs(auxD*padre.dominantePico+(Math.abs(auxD-1)*madre.dominantePico)-(int)((Math.random()*106)/100));



        if(estaEnPadre(padre.dominantePico,aux)){
            this.pico=padre.pico;
        }else if(estaEnMadre(madre.dominantePico,aux)){
            this.pico=madre.pico;
        }else{
            this.pico=(madre.pico+padre.pico)/2+((madre.pico+padre.pico)%2)*(int)(Math.random()*2);
        }



        mutacion =(int)(Math.random()*2);
        this.pico=this.pico + (mutacion+(Math.abs(mutacion-1)*-1)) *  ((int)(Math.random()*105)/100);
        if(this.pico>10||this.pico<-10){
            if (this.pico>10){
                this.pico=10;
            }else{
                this.pico=-10;
            }
        }


        auxD =(int)(Math.random()*2);

        this.dominanteAla=Math.abs(auxD*padre.dominanteAla+(Math.abs(auxD-1)*madre.dominanteAla)-(int)((Math.random()*106)/100));

        aux =(int)(Math.random()*101);
        if(estaEnPadre(padre.dominanteAla,aux)){
            this.ala=padre.ala;
        }else if(estaEnMadre(madre.dominanteAla,aux)){
            this.ala=madre.ala;
        }else{
            this.ala=(madre.ala+padre.ala)/2+((madre.ala+padre.ala)%2)*(int)(Math.random()*2);
        }
        mutacion =(int)(Math.random()*2);
        this.ala=this.ala+(mutacion+(Math.abs(mutacion-1)*-1)) *  ((int)(Math.random()*105)/100);

        if(this.ala>10||this.ala<-10){
            if (this.ala>10){
                this.ala=10;
            }else{
                this.ala=-10;
            }
        }
// -------------------
        auxD =(int)(Math.random()*2);

        this.dominantePata=Math.abs(auxD*padre.dominantePata+(Math.abs(auxD-1)*madre.dominantePata)-(int)((Math.random()*106)/100));

        aux =(int)(Math.random()*101);
        if(estaEnPadre(padre.dominantePata,aux)){
            this.pata=padre.pata;
        }else if(estaEnMadre(madre.dominantePata,aux)){
            this.pata=madre.pata;
        }else{
            this.pata=(madre.pata+padre.pata)/2+((madre.pata+padre.pata)%2)*(int)(Math.random()*2);
        }
        mutacion =(int)(Math.random()*2);
        this.pata=this.pata+(mutacion+(Math.abs(mutacion-1)*-1)) *  ((int)(Math.random()*105)/100);
        if(this.pata>10||this.pata<-10){
            if (this.pata>10){
                this.pata=10;
            }else{
                this.pata=-10;
            }
        }




    }
    public String nombreRandom(){
        Random rand = new Random();
        List<String> lista = Arrays.asList("Salah", "Eliot", "Elito", "Luis", "Dong", "DogoDONGo", "Alberto",
                "Gilito", "Feo", "Pato", "Donald", "Donald Saxofon", "Daisy", "Juanito", "Jaimito", "Jorgito",
                "Juanero", "Núria", "Patoso", "Patriarca", "Patricio", "Patrimonio", "Brosu", "Álvaro", "Steve",
                "Ronoa Gamer", "Zaida", "Marchando", "Manolo", "Jose Juan", "Tio Alex", "Cheetxs", "AlmansaFlow",
                "Bita", "Lola", "Biuguir", "Rebecca", "Chabe", "Leire", "Aarón", "Burguir", "Azume", "Gendu", "Kevinsito",
                "Croqueta", "HUGOO", "Isa", "Vicky", "Rafa", "Bee", "Lucas", "Sebas", "Miriam", "Raquel", "Pipi", "Ros",
                "Mi Dama", "Diego", "Philip Mila",


                "Raúl");
        int nAleatorio = rand.nextInt(lista.size());
        String elementoAzar = lista.get(nAleatorio);

        return elementoAzar;
    }
    public String descripcionRandom(){
        Random rand = new Random();
        List<String> lista = Arrays.asList(
                "Pato escéptico que no cree que su vida dependa de un ser superior \n" +
                        "que vive en una dimensión superior\n",
                "De naturaleza patosa, siempre mete la pata",
                "No es un pato, pero se identifica como uno",
                "Asesinaron a sus padres en un callejón, para superar el dolor \n" +
                        "emprendió un viaje con el fin de convertirse en Batduck\n",
                "Viajero del tiempo que regresó al pasado para evitar que un dictador \n" +
                        "genocida naciese, fue criticado ampliamente por los patos a los que salvó\n",
                "Pertenece al 0.00000002% de la población de patos que sabe que lo que \n" +
                        "hay debajo de su cuerpo no es una pata sino caracteres Ascii\n",

                "Pato con un P... muy bien dotado, sí, hablo de su Pico",
                "Le gusta mucho comer, pero tarda mucho y odia el pate",

                "Fue una vez a la peluquería y le desplumaron, el corte estaba muy \n" +
                        "caro",
                "Actuó en Patito Feo, era una Divina",
                "Pertenece a una banda de patos apodados ‘Los Patos’, muy originales\n" +
                        "no son",
                "Si se asusta se llena de acido lactico",
                "Su animal espiritual es el humano",
                "Tiene miedo de cruzar la carretera por lo que le paso a la gallina ",
                "Pato antipático ",
                "Es el gracioso de las fiestas, su chiste estrella: ¿Qué le dice un \n" +
                        "pato a otro? Cuak",
                "Pato programador, es capaz de programarte una vida llena de amor \n" +
                        "pato’ la vida",
                "Tiene un pico de oro, habla muy bien, pero no es muy bueno para \n" +
                        "minar obsidiana",
                "Su padre era un pingüino, heredo la capacidad de aguantar el frio",
                "Tuvo un accidente, le tuvieron que poner una prótesis de plástico, \n" +
                        "ahora trabaja surcando los mares de bañeras plagadas de monstruos mitológicos \n" +
                        "llamados “Humanos”",
                "Pato dorado que cree que tiene poderes psíquicos",
                "Pato azul que tiene poderes psíquicos, pero cree ser dorado",
                "Tiene un puerro, va a todos lados con su puerro",
                "Es una Winx, reza a Chayanne 10 todos los días  ",
                "Soluciono el problema del mal olor en las cañerías gracias a ver a \n" +
                        "un pato haciendo el Helicóptero con el cuello",
                "De naturaleza temeraria, no le tiene miedo a las alturas, pero \n" +
                        "siempre lleva un paracaídas consigo\n",
                "Pone huevos y esta hasta ellos de base de datos",
                "Pato acuático, le encanta nadar, pero no puede ni ver el agua de \n" +
                        "Toledo\n",
                "Es otaku, esto supone un problema ya que ha empezado a coger miedo \n" +
                        "al agua",
                "Hey, tu, el que está leyendo esto, voy a romper la 4 pared para \n" +
                        "decirte que comer pan es malo para nosotros porque se nos infla el estomago",
                "Tiene miedo de reproducirse por que ha leído en un comic que la \n" +
                        "probabilidad de que tu hijo mute es de un 5%\n");
        int nAleatorio = rand.nextInt(lista.size());
        String elementoAzar = lista.get(nAleatorio);

        return elementoAzar;
    }
    public boolean estaEnPadre(int dominante, int randHerencia){
        return (randHerencia< 25+dominante*25);
    }
    public boolean estaEnMadre(int dominante, int randHerencia){
        return (randHerencia>=100-(25+dominante*25));
    }
    public void imprimir(){
        System.out.println("");


        System.out.print("Dominante Pico: "+this.dominantePico+" ");
        System.out.print("\uD83E\uDD86"+"(Pico): ");
        //Pato 🦆
        String  estrella ="⛏";
        if (this.pico==10)estrella ="\uD83E\uDD51";
        //Aguacate 🥑
        for (int i = 0; i < this.pico; i++) {
            System.out.print(estrella+" ");
        }




        System.out.println("");
        System.out.print("Dominante Ala:  "+this.dominanteAla+" ");
        System.out.print("\uD83E\uDD86"+"(Ala):  ");
        //Pato 🦆

        if(this.ala>=0){
            estrella ="\uD83D\uDD25";
            //Llama 🔥
            if (this.ala==10)estrella ="☀";
            //Sol ☀
        }else {
            estrella ="\uD83D\uDCA6";
            //Gotas 💦
            if (Math.abs(this.ala)==10)estrella ="\uD83E\uDDCA";
            //Hielo 🧊
        }

        for (int i = 0; i < Math.abs(this.ala); i++) {
            System.out.print(estrella+" ");
        }

        if(this.pata>=0){
            estrella ="\uD83D\uDCA8";
            //Aire 💨
            if (this.pata==10)estrella ="\uD83C\uDF88";
            //Globo 🎈
        }else {
            estrella ="\uD83C\uDF0B";
            //Montaña 🌋
            if (Math.abs(this.pata)==10)estrella ="\uD83C\uDF35";
            //Cactus 🌵
        }
        System.out.println("");
        System.out.print("Dominante Pata: "+this.dominantePata+" ");
        System.out.print("\uD83E\uDD86"+"(Pata): ");
        //Pato 🦆

        for (int i = 0; i < Math.abs(this.pata); i++) {
            System.out.print(estrella+" ");
        }

        System.out.println("");



    }




}
