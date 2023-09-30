package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.Mundo.Mundo;
import holyStudio.main.Game;

public class Player extends Entidade {

	public Mundo mundo;
	
	public NpcMoon npc;
	
	public String texto = ""; 

	public double life = 100, maxLife = 100;

	public boolean right, left, down, up;

	public boolean rightP, leftP;

	public boolean rightA, leftA;

	public double speed = 4;

	public int direita = 1, esquerda = 0, paradoD = 1, paradoL = 0, atacandoR = 1 , atacandoL = 0, pulandoR = 1, pulandoL = 0;

	public int direcaoAtual = direita;

	public int PuloDirecao = direita;

	public int movimentacao = 0;

	public int ataque = 0;

	public int frames = 0, maxFrames = 7, index = 0, maxIndex = 6;

	public int framesP = 0, maxFramesP = 5, indexP = 0, maxIndexP = 6;

	public int framesA = 0, maxFramesA = 5, indexA = 0, maxIndexA = 6;

	public int framesPl = 0, maxFramesPl = 5, indexPl = 0, maxIndexPl = 6;

	public int maskx= 0, masky = 0, maskw = 16, maskh = 16;
	
	private boolean mostrarTexto = false;
	private long tempoTextoVisivel = 0;
	
	public boolean interagindo = false;
	
	public boolean opemInventory = false;
	
	public boolean abrindoInventarioy = false;
	
	
	
	public boolean jump = false;
	public boolean isJump = false;
	public int jumpHeigth = 48;
	public int jumpFrames = 0;

	public InimigoRato pl;
	
	public InimigoSoldado pl2;

	public Lixo lixoo;
	
	public ItemMedalSol iSol;
	
	public ItemMoonSword iMoon;
	
	public ItemChave iChave;

	public int numeroLixo = 0;
	
	public int medalsol = 0;
	
	public int moonsword = 0;

	public int chave = 0;
	
	public int numeroFrasco = 0;
	
	public int numeroDeWill = 000;
	
	public boolean usandocura = false;
	
	public BufferedImage[] playerRight;
	public BufferedImage[] playerLeft;
	public BufferedImage[] playerRightP;
	public BufferedImage[] playerLeftP;
	public BufferedImage[] playerRAtaque;
	public BufferedImage[] playerLAtaque;
	public BufferedImage[] playerRPulo;
	public BufferedImage[] playerLPulo;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		playerRightP = new BufferedImage[5];
		playerLeftP = new BufferedImage[5];
		playerRight = new BufferedImage[7];
		playerLeft = new BufferedImage[7];
		playerRAtaque = new BufferedImage[5];
		playerLAtaque = new BufferedImage[5];
		playerRPulo = new BufferedImage[5];
		playerLPulo = new BufferedImage[5];

		for(int i = 0; i < 5; i++) {
			playerRightP[i] = Game.sprite.getSprite(2, 1, 34, 49);
		}

		for(int i = 0; i < 5; i++) {
			playerLeftP[i] = Game.sprite.getSprite(3, 54, 34, 49);
		}

		for(int i = 0; i < 7; i++) {
			playerRight[i] = Game.sprite.getSprite(2 + (i*50), 105, 49, 49);
		}

		for(int i = 0; i < 7; i++) {
			playerLeft[i] = Game.sprite.getSprite(306 - (i*50), 155, 49, 49);
		}

		for(int i = 0; i < 5; i++) {
			playerRAtaque[i] = Game.sprite.getSprite(3, 213, 74, 50);
		}

		for(int i = 0; i < 5; i++) {
			playerLAtaque[i] = Game.sprite.getSprite(3, 264, 74, 50);
		}

		for(int i = 0; i < 5; i++) {
			playerRPulo[i] = Game.sprite.getSprite(189, 214, 41, 54);
		}

		for(int i = 0; i < 5; i++) {
			playerLPulo[i] = Game.sprite.getSprite(230, 213, 41, 54);
		}



	}

	@Override
	public void tick() {
		movimentacao = 0;
		ataque = 0;

		if(!colisao((int) x, (int)(y+33)) && !isJump) {
			y+=1;

		}

		 if (right && !colisaoBloco((int)(x+speed), this.getY())) {
		        x += speed;
		        movimentacao = 1;
		        direcaoAtual = direita;
		        speed = 4;
		    }

		    if (left && !colisaoBloco((int)(x-speed), this.getY())) {
		        x -= speed;
		        movimentacao = 1;
		        direcaoAtual = esquerda;
		        speed = 4;
		    }

		if(Lixo((int)(x-speed), this.getY())) {
			numeroLixo += 1;
			life += 10;
			if(life > 100) {
				life = 100;
			}
			Game.lixo.remove(lixoo);
			System.out.println("numero do vontade" + numeroLixo );

			if (numeroLixo == 2) {
			    mostrarTexto = true;
			    tempoTextoVisivel = System.currentTimeMillis();
			    texto = "Você coletou todos as vontades";
			} else {
			    texto = "";
			}

		}
		
		if(medal((int)(x-speed), this.getY())){
			medalsol += 1;
			Game.itemS.remove(iSol);
			System.out.println("Item coletado");
			if(medalsol == 1) {
				mostrarTexto = true;
				tempoTextoVisivel = System.currentTimeMillis();
			    texto = "Uma medalha de sol com um rosto";
			} else {
				texto = "";
			}
		}
		
		if(chave((int)(x-speed), this.getY())){
			chave += 1;
			Game.itemC.remove(iChave);
			System.out.println("Item coletado");
			if(chave == 1) {
				mostrarTexto = true;
				tempoTextoVisivel = System.currentTimeMillis();
			    texto = "uma chave?!";
			} else {
				texto = "";
			}
		}
		
		if(MoonLight((int)(x-speed), this.getY())){
			moonsword += 1;
			Game.itemMS.remove(iMoon);
			System.out.println("Item coletado");
			if(moonsword == 1) {
				mostrarTexto = true;
				tempoTextoVisivel = System.currentTimeMillis();
			    texto = "Uma espada que reflete o sol";
			} else {
				texto = "";
			}
		}

		if(rightA && !colisaoBloco(this.getX(), this.getY())) {
			ataque = 1;
			movimentacao = 2;
			speed= 0;
			direcaoAtual = atacandoR;
			for (int i = 0 ; i < Game.rato.size(); i++) {
				InimigoRato inimigo = Game.rato.get(i);
				if(danoRato(this.getX(), this.getY()) && Game.rato.get(i) == inimigo) {
					Game.rato.remove(i);
					 numeroFrasco += 1;
				} 
			}
			for (int i = 0 ; i < Game.soldado.size(); i++) {
				InimigoSoldado soldado = Game.soldado.get(i);
				if (danoSoldado(this.getX(), this.getY()) && Game.soldado.get(i) == soldado) { 
					Game.soldado.remove(i);
					numeroFrasco += 1;
				}
			}
		}

		if(leftA && !colisaoBloco(this.getX(), this.getY())) {
			ataque = 1;
			movimentacao = 2;
			speed= 0;
			direcaoAtual = atacandoL;
			for (int i = 0 ; i < Game.rato.size(); i++) {
				InimigoRato inimigo = Game.rato.get(i);
				if(danoRato(this.getX(), this.getY()) && Game.rato.get(i) == inimigo ) {
					Game.rato.remove(i);
					numeroFrasco += 1;
				} 
			}
			for (int i = 0 ; i < Game.soldado.size(); i++) {
				InimigoSoldado soldado = Game.soldado.get(i);
				if (danoSoldado(this.getX(), this.getY()) && Game.soldado.get(i) == soldado) {
					Game.soldado.remove(i);	
					numeroFrasco += 1;
				}
			}
		}

		if(rightP && !colisaoBloco((int)(x+speed), this.getY())) {
			movimentacao = 0;
			direcaoAtual = paradoD;
		}

		if(leftP && !colisaoBloco((int)(x-speed), this.getY())) {
			movimentacao = 0;
			direcaoAtual = paradoL;
		}

		if(jump && direcaoAtual == direita) {
			movimentacao = 3;
			direcaoAtual = pulandoR;
			PuloDirecao = direita;
			if(colisao(this.getX(), this.getY()+33)) {
				isJump = true;
			}
		} else if(jump) {
			movimentacao = 3;
			direcaoAtual = pulandoL;
			PuloDirecao = esquerda;
			if(colisao(this.getX(), this.getY()+33)) {
				isJump = true;
			}
		}

		if(isJump){
			if(!colisao(this.getX(), this.getY()-2)) {
				y-=5; // ajusta o tamanho do pulo
				jumpFrames +=2;
				if(jumpFrames == jumpHeigth) {
					isJump = false;
					jump = false;
					jumpFrames = 0;
				}
			}else {
				isJump = false;
				jump = false;
				jumpFrames = 0;
			}

		}
		
		if (movimentacao == 1 || ataque == 1 ) {
			frames ++;
			  if(frames == maxFrames) {
				  index++;
				  frames = 0;
				  if (index > maxIndex) {
					  index = 0;
				  }
			  }
			  if(framesP == maxFramesP) {
				  indexP++;
				  framesP = 0;
				  if (indexP > maxIndexP) {
					  indexP = 0;
				  }
			  }
		}

		if(damage((int)(x-speed), this.getY())) {
			life -= 0.45;
		}
		
		if (opemInventory) {
			abrindoInventarioy = true;
			
		}
		
		if (mostrarTexto) {
		    long tempoAtual = System.currentTimeMillis();
		    if (tempoAtual - tempoTextoVisivel >= 3000) { 
		        mostrarTexto = false;
		        texto = ""; 
		    }
		}


		Camera.x = Camera.Clamp(this.getX() - (Game.WIDTH/3), 0, Mundo.WIDTH*16 - Game.WIDTH);
		Camera.y = Camera.Clamp(this.getY() - (Game.HEIGHT/3), 0, Mundo.HEIGHT*16 - Game.HEIGHT);

	}
	
	public boolean colisaoBloco(int nextx, int nexty) {
	    int hitboxWidth = maskw;
	    int hitboxHeight = maskh;

	    if (right) {
	        hitboxWidth = 32;
	        hitboxHeight = 32;
	    } else if (left) {
	        hitboxWidth = 16;
	        hitboxHeight = 16;
	    }

	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, hitboxWidth, hitboxHeight);
	    for (Entidade entidade : Game.entidade) {
	        if (entidade instanceof Solido) {
	            Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky, maskw, maskh);
	            if (player.intersects(solido)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public boolean danoRato(int nextx, int nexty) {
	    int hitboxWidth = maskw;
	    int hitboxHeight = maskh;

	    if (right) {
	    	if (rightA) {
	    		hitboxWidth = 64;
	    	}else {
	    		hitboxWidth = 48;
		        hitboxHeight = 32;
	    	}
	        
	    } else if (left) {
	    	if(leftA) {
	    		hitboxWidth = -32;
	    	}
	        hitboxWidth = -16;
	        hitboxHeight = 16;
	    }

	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, hitboxWidth, hitboxHeight);
		for (InimigoRato entidade : Game.rato) {
			if(entidade instanceof InimigoRato) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky, maskw, maskh);
				if(player.intersects(inimigo)) {
					pl = entidade;
					return true;

				}
			}

		}
		return false;
	}
	
	public boolean danoSoldado(int nextx, int nexty) {
	    int hitboxWidth = maskw;
	    int hitboxHeight = maskh;

	    if (right) {
	    	if(rightA) {
	    		hitboxWidth = 48;
	    	}
	        hitboxWidth = 48;
	        hitboxHeight = 32;
	    } else if (left) {
	    	if(leftA) {
	    		hitboxWidth = -32;
	    	}
	        hitboxWidth = -16;
	        hitboxHeight = 16;
	    }

	    Rectangle player = new Rectangle(nextx + maskx, nexty + masky, hitboxWidth, hitboxHeight);
		for (InimigoSoldado entidade : Game.soldado) {
			if(entidade instanceof InimigoSoldado) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky, maskw, maskh);
				if(player.intersects(inimigo)) {
					pl2 = entidade;
					return true;

				}
			}

		}
		return false;
	}


	public boolean colisao(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky,maskw,maskh);
		for (Entidade entidade : Game.entidade) {
			if(entidade instanceof Solido) {
				Rectangle solido = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky,maskw,maskh);
				if(player.intersects(solido)) {
					return true;
				}
			}

		}
		return false;
	}

	public boolean damage(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		for (InimigoRato entidade : Game.rato) {
			if(entidade instanceof InimigoRato) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY()+masky, maskw, maskh);
				if(player.intersects(inimigo)) {
					pl = entidade;
					return true;

				}
			}

		}
		return false;
	}

	public boolean Lixo(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		for (holyStudio.entidade.Lixo entidade : Game.lixo) {
			if(entidade instanceof Lixo) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
				if(player.intersects(inimigo)) {
				     lixoo = entidade;
					return true;

				}
			}

		}
		return false;
	}
	public boolean medal(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		for (holyStudio.entidade.ItemMedalSol entidade : Game.itemS) {
			if(entidade instanceof ItemMedalSol) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
				if(player.intersects(inimigo)) {
					iSol = entidade;
					return true;

				}
			}

		}
		return false;
	}
	
	public boolean MoonLight(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		for (holyStudio.entidade.ItemMoonSword entidade : Game.itemMS) {
			if(entidade instanceof ItemMoonSword) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 10, maskw, maskh);
				if(player.intersects(inimigo)) {
					iMoon = entidade;
					return true;

				}
			}

		}
		return false;
	}
	public boolean chave(int nextx, int nexty) {
		Rectangle player = new Rectangle(nextx + maskx, nexty + masky, maskw, maskh);
		for (holyStudio.entidade.ItemChave entidade : Game.itemC) {
			if(entidade instanceof ItemChave) {
				Rectangle inimigo = new Rectangle(entidade.getX() + maskx, entidade.getY() + masky - 30, maskw, maskh);
				if(player.intersects(inimigo)) {
					iChave = entidade;
					return true;

				}
			}

		}
		return false;
	}

	@Override
	public void render(Graphics g) {
		if (direcaoAtual == direita && movimentacao == 1) {
			g.drawImage(playerRight[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if (direcaoAtual == paradoD && movimentacao == 0) {
			g.drawImage(playerRightP[indexP], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if (direcaoAtual == pulandoR && movimentacao == 3 && PuloDirecao == direita) {
			g.drawImage(playerRPulo[indexPl], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if (direcaoAtual == atacandoR && ataque == 1 && movimentacao == 2) {
			g.drawImage(playerRAtaque[indexA], this.getX()-Camera.x,((int)(y + 1))-Camera.y, null);
		}
		if (direcaoAtual == esquerda && movimentacao == 1) {
			g.drawImage(playerLeft[index], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if (direcaoAtual == paradoL && movimentacao == 0) {
			g.drawImage(playerLeftP[indexP], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if (direcaoAtual == pulandoL && movimentacao == 3 && PuloDirecao == esquerda) {
			g.drawImage(playerLPulo[indexPl], this.getX()-Camera.x, this.getY()-Camera.y, null);
		}
		if (direcaoAtual == atacandoL && ataque == 1 && movimentacao == 2) {
			g.drawImage(playerLAtaque[indexA], ((int)(x - 39))-Camera.x,((int)(y + 1))-Camera.y, null);
		}
	}

	public double getLife() {
		return life;
	}

	public double setLife(double life) {
	   return this.life =  life;
	}
	
	public boolean isInteragindo() {
	    interagindo = true;
	    return interagindo;
	}

}