public class Ambiente {
    private int medio;
    //para el ala
    private int suelo;
    //para la pata
    public Ambiente(){
        this.medio=(int)(Math.random()*21)-10;
        this.suelo=(int)(Math.random()*21)-10;
    }

    public void setMedio(int medio) {
        if(this.medio>10){
            this.medio = 10;
        }else if (this.medio<-10){
            this.medio = -10;
        }else this.medio = medio;
    }
    public void setMedioSuelo(int medio,int suelo) {
        setMedio( medio);
        setSuelo( suelo);
    }

    public void setSuelo(int suelo) {
        if(this.suelo>10){
            this.suelo = 10;
        }else if (this.suelo<-10){
            this.suelo = -10;
        }else this.suelo = suelo;

    }


    public int getMedio() {
        return medio;
    }

    public int getSuelo() {
        return suelo;
    }
    public void imprimir_ambiente() {
        String estrella;
        System.out.println("");

        System.out.print("\uD83E\uDD51"+"(medio): ");
        //aguacate

        if(this.medio>=0){
            estrella ="\uD83D\uDD25";
            //Llama 🔥
            if (this.medio==10)estrella ="☀";
            //Sol ☀
        }else {
            estrella ="\uD83D\uDCA6";
            //Gotas 💦
            if (Math.abs(this.medio)==10)estrella ="\uD83E\uDDCA";
            //Hielo 🧊
        }

        for (int i = 0; i < Math.abs(this.medio); i++) {
            System.out.print(estrella+" ");
        }

        if(this.suelo>=0){
            estrella ="\uD83D\uDCA8";
            //Aire 💨
            if (this.suelo==10)estrella ="\uD83C\uDF88";
            //Globo 🎈
        }else {
            estrella ="\uD83C\uDF0B";
            //Montaña 🌋
            if (Math.abs(this.suelo)==10)estrella ="\uD83C\uDF35";
            //Cactus 🌵
        }
        System.out.println("");

        System.out.print("\uD83E\uDD51"+"(suelo): ");
        //aguacate

        for (int i = 0; i < Math.abs(this.suelo); i++) {
            System.out.print(estrella+" ");
        }

        System.out.println("");
        System.out.println();


    }

}
