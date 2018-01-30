package emtiy;

import java.util.Arrays;

public class snake {
	int bodylong;
	Point head;
	Point ps[];
	String way;
	public int getBodylong() {
		return bodylong;
	}
	public void setBodylong(int bodylong) {
		this.bodylong = bodylong;
	}
	public Point getHead() {
		return head;
	}
	public void setHead(Point head) {
		this.head = head;
	}
	public Point[] getPs() {
		return ps;
	}
	public void setPs(Point[] ps) {
		this.ps = ps;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	@Override
	public String toString() {
		return "snake [bodylong=" + bodylong + ", head=" + head + ", ps=" + Arrays.toString(ps) + ", way=" + way + "]";
	}
	public snake(int bodylong, Point head, Point[] ps, String way) {
		super();
		this.bodylong = bodylong;
		this.head = head;
		this.ps = ps;
		this.way = way;
	}
	public snake() {
		super();
		// TODO Auto-generated constructor stub
		ps=new Point[6];
		ps[0]=new Point(6,5);
		ps[1]=new Point(5,5);
		ps[2]=new Point(5,4);
		ps[3]=new Point(4,4);
		ps[4]=new Point(4,3);
		ps[5]=new Point(3,3);
		bodylong=ps.length;
		head=ps[0];
		way="d";
	}
	public void add(int x, int y) {
		// TODO Auto-generated method stub
		ps=Arrays.copyOf(ps, ps.length+1);
		ps[ps.length-1]=new Point(x,y);
	}
	public Point[] snakeadd(){
		Point m=ps[0];
		for(int i=ps.length-1;i>=0;i--){
			if(i!=0){
				ps[i]=new Point(ps[i-1].getX(),ps[i-1].getY());
			}
			else{
				if(way.equals("d")){
					ps[0]=new Point(m.getX()+1,m.getY());
				}
				else if(way.equals("a")){
					ps[0]=new Point(m.getX()-1,m.getY());
				}
				else if(way.equals("w")){
					ps[0]=new Point(m.getX(),m.getY()-1);
				}
				else if(way.equals("s")){
					ps[0]=new Point(m.getX(),m.getY()+1);
				}
			}
		}
		return ps;
	}	
}
