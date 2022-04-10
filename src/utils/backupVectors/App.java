package utils.backupVectors;

import java.awt.*;
import templetes.canvas.*;
import utils.clocks.*;
import utils.settings.ConstantsManager;
import utils.vectors.*;

public class App implements CanvasRepaintListener{
	
	private Camera3D camera;
	private PlayerMovement player;
	private final int PIXEL_SPACING, DIMENSION, SIDE;
	
	
	//BASE
	public static void main(String[] args) {
		ConstantsManager.addDefaultConstantsThenReadFromFile(null);
		//ConstantsManager.debugPrintValue();
		
		new App();
	}
	public App() { 
		
		//FRAME
		CanvasFrame canvas=new CanvasFrame(this);
		canvas.getFrame().setResizable(false);
		

		//PANEL GAME
		this.PIXEL_SPACING=ConstantsManager.getIntValueOrCrash("pixelSpacing");
		this.DIMENSION=ConstantsManager.getIntValueOrCrash("dimension");
		this.SIDE=PIXEL_SPACING*DIMENSION;
		canvas.setPreferredSize(new Dimension(SIDE, SIDE));
		
		//TEST CUBE
		test();
		
		//PLAYER 
		camera=new Camera3D(SIDE, SIDE, Math.PI/2, Math.PI/2);
		player=new PlayerMovement(camera);
		canvas.getFrame().addKeyListener(player);
		
		//StartClock and setvisible
		canvas.setVisible(true);
		canvas.start(ConstantsManager.getIntValueOrCrash("fps"));
		new Clock(player, (int) (1000/ConstantsManager.getIntValueOrCrash("cps"))).start();
	}
	
	
	//TEST CUBES
	private Vector3D testCubi[]=new Vector3D[100];
	private void test() {
		for(int i=0; i<10; i++) {
			for(int i2=0; i2<10; i2++) {
				testCubi[i*10+i2]=new Vector3D(i, -3, i2);
			}
		}
	}
	
	//PAINT
	/**White is DefaultColor*/
	private void setColorByCostant(String key, Graphics2D graphics) {
		String colorExa=ConstantsManager.getStringValue(key);
		
		graphics.setColor(Color.white); 
		if(colorExa!=null){
			graphics.setColor(Color.decode("#"+colorExa));
		}
	}
	@Override public void paintComponent(Graphics2D graphics) {
		//BACKGROUND
		setColorByCostant("backgroundColor", graphics);
		graphics.fillRect(0, 0, SIDE, SIDE);
		
		
		//GRID
		setColorByCostant("gridColor", graphics);
		for(int i=0; i<DIMENSION; i++) {
			int l=PIXEL_SPACING*i;
			graphics.drawLine(0, l, SIDE, l);
			graphics.drawLine(l, 0, l, SIDE);
		}
		
		//TEXT
		setColorByCostant("textColor", graphics);
		String strings[]=camera.getLookingDirection().toString().split("\n");
		
		for(int i=0; i<strings.length; i++) {
			graphics.drawString(strings[i], 10, 20*(i+1));
		}
		
		
		//CUBO
		setColorByCostant("lineColor", graphics);
		for(int i=0; i<testCubi.length; i++) {
			drawCube(graphics, testCubi[i]);
		}
		
		
	}
	private final Vector3D up=new Vector3D(0, 1, 0), right=new Vector3D(0, 0, 1), forward=new Vector3D(1, 0, 0),
			forwardUp=new Vector3D(1, 1, 0), forwardRight=new Vector3D(1, 0, 1), upRight=new Vector3D(0, 1, 1),
			forwardUpRight=new Vector3D(1, 1, 1);
	private void drawCube(Graphics2D graphics, Vector3D position) {
		
		drawLine(graphics, position, Vector3D.getSummed(position, up));
		drawLine(graphics, position, Vector3D.getSummed(position, right));
		drawLine(graphics, position, Vector3D.getSummed(position, forward));
		
		
		drawLine(graphics, Vector3D.getSummed(position, up), Vector3D.getSummed(position, upRight));
		drawLine(graphics, Vector3D.getSummed(position, up), Vector3D.getSummed(position, forwardUp));
		drawLine(graphics, Vector3D.getSummed(position, right), Vector3D.getSummed(position, upRight));
		drawLine(graphics, Vector3D.getSummed(position, right), Vector3D.getSummed(position, forwardRight));
		drawLine(graphics, Vector3D.getSummed(position, forward), Vector3D.getSummed(position, forwardUp));
		drawLine(graphics, Vector3D.getSummed(position, forward), Vector3D.getSummed(position, forwardRight));
		
		
		drawLine(graphics, Vector3D.getSummed(position, forwardRight), Vector3D.getSummed(position, forwardUpRight));
		drawLine(graphics, Vector3D.getSummed(position, upRight), Vector3D.getSummed(position, forwardUpRight));
		drawLine(graphics, Vector3D.getSummed(position, forwardUp), Vector3D.getSummed(position, forwardUpRight));
	}
	private void drawLine(Graphics2D graphics, Vector3D v1,  Vector3D v2) {
		Vector2D a=camera.getOnScreenCoord(v1);
		Vector2D b=camera.getOnScreenCoord(v2);
		
		if(a!=null&& b!=null) {
			graphics.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
		}
			
	}
	

}
