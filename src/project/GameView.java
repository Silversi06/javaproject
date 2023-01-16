package project;
import javax.swing.*;
import java.awt.*;


public class GameView extends JFrame {
    Image buffImg;
    Graphics buffG;
    
    GameModel model;
    GameController controller;

    Toolkit imageTool = Toolkit.getDefaultToolkit();
	Image background=new ImageIcon(Main.class.getResource("../project/��Ÿ�.png")).getImage();
	//Image Car=new ImageIcon(Main.class.getResource("../project/�ڵ���.png")).getImage();
	//Image Person=new ImageIcon(Main.class.getResource("../project/���.png")).getImage();
	
    public Color[] red = {Color.RED, Color.GRAY};
    public Color[] yellow = {Color.GRAY,Color.GRAY};
    public Color[] green = {Color.GRAY, Color.GREEN};
    public int light_stack = 0;
	
    public GameView(GameModel model, GameController controller){
    	this.model = model;
    	this.controller = controller;
        // �������� ���� ����.
        setTitle("����Ⱦ��"); // ������ ���� ����.
        setSize(1720,1010); // �������� ũ�� ����.
        setResizable(false); // �������� ũ�� ���� ���ϰ� ����.
        setVisible(true); // ������ ���̱�;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // �������� x��ư ������ ����;
        
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
    	buffImg = createImage(getWidth(),getHeight()); // ���۸��� �̹��� ( ��ȭ�� )
        buffG = buffImg.getGraphics(); // ���۸��� �̹����� �׷��� ��ü�� ���� �׸� �� �ִٰ� �Ѵ�. ( ��? )
        update(g);
    }
    
    @Override
    public void update(Graphics g) {
        buffG.clearRect(0, 0, 854, 480); // ����ȭ
        buffG.clearRect(0,0,1720,1010);
        buffG.drawImage(background, 0, 0, null);//background    ?   	
        buffG.drawImage(model.player.img, model.player.x,model.player.y,this);
        buffG.drawImage(model.car.img, model.car.x, model.car.y,this);
        buffG.drawImage(model.car2.img, model.car2.x, model.car2.y,this);
        buffG.drawImage(model.car3.img, model.car3.x, model.car3.y,this);
        buffG.drawImage(model.car4.img, model.car4.x, model.car4.y,this);
        
        if(light_stack < 500) { // ��ȣ�� �� �ٲٱ�
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
        g.drawImage(buffImg,0,0,this); // ȭ��g�� ����(buffG)�� �׷��� �̹���(buffImg)�ű�. ( ��ȭ���� �̹����� ��� )
        light_stack+=1;
        if(light_stack > 2000)
        	light_stack = 0;
        repaint();
    }
}
