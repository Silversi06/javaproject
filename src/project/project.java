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
   
   private ImageIcon btnimg1 = new ImageIcon(project.class.getResource("../project/��ư1.png"));
   private ImageIcon btnimg2 = new ImageIcon(project.class.getResource("../project/��ư2.png"));
   private ImageIcon btnimg3 = new ImageIcon(project.class.getResource("../project/���ư����ư.png"));
   private ImageIcon Car = new ImageIcon(project.class.getResource("../project/�ڵ���.png"));
   
   
   static JPanel page1=new JPanel() {/////////�г� 11111111111
		/*�̹���*/
		Image background=new ImageIcon(Main.class.getResource("../project/���.png")).getImage();
		 
		public void paint(Graphics g) {//�׸��� �Լ�
				g.drawImage(background, 0, 0, null);//background�� �׷���		
				
				btn1.addMouseListener(new MouseAdapter() { // ���콺 �̺�Ʈ 
					@Override public void mouseEntered(MouseEvent e) { // ���콺 �������� 
						
					} 
					@Override public void mouseExited(MouseEvent e) { // ���콺 �������� 	
					}
					@Override public void mousePressed(MouseEvent e) { // Ŭ�������� 
						
						
						setVisible(false);
						page2.setVisible(true);//â�� ���̰�
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
	/*�г�2*/
	static JPanel page2=new JPanel() {/////////�г� 222222222222
	
		public void paint(Graphics g) {//�׸��� �Լ�
			
			GameModel model = new GameModel();
	    	GameController controller = new GameController(model, pro);
	        view = new GameView(model, controller);
			
			
		}
			
		};
		
		  public void homeframe() {
		      setTitle("����Ⱦ��");
		      setSize(1720,1010);
		      setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		      setLocationRelativeTo(null);//â�� ��� ������
		      setLayout(null);
		      setVisible(true);//â�� ���̰�   
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		      
		      
		      
		     
		   }
	
	static JPanel page3=new JPanel() {	/////////�г� 333333333333
		/*�̹���*/
		Image background=new ImageIcon(Main.class.getResource("../project/���ӹ��.png")).getImage();
		public void paint(Graphics g) {//�׸��� �Լ�
				g.drawImage(background, 0, 0, null);//background�� �׷���	
				btn3.addMouseListener(new MouseAdapter() {
					@Override public void mouseEntered (MouseEvent e) {
						
					}
					@Override public void mouseExited(MouseEvent e) {
						
					}
					@Override public void mousePressed(MouseEvent e) {
						btn1.setVisible(true);
						btn2.setVisible(true);
						btn3.setVisible(false);
						page1.setVisible(true);//â�� ���̰�
						
						
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
		/*��ġ ����*/
		
		page1.setBounds(0, 0, 1720,1010);//�г�1�� ��ġ ����
		page2.setBounds(0, 0, 1720,1010);//�г�2�� ��ġ ����
		page3.setBounds(0, 0, 1720,1010);
		
		page3.setLayout(null);//���̾ƿ� ����
		page2.setLayout(null);//���̾ƿ� ����
		page1.setLayout(null);
		/*visible*/
		page2.setVisible(false);//â�� ������ �ʰ�
		/*�г��̳� �����ӿ� �߰�*/
		add(page1);//�����ӿ� �г��� �߰�
		add(page2);//�����ӿ� �г��� �߰�
		add(page3);
		page3.add(btn3);//�г�1�� ��ư�� �߰�
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
