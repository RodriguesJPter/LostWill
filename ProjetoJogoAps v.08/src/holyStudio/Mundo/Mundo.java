package holyStudio.Mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import holyStudio.entidade.Ceu;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.InimigoRato;
import holyStudio.entidade.InimigoSoldado;
import holyStudio.entidade.ItemChave;
import holyStudio.entidade.ItemMedalSol;
import holyStudio.entidade.ItemMoonSword;
import holyStudio.entidade.ItemSword;
import holyStudio.entidade.Lixo;
import holyStudio.entidade.NpcDoll;
import holyStudio.entidade.NpcMoon;
import holyStudio.entidade.NpcOutro;
import holyStudio.entidade.PosteUm;
import holyStudio.entidade.Solido;
import holyStudio.entidade.caxote;
import holyStudio.main.Game;

public class Mundo {

	public static int WIDTH;
	public static int HEIGHT;
	public Tile[] tiles;

	public Mundo(String path) {
		try {
			BufferedImage level = ImageIO.read(getClass().getResource(path));
			int[] pixel = new int[level.getWidth()* level.getHeight()];
			tiles = new Tile[level.getWidth() * level.getHeight()];
			WIDTH = level.getWidth();
			HEIGHT = level.getHeight();
			level.getRGB(0, 0, level.getWidth(), level.getHeight(), pixel, 0, level.getWidth());


			for(int x = 0; x < level.getWidth(); x++) {
				for(int y = 0; y < level.getHeight(); y++) {
					int pixelAtual = pixel[x + (y*level.getWidth())];
					tiles[x + (y*WIDTH)] = new Nada(x*16, y*16, Entidade.nada);

					if (pixelAtual == 0xFFf60000) {
						//Jogador (player)

						Game.player.setX(x*16);
						Game.player.setY(y*16);

					} else if(pixelAtual == 0xFF37946e) {
						//chão
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chao);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF99e0c5) {
						//chão 2
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chao2);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFab005a) {
						//chão canto esquerda
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaoCantoE);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF99a1e0) {
						//chão canto esquerda baixo
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaoCantoEb);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFab5a00) {
						//chão canto direita
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaoCantoD);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFe099bf) {
						//chão canto direita baixo
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaoCantoDb);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF8f6f9a) {
						//chão canto direita baixo
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.teto1);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF278d72) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF76c6b0) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF1d6e58) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama03);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF322a72) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF7c75b9) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF3522d7) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte03);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFFc1bbed) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.ponte04);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF663931) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.solo01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF9a6d64) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.solo02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF46221b) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.solo03);
						Game.entidade.add(solido);

					}else if(pixelAtual == 0xFF390f08) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terra01);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF952e1a) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terra02);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF463d3b) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.terra03);
						Game.entidade.add(solido);

					}  else if(pixelAtual == 0xFFd77bba) {
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.grama);
						Game.entidade.add(solido);

					}  else if(pixelAtual == 0xFFb428e5) {
						//chão canto direita baixo
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.teto2);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF570872) {
						//chão canto direita baixo
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.teto3);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF0048ab) {
						//nadaChao
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.chaoP);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF000000) {
						//nada
						Solido solido = new Solido(x*16, y*16, 16, 16, Entidade.vazio);
						Game.entidade.add(solido);

					} else if(pixelAtual == 0xFF004eff) {
						//fundo
						Ceu ceu = new Ceu(x*16, y*16, 16, 16, Entidade.fundo);
						Game.fundoCenario.add(ceu);

					} else if(pixelAtual == 0xFF639bff) {
						//fundo
						Ceu ceu = new Ceu(x*16, y*16, 16, 16, Entidade.iniciofundo);
						Game.fundoCenario.add(ceu);

					}else if(pixelAtual == 0xFF3f3f74) {
						//fundo
						Ceu ceu = new Ceu(x*16, y*16, 16, 16, Entidade.iniciofundoceu);
						Game.fundoCenario.add(ceu);

					} else if(pixelAtual == 0xFFbb2475) {
						//
						InimigoRato inimigoRato = new InimigoRato(x*16, y*16, 16, 16, Entidade.inimigoRato);
						Game.rato.add(inimigoRato);

					} else if(pixelAtual == 0xFFa32222) {
						//
						InimigoSoldado inimigosoldado = new InimigoSoldado(x*16, y*16, 16, 16, Entidade.inimigoSoldado);
						Game.soldado.add(inimigosoldado);

					} else if(pixelAtual == 0xFF00e1ed) {
						//
						NpcMoon npcMoon = new NpcMoon(x*16, y*16, 16, 16, Entidade.npcMoon);
						Game.npcMoon.add(npcMoon);
						
					} else if(pixelAtual == 0xFF7d1ed3) {
							//
						NpcDoll npcDoll = new NpcDoll(x*16, y*16, 16, 16, Entidade.npcDoll);
						Game.npcDoll.add(npcDoll);

					}  else if(pixelAtual == 0xFF6bff00) {
						//
						NpcOutro npcOutro = new NpcOutro(x*16, y*16, 16, 16, Entidade.npcOutro);
						Game.npcOutro.add(npcOutro);

					} else if(pixelAtual == 0xFFe0d623) {
						//
						Lixo lixo= new Lixo(x*16, y*16, 16, 16, Entidade.lixo);
						Game.lixo.add(lixo);

					} else if(pixelAtual == 0xFFa7a01d) {
						//
						ItemMedalSol medal= new ItemMedalSol(x*16, y*16, 16, 16, Entidade.medalSol);
						Game.itemS.add(medal);

					}  else if(pixelAtual == 0xFF878018) {
						//
						ItemMoonSword moons= new ItemMoonSword(x*16, y*16, 16, 16, Entidade.moonsword);
						Game.itemMS.add(moons);

					}   else if(pixelAtual == 0xFF878018) {
						//
						ItemSword moons= new ItemSword(x*16, y*16, 16, 16, Entidade.sword);
						Game.itemM.add(moons);

					}  else if(pixelAtual == 0xFF3e3b13) {
						//
						ItemChave chave= new ItemChave(x*16, y*16, 16, 16, Entidade.chave);
						Game.itemC.add(chave);

					}  else if(pixelAtual == 0xFF802828) {
						//
						PosteUm poste= new PosteUm(x*16, y*16, 16, 16, Entidade.poste1);
						Game.poste.add(poste);

					}   else if(pixelAtual == 0xFF802828) {
						//
						caxote poste= new caxote(x*16, y*16, 16, 16, Entidade.caixote);
						Game.caixa.add(poste);

					}
					



				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void render(Graphics g) {
		int xi = Camera.x/16;
		int yi = Camera.y/16;
		int xf = xi + (Game.WIDTH/10);
		int yf = yi + (Game.HEIGHT/10);
		for(int x = xi; x < xf; x++) {
			for(int y = yi; y < yf; y++) {
				if (x < 0 || y < 0 || x >= WIDTH|| y >= HEIGHT)
					continue;
				Tile tile = tiles[x + (y*WIDTH)];
				tile.render(g);
			}
		}

	}

}
