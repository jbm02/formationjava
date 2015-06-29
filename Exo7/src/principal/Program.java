package principal;

import geometrie.*;

public class Program {

	public static void main(String[] args) {
		Figure[] tb_fig = new Figure[4];
		tb_fig[0] = new Triangle();
		tb_fig[1] = new Rectangle();
		tb_fig[2] = new Triangle();
		tb_fig[3] = new Rectangle();
		
		for(Figure f : tb_fig){
			f.type();
		}
	}

}
