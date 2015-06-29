package geometrie;

//Rectangle
public class Rectangle {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	//Point Haut-Gauche
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	//Point Bas-Droite
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	//Constructeur defaut
	public Rectangle(){
		this.setX1(0);
		this.setY1(0);
		this.setX2(2);
		this.setY2(1);
	}
	
	//Constructeur paramétré
	public Rectangle(int x1, int y1, int x2, int y2){
		this.setX1(x1);
		this.setY1(y1);
		this.setX2(x2);
		this.setY2(y2);
	}
	
	//getAire
	public int getAire() {
		return((x2-x1)*(y2-y1));
	}
	
	//toString
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Coord HG : "+ x1 + " "+ y1 + "\n");
		sb.append("Coord BD : "+ x2 + " "+ y2 + "\n");
		
		for(int i = 0; i < getY2(); i++){

			sb.append("\n|");

			for(int j = 0; j < getX2(); j++){
				if (i==0 || i== getY2()-1){
					sb.append("- ");
				}
				else{
					sb.append("  ");
				}
			}

			sb.append("|");
			}
		
		return sb.toString();
	} 
	
}
