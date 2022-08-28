package typingTutor;

import java.util.concurrent.atomic.AtomicBoolean;

//Thread to monitor the word that has been typed.
public class CatchWord extends Thread {
	String target;
	static AtomicBoolean done ; //REMOVE
	static AtomicBoolean pause; //REMOVE
	
	private static  FallingWord[] words; //list of words
	private static int noWords; //how many
	private static Score score; //user score
	public static HungryWordMover hgy;

	volatile int lowPos = 0;
	
	CatchWord(String typedWord) {
		target=typedWord;
	}
	
	public static void setWords(FallingWord[] wordList) {
		words=wordList;	
		noWords = words.length;
	}
	
	public static void setScore(Score sharedScore) {
		score=sharedScore;
	}
	
	public static void setFlags(AtomicBoolean d, AtomicBoolean p) {
		done=d;
		pause=p;
	}
	
	//The run method was altered to ensure that the lowest duplicate would be the first word to dissapper
	public void run() {

		int i=0;
		

		while (i<noWords) {		
			while(pause.get()) {};

			lowPos = i;
			for(int counter3 = 0; counter3< noWords; counter3++){


				if(words[i].getWord().equals(target) && words[counter3].getWord().equals(words[i].getWord()) && words[counter3].getY() >  words[i].getY()){

					lowPos = counter3;


				}
					
				
			}

			

			if(words[lowPos].matchWord(target) || hgy.mtchWord(target)){

				System.out.println( " score! '" + target); //for checking
				score.caughtWord(target.length());	
				//FallingWord.increaseSpeed();
				break;
	
	
			}

					
				
		
		   i++;
		}

	}	
}
