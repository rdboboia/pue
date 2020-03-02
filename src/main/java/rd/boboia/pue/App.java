package rd.boboia.pue;

import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import rd.boboia.pue.calc.DaysAndProbsCalculator;

public class App {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		float probability = DaysAndProbsCalculator.getCurrentProbability(LocalDate.of(2020, 3, 1),
				LocalDate.of(2020, 8, 31));

		JOptionPane.showMessageDialog(null, "Current probability: " + probability, "Java",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
