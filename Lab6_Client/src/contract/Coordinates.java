package contract;

import java.io.Serializable;

public class Coordinates implements Serializable{
    private int x; //Максимальное значение поля: 242, Поле не может быть null
    private int y; //Значение поля должно быть больше -311
    
    public Coordinates(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public int getX() {
    	return (int) x;
    }
    public int getY() {
    	return y;
    }
}
