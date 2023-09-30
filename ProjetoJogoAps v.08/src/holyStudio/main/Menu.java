package holyStudio.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

    private JButton novoButton;
    private JButton abrirButton;
    private JButton salvarButton;
    private JButton fecharButton;

    private Game game;
    
    private static Menu menu;

    public Menu() {
        setTitle("Lost Will");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400); 
        
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(64, 64, 64));

        JLabel titleLabel = new JLabel("LOST WILL");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(new EmptyBorder(20, 0, 10, 0));
        titleLabel.setForeground(Color.YELLOW);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(64, 64, 64));
        novoButton = createCustomButton("Novo jogo");
        abrirButton = createCustomButton("Abrir");
        salvarButton = createCustomButton("Salvar");
        fecharButton = createCustomButton("Fechar"); 

        JMenuItem fecharItem = new JMenuItem("Fechar");
        fecharItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fecharJanela();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets.top = 20;

        buttonPanel.add(novoButton, gbc);
        buttonPanel.add(abrirButton, gbc);
        buttonPanel.add(salvarButton, gbc);
        buttonPanel.add(fecharButton, gbc); 
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                game.start();
                game.jframe.setVisible(true);
                
                
               fecharJanela();
            }
        });

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

        SwingUtilities.updateComponentTreeUI(this);
        setContentPane(mainPanel);
    }

    private void fecharJanela() {
        this.dispose();
    }

    private JButton createCustomButton(String label) {
        JButton button = new JButton(label);
        int buttonWidth = 150; 
        int buttonHeight = 40; 
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new RoundedBorder(20));
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }
}

class RoundedBorder implements javax.swing.border.Border {
    private int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
