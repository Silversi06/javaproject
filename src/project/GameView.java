package project;
import javax.swing.*;
import java.awt.*;


public class GameView extends JFrame {
    Image buffImg;
    Graphics buffG;
    
    GameModel model;
    GameController controller;

    Toolkit imageTool = Toolkit.getDefaultToolkit();
	Image background=new ImageIcon(Main.class.getResource("../project/사거리.png")).getImage();
	//Image Car=new ImageIcon(Main.class.getResource("../project/자동차.png")).getImage();
	//Image Person=new ImageIcon(Main.class.getResource("../project/사람.png")).getImage();
	
    public Color[] red = {Color.RED, Color.GRAY};
    public Color[] yellow = {Color.GRAY,Color.GRAY};
    public Color[] green = {Color.GRAY, Color.GREEN};
    public int light_stack = 0;
	
    public GameView(GameModel model, GameController controller){
    	this.model = model;
    	this.controller = controller;
        // 프레임의 대한 설정.
        setTitle("무단횡단"); // 프레임 제목 설정.
        setSize(1720,1010); // 프레임의 크기 설정.
        setResizable(false); // 프레임의 크기 변경 못하게 설정.
        setVisible(true); // 프레임 보이기;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 프레임의 x버튼 누르면 종료;
        
        addKeyListener(controller);
        
        Thread control_thread = new Thread(this.controller);
        control_thread.setDaemon(true);
        control_thread.start();
    }
    public void exit() {
    	dispose();
    }

    @Override
    public void paint(Graphics g) {
    	buffImg = createImage(getWidth(),getHeight()); // 버퍼링용 이미지 ( 도화지 )
        buffG = buffImg.getGraphics(); // 버퍼링용 이미지에 그래픽 객체를 얻어야 그릴 수 있다고 한다. ( 붓? )
        update(g);
    }
    
    @Override
    public void update(Graphics g) {
        buffG.clearRect(0, 0, 854, 480); // 백지화
        buffG.clearRect(0,0,1720,1010);
        buffG.drawImage(background, 0, 0, null);//background    ?   	
        buffG.drawImage(model.player.img, model.player.x,model.player.y,this);
        buffG.drawImage(model.car.img, model.car.x, model.car.y,this);
        buffG.drawImage(model.car2.img, model.car2.x, model.car2.y,this);
        buffG.drawImage(model.car3.img, model.car3.x, model.car3.y,this);
        buffG.drawImage(model.car4.img, model.car4.x, model.car4.y,this);
        
        if(light_stack < 500) { // 신호등 색 바꾸기
        	controller.red = true;
        	for (int i = 0; i < red.length; i++) {
        		buffG.setColor(red[i]);
        		buffG.fillOval(50, 25 + (i * 125), 100, 100);
        	}
        }
    
        else{
        	controller.red = false;
        	for (int i = 0; i < green.length; i++) {
        		buffG.setColor(green[i]);
        		buffG.fillOval(50, 25 + (i * 125), 100, 100);
        	}
        }
        g.drawImage(buffImg,0,0,this); // 화면g애 버퍼(buffG)에 그려진 이미지(buffImg)옮김. ( 도화지에 이미지를 출력 )
        light_stack+=1;
        if(light_stack > 2000)
        	light_stack = 0;
        repaint();
    }
}
