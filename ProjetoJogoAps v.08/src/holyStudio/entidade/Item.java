package holyStudio.entidade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import holyStudio.Mundo.Camera;
import holyStudio.main.Game;

public class Item extends Entidade{
    private String nome = "";
    private int quantidade;
    
    public int medalsunI = 1, tearI = 0, dollI = 0, fraskI = 1, catScullI = 0, keyI = 0;
    
    public int itemAmostra = fraskI;
    
    private BufferedImage imagem; 
    
    public BufferedImage[] medalsun;
    public BufferedImage[] tear;
    public BufferedImage[] doll;
    public BufferedImage[] frask;
    public BufferedImage[] catScull;
    public BufferedImage[] key;

    public Item(String nome, int quantidade, int x, int y, int width, int height, BufferedImage sprite) {
    	super(x, y, width, height, sprite);
    	this.nome = nome;
        this.quantidade = quantidade;
        this.imagem = imagem;
        
        medalsun = new BufferedImage[5];
        tear = new BufferedImage[5];
        doll = new BufferedImage[5];
        frask = new BufferedImage[5];
        catScull = new BufferedImage[5];
        key = new BufferedImage[5];
        
        for(int i = 0; i < 5; i++) {
        	medalsun[i] = Game.sprite.getSprite(720 , 48, 16, 16);
		}
        
        for(int i = 0; i < 5; i++) {
        	tear[i] = Game.sprite.getSprite(736 , 80, 16, 16);
		}
        
        for(int i = 0; i < 5; i++) {
        	doll[i] = Game.sprite.getSprite(736  , 64, 16, 16);
		}
        
        for(int i = 0; i < 5; i++) {
        	frask[i] = Game.sprite.getSprite(720 , 80, 16, 16);
		}
        
        for(int i = 0; i < 5; i++) {
        	catScull[i] = Game.sprite.getSprite(720  , 64, 16, 16);
		}
        
        for(int i = 0; i < 5; i++) {
        	key[i] = Game.sprite.getSprite(736 , 48, 16, 16);
		}
        
        

    }
		

    public  String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public BufferedImage getImagem() {
        return imagem;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void render(Graphics g, int x, int y) {
        g.drawString(nome + ": " + quantidade, x, y);
        
    }
}
