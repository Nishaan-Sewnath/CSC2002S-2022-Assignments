package typingTutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class WordMover extends Thread {
	private FallingWord myWord;
	private HungryWordMover Myhung;
	private AtomicBoolean done;
	private AtomicBoolean pause; 
	private Score score;
	CountDownLatch startLatch; //so all can start at once
	
	WordMover( FallingWord word, HungryWordMover hung) {
		myWord = word;
		Myhung = hung;
	}
	
	WordMover( FallingWord word, HungryWordMover hung, WordDictionary dict, Score score,
			CountDownLatch startLatch, AtomicBoolean d, AtomicBoolean p) {
		this(word, hung);
		this.startLatch = startLatch;
		this.score=score;
		this.done=d;
		this.pause=p;
	}
	
	
	
	public void run() {

		//System.out.println(myWord.getWord() + " falling speed = " + myWord.getSpeed());
		try {
			System.out.println(myWord.getWord() + " waiting to start " );
			startLatch.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //wait for other threads to start
		System.out.println(myWord.getWord() + " started" );
		while (!done.get()) {				
			//animate the word
			while (!myWord.dropped() && !done.get()) {
				    myWord.drop(10);
					Myhung.slide(10);

					//checks if the hungry word has falled off Screen
					if(Myhung.OffScreen() && !done.get()){

						score.missedWord();
						Myhung.rsWord();
						
					}

					//below if statment checks if two words have collided
					if(!done.get() && Myhung.gtX()>=myWord.getX()-30 && Myhung.gtX()<=myWord.getX()+10 && myWord.getY()>220 && myWord.getY()<300){

						System.out.println("Hit hungry word!");
						score.missedWord();
						myWord.resetWord();
						Myhung.rsWord();
		
		
					}
					
					try {
						sleep(myWord.getSpeed());
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};		
					while(pause.get()&&!done.get()) {};
			}


			if (!done.get() && myWord.dropped()) {
				score.missedWord();
				myWord.resetWord();
			}
			


			myWord.resetWord();
			
		}
	}
	
}
