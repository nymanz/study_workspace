package move;

import java.util.Scanner;

import emtiy.Point;
import emtiy.food;
import emtiy.snake;
import emtiy.wall;

public class move {

	public static void main(String[] args) {

		Point point = new Point(1,1);
		wall wall = new wall(point,13,13);
		snake snake=new snake();
		food food=new food();
		food.givefood(snake.getPs());
		wall.buildwall(point,wall.getWallwidth(),wall.getWallheight(),snake.getPs(),food.getFood());
		String direct="";
		while(!direct.equals("u")){
			Scanner scanner=new Scanner(System.in);
			direct=scanner.next();
			if(direct.equals("d")||direct.equals("a")||direct.equals("w")||direct.equals("s")){
				snake.setWay(direct);
				snake.snakeadd();
			}
			int i;
			for(i=1;i<snake.getPs().length;i++){
				if(snake.getPs()[0].getX()==snake.getPs()[i].getX()&&snake.getPs()[0].getY()==snake.getPs()[i].getY()){
					break;
				}
			}
			if(i!=snake.getPs().length){
				System.out.println("咬到自己了");
				break;
			}
			if(snake.getPs()[0].getX()==food.getFood()[0].getX()&&snake.getPs()[0].getY()==food.getFood()[0].getY()){
				snake.add(food.getFood()[0].getX(),food.getFood()[0].getY());
				food.givefood(snake.getPs());
			}
			if(snake.getPs()[0].getX()<=1||snake.getPs()[0].getX()>=wall.getWallwidth()-1||snake.getPs()[0].getY()<=1||snake.getPs()[0].getY()>=wall.getWallheight()-1){
				System.out.println("撞墙了");
				break;
			}
			wall.buildwall(point, wall.getWallwidth(),wall.getWallheight(),snake.getPs(),food.getFood());
			
			
		}
	}

}
