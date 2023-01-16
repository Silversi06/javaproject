package project;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GameController extends KeyAdapter implements Runnable {
	boolean keyUp;
	boolean keyDown;
	boolean keyLeft;
	boolean keyRight;
    public boolean gameover;
	public boolean red,green;
	project project;
	GameModel model;
	public GameController(GameModel model, project project) {
		this.model = model;
		this.project = project;
		gameover = false;
	}

    // 키가 눌렸을 때
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W :
                this.keyUp = true;
                break;
            case KeyEvent.VK_S :
                this.keyDown = true;
                break;
            case KeyEvent.VK_A :
                this.keyLeft = true;
                break;
            case KeyEvent.VK_D :
                this.keyRight = true;
                break;
        }
    }

    // 키가 눌렀다 때졌을 때.
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W :
                this.keyUp = false;
                break;
            case KeyEvent.VK_S :
                this.keyDown = false;
                break;
            case KeyEvent.VK_A :
                this.keyLeft = false;
                break;
            case KeyEvent.VK_D :
                this.keyRight = false;
                break;
        }
    }

    // 키에 대한 처리.
    public void keyProcess() {
        if(this.keyUp){
        	System.out.println("up1");
                this.model.player.y -= 10;
        }

        if(this.keyDown){
                this.model.player.y += 10;
        }

        if(this.keyLeft){
                this.model.player.x -= 10;
        }

        if(this.keyRight){
                this.model.player.x += 10;
        }
    }
    
    public void redProcess() { // 만약 red가 true일때 model.player의 x나 y값이 횡단보도의 좌표를 넘어가면 gameover
    	//todo
    	if(red) {
    		if(this.model.player.y>30 && this.model.player.y<650) {
        		System.out.println("gameover");
        		if(!gameover) {
        		project.setGameoverPanel();
        		gameover = true;
        		}
    			//gameover
    		}
    		else if(this.model.player.x >500 && this.model.player.x<1200) {
        		System.out.println("gameover");
        		if(!gameover) {
        		project.setGameoverPanel();
        		gameover = true;
        		}
        		/*else if(!gameover) {
        			project.setGreatPanel();
        			gameover=false;
        		}*/
    		}
    	}
    }
    
    public void carProcess() {
    	if(red) {
    		
    			model.car.move();model.car2.move(); model.car3.move(); model.car4.move();
    			if(Crash(this.model.player,model.car,model.car2,model.car3,model.car4)) {
    				if(!gameover) {	//차에 닿으면 gameover
    					project.setGameoverPanel();
    					gameover = true;
    				}
    				this.model.player.hp -= 1;
    				System.out.println(model.player.hp);
    				}
    			}
    	
    }
    
    // 충돌 체크
    public boolean Crash(Player go1, Car go2,Car2 go3, Car3 go4, Car4 go5){
        // 위치값, 이미지의 높이와 길이를 이용하여 충돌 체크
        boolean check = false;
        if(Math.abs((go1.x + go1.width / 2) - ( go2.x + go1.width / 2)) < ( go2.width / 2 + go1.width / 2) &&
                Math.abs( (go1.y + go1.height / 2) - (go2.y + go2.height / 2)) < ( go2.height /2 + go1.height / 2)||
                (Math.abs( (go1.x + go1.width / 2) - (go3.x + go1.width / 2)) < ( go3.width /2 + go1.width / 2)&&
                Math.abs( (go1.y + go1.height / 2) - (go3.y + go3.height / 2)) < ( go3.height /2 + go1.height / 2))||
                (Math.abs( (go1.x + go1.width / 2) - (go4.x + go1.width / 2)) < ( go4.width /2 + go1.width / 2)&&
                        Math.abs( (go1.y + go1.height / 2) - (go4.y + go4.height / 2)) < ( go4.height /2 + go1.height / 2))||
                (Math.abs( (go1.x + go1.width / 2) - (go5.x + go1.width / 2)) < ( go5.width /2 + go1.width / 2)&&
                        Math.abs( (go1.y + go1.height / 2) - (go5.y + go5.height / 2)) < ( go5.height /2 + go1.height / 2)))
            check = true;
        return check;
    }

    @Override
    public void run() {
        try {
            while(true){
                keyProcess();
                carProcess();
                redProcess();
                Thread.sleep(20);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
