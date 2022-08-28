package typingTutor;

public class HungryWordMover{

    private String Hword;

    private int x, y, maxX;
    private int slidingSpeed;
    private static int slidingMax = 1000;
    private static int slidingMin = 100;

    private boolean ofs, go;
    public static WordDictionary wd;

    //constructors

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
        

    }

    public HungryWordMover(String text, int x, int MaxX){

        this(text);
        this.x = x;
        this.maxX = maxX;


    }

    //below two methods concerning the speed of the word

    public static void IncSpeed(){

        slidingMax+=50;
        slidingMin+=50;

    }

    public static void rsSpeed(){

        slidingMax = 1000;
        slidingMin = 100;

    }

    //gets the words as a string
    public String getHungryWord(){

        return Hword;
    }




    //sets the x and y coordinates of the word and checks if x goes over the boundary
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

    //sets the contents of the word
    public void stword(String text){

        this.Hword = text;

    }

    //gets the word in a string format
    public String gtWord(){

        return Hword;

    }

    //below two methods are getter methods for the x and y coordinates
    public int gtX(){

        return x;

    }

    public int gtY(){

        return y;

    }


    public int gtSpeed(){

        return slidingSpeed;

    }


    public void stPos(int x, int y){//sets the position of the word if necessary

        stX(x);
        stY(y);

    }

    public void rsPos(){//resets the words position

        stX(0);

    }


    public void rsWord(){// resets the words

        rsPos();
        Hword = wd.getNewWord();
        ofs = false;
        slidingSpeed = (int)(Math.random() * (slidingMax-slidingMin)+slidingMin);

    }

    public boolean mtchWord(String typedText) {//Similar to the matchingWords method in Falling words
		
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
