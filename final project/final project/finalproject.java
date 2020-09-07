//Copyright by TPY s1061516 | All rights reserved
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class finalproject extends Frame implements ActionListener,KeyListener
{
   static finalproject frm=new finalproject();
   static int size;
   static JButton btn[];
   static int map[][]={
    {1,1,1,1,1,1,1,1,1,1,
      1,3,0,0,0,0,0,0,0,1,
      1,0,2,0,0,0,0,0,0,1,
      1,0,0,0,0,0,0,0,0,1,
      1,0,0,0,0,0,0,0,0,1,
      1,0,0,0,0,0,0,0,0,1,
      1,0,0,0,0,0,0,0,0,1,
      1,0,0,0,0,0,0,0,0,1,
      1,0,0,0,0,0,0,0,4,1,
      1,1,1,1,1,1,1,1,1,1},
     {1,1,1,1,1,1,1,1,1,1,
      1,4,0,0,0,1,0,0,0,1,
      1,1,1,0,0,0,0,0,0,1,
      1,1,0,0,0,1,1,1,1,1,
      1,1,1,0,1,0,1,0,1,1,
      1,0,0,0,0,0,0,0,0,1,
      1,1,1,0,1,1,1,0,0,1,
      1,0,0,0,0,0,0,0,0,1,
      1,0,2,1,0,0,0,0,3,1,
      1,0,0,1,1,1,1,1,1,1},
     {1,1,1,1,1,1,1,1,1,1,
      1,3,0,0,0,0,0,0,0,1,
      1,0,2,0,0,0,0,0,0,1,
      1,1,1,1,1,1,1,0,0,1,
      1,1,0,0,1,1,1,1,0,0,
      1,0,0,0,0,0,0,0,0,0,
      1,0,1,0,1,1,1,1,1,1,
      1,0,0,0,0,0,0,1,0,1,
      1,0,0,0,0,0,0,0,4,1,
      1,1,1,1,1,1,1,1,1,1},
     {1,1,1,0,0,1,1,1,0,0,
      1,3,1,0,0,1,0,0,0,0,
      1,0,1,1,1,1,1,1,2,0,
      0,0,0,1,0,4,1,0,0,1,
      0,0,0,1,0,0,1,1,0,1,
      0,0,0,1,1,0,1,0,0,1,
      0,1,0,0,0,0,0,0,0,0,
      0,0,0,1,0,0,0,1,0,0,
      1,1,0,0,1,1,0,0,0,1,
      0,0,1,0,1,1,1,1,1,1},
     {0,1,0,1,0,0,0,0,0,3,
      0,0,0,0,0,1,0,1,0,1,
      0,2,1,0,0,0,0,0,0,0,
      0,0,1,0,1,1,1,0,0,0,
      1,0,1,0,0,5,1,0,1,0,
      1,1,1,1,1,1,1,0,1,0,
      1,1,0,1,0,1,0,0,0,1,
      1,0,1,0,0,0,0,0,0,0,
      0,1,0,4,0,0,1,0,1,0,
      1,0,0,1,1,0,0,1,0,1},
      {0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0,
      0,0,0,0,0,0,0,0,0,0}

   };
       static int stickman;
       static ImageIcon blankIcon = new ImageIcon("./img/blank.png");
       static ImageIcon blockIcon = new ImageIcon("./img/block.png");
       static ImageIcon stickmanIcon = new ImageIcon("./img/stickman.png");
       static ImageIcon boxIcon = new ImageIcon("./img/box.png");
       static ImageIcon endIcon = new ImageIcon("./img/end.png");
       static ImageIcon lightning = new ImageIcon("./img/lightning.png");
       static int level;
       static boolean Flash;
   public static void main(String args[]){
      level=0;
      size=10;
      btn=new JButton[size*size];
      for (int i=0;i<100;i++){  
            btn[i]= new JButton(" ");
         if (map[level][i]==0)
            btn[i].setIcon(blankIcon);
         else if (map[level][i]==1){
            btn[i].setIcon(blockIcon);
            btn[i].addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e){
	            	for(int j = 0; j < 100; j++){
				  		if(e.getSource() == btn[j]){
				  			if(map[level][j]==1&&Flash==true){
				  				btn[j].setIcon(blankIcon);
				  				map[level][j]=0;
				  				Flash=false;
				  			}
				  		}
				  	}
				}
			  });
         }
         else if (map[level][i]==2){//box
          btn[i].setIcon(boxIcon);
         }
         else if (map[level][i]==3){//man
          stickman=i;
          btn[i].setIcon(stickmanIcon);
         }
         else if (map[level][i]==4){//end
          btn[i].setIcon(endIcon);
          btn[i].addActionListener(frm);
        }
        else if (map[level][i]==5){//lightning
          btn[i].setIcon(lightning);
         }
          frm.add(btn[i]);
      }
      for (int j=0;j<100;j++){
          btn[j].addKeyListener(frm);
      }
      GridLayout grid = new GridLayout(size,size);
      frm.setTitle("assiment1");
      frm.setLayout(grid);
      frm.setSize(size*50,size*50);
      frm.setVisible(true);
      frm.addWindowListener(new WindowAdapter(){@Override public void windowClosing(WindowEvent e){System.exit(0);}});
     }
  public void actionPerformed(ActionEvent e){
    Runtime rt = Runtime.getRuntime();
    try {
      rt.exec(new String[]{"cmd.exe","/c","java finalproject"});
    }
    catch (IOException r) {
      r.printStackTrace();
    }
    System.exit(0);
  }
  public void repaintmap(){
        for (int i=0;i<100;i++){  
         if (map[level][i]==0)
            btn[i].setIcon(blankIcon);
         else if (map[level][i]==1)
          {
            btn[i].setIcon(blockIcon);
            btn[i].addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                for(int j = 0; j < 100; j++){
              if(e.getSource() == btn[j]){
                if(map[level][j]==1&&Flash==true){
                  btn[j].setIcon(blankIcon);
                  map[level][j]=0;
                  Flash=false;
                }
               }
              }
            }});
          }
         else if (map[level][i]==2){//box
          btn[i].setIcon(boxIcon);
         }
         else if (map[level][i]==3){//man
          stickman=i;
          btn[i].setIcon(stickmanIcon);
         }
         else if (map[level][i]==4){//end
          btn[i].setIcon(endIcon);
          btn[i].addActionListener(frm);
        }
        else if (map[level][i]==5){//lightning
          btn[i].setIcon(lightning);
         }
          frm.add(btn[i]);
      }
  }
   public void keyReleased(KeyEvent e){}
   public void keyTyped(KeyEvent e){}
   public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
       System.out.print("left press \n");
       if(map[level][stickman-1]==2&&map[level][stickman-2]==4){
          level++;
          btn[stickman-2].removeActionListener(frm);
          repaintmap();
        }
       if(map[level][stickman-1]==2&&map[level][stickman-2]==0){
          btn[stickman-2].setIcon(boxIcon);
          btn[stickman-1].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman-1]=3;
          map[level][stickman-2]=2;
          map[level][stickman]=0;
          stickman--;
        }
        else if(map[level][stickman-1]==0){
          map[level][stickman-1]=3;
          map[level][stickman]=0;
          btn[stickman-1].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          stickman--;
        }
        else if(map[level][stickman-1]==5){
          btn[stickman-1].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman-1]=3;
          map[level][stickman]=0;
          stickman--;
          Flash=true;
        }
    }
    if (key == KeyEvent.VK_RIGHT) {
        System.out.print("right press \n");
       if(map[level][stickman+1]==2&&map[level][stickman+2]==4){
          level++;
          btn[stickman+2].removeActionListener(frm);
          repaintmap();
        }
        if (map[level][stickman+1]==0){
          map[level][stickman+1]=3;
          map[level][stickman]=0;
          btn[stickman+1].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          stickman++;
        }
        else if(map[level][stickman+1]==2&&map[level][stickman+2]==0){
          btn[stickman+2].setIcon(boxIcon);
          btn[stickman+1].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman+1]=3;
          map[level][stickman+2]=2;
          map[level][stickman]=0;
          stickman++;
        }
        else if(map[level][stickman+1]==5){
          btn[stickman+1].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman+1]=3;
          map[level][stickman]=0;
          stickman++;
          Flash=true;
        }
       
    }
    if (key == KeyEvent.VK_UP) {
       System.out.print("up press \n");
       if(map[level][stickman-10]==2&&map[level][stickman-20]==4){
          level++;
          btn[stickman-20].removeActionListener(frm);
          repaintmap();
        }
        if (stickman-10>0){
        if (map[level][stickman-10]==0){
            map[level][stickman-10]=3;
            map[level][stickman]=0;
            btn[stickman-10].setIcon(stickmanIcon);
            btn[stickman].setIcon(blankIcon);
            stickman-=10;
        }
       else if(map[level][stickman-10]==2&&map[level][stickman-20]==0){
          btn[stickman-20].setIcon(boxIcon);
          btn[stickman-10].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman-10]=3;
          map[level][stickman-20]=2;
          map[level][stickman]=0;
          stickman-=10;
        }
        if(map[level][stickman-10]==5){
          btn[stickman-10].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman-10]=3;
          map[level][stickman]=0;
          stickman-=10;
          Flash=true;
        }
      }
    }
    if (key == KeyEvent.VK_DOWN) {
      System.out.print("down press \n");
      if(map[level][stickman+10]==2&&map[level][stickman+20]==4){
          level++;
          btn[stickman+20].removeActionListener(frm);
          repaintmap();
        }
       if (stickman+10>0){
        if (map[level][stickman+10]==0){
          map[level][stickman+10]=3;
          map[level][stickman]=0;
          btn[stickman+10].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          stickman+=10;
        }
       else if(map[level][stickman+10]==2&&map[level][stickman+20]==0){
          btn[stickman+20].setIcon(boxIcon);
          btn[stickman+10].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman+10]=3;
          map[level][stickman+20]=2;
          map[level][stickman]=0;
          stickman+=10;
        }
        if(map[level][stickman+10]==5){
          btn[stickman+10].setIcon(stickmanIcon);
          btn[stickman].setIcon(blankIcon);
          map[level][stickman+10]=3;
          map[level][stickman]=0;
          stickman+=10;
          Flash=true;
        }
      }
    }
  }
}

