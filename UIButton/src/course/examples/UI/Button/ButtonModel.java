package course.examples.UI.Button;

import java.util.Observable;

public class ButtonModel extends Observable{

private int counter;

public int getCounter(){
	return counter;
}

public void setCounter(int counter){
	this.counter=counter;
	setChanged();
	notifyObservers();
}

public void increaseCounter(int num){
	counter+=num;
	setChanged();
	notifyObservers();
}

public void decreaseCounter(int num) {
	counter-=num;
	setChanged();
	notifyObservers();
}
}
