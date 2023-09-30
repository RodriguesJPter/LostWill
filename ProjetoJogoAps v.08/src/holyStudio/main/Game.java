package holyStudio.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import holyStudio.Graficos.SpriteSheet;
import holyStudio.Mundo.Mundo;
import holyStudio.entidade.Ceu;
import holyStudio.entidade.Entidade;
import holyStudio.entidade.InimigoRato;
import holyStudio.entidade.InimigoSoldado;
import holyStudio.entidade.ItemChave;
import holyStudio.entidade.ItemFrasco;
import holyStudio.entidade.ItemMedalSol;
import holyStudio.entidade.ItemMoonSword;
import holyStudio.entidade.ItemSword;
import holyStudio.entidade.Lixo;
import holyStudio.entidade.NpcDoll;
import holyStudio.entidade.NpcMoon;
import holyStudio.entidade.NpcOutro;
import holyStudio.entidade.Player;
import holyStudio.entidade.PosteUm;
import holyStudio.entidade.Solido;
import holyStudio.entidade.Will;
import holyStudio.entidade.caxote;

public class Game extends Canvas implements Runnable, KeyListener {


	private static final long serialVersionUID = 1L;

	public static JFrame jframe;

	private Thread thread;
	
	private boolean isRunning = true;

	public final String titulo = "Lost Will";

	public static int WIDTH = 260;
	public static int HEIGHT = 140;
	public static int SCALE = 4;

	private BufferedImage fundo;

	public static List<Entidade> entidade;
	public static SpriteSheet sprite;

	public static List<Solido> solido;

	public static List<InimigoRato> rato;
	
	public static List<InimigoSoldado> soldado;

	
	public static List<NpcMoon> npcMoon;
	
	public static NpcMoon moon;
	
	public static List<NpcOutro> npcOutro;
	
	public static NpcOutro outro;
	
	public static List<NpcDoll> npcDoll;
	
	public static NpcDoll doll;

	public static List<Lixo> lixo;
	
	public static List<ItemMedalSol> itemS;
	
	public static List<ItemMoonSword> itemMS;
	
	public static List<ItemSword> itemM;
	
	public static List<ItemChave> itemC;
	
	public static List<PosteUm> poste;
	
	public static List<ItemFrasco> frasco;
	
	public static List<caxote> caixa;
	
	public static List<Will> will;
	
	private boolean inventarioAberto = false;
	
	public static List<Ceu> fundoCenario;
	public static SpriteSheet ceu;

	public static Player player;

	public static Mundo mundo;
	public static UserInterface ui;

	public Game() {
		addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
	    ui = new UserInterface();
		fundo = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		entidade = new ArrayList<>();
		sprite = new SpriteSheet("/Spritesheet.png");
		fundoCenario = new ArrayList<>();
		lixo = new ArrayList<>();
		itemS = new ArrayList<>();
		itemMS = new ArrayList<>();
		itemM = new ArrayList<>();
		itemC = new ArrayList<>();
		frasco = new ArrayList<>();
		npcMoon = new ArrayList<>();
		npcOutro = new ArrayList<>();
		npcDoll = new ArrayList<>();
		rato = new ArrayList<>();
		will = new ArrayList<>();
		caixa = new ArrayList<>();
		soldado = new ArrayList<>();
		ceu = new SpriteSheet("/blocosfundo01.png");
		moon = new NpcMoon(0, 336, 25, 53, sprite.getSprite(0, 336, 25, 53));;
		player = new Player(0, 0, 35, 50, sprite.getSprite(0, 0, 35, 50));
		entidade.add(player);
		poste = new ArrayList<>();
		mundo = new Mundo("/sala teste.png");

	}

	public void initFrame() {
		jframe = new JFrame("Lost will");
		jframe.add(this);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	private void telaMorte(Graphics g){
	    int inventarioX = 55;
	    int inventarioY = 10;
	    int larguraInventario = 150;
	    int alturaInventario = 100;
	    int campoX = 30;
		int campoY = 115;
		int campoHeight = 20;

	    g.setColor(Color.BLACK);
	    g.fillRect(inventarioX, inventarioY, larguraInventario, alturaInventario);
	    g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("VOCE MORREU", campoX + 5, campoY + campoHeight - 5);
	   
	}
	
	private void renderInventario(Graphics g){
	    int inventarioX = 55;
	    int inventarioY = 15;
	    int larguraInventario = 150;
	    int alturaInventario = 100;
	    int campoX = 53;
		int campoY = 10;
		int campoHeight = 20;


	   
	    
	    g.setColor(Color.LIGHT_GRAY);
	    g.fillRect(inventarioX, inventarioY, larguraInventario, alturaInventario);
	    
	    g.setColor(Color.BLACK);
	    g.drawRect(inventarioX, inventarioY, larguraInventario, alturaInventario);
	    
	    g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Inventario", campoX + 5, campoY + campoHeight - 5);
        
        g.setColor(Color.GRAY);
	    g.fillRect(inventarioX + 5, inventarioY + 16, larguraInventario - 9, alturaInventario - 20);
        
        if (Game.player.medalsol == 1) {
        g.drawImage(Entidade.medalSol , campoX + 30, campoY + 25, jframe);
        }
        
        if (Game.player.moonsword == 1) {
         g.drawImage(Entidade.moonsword , campoX + 15, campoY + 25, jframe);
        }
        
        if (Game.player.chave == 1) {
            g.drawImage(Entidade.chave , campoX + 40, campoY + 25, jframe);
        }
        
        g.drawImage(Entidade.sword , campoX + 5, campoY + 25, jframe);
        
        
	    
	    
	    
	}


	public static void main(String[] args) {
	 Game game = new Game();
	 game.start();
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}

	}

	public void tick() {
		for (Ceu entiCeu : fundoCenario) {
			entiCeu.tick();
		}

		for (Entidade enti : entidade) {
			enti.tick();
		}

		for (InimigoRato entiInimigo : rato) {
			entiInimigo.tick();
		}
		
		for (InimigoSoldado entisoldado : soldado) {
			entisoldado.tick();
		}
		
		for (NpcMoon entiNpcMoon : npcMoon) {
			entiNpcMoon.tick();
		}
		for (NpcDoll entiNpcDoll : npcDoll) {
			entiNpcDoll.tick();
		}
		
		for (NpcOutro entiNpcOutro : npcOutro) {
			entiNpcOutro.tick();
		}

		for (Lixo entiLixo : lixo) {
			entiLixo.tick();
		}
		
		for (ItemMedalSol entiitems : itemS) {
			entiitems.tick();
		}
		
		for (ItemChave entiChave : itemC) {
			entiChave.tick();
		}
		
		for (ItemMoonSword entiMSword : itemMS) {
			entiMSword.tick();
		}
		
		for (ItemSword entiSword : itemM) {
			entiSword.tick();
		}
		for (PosteUm entiposte : poste) {
			entiposte.tick();
		}
		
		for (ItemFrasco entifrasco : frasco) {
			entifrasco.tick();
		}
		
		for (caxote enticaixa : caixa) {
			enticaixa.tick();
		}
		
		for (Will entiwill : will) {
			entiwill.tick();
		}


	}

	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();
			if(buffer == null) {
				this.createBufferStrategy(3);
				return;
			}
			Graphics g = fundo.getGraphics();
			g.setColor(new Color(0,0,0));
			g.fillRect(0, 0, WIDTH, HEIGHT);

			mundo.render(g);

			for (Ceu entiCeu : fundoCenario) {
				entiCeu.render(g);
			}

			for (Entidade enti : entidade) {
				enti.render(g);
			}

			for (InimigoRato entiInimigo : rato) {
				entiInimigo.render(g);
			}
			
			for (InimigoSoldado entiSoldado : soldado) {
				entiSoldado.render(g);
			}
			
			for (NpcMoon entiNpcMoon : npcMoon) {
				entiNpcMoon.render(g);
			}
			
			for (NpcDoll entiNpcDoll : npcDoll) {
				entiNpcDoll.render(g);
			}
			
			for (NpcOutro entiNpcOutro : npcOutro) {
				entiNpcOutro.render(g);
			}

			for (Lixo entiLixo : lixo) {
				entiLixo.render(g);
			}
			for (ItemMedalSol entiitems : itemS) {
				entiitems.render(g);
			}
			
			for (ItemChave entiChave : itemC) {
				entiChave.render(g);
			}
			
			for (Will entiwill : will) {
				entiwill.render(g);
			}
			
			for (ItemMoonSword entiMSword : itemMS) {
				entiMSword.render(g);
			}
			
			for (ItemSword entiSword : itemM) {
				entiSword.render(g);
			}
			
			for (ItemFrasco entiFrasco : frasco) {
				entiFrasco.render(g);
			}
			
			for (PosteUm entiPoste : poste) {
				entiPoste.render(g);
			}
			
			for (caxote enticaixa : caixa) {
				enticaixa.render(g);
			}
			
			if (inventarioAberto) {
		        renderInventario(g);
		    }
			if(Game.player.life == 0) {
				telaMorte(g);
			}
			
			
			
			ui.render(g);
			
			g = buffer.getDrawGraphics();
		    g.drawImage(fundo, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		    buffer.show();

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0f;
		double ms = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();

		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ms;
			lastTime = now;

				if(delta > 1) {
					tick();
					render();
					frames++;
					delta--;
				}

				if(System.currentTimeMillis() - timer >= 1000) {
					System.out.println("FPS : " + frames );
					frames = 0;
					timer +=1000;
				}

		}
		stop();

	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// Nao vamos trabalhar nela

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			player.jump = true;
		} 
		if(e.getKeyCode() == KeyEvent.VK_Q){
			player.interagindo = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_C){
			player.usandocura = true;
			System.out.println("Tecla C pressionada");
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
		    System.out.println("Tecla I pressionada");
		    inventarioAberto = !inventarioAberto;
		}
		if(e.getKeyCode() == KeyEvent.VK_E && player.direcaoAtual == player.atacandoR) {
			player.rightA = true;
		} else if(e.getKeyCode() == KeyEvent.VK_E && player.direcaoAtual == player.atacandoL) {
			player.leftA = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		} else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_E && player.direcaoAtual == player.atacandoR) {
			player.rightA = false;
		} else if (e.getKeyCode() == KeyEvent.VK_E && player.direcaoAtual == player.atacandoL) {
			player.leftA = false;
		}

	}


}
