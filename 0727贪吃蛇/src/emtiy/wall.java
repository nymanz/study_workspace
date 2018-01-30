package emtiy;

import java.awt.Container;
import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.Scanner;

public class wall {
	Point point;
	int wallwidth;
	int wallheight;
	snake snake;

	public int getWallwidth() {
		return wallwidth;
	}

	public void setWallwidth(int wallwidth) {
		this.wallwidth = wallwidth;
	}

	public int getWallheight() {
		return wallheight;
	}

	public void setWallheight(int wallheight) {
		this.wallheight = wallheight;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "wall [point=" + point + ", wallwidth=" + wallwidth + ", wallheight=" + wallheight + "]";
	}

	public wall(Point point, int wallwidth, int wallheight) {
		super();
		this.point = point;
		this.wallwidth = wallwidth;
		this.wallheight = wallheight;
		snake =new snake();
	}
	public wall() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void buildwall(Point point, int wallwidth, int wallheight,Point[] ps,Point[] food){
		for(int i=1;i<wallheight;i++){
			for(int j=1;j<wallwidth;j++){
				if(i==1||i==wallheight-1||j==1||j==wallwidth-1){
					System.out.print("#");
				}
				else if(contain(i,j,ps)){
					System.out.print("$");
				}
				else if(contain(i,j,food)){
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}	
			}
			System.out.println("");
		}
	}
	public boolean contain(int x,int y,Point[] ps){
		for(int i=0;i<ps.length;i++){
			if(x==ps[i].y&&y==ps[i].x){
				return true;
			}
		}
		return false;
	}

	
}
