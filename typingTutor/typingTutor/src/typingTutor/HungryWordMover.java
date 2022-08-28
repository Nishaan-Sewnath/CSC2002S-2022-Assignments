package typingTutor;

public class HungryWordMover{

    private String Hword;

    private int x, y, maxX;
    private int slidingSpeed;
    private static int slidingMax = 1000;
    private static int slidingMin = 100;

    private boolean ofs, go;



    //GamePanel gp;

    //public static WordDictionary dict;

    public HungryWordMover(){

        Hword = "Hungry";
        x = 0;
        y = 0;
        maxX = 1000;
        ofs = false;
        slidingSpeed = (int)(Math.random() * (slidingMax-slidingMin)+slidingMin);
        go = true;


    }

    public HungryWordMover(String text){

        this();
        Hword = text;
        //this.ofs = false;

    }

    public HungryWordMover(String text, int x, int MaxX){

        this(text);
        this.x = x;
        //this.ofs = false;
        this.maxX = maxX;


    }
 

    public static void IncSpeed(){

        slidingMax+=50;
        slidingMin+=50;

    }

    public static void rsSpeed(){

        slidingMax = 1000;
        slidingMin = 100;

    }

    public String getHungryWord(){

        return Hword;
    }




    public void stX(int x){

        if(x>maxX){

            rsWord();
            setScreen(true);

        }

        this.x = x;

    }

    public void stY(int y){

        this.y = y;

    }

    public void stword(String text){

        this.Hword = text;

    }

    public String gtWord(){

        return Hword;

    }

    public int gtX(){

        return x;

    }

    public int gtY(){

        return y;

    }


    public int gtSpeed(){

        return slidingSpeed;

    }


    public void stPos(int x, int y){

        stX(x);
        stY(y);

    }

    public void rsPos(){

        stX(0);

    }


    public void rsWord(){

        rsPos();
        Hword = TypingTutorApp.dict.getNewWord();
        ofs = false;
        slidingSpeed = (int)(Math.random() * (slidingMax-slidingMin)+slidingMin);

    }

    public boolean mtchWord(String typedText) {
		//System.out.println("Matching against: "+text);
		if (typedText.equals(this.Hword)) {
			rsWord();
			return true;
		}
		else
			return false;
	}


    public void slide(int inc){
        
        stX(x+inc);

    }

    public boolean OffScreen(){

        return ofs;

    }



    public boolean strt(){

        return go;

    }

    public void setGo(boolean gettingHungry){

        this.go = gettingHungry;

    }


    public void setScreen(boolean isOff){

        this.ofs = isOff;

    }
    



}
