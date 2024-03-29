import com.mareksit.abstractobjects.Animal;
import com.mareksit.abstractobjects.Organism;
import com.mareksit.repository.ObjectRepository;
import com.mareksit.world.TheWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gra {
	private static TheWorld theWorld;
	private JFrame mainFrame;
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel[][] panelHolder;
	int dimX, dimY;

	public Gra() {
		this.dimX = 20;
		this.dimY = 20;
		this.theWorld = new TheWorld();
	}


	public static void main(String[] args) {
		Gra gra = new Gra();
		theWorld.drawTheWorld();
		gra.createGUI();
	}

	public void createGUI() {

		mainFrame = new JFrame("The New Magnificient World");
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

		BorderLayout frame = new BorderLayout();

		mainPanel = new JPanel(frame);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		mainPanel.addKeyListener(listener);
		mainPanel.setFocusable(true);
		mainPanel.requestFocusInWindow();

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(dimY, dimX, 1, 1));

		panelHolder = new JPanel[dimY][dimX];
		for (int i = 0; i < dimY; i++) {
			for (int j = 0; j < dimX; j++) {
				JPanel jpanel = new JPanel();
				jpanel.setBackground(Color.white);
				panelHolder[i][j] = jpanel;
				panel1.add(panelHolder[i][j]);
			}
		}
		this.refresh();

		mainPanel.add(BorderLayout.WEST, panel1);
		mainPanel.add(BorderLayout.EAST, panel2);

		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setBounds(100, 100, 300, 100);
		mainFrame.pack();
		mainFrame.setSize(1000, 800);
		mainFrame.setVisible(true);
	}

	public void refresh() {
		for (int i = 0; i < dimY; i++) {
			for (int j = 0; j < dimX; j++) {
				panelHolder[i][j].removeAll();
			}
		}
		for (int i = 0; i < ObjectRepository.getOrganisms().size(); i++) {
			Organism tempOrg = ObjectRepository.getOrganisms().get(i);
			String thePath = tempOrg.getImagePath();
			ImageIcon anImage = new ImageIcon(getClass().getResource(thePath));
			Image image = anImage.getImage();
			Image newimg = image.getScaledInstance(35, 31, java.awt.Image.SCALE_SMOOTH);
			anImage = new ImageIcon(newimg);
			JLabel jlab = new JLabel(anImage);
			panelHolder[tempOrg.getY()][tempOrg.getX()].add(jlab);
			panelHolder[tempOrg.getY()][tempOrg.getX()].revalidate();
			panelHolder[tempOrg.getY()][tempOrg.getX()].repaint();
		}
		panel1.repaint();

	}

	KeyListener listener = new KeyListener() {
		public void up() {
			if (Animal.spatialChecker(TheWorld.human_.getX(), TheWorld.human_.getY() - 1)) {
				TheWorld.human_.setY(TheWorld.human_.getY() - 1);
				theWorld.doTurn();
				refresh();
			} else {
				communicateWarning();
			}
		}

		public void down() {
			if (Animal.spatialChecker(TheWorld.human_.getX(), TheWorld.human_.getY() + 1)) {
				TheWorld.human_.setY(TheWorld.human_.getY() + 1);
				theWorld.doTurn();
				refresh();
			} else {
				communicateWarning();
			}
		}

		public void right() {
			if (Animal.spatialChecker(TheWorld.human_.getX() + 1, TheWorld.human_.getY())) {
				TheWorld.human_.setX(TheWorld.human_.getX() + 1);
				theWorld.doTurn();
				refresh();
			} else {
				communicateWarning();
			}
		}

		public void left() {

			if (Animal.spatialChecker(TheWorld.human_.getX() - 1, TheWorld.human_.getY())) {
				TheWorld.human_.setX(TheWorld.human_.getX() - 1);
				theWorld.doTurn();
				refresh();
			} else {
				communicateWarning();
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_UP:
					up();
					break;
				case KeyEvent.VK_DOWN:
					down();
					break;
				case KeyEvent.VK_RIGHT:
					right();
					break;
				case KeyEvent.VK_LEFT:
					left();
				default:
					break;
			}
		}
	};

	private void communicateWarning() {
		JOptionPane.showMessageDialog(mainFrame, "Nie wychodz poza plansze");
	}
}