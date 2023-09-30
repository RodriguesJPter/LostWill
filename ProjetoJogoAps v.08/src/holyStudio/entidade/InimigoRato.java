package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class InimigoRato extends Entidade {

	public double speed = 0.5;
	public int movimentacao = 1;
	public int frames = 0, maxFrames = 7, index = 0, maxIndex = 6;
	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;
	public int life = 5, maxlife = 9;

	public int direita = 1, esquerda = 0;
	public int direcaoAtual = direita;

	boolean jogadorProximo = false;
	
	public BufferedImage[] inimigoLeft;
	public BufferedImage[] inimigoRight;

	public InimigoRato(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		inimigoLeft = new BufferedImage[7];
		inimigoRight = new BufferedImage[7];

		for(int i = 0; i < 7; i++) {
			inimigoLeft[i] = Game.sprite.getSprite(1 + (i*75) , 565, 73, 52);
		}

		for(int i = 0; i < 7; i++) {
			inimigoRight[i] = Game.sprite.getSprite(451 - (i*75) , 507, 73, 52);
		}

	}

	@Override
	public void tick() {
		movimentacao = 0;
		double distancia = Math.sqrt(Math.pow(Game.player.getX() - this.getX(), 2) + Math.pow((Game.player.getY() + 10) - this.getY(), 2));
        double limiteProximidade = 100.0;

        jogadorProximo = distancia < limiteProximidade;
        
        //System.out.println("Distância até o jogador: " + distancia);
        

		if(life <= 0) {
		}

		for(int i = 0; i< Game.rato.size(); i++) {
		}


		if(!colisao((int)x,(int)(y + 38))) {
			y+=2;
		}
		 double diferencaX = Game.player.getX() - this.getX();

		    if (jogadorProximo) {
		        if (diferencaX > 0 && !colisao((int) (x + speed), this.getY())) {
		            x += speed;
		            movimentacao = 1;
		            direcaoAtual = direita;
		        } else if (diferencaX < 0 && !colisao((int) (x - speed), this.getY())) {
		            x -= speed;
		            movimentacao = 1;
		            direcaoAtual = esquerda;
		        }
		    }

		    if (movimentacao == 1) {
		        frames++;
		        if (frames == maxFrames) {
		            index++;
		            frames = 0;
		            if (index > maxIndex)
		                index = 0;
		        }
		    }
		}

	public boolean colisao(int nextx, int nexty) {
		Rectangle inimigo = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Solido) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky,maskw,maskh);
				if(inimigo.intersects(solido)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void render(Graphics g) {
		if (direcaoAtual == direita && movimentacao == 1) {
			g.drawImage(inimigoLeft[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}

		if (direcaoAtual == direita && movimentacao == 0) {
			g.drawImage(inimigoLeft[0], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 1) {
			g.drawImage(inimigoRight[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}

		if (direcaoAtual == esquerda && movimentacao == 0) {
			g.drawImage(inimigoRight[0], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
	}

}
