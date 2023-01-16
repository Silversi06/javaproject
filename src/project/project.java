package project;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Point;
//import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class project extends JFrame{
   static JButton btn1 = new JButton();
   static JButton btn2 = new JButton();
   static JButton btn3 = new JButton();
   
   private ImageIcon btnimg1 = new ImageIcon(project.class.getResource("../project/버튼1.png"));
   private ImageIcon btnimg2 = new ImageIcon(project.class.getResource("../project/버튼2.png"));
   private ImageIcon btnimg3 = new ImageIcon(project.class.getResource("../project/돌아가기버튼.png"));
   private ImageIcon Car = new ImageIcon(project.class.getResource("../project/자동차.png"));
   
   
   static JPanel page1=new JPanel() {/////////패널 11111111111
		/*이미지*/
		Image background=new ImageIcon(Main.class.getResource("../project/배경.png")).getImage();
		 
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌		
				
				btn1.addMouseListener(new MouseAdapter() { // 마우스 이벤트 
					@Override public void mouseEntered(MouseEvent e) { // 마우스 들어왔을때 
						
					} 
					@Override public void mouseExited(MouseEvent e) { // 마우스 나왔을때 	
					}
					@Override public void mousePressed(MouseEvent e) { // 클릭했을때 
						
						
						setVisible(false);
						page2.setVisible(true);//창이 보이게
						//getContentPane().add(imgLabel);
						
					
					} 
				});
				
				btn2.addMouseListener(new MouseAdapter(){
					@Override public void mouseEntered(MouseEvent e) {
						btn3.setVisible(true);
					}
					@Override public void mouseExited(MouseEvent e) {
						
					}
					@Override public void mousePressed(MouseEvent e) {
						btn1.setVisible(false);
						btn2.setVisible(false);
						btn3.setVisible(true);
						setVisible(false);
						page3.setVisible(true);
						//new Traffic_light();
						
					}
				});
		}
	};

	

	static GameView view;
	/*패널2*/
	static JPanel page2=new JPanel() {/////////패널 222222222222
	
		public void paint(Graphics g) {//그리는 함수
			
			GameModel model = new GameModel();
	    	GameController controller = new GameController(model, pro);
	        view = new GameView(model, controller);
			
			
		}
			
		};
		
		  public void homeframe() {
		      setTitle("무단횡단");
		      setSize(1720,1010);
		      setResizable(false);//창의 크기를 변경하지 못하게
		      setLocationRelativeTo(null);//창이 가운데 나오게
		      setLayout(null);
		      setVisible(true);//창이 보이게   
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
		      
		      
		      
		     
		   }
	
	static JPanel page3=new JPanel() {	/////////패널 333333333333
		/*이미지*/
		Image background=new ImageIcon(Main.class.getResource("../project/게임방법.png")).getImage();
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌	
				btn3.addMouseListener(new MouseAdapter() {
					@Override public void mouseEntered (MouseEvent e) {
						
					}
					@Override public void mouseExited(MouseEvent e) {
						
					}
					@Override public void mousePressed(MouseEvent e) {
						btn1.setVisible(true);
						btn2.setVisible(true);
						btn3.setVisible(false);
						page1.setVisible(true);//창이 보이게
						
						
					}
				});
		}
	};
	
	static JPanel page4 = new JPanel() {
		Image gameover=new ImageIcon(Main.class.getResource("../project/gameover.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(gameover,0,0,null);
		}
	};
	
	static JPanel page5 = new JPanel() {
		Image gameover=new ImageIcon(Main.class.getResource("../project/great.png")).getImage();
		public void paint(Graphics g) {
			g.drawImage(gameover,0,0,null);
		}
	};
				


   static project pro;
   public project() {
	   pro = this;
      homeframe();
      btn();
     setpanel_1();

   }
   public void setGameoverPanel() {
	   page4.setBounds(0,0,1800,1010);
	   page1.setVisible(false);
	   view.exit();
	   page2.setVisible(false);
	   page3.setVisible(false);
		btn1.setVisible(true);
		btn2.setVisible(false);
		btn3.setVisible(false);
	   page4.setLayout(null);
	   add(page4);
	   page4.setVisible(true);
		
   }
   public void setGreatPanel() {
	   page5.setBounds(0,0,1800,1010);
	   page1.setVisible(false);
	   view.exit();
	   page2.setVisible(false);
	   page3.setVisible(false);
		btn1.setVisible(true);
		btn2.setVisible(false);
		btn3.setVisible(false);
	   page4.setLayout(null);
	   add(page5);
	   page5.setVisible(true);
		
   }
   
   public void setpanel_1() {
		/*위치 설정*/
		
		page1.setBounds(0, 0, 1720,1010);//패널1의 위치 설정
		page2.setBounds(0, 0, 1720,1010);//패널2의 위치 설정
		page3.setBounds(0, 0, 1720,1010);
		
		page3.setLayout(null);//레이아웃 설정
		page2.setLayout(null);//레이아웃 설정
		page1.setLayout(null);
		/*visible*/
		page2.setVisible(false);//창이 보이지 않게
		/*패널이나 프레임에 추가*/
		add(page1);//프레임에 패널을 추가
		add(page2);//프레임에 패널을 추가
		add(page3);
		page3.add(btn3);//패널1에 버튼을 추가
	}

   
   public void btn() {
      btn1.setLayout(null);
      btn1.setBounds(200,700,600,150);
      add(btn1);
      btn1.setIcon(btnimg1);
      
      btn2.setLayout(null);
      btn2.setBounds(900,700,600,150);
      add(btn2);
      btn2.setIcon(btnimg2);
      
      btn3.setLayout(null);
      btn3.setBounds(1450,20,200,100);
      add(btn3);
      btn3.setIcon(btnimg3);
      
   }

};
