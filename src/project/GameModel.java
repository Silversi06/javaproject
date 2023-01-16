package project;

public class GameModel { 
	Player player;
	Car car;
	Car2 car2;
	Car3 car3;
	Car4 car4;
	
	GameModel(){
		this.player = new Player();
		this.car = new Car();
		this.car2=new Car2();
		this.car3=new Car3();
		this.car4=new Car4();
	}
}
