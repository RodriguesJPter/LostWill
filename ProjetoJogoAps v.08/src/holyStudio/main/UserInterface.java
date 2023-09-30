package holyStudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

import holyStudio.entidade.Entidade;

public class UserInterface {

	private String textoNoCampo = "";
	private int contador = 10;
	private String contagemWill = "";
	private String interacaoNpc = "";
	
	public static JFrame jframe;

	public void render(Graphics g) {
		
		lifeBar(g);
		frascoNumero(g);
		contadorWill(g);
		contadorObjeto(g);
		dialogoMoon(g);
		dialogoOutro(g);
		
	}
	
	public void frascoNumero(Graphics g) {
		int contadorX = 5;
		int contadorY = 10;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 8));
		g.drawImage(Entidade.frasco, contadorX, contadorY, jframe);
		g.drawString(" " + Game.player.numeroFrasco, contadorX + 12, contadorY + 13);
		
		
	}
	
	public void contadorWill(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 8));

		int contadorX = 230;
		int contadorY = 20;
		g.drawString(": " + Game.player.numeroDeWill, contadorX, contadorY);
		g.drawImage(Entidade.will , contadorX - 13, contadorY - 15, jframe);
	}

	public void dialogoOutro(Graphics g) {
		int campoX = 30;
		int campoY = 115;
		int campoWidth = 200;
		int campoHeight = 20;
		if (Game.outro != null && !Game.outro.textoOutro.isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(campoX, campoY, campoWidth, campoHeight);
            g.setColor(Color.BLACK);
            g.drawRect(campoX, campoY, campoWidth, campoHeight);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(Game.outro.textoOutro, campoX + 5, campoY + campoHeight - 5);
        } 
	}
	
	public void contadorObjeto(Graphics g) {
		int campoX = 30;
		int campoY = 115;
		int campoWidth = 200;
		int campoHeight = 20;
		if (!Game.player.texto.isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(campoX, campoY, campoWidth, campoHeight);
            g.setColor(Color.BLACK);
            g.drawRect(campoX, campoY, campoWidth, campoHeight);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(Game.player.texto, campoX + 5, campoY + campoHeight - 5);
        } 
	}
	
	public void dialogoMoon(Graphics g) {
		int campoX = 30;
		int campoY = 115;
		int campoWidth = 200;
		int campoHeight = 20;
		if (!Game.moon.textoMoon.isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(campoX, campoY, campoWidth, campoHeight);
            g.setColor(Color.BLACK);
            g.drawRect(campoX, campoY, campoWidth, campoHeight);
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString(Game.moon.textoMoon, campoX + 5, campoY + campoHeight - 5);
        }
	}
	
	public void lifeBar(Graphics g) {
		int inventarioXB = 5; 
        int inventarioYB = 5;
        int inventarioX = inventarioXB + 1; 
        int inventarioY = inventarioYB + 1;
		
		g.setColor(Color.black);
		g.fillRect(inventarioXB, inventarioYB, 52, 7);

		g.setColor(Color.red);
		g.fillRect(inventarioX, inventarioY, 50, 5);

		g.setColor(Color.green);
		g.fillRect(inventarioX, inventarioY, (int) ((Game.player.life / Game.player.maxLife) * 50), 5);
	}
	
	public void dialogo() {
		Game.player.texto = contagemWill;
		Game.moon.textoMoon = interacaoNpc;
		Game.outro.textoOutro = interacaoNpc;
	}

	public void tick() {
        if (contador > 0) {
            contador--; 
        } else {
            textoNoCampo = "";
        }
	}
        
        public void setTextoNoCampo(String texto) {
            this.textoNoCampo = texto;
            contador = 10; 
        }
    }

