/*
 * Lab8 implementation of inheritance by Michael Loewe Alivio, Michael Ervin Pacana and Juan Carlos Roldan
 */

//imported for use of PI constant
import static java.lang.Math.PI;

//derived class from Shape class
public class Circle extends Shape{
	protected double radius;

	public Circle(){
		super();
		radius = 1.0;
	}

	public Circle(double radius){
		super();
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled){
		super(color,filled);
		this.radius = radius;
	}

	public double getRadius(){ return radius; }

	public void setRadius(double radius){
		this.radius = radius;
	}

	public double getArea(){
		return radius * radius * PI;
	}

	public double getPerimeter(){
		return radius * 2 * PI;
	}

	public String toString(){
		String shape;
		shape = String.format("A Circle with radius = %.2f which is a subclass of %s",radius, super.toString());
		return shape;
	}
}
