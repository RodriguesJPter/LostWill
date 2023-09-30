package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class Entidade {
	
	private BufferedImage itemImage;

	public static Solido solido;

	private int maskx, masky,mwidth,mheight;
	public static BufferedImage chao = Game.sprite.getSprite(480, 176, 16, 16);
	public static BufferedImage chao2 = Game.sprite.getSprite(448, 176, 16, 16);
	public static BufferedImage chaoCantoD = Game.sprite.getSprite(480, 208, 16, 16);
	public static BufferedImage chaoCantoDb = Game.sprite.getSprite(416, 208, 16, 16);
	public static BufferedImage chaoCantoE = Game.sprite.getSprite(512, 208, 16, 16);
	public static BufferedImage chaoCantoEb = Game.sprite.getSprite(448, 208, 16, 16);
	public static BufferedImage chaoP = Game.sprite.getSprite(512, 176, 16, 16);
	public static BufferedImage teto1 = Game.sprite.getSprite(448, 144, 16, 16);
	public static BufferedImage teto2 = Game.sprite.getSprite(400, 144, 16, 16);
	public static BufferedImage teto3 = Game.sprite.getSprite(416, 144, 16, 16);
	public static BufferedImage nada = Game.sprite.getSprite(930, 10, 16, 16);
	public static BufferedImage vazio = Game.sprite.getSprite(512, 144, 16, 16);
	public static BufferedImage grama01 = Game.sprite.getSprite(608, 240, 16, 16);
	public static BufferedImage grama02 = Game.sprite.getSprite(624, 240, 16, 16);
	public static BufferedImage grama03 = Game.sprite.getSprite(640, 240, 16, 16);
	public static BufferedImage solo01 = Game.sprite.getSprite(608, 256, 16, 16);
	public static BufferedImage solo02 = Game.sprite.getSprite(624, 256, 16, 16);
	public static BufferedImage solo03 = Game.sprite.getSprite(640, 256, 16, 16);
	public static BufferedImage terra01 = Game.sprite.getSprite(608, 272, 16, 16);
	public static BufferedImage terra02 = Game.sprite.getSprite(624, 272, 16, 16);
	public static BufferedImage terra03 = Game.sprite.getSprite(640, 272, 16, 16);
	
	public static BufferedImage ponte01 = Game.sprite.getSprite(576, 240, 16, 16);
	public static BufferedImage ponte02 = Game.sprite.getSprite(560, 240, 16, 16);
	public static BufferedImage ponte03 = Game.sprite.getSprite(544, 240, 16, 16);
	public static BufferedImage ponte04 = Game.sprite.getSprite(576, 256, 16, 16);

	
	public static BufferedImage grama = Game.sprite.getSprite(608, 224, 16, 16);

	public static BufferedImage escadaE = Game.sprite.getSprite(385, 113, 16, 16);
	public static BufferedImage escadaD = Game.sprite.getSprite(401, 113, 16, 16);

	public static BufferedImage iniciofundoceu = Game.ceu.getSprite(0, 0, 16, 16);

	public static BufferedImage iniciofundo = Game.ceu.getSprite(0, 160, 16, 16);

	public static BufferedImage fundo = Game.ceu.getSprite(0, 320, 16, 16);
	
	public static BufferedImage inimigoRato = Game.sprite.getSprite(512, 144, 16, 16);
	
	public static BufferedImage caixote = Game.sprite.getSprite(736, 272, 32, 32);
	
	public static BufferedImage inimigoSoldado = Game.sprite.getSprite(3, 768, 16, 16);
	
	public static BufferedImage npcMoon = Game.sprite.getSprite(1, 336, 16, 16);
	
	public static BufferedImage npcDoll = Game.sprite.getSprite(80, 336, 16, 16);
	
	public static BufferedImage npcOutro = Game.sprite.getSprite(0, 400, 16, 16);

	public static BufferedImage lixo = Game.sprite.getSprite(672, 80, 16, 16);
	
	public static BufferedImage medalSol = Game.sprite.getSprite(720, 48, 16, 16);
	
	public static BufferedImage chave = Game.sprite.getSprite(736, 48, 16, 16);
	
	public static BufferedImage moonsword = Game.sprite.getSprite(688, 48, 16, 56);
	
	public static BufferedImage sword = Game.sprite.getSprite(704, 48, 16, 48);
	
	public static BufferedImage poste1 = Game.sprite.getSprite(704, 336, 16, 48);
	
	public static BufferedImage frasco = Game.sprite.getSprite(720, 80, 16, 16);
	
	public static BufferedImage will = Game.sprite.getSprite(656, 80, 16, 16);

	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected BufferedImage sprite;

	public Entidade(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public int getX() {
		return (int)this.x;
	}

	public int getY() {
		return (int)this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void tick() {

	}

	public static boolean isColidding(Entidade e1,Entidade e2) {
		Rectangle e1mask = new Rectangle(e1.getX() + e1.maskx,e1.getY() + e1.masky,e1.mwidth,e1.mheight);
		Rectangle e2mask = new Rectangle(e2.getX() + e2.maskx,e2.getY() + e2.masky,e2.mwidth,e2.mheight);
		return e1mask.intersects(e2mask);
	}

	public void render(Graphics g) {

		g.drawImage(sprite, this.getX()-Camera.x, this.getY()-Camera.y, null);

	}

}
